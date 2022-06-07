<template>

  <main class="mb-5">
        
    <navbar /> 

      <b-container  class="dashboard mt-1 pb-0 shadow-sm p-3 mb-5 bg-body rounded" >
                 
        <br>

        <div class="d-flex justify-content-between flex-row align-items-center align-self-center mb-4">
          
          <h3 class="m-0">Dashboard</h3>
          
          <div class="d-flex flex-column justify-content-center">
            <div class="d-flex m-0">
              <NuxtLink to="/charts">
              <h3 class="stats p-2">Statistiche</h3>
              </NuxtLink>
              <img src="~/assets/stats-bars.png" class="img-stats"/>
            </div> 
            <div class="err-stats d-flex ">
              <NuxtLink to="/dashboard/logerrors">
                <h3 class="stats p-2">Error logs</h3>
              </NuxtLink>
              <img src="~/assets/alert.png" class="img-err p-1"/>
            </div>
          </div>

        </div>
         
      </b-container>

      <b-container class="d-flex flex-column-reverse shadow p-3 mb-5 bg-white rounded">

            <b-container fluid class="m-0 mt-5">
                <b-table
                :items="logs"
                :fields="fields"
                :current-page="currentPage"
                :per-page="perPage"
                :filter="filter"
                :filter-included-fields="filterOn"
                :tbody-tr-class="rowClass"
                :filter-debounce="1000"
                stacked="md"          
                show-empty  
                small
                @filtered="onFiltered"
                class="tbl"
              >
              <template #cell(richiesta)="row">
                {{ row.item.richiesta }}
              </template>

              <template #cell(data_completo)="row">
                {{ row.item.data_completo }} 
              </template>

              <template #cell(ip)="row">
                {{ row.item.ip_cliente }}
              </template>

              <template #cell(codice_risposta)="row">
                {{ row.item.codice_risposta }}
                <NuxtLink :to="'/info'">
                  <img src="~/assets/info.png" class="img-info m-1"/>
                </NuxtLink>
              </template>

              <template #cell(actions)="row">
                <NuxtLink :to="`/dashboard/logdetails/${row.item.id}`">
                  mostra dettagli
                </NuxtLink>
                
              </template>

              </b-table>

                <b-pagination
                v-model="currentPage"
                :total-rows="totalRows"
                :per-page="perPage"
                align="fill"
                size="sm"     
                class="mx-auto" style="width: 350px;"
              >
                </b-pagination>
            </b-container>

            <b-container fluid class="pt-1">

              <b-form-group
              label-for="filter-input"
              label="Filtra:"
              label-cols="1"
              content-cols="5"
              label-class="label"
             >
            <b-input-group size="sm">
                <b-form-input
                  id="filter-input"
                  v-model="filter"
                  type="search"
                  placeholder="Cerca nel log.."
                ></b-form-input>

                <b-input-group-append>
                  <b-button :disabled="!filter" @click="filter = ''" class="btn-clear">Clear</b-button>
                </b-input-group-append>

              </b-input-group>

              </b-form-group>

              <b-form-group
               
                label="Filtra su"
                description=""
                label-cols="1"
                label-align="left"
                label-size="sm"
                class="mb-3"
                label-class="label2"
                v-slot="{ ariaDescribedby }"  
              >
                <b-form-checkbox-group
                  v-model="filterOn"
                  :aria-describedby="ariaDescribedby"
                  class="mt-1"
                >
                  <b-form-checkbox value="richiesta">richiesta</b-form-checkbox>
                  <b-form-checkbox value="data_completo">
                    data 
                    <small>(yyyy-mm-dd)</small>
                  </b-form-checkbox>
                  <b-form-checkbox value="ip_cliente">ip</b-form-checkbox>               
                  <b-form-checkbox value="codice_risposta">Codice stato</b-form-checkbox> 
                </b-form-checkbox-group>
              </b-form-group>

              <b-form-group
              label="Logs per pagina"
              label-for="per-page-select"
              label-cols="1"
              label-class="label2"
              label-align-sm="left"
              label-size="sm"
              content-cols="1"
              class="mb-0"
            >
              <b-form-select
                id="per-page-select"
                v-model="perPage"
                :options="pageOptions"
                size="sm"
              >
              </b-form-select>
              </b-form-group>
            </b-container>
            

      </b-container>

    
  </main>       

</template>

<script>
  
  export default {
    
    head: {
    title: 'Logs View',
    },
    async asyncData({ $axios}) {
      const logs = await $axios.$get('/alldb/all')
      return { logs }
    },
    data() {
      return {
        fields: [
          { key: 'richiesta', label: 'Richiesta'},
          { key: 'data_completo', label: 'Data'},
          { key: 'ip_cliente', label: 'Ip'},
          { key: 'codice_risposta', label: 'Codice stato', class: 'text-center'},
          { key: 'actions', label: 'Actions'},
        ],
        totalRows: 1,
        currentPage: 1,
        perPage: 5,
        pageOptions: [5, 10, 15, { value: 100, text: "Show a lot" }],
        filter: null,
        filterOn: [],       
      }
    },
    computed: {
    
    },
    mounted() {
      // Set the initial number of items
      this.totalRows = this.logs.length;
    },
    methods: {
      // Colora la riga in base al codice d'errore
      rowClass(log, type){

          if (!log || type !== 'row') 
                return

          if ((log.codice_risposta >= 200) && (log.codice_risposta < 400)) 
                return 'log_success'
                
          if ((log.codice_risposta == 401) || 
              (log.codice_risposta == 429) || 
              (log.codice_risposta == 403) ||
              (log.codice_risposta == 451))
                return 'log_danger'

          if ((log.codice_risposta >= 500))
                return 'table-warning'  
      },
      onFiltered(filteredItems) {
        // Trigger pagination to update the number of buttons/pages due to filtering
        this.totalRows = filteredItems.length
        this.currentPage = 1
      }
    }

  }
</script>

<style>

  .err-stats{
    margin-top: -10px;
    margin-left: 2px;
  }
  th{
    background-color: #fff;
  }
  
  .log_success {
    background-color: #b6eef5;
  }

  .log_warning{
    background-color: #d8eb2e;
  }

  .log_danger{
    background-color: #E34234;
  }

  .stats{
    color: #727cf5;
    letter-spacing: 0.3px;
    font-weight: 600;
    font-size: 16px!important;
  }

  .label{
    font-weight: 600;
    letter-spacing: 0.5px;
    font-size: 18px;
    color: #808080;
  
  }

  .label2{
    font-weight: 500;
    letter-spacing: 0.3px;
    font-size: 13px;
    color: #000;

  }

  main{ background-color: #fff; }

  td div {
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    max-width: 500px !important;
  }
 
  .btn-clear{
    background-color: #007bff !important;
    border-color: #007bff;
    z-index: 3  ;
    color: #fff;
  }

  .tbl{
    margin-top: 5px!important;
  }
  
</style>
