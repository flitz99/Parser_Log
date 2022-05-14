<template>
    
        <nav>
            <b-container class="navbar">
                <p class="brand m-3">H</p>
                <b-nav-form class="ml-5">
                    <b-form-input size="sm" class="mr-sm-2" placeholder="Cerca nel log.."></b-form-input>
                    <b-button size="sm" class="my-2 my-sm-0 butn" type="submit">Search</b-button>
                </b-nav-form>
            </b-container>  
        </nav>   
    

</template>

<script>
export default {

}
</script>

<style>

.brand {
    font-weight: 700 ;
    font-size: 30px;
    color: black !important;
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
.butn{
    background-color: #727cf5;
}
</style>