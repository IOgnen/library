<template>
  <div class="home">
    <button clase="add-to-cart" @click="getData()">Get Data</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'HomePage',
  data() {
  return {
    publishers: [],
    };
  },
  methods: {
      getData() {
        axios.get('http://localhost:8080/api/publisher/getAllPublishers')
          .then((response) => {
            console.log(response);
          });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.home {
  text-align: center;
}
.robot {
  height: 300px;
}
.add-to-cart {
  position: absolute;
  right: 30px;
  width: 220px;
  padding: 3px;
  font-size: 16px;
}
</style>
