<script setup lang="ts">
import { ElMessage, FormRules } from 'element-plus'
import { reactive } from 'vue'
//表单响应式数据
const form = reactive({
  username: 'admin',
  password: '123456',
})
//登录事件处理
const onSubmit = () => {
  if (form.username === 'admin' && form.password === '123456') {
    ElMessage.success('登录成功')
    // 这里可以添加登录成功后的操作，比如跳转页面
  } else {
    ElMessage.error('登录失败：账号或密码错误')
  }
}
//定义表单校验
const rules = reactive<FormRules>({
  username: [
    { required: true, message: '账号不能为空', trigger: 'blur' },
    { pattern: /^[a-zA-Z_]{4,16}$/, message: '账号必须为4-16位字母或下划线', trigger: 'blur' },
  ],
  password: [
    { required: true, message: '密码不能为空', trigger: 'blur' },
    { min: 6, max: 18, message: '密码长度需要6~18位', trigger: 'blur' },
  ],
})
</script>

<template>
  <div class="login">
    <el-form :model="form" :rules="rules" label-width="120px" label-position="top" size="large">
      <h2>宿舍管理系统</h2>
      <el-form-item label="账号" prop="username">
        <el-input v-model="form.username" />
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="form.password" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style lang="scss" scoped>
.login {
  background-color: #ccc;
  height: 100vh;
  width: 100vw;
  display: flex;
  justify-content: center; //水平居中
  align-items: center; //垂直居中
}
.el-form {
  width: 500px;
  background-color: #fff;
  padding: 40px;
  border-radius: 10px;
  .el-form-item {
    margin-top: 20px;
  }
  .el-button {
    width: 100%;
    margin-top: 30px;
  }
}
</style>
