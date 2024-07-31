<template>
  <div id="app">
    <HomeIndex></HomeIndex>
  </div>
</template>

<script>
import HomeIndex from './components/HomeIndex.vue'
// import HomeIndex from "@/components/HomeIndex";
import Index from "@/components";

export default {
  name: 'App',
  components: {
    HomeIndex
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
