<template>
  <el-menu background-color="#545c64"
           text-color="#fff"
           active-text-color="#ffd04b"
           style="height: 100%"
           :collapse="isCollapse"
            default-active="/Home"
  router>
    <el-menu-item index="/index">
      <i class="el-icon-s-home"></i>
      <span slot="title">首页</span>
    </el-menu-item>

    <el-menu-item index="/admin/AdminManage">
      <i class="el-icon-s-flag"></i>
      <span slot="title">导航一</span>
    </el-menu-item>

    <el-menu-item index="/user/UserManage">
      <i class="el-icon-s-opportunity"></i>
      <span slot="title">导航二</span>
      </el-menu-item>

</el-menu>
</template>

<script>
export default {
  name: "Aside",
  data(){
    return{
      // isCollapsed:false
    }
  },
  props:{
      isCollapse:Boolean
  }
}
</script>

<style scoped>

</style>