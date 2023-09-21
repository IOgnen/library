<template>
    <div>
      <form @submit.prevent="onCreatePost">
        <p>Name:  <input type="text" name="title" v-model="name"> <br/> </p>
        <p>Adress:<input type="text" name="address" v-model="address"> <br/> </p>
        <p>Number:<input type="text" name="number" v-model="number"> <br/> </p>
        <p>City:  <input type="text" name="city" v-model="city"> <br/> </p>
        <button type="submit"> Submit </button>
      </form>
    </div>
  <div class="add-to-cart">
    <button class="add-to-cart-button" @click="getData()">Get Data</button>
  </div>
  <table class="cool-table" data-table-theme="default zebra">
      <thead class="cool-head">
        <tr class="cool-column">
          <th>id</th>
          <th>name</th>
          <th>address</th>
          <th>number</th>
          <th>city</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(publisher) in publishers" :key="publisher.id">
          <td>{{ publisher.id }}</td>
          <td>{{ publisher.name }}</td>
          <td>{{ publisher.address }}</td>
          <td>{{ publisher.number }}</td>
          <td>{{ publisher.city }}</td>
        </tr>
      </tbody>
    </table>
      <input type="text" name="publisherId" id="publisherId">
      <button class="add-to-cart-button" @click="getPublisher()">Hello</button>
</template>

<script>
import axios from 'axios';

axios.defaults.headers.get['Access-Control-Allow-Origin'] = '*';

export default {
  name: 'HomePage',
  data() {
  return {
    name: '',
    address: '',
    number: '',
    city: '',
    publisherId: '',
    publishers: [],
    };
  },
  methods: {
    onCreatePost() {
      axios.post('http://localhost:8080/publisher/insertPublisher', {
        name: this.name,
        address: this.address,
        number: this.number,
        city: this.city,
      }).then((response) => {
        console.log(response);
      });
    },
    getPublisher() {
      this.publisherId = this.publisherId.valueOf;
      axios.get('http://localhost:8080/publisher/getPublisher', {
        params: {
          id: this.publisherId,
        },
      }).then((response) => {
        console.log(response);
      });
    },
    getData() {
      axios.get('http://localhost:8080/publisher/getAllPublishers')
        .then((response) => {
          this.publishers = response.data;
        });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.add-to-cart {
  text-align: center;
  margin-bottom: 20px;
}
.robot {
  height: 300px;
}
.add-to-cart-button {
  align-content: center;
  right: 30px;
  width: 220px;
  padding: 3px;
  font-size: 16px;
}
.cool-table {
  width: 50%;
  margin: 0 auto;
  color: #333;
  background: white;
  border: 1px solid grey;
  font-size: 12pt;
  border-collapse: collapse;
}
table th,
table td {
  padding: .5em;
  border: 1px solid lightgrey;
}
[data-table-theme*=zebra] tbody tr:nth-of-type(odd) {
  background: rgba(0,0,0,.05);
}
[data-table-theme*=zebra] tbody tr:nth-of-type(odd) {
  background: rgba(255,255,255,.05);
}
caption {
  padding:.5em;
}
th{
  margin: left 20px;
  margin: right 20px;
  padding: .5em;
  border: 1px solid grey;
}

</style>
