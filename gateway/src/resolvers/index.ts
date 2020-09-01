import { IResolvers } from 'apollo-server';
import authorResolver from './authorResolver';
import bookResolver from './bookResolver';
import bookClassifyResolver from './bookClassifyResolver';

const resolvers: IResolvers[] = [
  authorResolver,
  bookResolver,
  bookClassifyResolver,
];
export default resolvers;
