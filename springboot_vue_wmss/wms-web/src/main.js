// import { createApp } from 'vue'
import Vue from 'vue';
import App from './App.vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/global.css'
import axios from "axios";
import VueRouter from "vue-router";
import router from "./router";
Vue.config.productionTip = false
Vue.prototype.$axios=axios;
// 配置 Axios 实例
const instance = axios.create({
    baseURL: 'http://localhost:8090',
    headers: {
        'Content-Type': 'application/json'
    }
});

export {instance};
Vue.prototype.$httpUrl='http://localhost:8090'
Vue.use(ElementUI);
Vue.use(VueRouter);
new Vue({
    router,
    render: h => h(App),
}).$mount('#app');
// createApp(App).mount('#app')
