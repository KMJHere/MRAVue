import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import NotFound from '../views/NotFound.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: "/notFound",
    name: "notFound",
    component: NotFound
  },
  {
    path: "/mraLogin",
    name: "mraLogin",
    component: () => import(/* webpackChunkName: "about" */ '../views/mraLogin.vue')
  },
  {
    path: "/assmntList",
    name: "assmntList",
    component: () => import(/* webpackChunkName: "about" */ '../views/AssmntList.vue')
  },
  {
    path: "/:pathMatch(.*)*",
    redirect: "/notFound"
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
