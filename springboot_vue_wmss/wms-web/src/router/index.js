import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'login',
        component: () => import('../components/login')
    },
    {
        path: '/index',
        name: 'index',
        component: () => import('../components/index')
    },
    {
        path: '/admin/AdminManage',
        name: 'admin',
        meta:{
            title:'管理员管理'
        },
        component: () => import('../components/admin/AdminManage')
    },
    {
        path: '/user/UserManage',
        name: 'user',
        meta:{
            title:'用户管理'
        },
        component: () => import('../components/user/UserManage')
    }
]

const router = new VueRouter({
    mode: 'history',
    routes
})

export default router
