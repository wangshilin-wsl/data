<template>
  <!--template只能有一个子标签-->
    <div>
      <h1>个人信息页 </h1>
      {{$route.params.id}}
      <br>
      {{id}}
    </div>
</template>

<script>
    export default {
        props: ['id'],
        name: "UserProfile",
      //过滤器 chain
      beforeRouteEnter: (to,from,next)=>{
        console.log("进入路由之前");
        next(vm=>{
          vm.getData();//进入路由之前执行getData;
        });
      },
      beforeRouteLeave: (to,from,next)=>{
        console.log("进入路由之后后");
        next();
      },
      methods: {
          getData: function () {
            this.axios({
              method: 'get',
              url: 'http://localhost:8080/static/mock/data.json'
            }).then(function (response) {
              console.log(response);
            });
          }
      }
    }
</script>

<style scoped>

</style>
