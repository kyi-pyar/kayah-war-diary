<template>
  <v-container>
    <v-row class="text-center">
      hello world
      <v-btn @click="getLocation()">get Location</v-btn>
      {{ location }}
    </v-row>
  </v-container>
</template>

<script>

export default {
  name: 'HelloWorld',

  data: () => ({
    location:[]
}),
methods:{  

  async getLocation(){
//     const options = {
//   method: 'GET',
//   url: 'https://api.geoapify.com/v1/isoline?lat=48.13736145&lon=11.574172059316222&type=time&mode=transit&range=1800&apiKey=60382788c02948f18d0a564122b40d02',
  
// };


// async function get(path){
    
//     const resp=await fetch(
//     domain+path,{
//     method:'GET'
//     });
//     return resp;
//     }
    

try {
	const response = await fetch(
    'https://api.geoapify.com/v1/isoline?lat=48.13736145&lon=11.574172059316222&type=time&mode=transit&range=1800&apiKey=60382788c02948f18d0a564122b40d02',{
    method:'GET'
  });
  
	// console.log(response);
  this.location = await response.json();
} catch (error) {
	console.error(error);
}
}

  }
}
</script>
