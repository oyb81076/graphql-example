<template>
  <div>
    <h1>Books Edit</h1>
    <pre>{{findBook}}</pre>
    <pre>{{findBookClassifyList}}</pre>
    <div>
      <div>
        <span>Name</span>
        <input v-model="name" />
      </div>
      <div>
        <span>Classify</span>
        <select v-model="classifyId">
          <option v-if="findBook" :value="findBook.classify.id" v-text="findBook.classify.name" />
          <option v-for="x in findBookClassifyList" :key="x.id" :value="x.id" v-text="x.name" />
        </select>
      </div>
      <div>Submitting: {{submitting}}</div>
      <button @click="submit">保存</button>
    </div>
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
    findBookClassifyList: gql`query edit_findBookClassifyList {
      findBookClassifyList {
        id
        name
      }
    }
    `,
    findBook: {
      query: gql`query edit_FindBook($id: ID!){
        findBook(id: $id) {
          id
          name
          author {
            id, name
          }
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
  data() {
    return {
      name: '', classifyId: '', authorId: '', submitting: false,
    };
  },
  watch: {
    findBook(obj: { name: string; classify: { id: string }; author: { id: string } }) {
      this.name = obj.name;
      this.classifyId = obj.classify.id;
      this.authorId = obj.author.id;
    },
  },
  methods: {
    submit() {
      this.submitting = true;
      this.$apollo.mutate({
        mutation: gql`mutation updateBook($id: ID!, $name: String!, $classifyId: ID!, $authorId: ID!) {
          updateBook(id: $id, input: { name: $name, classifyId: $classifyId, authorId: $authorId }) {
            id name classify {
              id name
            }
            created
          }
        }`,
        variables: {
          id: this.id,
          name: this.name,
          classifyId: this.classifyId,
          authorId: this.authorId,
        },
      }).then(() => {
        this.$apollo.queries.findBook.refetch();
      }).catch((err) => {
        console.log(err);
      }).finally(() => { this.submitting = false; });
    },
  },
});
</script>
