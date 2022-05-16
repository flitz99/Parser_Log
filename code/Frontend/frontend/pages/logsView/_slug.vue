<template>

  <main>
        
    <navbar /> 

      <b-container  class="dashboard mt-5 pb-5">
                 
        <br>

        <div class="d-flex justify-content-between flex-row align-items-center align-self-center mb-4">
          
          <h3 class="m-2">Dashboard</h3>
          
          <div class="d-flex m-2">
            <NuxtLink to="/charts">
            <h3 class="stats p-2">Statistiche</h3>
            </NuxtLink>
            <img class="img-stats" src="~assets/stats-bars.png" />
          </div> 

        </div>

      
        <table class="table table-bordered table-sm table-hover text-center">

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
            <tbody class="align-middle">

              <tr v-for="( log, index) in logs" :key="log.id">  
                <th scope="row" class="id align-middle"> {{ index }}</th>
                <td class="req align-middle">{{ log.richiesta }}</td>
                <td class="date align-middle">{{ log.orario }}-{{ log.giorno }}-{{ log.mese }}-{{ log.anno }}</td>
                <td class="res align-middle" >{{ log.codice_risposta }}</td>
                <td class="byt align-middle">{{ log.quantita_trasmissione }}</td>
                <td class="ip align-middle">{{ log.ip_cliente }} </td>
              </tr>

            </tbody>

        </table>


      </b-container>
        
  </main>       

</template>

<script>

  export default {
 
    /*async asyncData({ params, $http }) {
      const logs = await $http.$get('http://localhost:8080/api/alldb')
      return { logs }
    }*/
    async asyncData({ $axios }) {
      const logs = await $axios.$get('http://localhost:8080/api/alldb')
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

  .stats{
    color: #727cf5;
    letter-spacing: 0.3px;
    font-weight: 600;
    font-size: 16px;
  }

  .img-stats{
    width: 30px;
    filter: invert(70%);
    height: 30px;
  }

  main{ background-color: #fff; }

  .req{
    max-width:200px !important;
    overflow: scroll;
  }
  
  .ip, .res, .date , .byt{
    width: auto;
  }

  .bg-header{
    background-color:lightsteelblue ;
  }
</style>
