<template>
  <div>

    
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">

      <b-form-group 
        id="input-group-2" 
        label="Username:" 
        label-for="input-2"
      >
        <b-form-input
          id="input-2"
          v-model="form.Username"
          placeholder="Enter username"
          required
        >
        </b-form-input>

      </b-form-group>

       <b-form-group
        id="input-group-1"
        label="Password:" 
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="form.Password"
          type="password"
          placeholder="Enter password"
          required
        ></b-form-input>

      </b-form-group>
      <!--  
      <b-form-group id="input-group-4" v-slot="{ ariaDescribedby }">
        <b-form-checkbox-group
          v-model="form.checked"
          id="checkboxes-4"
          :aria-describedby="ariaDescribedby"
        >
        
        </b-form-checkbox-group>
      </b-form-group>
      -->

      <b-button block type="submit" class="btn" variant="primary">Submit</b-button>  
    
      <b-button block type="reset" class="btn" variant="danger">Reset</b-button>
      
    </b-form>
    <!--
    <b-card class="mt-3" header="Form Data Result">
      <pre class="m-0">{{ form }}</pre>
    </b-card>
    -->
  </div>
</template>

<script>
  export default {
    data() {
      return {
        form: {
          username: '',
          password: '',
      
        },
        //foods: [{ text: 'Select One', value: null }, 'Carrots', 'Beans', 'Tomatoes', 'Corn'],
        show: true
      }
    },
    methods: {
      onSubmit(event) {
        event.preventDefault()
        alert(JSON.stringify(this.form))
      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.form.Username = ''
        this.form.Password = ''
        
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
    }
  }
</script>

<style>
  .btn {
    font-size: 13px !important;
  }
</style>