<template>

  <b-container class="main-cont">
    
    <h1 class="f-sm-b">Heimdall</h1>

    <b-row>

      <b-col>

        <p class="f-reg mt-2">
          Benvenuto sul sito Heimdall 
          del gruppo 4.
        </p>
        <p>
          Designed and coded by :
          <ul>
            <li>Baroni Simone</li>    
            <li>Lucchina Lorenzo</li>
            <li>Reggiani Filippo</li>
            <li>Uthayakumar Janath </li>
            <li>Vecchi Jacopo</li>
            <li>Villa Massimiliano</li>
          </ul>
        </p>

      </b-col>

      <b-col>

        <Login />
        <br><br>
        <div class="text-center">
        <NuxtLink to="/dashboard/logs" >Vai alla Dashboard</NuxtLink>
        </div>
      </b-col>

    </b-row> 

  </b-container>

</template>

<script>
export default {
  head: {
    title: 'Login',
    meta: [
      {
        hid: 'description',
        name: 'description',
      },
      
    ],
  },
  name: 'IndexPage'
}
</script>


<style>

  .main-cont { margin-top: 180px;  }
  h3 {letter-spacing: -0.3px;}
  p { color: var(--c-grey);}
  
</style>