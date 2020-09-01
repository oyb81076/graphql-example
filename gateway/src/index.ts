import { ApolloServer, mergeSchemas } from 'apollo-server';
import getFileLogger from './getFileLogger';
import dataSources from './dataSources';
import resolvers from './resolvers';
import typeDefs from './typeDefs';

const schema = mergeSchemas({ schemas: typeDefs, resolvers });
const logger = getFileLogger(__filename);
const server = new ApolloServer({
  schema,
  dataSources,
});
server.listen(4000)
  .then(({ url }) => logger.info('🚀  Server ready at %s', url))
  .catch((err) => {
    logger.error(err);
    process.exit(1);
  });
