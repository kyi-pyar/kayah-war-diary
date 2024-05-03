<template>
  <v-container>
    <v-row>
      <v-col>
        
          <VueDatePicker v-model="date"></VueDatePicker>
          <v-text-field label="Label" v-model="title"></v-text-field>      
              <v-textarea
                bg-color="amber-lighten-4"
                color="orange orange-darken-4"
                label="about detail"
                v-model="about"
              ></v-textarea>
              
              <v-btn @click="getDate">click</v-btn>
       
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <v-text-field>Enter receiver mail address</v-text-field>
        <v-btn @click="mail_sent()">send</v-btn>
      </v-col>
    </v-row>
  
</v-container>
  </template>
  
  <script>
  import VueDatePicker from '@vuepic/vue-datepicker';
  import '@vuepic/vue-datepicker/dist/main.css'
  
  export default {
    name: 'InsertDataVue',
    components: { VueDatePicker },
    data() {
      return {
         to : 'kyipyarlwin9@gmail.com',
       subject : 'Hello',
       body : 'This is the body of the email.',
        date: null,
        about:"",
        title:""
      };
    },
    methods:{
      getDate(){
      console.log(this.date)
      console.log(this.title)
      console.log(this.about)
    },
    async mail_sent(){
     
      
  try {
    const resp = await fetch("http://localhost:8082/diary/sent", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({to:this.to, subject:this.subject,body:this.body}),
    });
    if(resp){
      console.log(resp, )
    }
  } catch (error) {
    console.log(error);
    return null;
  }
}

    }
}
  </script>