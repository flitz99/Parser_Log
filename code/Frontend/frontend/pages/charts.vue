<template>

    <main>

    <navbar />
  
    <h1 class="text-center mt-5 mb-5">Log Charts</h1>
  
    <b-container class="shadow-sm p-3 mb-5 bg-body rounded">
      <b-row>
        <b-col class="">
          <BarChart :chartData="chartData" :options="chartOptions" class="chart" />
          <h3 class="mt-3 mb-3 ml-3">Tot. Transizioni: 4089 transizioni</h3>
        </b-col>
        <b-col class="">
          <LineChart :chartData="chartData2" :options="chartOptions" class="chart" />
          <h3 class="mt-3 mb-3 ml-3">Num. Bytes scambiati: 56744688 bytes</h3>
        </b-col>
      </b-row>
      <b-row>  
        <b-col class="">

          <table class="table table-bordered table-sm table-hover text-center">

          <!--INTENZIONE STATICA DELLA TABELLA-->
          <thead class="">
            <tr class="bg-header">
            <th scope="col">#</th>
            <th scope="col">Pagine visitate</th>
            <th scope="col">Data</th>
            </tr>
          </thead>

                <!--CORPO DELLA TABELLA-->
            <tbody class="align-middle">
              <tr v-for="( log, index) in logs" :key="log.id">  
                <th scope="row" class="id align-middle"> {{ index }}</th>
                <td class="req align-middle">{{ log.richiesta }}</td>
                <td class="date align-middle">{{ log.orario }}-{{ log.giorno }}-{{ log.mese }}-{{ log.anno }}</td>
              </tr>

            </tbody>

        </table>
        </b-col>
      </b-row>
    </b-container>
  
    </main>
    
</template>

<script>
//import axios from 'axios';

export default {

  data(){
      return {    
        logs: [],
            chartData: {
            labels: [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
            datasets: [{
                label: "Transizioni",
                borderWidth: 2,
                fill: true,
                //borderColor: ['red', '#fff','#fff','#fff', '#fff','#fff','#fff'], 
                data: [0, 0, 0, 0, 0, 0, 0, 1529, 2560, 0, 0, 0],
            }]
        },
        chartData2: {
            labels: [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
            datasets: [{
                label: "Bytes scambiati",
                borderWidth: 2,
                fill: true,
                //borderColor: ['red', '#fff','#fff','#fff', '#fff','#fff','#fff'], 
                data: [0, 0, 0, 0, 0, 0, 0, 15861539, 40886149, 0, 0, 0],
            }]
        },
        chartOptions: {
            maintainAspectRatio: false,
            responsive: true,
            tooltips:{
                backgroundColor: "lightsteelblue",
                titleFontColor: "#6c757d",
                bodyFontColor: "#000000",
                position: "nearest",
                intersect: 0,
                
            },
            legend:{
                display: true,
                labels: {
                    fontColor: "#000",
                },
            }
        }
        
      }
    },
    /*async fetch() {
    const { data } = await axios.get(
      'http://localhost:8080/api/alldb/'
    );
    this.logs = data;
  },
    activated() {
      // Call fetch again if last fetch more than 5 sec ago
      if (this.$fetchState.timestamp <= Date.now() - 5000) {
        this.$fetch()
      }
    },*/
    async asyncData({ $axios }) {
      const logs = await $axios.$get('/alldb')
      return { logs }
    }
}


</script>

<style>

h1{
    color: #6c757d;
    letter-spacing: -0.3px;
    font-weight: 600;
    font-size: 28px;
}
 h3{
    color: #6c757d;
    letter-spacing: -0.3px;
    font-weight: 600;
    font-size: 15px;
  }
.chart{

    width: 100%;
    height: 280px;

}
table{
  margin-top: 80px;
}
.req{
    max-width:300px !important;
    overflow: scroll;
  }
.bg-header{
    background-color:lightsteelblue ;
  }
</style>