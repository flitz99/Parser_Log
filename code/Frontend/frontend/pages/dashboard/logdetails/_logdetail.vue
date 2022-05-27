<template>

  
  <b-container class="detail shadow p-3 mb-5 bg-white rounded">

        <b-row> 
          <b-col>
          <b-list-group v-for="log in log_details" :key="log.id"  class=" p-4 ">
          <h5 class="pb-3">Dettagli del log</h5>
            <b-list-group-item class="p-1">
              <p>Richiesta:</p>{{ log.richiesta }}
              </b-list-group-item>
            <b-list-group-item class="p-1">
              <p>Data:</p>{{ log.data_completo }}
              </b-list-group-item>
            <b-list-group-item class="p-0">
              <p>Orario:</p>{{ log.orario }}
              </b-list-group-item>
            <b-list-group-item class="p-1">
              <p>Timezone:</p> {{ log.timezone }}
              </b-list-group-item>
            <b-list-group-item class="p-1">
              <p>Tipo di richiesta:</p> {{ log.tipo_richiesta }}
              </b-list-group-item>
            <b-list-group-item class="p-1">
              <p>Codice risposta:</p> {{ log.codice_risposta }}
              </b-list-group-item>
            <b-list-group-item class="p-1">
              <p>Bytes trasmessi:</p> {{ log.quantita_trasmissione }}
              </b-list-group-item>
            <b-list-group-item class="p-1">
              <p>Autenticazione:</p> {{ log.autenticato }}
              </b-list-group-item>
            <b-list-group-item class="p-1">
              <p>Identificativo:</p> {{ log.identificativo }}
              </b-list-group-item>
            <b-list-group-item class="p-1">
              <p>Sito referente:</p> {{ log.sito_referente }}
              </b-list-group-item>
            <b-list-group-item class="p-1">
              <p>Dispositivo:</p> {{ log.dispositivo }}
              </b-list-group-item>
          </b-list-group>
          </b-col>

          <b-col class="p-4">

          <h5 class="pb-3">Geolocalizzazione</h5>
          <b-list-group v-for="log in log_details" :key="log.id" class="">
            <b-list-group-item class="p-1">
            <p>Ip:</p> {{ log.ip_cliente }}
            </b-list-group-item>
              <b-list-group-item class="p-0">
                <p>Latitudine:</p> {{ log.latitudine }}
                </b-list-group-item>
              <b-list-group-item class="p-0">
                <p>longitudine:</p> {{ log.longitudine }}
                </b-list-group-item>
              <b-list-group-item class="p-0">
                <p>Stato:</p> {{ log.posizione_stato }}
                </b-list-group-item>
          </b-list-group>
    
          <div v-for="item in map_url" :key="item.id" class="text-center">
            <iframe
              width="500"
              height="350"
              style="border:0"
              loading="lazy"
              allowfullscreen
              :src="item.reportUrl">
            </iframe>
            <br>
            <a :href="item.reportUrl" target="_blank">Visualizza la mappa</a>
          </div>
          
        </b-col>

        </b-row>

        <b-row fluid class="text-center">
           <b-col><NuxtLink to="/dashboard/logs" class="back">Torna ai logs</NuxtLink></b-col>
        </b-row>
              
  </b-container>
 
</template>

<script >

const { IPinfoWrapper } = require("node-ipinfo");

const ipinfo = new IPinfoWrapper("b5f71cdb8a2b75");

var resp = [];

//var ip_to_find = "";


const ips = ["1.1.1.1", "8.8.8.8", "1.2.3.4"]; 
/*
ipinfo.getMap(ips).then((response) => {
    console.log(response);
    resp.push(response)
});
*/


export default {

  data(){
    return {
      map_url: resp,
      ip_to_find: ["1.1.1.1"],
    }
  },
  async asyncData({ params, $axios }){
    
    const log_details = await $axios.$get(`/alldb/all/${params.logdetail}`)
    return { log_details }   
  },

}
</script>

<style>

  h5{
    text-transform: uppercase;
    font-size: 16px;
    font-weight: 600;
    letter-spacing: -0.3px;
  }
  p{
    display: inline;
    padding: 0 10px 0 0;
    font-weight: 600;
  }
  .back{
    font-weight: 600;
    font-size: 18px
  }
  
</style>