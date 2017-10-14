<template>
  <div id="app">
    <b-jumbotron header="Docker compose demo (Microservice Architecture)" lead="Products are fetched from products-server, which lives in separate container">
      <b-card-group deck>
        <template v-for="(p, index) in products">
          <b-card :footer="p.id.toString()" :img-src="p.imgSrc" img-top style="max-width: 20rem;" class="mb-2">
              <p>Product Name: <b-badge>{{p.name}}</b-badge></p>
              <p>Product Id: <b-badge pill variant="success">{{p.id}}</b-badge></p>
          </b-card>
        </template>
      </b-card-group>
      <b-button :href='productsUrl' variant="primary">Get products as json</b-button>
    </b-jumbotron>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'app',
  components: {
  },
  data() {
    return {
      productsUrl: 'http://localhost:9196/api/products',
      products: [],
      product: {
        id: null,
        name: '',
        imgSrc: ''
      }
    }
  },
  created() {
    axios.get('http://localhost:9196/api/products').then(r => {
      if (r.data) {
        r.data.forEach(product => {
          this.products.push(product)
        })
      }
    }).catch(e => console.log(e))
  },
  methods: {

  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
