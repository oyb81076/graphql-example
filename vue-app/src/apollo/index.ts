import ApolloClient from 'apollo-boost';

const apollo = new ApolloClient({
  uri: '/graphql',
});
export default apollo;
