<template>
  <el-container style="height: 100%; border: 1px solid #eee">
    <el-aside :width="aside_width" style="background-color: rgb(238, 241, 246);margin-left: -1px">
      <Aside></Aside>
    </el-aside>

    <el-container style="height: 100%">
      <el-header style="text-align: right; font-size: 12px;height: 100%;border-bottom:#d00c0c 1px solid">
        <Header></Header>
      </el-header>

      <el-main style="height: 100%">
          <div class="user-manage">
            <h1>管理员管理</h1>
          </div>
      </el-main>

    </el-container>
  </el-container>

</template>

<script>
import Aside from "@/components/Aside";
import Header from "@/components/Header";
import Main from "@/components/Main";
export default {
  components:{Header, Aside},
  name: "AdminManage",
  data(){
    return{
      aside_width:'200px',
    }
  }
}
</script>

<style scoped>
.user-manage {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

h1 {
  text-align: center;
}
</style>
