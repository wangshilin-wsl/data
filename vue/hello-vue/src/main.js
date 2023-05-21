import Vue from 'vue'
import App from './App'
import router from './router'
//Element-ui的导入
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios';
import VueAxios from 'vue-axios';

Vue.use(VueAxios,axios);
Vue.use(ElementUI);
Vue.use(router);


new Vue({
  el: '#app',
  router: router,
  render: h => h(App)//ElementUI
});
