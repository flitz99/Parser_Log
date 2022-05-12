<template>

  <main>
        
    <navbar /> 

      <b-container fluid class="dashboard mt-5 pb-5">
                
        <!--<pre> {{ logs }} </pre>-->
        
        <br>
        
        <h3 class="mb-4">Dashboard</h3>

      
        <table class="table table-bordered table-sm table-hover">

          <!--INTENZIONE STATICA DELLA TABELLA-->
          <thead class="">
            <tr class="bg-header">
            <th scope="col">#</th>
            <th scope="col">Request</th>
            <th scope="col">Date</th>
            <th scope="col">Response</th>
            <th scope="col">Bytes</th>
            <th scope="col">Ip</th>
            </tr>
          </thead>

                <!--CORPO DELLA TABELLA-->
            <tbody>

              <tr v-for="( log, index) in logs" :key="log.id">  
                <th scope="row"> {{ index }}</th>
                <td>{{ log.request }}</td>
                <td>{{ log.MONTH }}-{{ log.YEAR }}</td>
                <td>{{ log.response }}</td>
                <td>{{ log.bytes }}</td>
                <td>{{ log.clientip }} </td>
              </tr>

            </tbody>

        </table>


      </b-container>
        
  </main>       

</template>

<script>

  export default {
    async asyncData({ $content, params }) {
          
              
      const logs = await $content('logrep', params.slug).fetch()       
                
        return { logs }
    }
  }
</script>

<style>
    
  h3{

    color: #6c757d;
    letter-spacing: 0.3px;
    font-weight: 600;
    font-size: 18px;
  }
  body{

    height: 100vh;
    background-color: #fff;
  }
    
  .bg-header{
    background-color:lightsteelblue ;
  }
</style>
