import { ApolloServer, mergeSchemas } from 'apollo-server';
import typeDefs from '../src/typeDefs';
import mocks from './mocks';

const schema = mergeSchemas({ schemas: typeDefs });
const server = new ApolloServer({
  schema,
  mocks,
});

server.listen(4000)
  .then(({ url }) => console.info('🚀  Server ready at %s', url))
  .catch((err) => {
    console.error(err);
    process.exit(1);
  });
