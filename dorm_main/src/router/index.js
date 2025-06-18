import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/auth/LoginView.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login,
    },
  ],
})

export default router
