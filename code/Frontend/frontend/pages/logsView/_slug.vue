<template>

  <main>
        
    <navbar /> 

      <b-container  class="dashboard mt-5 pb-5">
                 
        <br>
        <h3 class="mb-4">Dashboard</h3>

      
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

    data: () => ({
      logs: []
    }),
    async fetch() {
      this.logs = await this.$http.$get('http://localhost:8080/api/alldb')
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
