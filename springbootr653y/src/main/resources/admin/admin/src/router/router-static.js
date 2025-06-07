import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import youke from '@/views/modules/youke/list'
    import jingsaixinxi from '@/views/modules/jingsaixinxi/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import fuzeren from '@/views/modules/fuzeren/list'
    import jingsaileibie from '@/views/modules/jingsaileibie/list'
    import jingsaibaoming from '@/views/modules/jingsaibaoming/list'
    import pingwei from '@/views/modules/pingwei/list'
    import zhuanye from '@/views/modules/zhuanye/list'
    import chengguoxiangqing from '@/views/modules/chengguoxiangqing/list'
    import jieguozhanshi from '@/views/modules/jieguozhanshi/list'
    import banji from '@/views/modules/banji/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '公告栏',
        component: news
      }
      ,{
	path: '/youke',
        name: '游客',
        component: youke
      }
      ,{
	path: '/jingsaixinxi',
        name: '竞赛信息',
        component: jingsaixinxi
      }
      ,{
	path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
      ,{
	path: '/fuzeren',
        name: '负责人',
        component: fuzeren
      }
      ,{
	path: '/jingsaileibie',
        name: '竞赛类别',
        component: jingsaileibie
      }
      ,{
	path: '/jingsaibaoming',
        name: '竞赛报名',
        component: jingsaibaoming
      }
      ,{
	path: '/pingwei',
        name: '评委',
        component: pingwei
      }
      ,{
	path: '/zhuanye',
        name: '专业',
        component: zhuanye
      }
      ,{
	path: '/chengguoxiangqing',
        name: '成果详情',
        component: chengguoxiangqing
      }
      ,{
	path: '/jieguozhanshi',
        name: '结果展示',
        component: jieguozhanshi
      }
      ,{
	path: '/banji',
        name: '班级',
        component: banji
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
