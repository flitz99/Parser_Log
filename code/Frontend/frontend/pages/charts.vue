<template>

    <main>

    <navbar />
 
   <b-container class="d-flex flex-row justify-content-between align-self-center mt-5 mb-4">
      <h1 class="p-1">Log Charts</h1>
   
      <NuxtLink to="/dashboard/logs">
        <b-container class="d-flex flex-row p-1">
          <h3 class="stats p-2">Home</h3>
          <img src="~/assets/home.png" class="img-stats"/>
        </b-container>
        </NuxtLink>
      
      
   </b-container>
            
    <b-container class="shadow-sm p-3 mb-5 bg-body rounded">
      <b-row>
        <b-col class="">
          <BarChart :chartData="chartData" :options="chartOptions" class="chart" />
          <h3 class="mt-3 mb-3 ml-3">Tot. Transazioni: 4089 transizioni</h3>
        </b-col>
        <b-col class="">
          <LineChart :chartData="chartData2" :options="chartOptions" class="chart" />
          <h3 class="mt-3 mb-3 ml-3">Num. Bytes scambiati: 56744688 bytes</h3>
        </b-col>
      </b-row>

      <b-row class="mt-5">  

        <b-col class="">
            <NutChart v-if="loaded" :chartData="chartData3" :options="chartOptions" class="chart" />
            
        </b-col>

        <b-col class="bg-warning">
              <ul>
              <li v-for="info in infos" :key="info.id">{{ info.codice }}</li>
            </ul>
        </b-col>

      </b-row>

    </b-container>
  
    </main>
    
</template>

<script>

export default {

  data(){
      return {    
            info: [],
            chartData: {
            labels: [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
            datasets: [{
                label: "Transazioni",
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
        chartData3: {
            labels: [ "200", "302", "404", "400", "201", "301", "401", "304", "307", "206"],
            datasets: [{
                label: "Log ",
                borderWidth: 2,
                fill: true,
                backgroundColor: ['#b6eef5', '#b6eef5', '#d8eb2e', '#00D8FF', '#b6eef5', '#b6eef5'], 
                data: [2869, 320, 205, 23, 5, 662, 2, 2, 1, 1 ],
            }]
        },
        chartData3: null,
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
  
  async fetch() {
    this.info = await fetch('/alldb/all/stats').then(res => res.json())
  },
  
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
  .img-stats{
    width: 30px;
    filter: invert(70%);
    height: 30px;
  }
</style>