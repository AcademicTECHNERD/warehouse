/* eslint-disable vue/multi-word-component-names */

<template>
  <div class="loginBody">
    <div class="loginDiv">
      <div class="login-content">
        <h1 class="login-title">用户登录</h1>
        <el-form :model="loginForm" ref="loginForm" :rules="rules" label-width="100px" class="login-form">
          <el-form-item label="账号" prop="no">
            <el-input type="text" autocomplete="off" size="small" v-model="loginForm.no" placeholder="Username"></el-input>
          </el-form-item>
          <el-form-item prop="password" label="密码">
            <el-input v-model="loginForm.password" show-password autocomplete="off" size="small" @keyup.enter.native="confirm" type="password" placeholder="Password"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="confirm" :disabled="confirm_disabled">确定</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: "UserLoginPage",
  data() {
    return {
      confirm_disabled: false,
      loginForm: {
        no: '',
        password: ''
      },
      rules: {
        no: [
          { required: true, message: '请输入账号', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    confirm() {
      this.confirm_disabled = true;
      this.$refs.loginForm.validate((valid) => {
        if (valid) { // valid成功为true，失败为false
          // 去后台验证用户名密码
          axios.post('http://localhost:8090/user/login', this.loginForm)
              .then(res => res.data)
              .then(res => {
                console.log(res);
                if (res.code === 200) {
                  // 存储
                  sessionStorage.setItem("CurUser", JSON.stringify(res.data));
                  // 跳转到主页
                  this.$router.replace('/app');
                } else {
                  this.confirm_disabled = false;
                  alert('校验失败，用户名或密码错误!');
                }
              })
              .catch(() => {
                this.confirm_disabled = false;
                alert('请求失败，请重试!');
              });
        } else {
          this.confirm_disabled = false;
          console.log('校验失败');
        }
      });
    }
  }
}
</script>

<style scoped>
.loginBody {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100vw;
  height: 100vh;
  background-color: #B3C0D1;
}
.loginDiv {
  width: 33.33vw;
  height: 60vh;
  background: #fff;
  border-radius: 5%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.login-title {
  margin: 20px 0;
  text-align: center;
}
.login-content {
  width: 80%;
  height: 80%;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
</style>
