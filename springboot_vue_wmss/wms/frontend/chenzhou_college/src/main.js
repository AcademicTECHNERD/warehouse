import Vue from 'vue';
import App from './App.vue';
import router from './router'; // 确保引入 router
// 引入 Element UI 和它的样式
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.config.productionTip = false;
// 使用 Element UI
Vue.use(ElementUI);
new Vue({
  router, // 将 router 实例传递给 Vue 实例
  render: h => h(App),
}).$mount('#app');
