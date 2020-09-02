import Vue from 'vue';
import VueApollo from 'vue-apollo';
import App from './App.vue';
import router from './router';
import apollo from './apollo';

Vue.use(VueApollo);
Vue.config.productionTip = false;
const apolloProvider = new VueApollo({
  defaultClient: apollo,
});

new Vue({
  router,
  apolloProvider,
  render: (h) => h(App),
}).$mount('#app');
