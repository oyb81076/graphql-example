import Vue from 'vue';
import VueRouter, { RouteConfig } from 'vue-router';
import Home from '../views/home.vue';

Vue.use(VueRouter);

const routes: Array<RouteConfig> = [
  { path: '/', name: 'Home', component: Home },
  { path: '/book', redirect: '/book/index' },
  { path: '/book/index', name: 'Book', component: () => import('../views/book/index.vue') },
  {
    path: '/book/detail/:id',
    name: 'Book',
    props: true,
    component: () => import('../views/book/detail.vue'),
  },
  {
    path: '/book/edit/:id',
    name: 'Book',
    props: true,
    component: () => import('../views/book/edit.vue'),
  },
];

const router = new VueRouter({
  routes,
});

export default router;
