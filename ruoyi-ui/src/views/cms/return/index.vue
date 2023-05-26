<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="借还时间" prop="brTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.brTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择借还时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="借还数量" prop="brNum">
        <el-input
          v-model="queryParams.brNum"
          placeholder="请输入借还数量"
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
      <el-form-item label="借出人员编号" prop="borrowerId">
        <el-input
          v-model="queryParams.borrowerId"
          placeholder="请输入借出人员编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="归还人员编号" prop="returnerId">
        <el-input
          v-model="queryParams.returnerId"
          placeholder="请输入归还人员编号"
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
          v-hasPermi="['cms:return:add']"
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
          v-hasPermi="['cms:return:edit']"
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
          v-hasPermi="['cms:return:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['cms:return:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="returnList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="借还编号" align="center" prop="brId" />
      <el-table-column label="借还时间" align="center" prop="brTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.brTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="借还数量" align="center" prop="brNum" />
      <el-table-column label="VCD编号" align="center" prop="vcdId" />
      <el-table-column label="借出人员编号" align="center" prop="borrowerId" />
      <el-table-column label="归还人员编号" align="center" prop="returnerId" />
      <el-table-column label="借还状态，0表示借出，1表示归还" align="center" prop="status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['cms:return:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['cms:return:remove']"
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

    <!-- 添加或修改借还管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="借还时间" prop="brTime">
          <el-date-picker clearable size="small"
            v-model="form.brTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择借还时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="借还数量" prop="brNum">
          <el-input v-model="form.brNum" placeholder="请输入借还数量" />
        </el-form-item>
        <el-form-item label="VCD编号" prop="vcdId">
          <el-input v-model="form.vcdId" placeholder="请输入VCD编号" />
        </el-form-item>
        <el-form-item label="借出人员编号" prop="borrowerId">
          <el-input v-model="form.borrowerId" placeholder="请输入借出人员编号" />
        </el-form-item>
        <el-form-item label="归还人员编号" prop="returnerId">
          <el-input v-model="form.returnerId" placeholder="请输入归还人员编号" />
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
import { listReturn, getReturn, delReturn, addReturn, updateReturn } from "@/api/cms/return";

export default {
  name: "Return",
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
      // 借还管理表格数据
      returnList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        brTime: null,
        brNum: null,
        vcdId: null,
        borrowerId: null,
        returnerId: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        brTime: [
          { required: true, message: "借还时间不能为空", trigger: "blur" }
        ],
        brNum: [
          { required: true, message: "借还数量不能为空", trigger: "blur" }
        ],
        vcdId: [
          { required: true, message: "VCD编号不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "借还状态，0表示借出，1表示归还不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询借还管理列表 */
    getList() {
      this.loading = true;
      listReturn(this.queryParams).then(response => {
        this.returnList = response.rows;
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
        brId: null,
        brTime: null,
        brNum: null,
        vcdId: null,
        borrowerId: null,
        returnerId: null,
        status: 0
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
      this.ids = selection.map(item => item.brId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加借还管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const brId = row.brId || this.ids
      getReturn(brId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改借还管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.brId != null) {
            updateReturn(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addReturn(this.form).then(response => {
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
      const brIds = row.brId || this.ids;
      this.$modal.confirm('是否确认删除借还管理编号为"' + brIds + '"的数据项？').then(function() {
        return delReturn(brIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('cms/return/export', {
        ...this.queryParams
      }, `return_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
