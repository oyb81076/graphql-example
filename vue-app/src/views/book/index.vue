<template>
  <div>
    <h1>Books Page</h1>
    <button @click="$apollo.queries.findBookList.refetch()">Refresh</button>
    <div>{{$apollo.queries.findBookList.loading}}</div>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Classify</th>
          <th>Created</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in findBookList" :key="item.id">
          <td v-text="item.id"></td>
          <td v-text="item.name"></td>
          <td v-text="item.classify && item.classify.name"></td>
          <td v-text="item.created"></td>
          <td>
            <router-link :to="`detail/${item.id}`">详情</router-link>
            &nbsp;&nbsp;&nbsp;
            <router-link :to="`edit/${item.id}`">编辑</router-link>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script lang="ts">
import Vue from 'vue';
import gql from 'graphql-tag';

export default Vue.extend({
  apollo: {
    findBookList: gql`query bookList{
      findBookList {
        id
        name
        classify {
          id
          name
        }
        created
      }
    }
    `,
  },
});
</script>
