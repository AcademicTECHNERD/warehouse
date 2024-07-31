import Vue from 'vue';
import Router from 'vue-router';
import UserLoginPage from "@/components/UserLoginPage";
import App from "@/App.vue";


Vue.use(Router);

export default new Router({
    mode: 'history',  // 使用 history 模式
    routes: [
        {
            path: '/',
            name: 'LoginPage',
            component: UserLoginPage
        },
        {
            path: '/app',
            name: 'App',
            component: App
        }
    ]
});
