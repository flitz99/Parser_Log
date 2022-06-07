<template>

    <main>

    <navbar />
 
   <b-container class="d-flex flex-row justify-content-between align-self-center mt-5 mb-4 shadow-sm p-3 mb-5 bg-body rounded">
      <h1 class="p-1">Log Charts</h1>
   
      <NuxtLink to="/dashboard/logs">
        <b-container class="d-flex flex-row p-1">
          <h3 class="stats p-2">Home</h3>
          <img src="~/assets/home.png" class="img-stats"/>
        </b-container>
        </NuxtLink>
      
      
   </b-container>
            
    <b-container class="shadow p-3 mb-5 bg-body rounded">
      <b-row>
        <b-col class="">
          <BarChart :chartData="chartData" :options="chartOptions" class="chart" />
          <h3 class="mt-4 mb-3 ml-3">Tot. Transazioni: {{ tot_tran }} transazioni</h3>
        </b-col>
        <b-col class="">
          <LineChart :chartData="chartData2" :options="chartOptions" class="chart" />
          <h3 class="mt-4 mb-3 ml-3">Num. Bytes scambiati: {{ tot_bytes }} bytes</h3>
        </b-col>
      </b-row>

      <b-row class="mt-5">  

        <b-col class="">
             <div class="d-flex justify-content-center align-items-center mb-5">
                <h3 class="p-2">Log status code </h3>
                <NuxtLink :to="'/info'">
                      <img src="~/assets/info.png" class="img-info m-1"/>
                </NuxtLink>
             </div>
            <NutChart :chartData="chartData3" :options="chartOptions" class="chart" />
        </b-col>
        <b-col>
          <GmapMap
              :center="coord[0].position"
              :zoom="1"
              map-type-id="terrain"
              style="height: 300px" 
              class="mt-5"
            >
              <GmapMarker
                :key="index"
                v-for="(c, index) in coord"
                :position="c.position"
                :clickable="true"
              />
            </GmapMap>
        </b-col>
      </b-row>

    </b-container>
  
    </main>
    
</template>

<script>

export default {

  head: {
    title: 'Statistiche',
  },

  async asyncData( { $axios } ) {

      const lab = [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
      var tran = []
      var bytes = []
      var idx, idx2, idx3, idx4
      var tot_bytes = 0
      var tot_tran = 0
      const status_stat = await $axios.$get('/all/stats')
      const num_st_cod = 5
      var tot_cod_st = [0, 0, 0, 0, 0]
      const all_ip = []
      const geo = await $axios.$get('/richieste')
      const coord = []

      for( idx = 0; idx < lab.length; idx++ ){
        const stat = await $axios.$get(`/alldb/bytescount/anno/2021/mese/${lab[idx]}`)
        if (Array.isArray(stat)){
          tran.push(parseInt(stat[0].num_transizioni))
          bytes.push(parseFloat(stat[0].num_bytes))
        }
        else{
          tran.push(0)
          bytes.push(0)
        } 
        tot_bytes += bytes[idx]
        tot_tran += tran[idx]
      }
      for( idx3 = 0; idx3 < num_st_cod; idx3++){
        for ( idx2 = 0; idx2 < status_stat.length; idx2++ ){
          if ( status_stat[idx2].codice.charAt(0) == `${idx3+1}` ){
            tot_cod_st[idx3] += parseInt(status_stat[idx2].quantita)
          }
        }
      }
      for ( idx4 = 0; idx4 < geo.length; idx4++){
          coord.push(
            {
              position : {
                lat: parseFloat(geo[idx4].latitudine),
                lng : parseFloat(geo[idx4].longitudine)
              }
            }
          )
      }
      
      return { 
        chartData: {
          labels: lab,
          datasets: [{
            label: "Transazioni",
            borderWidth: 2,
            fill: true,
            data: tran
          }]
        },
        chartData2: {
           labels: lab,
            datasets: [{
                label: "Bytes scambiati",
                borderWidth: 2,
                fill: true,    
                data: bytes,
            }]
        },
        chartData3: {
          labels: ["1XX", "2XX", "3XX", "4XX", "5XX"],
         
          datasets: [{
                label: "Log ",
                borderWidth: 2,
                fill: true,
                backgroundColor: ['#808080', '#2185d0', '#008732', '#E34234', '#d8eb2e'], 
                data: tot_cod_st,
            }]
        },
        tot_bytes,
        tot_tran,
        all_ip,
        coord
      }
  },
  data(){
      return {    
        info: [],
        chartData: {},
        chartData2: {},
        chartData3: {},
        all_ip: [],
        coord: [],
        markers: [{

        }],
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
        },
        tot_bytes: '',
        tot_tran: '',        
      }
  },
}


</script>

<style>

  
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
  
.img-info{
  margin: 0 0 6px 2px!important;
  
}

</style>