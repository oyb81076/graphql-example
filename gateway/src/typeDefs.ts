import { gql } from 'apollo-server';
import { readdirSync, readFileSync } from 'fs';
import { join } from 'path';
import getFileLogger from './getFileLogger';

const logger = getFileLogger(__filename);
const GRAPHQL_DIR = join(__dirname, '../graphql');
const files = readdirSync(GRAPHQL_DIR);
const typeDefs = files
  .filter((x) => x.endsWith('.gql') || x.endsWith('.graphql'))
  // .filter((x) => x === 'book.gql')
  .map((x) => join(GRAPHQL_DIR, x))
  .map((x) => {
    try {
      const content = readFileSync(x, 'utf-8');
      return gql(content);
    } catch (err) {
      logger.error('failed to parse file %s', x);
      logger.error(err);
      throw new Error('parse file failed');
    }
  });
export default typeDefs;
