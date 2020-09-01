import { ApolloServer, mergeSchemas } from 'apollo-server';
import getFileLogger from '../src/getFileLogger';
import typeDefs from '../src/typeDefs';
import mocks from './mocks';

const schema = mergeSchemas({ schemas: typeDefs });
const logger = getFileLogger(__filename);
const server = new ApolloServer({
  schema,
  mocks,
});
server.listen(4000)
  .then(({ url }) => logger.info('🚀  Server ready at %s', url))
  .catch((err) => {
    logger.error(err);
    process.exit(1);
  });
