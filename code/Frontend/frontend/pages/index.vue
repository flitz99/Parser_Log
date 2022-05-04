<template>

  <b-container class="main-cont">
    
    <h1 class="f-sm-b">Heimdall</h1>

    <b-row>

      <b-col>

        <p class="f-reg mt-2">
          Benvenuto sul sito Heimdall 
          del gruppo 4.
        </p>

      </b-col>

      <b-col>

        <Login />
      
      </b-col>

    </b-row> 

  </b-container>

</template>

<script>
export default {
  name: 'IndexPage'
}
</script>


<style>

  .main-cont { margin-top: 180px;  }
  h3 {letter-spacing: -0.3px;}
  p { color: var(--c-grey);}
  
</style>