<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="80px">
      <el-form-item label="VCD名称" prop="vcdName">
        <el-input
          v-model="queryParams.vcdName"
          placeholder="请输入VCD名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="VCD类型" prop="typeId">
        <el-select v-model="queryParams.typeId" placeholder="请选择VCD类型" 
        clearable
          @keyup.enter.native="handleQuery">
            <el-option
              v-for="item in typeList"
              :key="item.typeId"
              :label="item.typeName"
              :value="item.typeId"
            />
          </el-select>
      </el-form-item>
      <el-form-item label="VCD价格" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入VCD价格"
          clearable
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
          v-hasPermi="['cms:info:add']"
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
          v-hasPermi="['cms:info:edit']"
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
          v-hasPermi="['cms:info:remove']"
        >删除</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="VCD编号" align="center" prop="vcdId" />
      <el-table-column label="VCD名称" align="center" prop="vcdName" />
      <el-table-column label="VCD类型" align="center" prop="typeId" :formatter="typemapping" />
      <el-table-column label="VCD价格" align="center" prop="price" />
      <el-table-column label="库存数量" align="center" prop="num"  />
      <el-table-column label="录入人员编号" align="center" prop="operatorId" :formatter="usermaping" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['cms:info:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['cms:info:remove']"
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

    <!-- 添加或修改VCD信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="VCD名称" prop="vcdName">
          <el-input v-model="form.vcdName" placeholder="请输入VCD名称" />
        </el-form-item>
        <el-form-item label="VCD类型" prop="typeId">
          <el-select v-model="form.typeId" placeholder="请选择VCD类型">
            <el-option
              v-for="item in typeList"
              :key="item.typeId"
              :label="item.typeName"
              :value="item.typeId"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="VCD价格" prop="price">
          <el-input v-model.number="form.price" placeholder="请输入VCD价格"  />
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
import { listInfo, getInfo, delInfo, addInfo, updateInfo } from "@/api/cms/info";
import { listType } from "@/api/cms/type";
import { listUser } from "@/api/system/user";

export default {
  name: "Info",
  data() {
    return {
      // 用户列表
      userList: [],
      // VCD类型列表
      typeList: [],
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
      // VCD信息表格数据
      infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        vcdName: null,
        typeId: null,
        price: null,
        operatorId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        vcdName: [
          { required: true, message: "VCD名称不能为空", trigger: "blur" }
        ],
        typeId: [
          { required: true, message: "VCD类型编号不能为空", trigger: "blur" }
        ],
        price: [
          { required: true, message: "VCD价格不能为空" },
          { type: "number", message: "价格必须为整数" }
          ],
      }
    };
  },
  created() {
    this.getList();
    this.getTypeList();
    listUser().then(response => {
        this.userList = response.rows;
      });

  },
  methods: {
    usermaping(row,column){
      let userName = '';
      this.userList.forEach(item => {
        if (item.userId == row.operatorId) {
          userName= item.userName;
        }
      });
      return userName;
    },
    typemapping(row,column){
      let typeName = '';
      this.typeList.forEach(item => {
        if (item.typeId == row.typeId) {
          typeName= item.typeName;
        }
      });
      return typeName;
    },


    /** 获取VCD类型列表 */
    getTypeList() {
      listType().then(response => {
        this.typeList = response.rows;
      });
    },

    /** 查询VCD信息列表 */
    getList() {
      this.loading = true;
      listInfo(this.queryParams).then(response => {
        this.infoList = response.rows;
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
        vcdId: null,
        vcdName: null,
        typeId: null,
        price: null,
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
      this.ids = selection.map(item => item.vcdId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加VCD信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const vcdId = row.vcdId || this.ids
      getInfo(vcdId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改VCD信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.vcdId != null) {
            updateInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInfo(this.form).then(response => {
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
      const vcdIds = row.vcdId || this.ids;
      this.$modal.confirm('是否确认删除VCD信息编号为"' + vcdIds + '"的数据项？').then(function() {
        return delInfo(vcdIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('cms/info/export', {
        ...this.queryParams
      }, `info_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
