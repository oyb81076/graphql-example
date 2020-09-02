<template>
  <div>
    <h1>Books Detail</h1>
    <pre>{{findBook}}</pre>
  </div>
</template>
<script lang="ts">
import Vue from 'vue';
import gql from 'graphql-tag';

export default Vue.extend({
  props: {
    id: String,
  },
  apollo: {
    findBook: {
      query: gql`query findBook($id: ID!){
        findBook(id: $id) {
          id
          name
          classify {
            id
            name
          }
          created
        }
      }`,
      variables() {
        return { id: this.id };
      },
    },
  },
});
</script>
