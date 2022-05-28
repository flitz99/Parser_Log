<template>

  <main class="mb-5">
        
    <nav>
        <b-container fluid class="navbar">
                <p class="brand m-3">Heimdall</p>
        </b-container>  
    </nav>   

      <b-container fluid class="dashboard mt-1 pb-0" >
                 
        <br>

        <div class="d-flex justify-content-between flex-row align-items-center align-self-center mb-4">
          
          <h3 class="m-2">Log di errore </h3>
          
          <div class="d-flex flex-column justify-content-center">
            <div class="d-flex m-0">
              <NuxtLink to="/charts">
              <h3 class="stats p-2">Statistiche</h3>
              </NuxtLink>
              <img src="~/assets/stats-bars.png" class="img-stats"/>
            </div> 
            <div class="err-stats d-flex ">
              <NuxtLink to="/dashboard/logs">
                <h3 class="stats p-2">Home</h3>
              </NuxtLink>
              <img src="~/assets/home.png" class="img-stats p-1"/>
            </div>
          </div>

        </div>
         
      </b-container>

      <b-container fluid class="d-flex flex-column-reverse shadow p-3 mb-5 bg-white rounded">

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
              <template #cell(pid)="row">
                {{ row.item.pid }}
              </template>

              <template #cell(ipv4)="row">
                {{ row.item.ipv4 }} 
              </template>

              <template #cell(ipv6)="row">
                {{ row.item.ipv6 }}
              </template>

              <template #cell(giorno)="row">
                {{ row.item.giorno }}
              </template>

              <template #cell(mese)="row">
                {{ row.item.mese }}
              </template>

              <template #cell(anno)="row">
                {{ row.item.anno }}
              </template>

              <template #cell(referer)="row">
                {{ row.item.referer }}
              </template>

              <template #cell(severita)="row">
                {{ row.item.severita }}
              </template>

              <template #cell(messaggio)="row">
                {{ row.item.messaggio }}
              </template>

              <template #cell(tag1)="row">
                {{ row.item.tag1 }}
              </template>

              <template #cell(url)="row">
                {{ row.item.url }}
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
                  <b-form-checkbox value="pid">pid</b-form-checkbox>
                  <b-form-checkbox value="ipv4">ipv4</b-form-checkbox>
                  <b-form-checkbox value="ipv6">ipv6</b-form-checkbox>
                  <b-form-checkbox value="referer">riferimento</b-form-checkbox>               
                  <b-form-checkbox value="url">url</b-form-checkbox> 
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
    title: 'Error log',
    meta: [
      {
        hid: 'description',
        name: 'description',
      },
      
    ],
  },
    async asyncData({ $axios}) {
      const logs = await $axios.$get('/alllogerr')
      return { logs }
    },
    data() {
      return {
        fields: [
          { key: 'pid', label: 'Pid'},
          { key: 'ipv4', label: 'Ipv4'},
          { key: 'ipv6', label: 'Ipv6'},
          { key: 'giorno', label: 'Giorno', class: 'text-center'},
          { key: 'mese', label: 'Mese', class: 'text-center'},
          { key: 'anno', label: 'Anno', class: 'text-center'},
          { key: 'referer', label: 'Riferimento'},
          { key: 'severita', label: 'Severità', class: 'text-center'},
          { key: 'messaggio', label: 'Messaggio'},
          { key: 'tag1', label: 'Tag'},
          { key: 'url', label: 'Url'},
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
     
      this.totalRows = this.logs.length;
    },
    methods: {
      
      rowClass(log, type){

          if (!log || type !== 'row') 
                return
            else
                return 'log_danger' 
      },
      onFiltered(filteredItems) {
        this.totalRows = filteredItems.length
        this.currentPage = 1
       
      }
    }

  }
</script>

<style >

.brand {
    font-weight: 700 ;
    font-size: 25px;
    color: #808080 !important;
    margin-left: 5px!important;
}

nav{  background-color: #f0f3fa; }

.navbar {
    background-color: #f0f3fa;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content:flex-start;
    flex-wrap: nowrap;
}
  .err-stats{
    margin-top: -10px;
    margin-left: 2px;
  }
  th{
    background-color: #fff;
  }
  
  .log_danger{
    background-color: rgb(240, 95, 82);
  }

 h3{
    color: #6c757d;
    letter-spacing: 0.3px;
    font-weight: 600;
    font-size: 22px!important;
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
    /*margin-left: 5px !important;*/
  }

  .label2{
    font-weight: 500;
    letter-spacing: 0.3px;
    font-size: 13px;
    color: #000;
    /*margin-left: 5px !important;*/
  }

  .img-stats{
    width: 30px;
    filter: invert(70%);
    height: 30px;
  }

  main{ background-color: #fff; }

  td div {
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    max-width: 150px !important;
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
