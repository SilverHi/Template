<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="入库时间" prop="inTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.inTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择入库时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="入库数量" prop="inNum">
        <el-input
          v-model="queryParams.inNum"
          placeholder="请输入入库数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="VCD编号" prop="vcdId">
        <el-input
          v-model="queryParams.vcdId"
          placeholder="请输入VCD编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="操作人员编号" prop="operatorId">
        <el-input
          v-model="queryParams.operatorId"
          placeholder="请输入操作人员编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['cms:in:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['cms:in:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['cms:in:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['cms:in:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="inList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="入库编号" align="center" prop="inId" />
      <el-table-column label="入库时间" align="center" prop="inTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.inTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="入库数量" align="center" prop="inNum" />
      <el-table-column label="VCD编号" align="center" prop="vcdId" />
      <el-table-column label="操作人员编号" align="center" prop="operatorId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['cms:in:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['cms:in:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改入库管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="入库时间" prop="inTime">
          <el-date-picker clearable size="small"
            v-model="form.inTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择入库时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="入库数量" prop="inNum">
          <el-input v-model="form.inNum" placeholder="请输入入库数量" />
        </el-form-item>
        <el-form-item label="VCD编号" prop="vcdId">
          <el-input v-model="form.vcdId" placeholder="请输入VCD编号" />
        </el-form-item>
        <el-form-item label="操作人员编号" prop="operatorId">
          <el-input v-model="form.operatorId" placeholder="请输入操作人员编号" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listIn, getIn, delIn, addIn, updateIn } from "@/api/cms/in";

export default {
  name: "In",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 入库管理表格数据
      inList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        inTime: null,
        inNum: null,
        vcdId: null,
        operatorId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        inTime: [
          { required: true, message: "入库时间不能为空", trigger: "blur" }
        ],
        inNum: [
          { required: true, message: "入库数量不能为空", trigger: "blur" }
        ],
        vcdId: [
          { required: true, message: "VCD编号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询入库管理列表 */
    getList() {
      this.loading = true;
      listIn(this.queryParams).then(response => {
        this.inList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        inId: null,
        inTime: null,
        inNum: null,
        vcdId: null,
        operatorId: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.inId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加入库管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const inId = row.inId || this.ids
      getIn(inId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改入库管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.inId != null) {
            updateIn(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addIn(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const inIds = row.inId || this.ids;
      this.$modal.confirm('是否确认删除入库管理编号为"' + inIds + '"的数据项？').then(function() {
        return delIn(inIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('cms/in/export', {
        ...this.queryParams
      }, `in_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
