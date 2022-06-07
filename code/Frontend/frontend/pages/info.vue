<template>

  <b-container class="info p-0 text-center shadow p-3 mb-5 bg-white rounded">

     <img src="~/assets/status.jpg" class="img-status" />

      <div class="d-flex justify-content-center pt-4 m-0">
          <NuxtLink to="/charts">
            <h3 class="stats p-2">Statistiche</h3>
          </NuxtLink>          
          <NuxtLink to="/dashboard/logs">
            <h3 class="stats p-2">Home</h3>
          </NuxtLink>
      </div>

  </b-container>

</template>

<script>
export default {
head: {
    title: 'HTTP Status Code',
  },
}
</script>

<style>

    .info{
        margin-top: 20vh;
    }
    
</style>