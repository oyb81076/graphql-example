/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { IResolvers } from 'apollo-server';
import { DataSources } from '../dataSources';

const bookClassifyResolver: IResolvers<{ authorId: string }, { dataSources: DataSources }> = {
  Mutation: {
    createBookClassify(_, { input }, ctx) {
      return ctx.dataSources.bookClassify.createOne(input);
    },
    deleteBookClassify(_, { id }, ctx) {
      return ctx.dataSources.bookClassify.deleteOne(id);
    },
    updateBookClassify(_, { id, input }, ctx) {
      return ctx.dataSources.bookClassify.updateOne(id, input);
    },
  },
  Query: {
    findBookClassify(_, { id }, ctx) {
      return ctx.dataSources.bookClassify.findOne(id);
    },
    findBookClassifyList(_, __, ctx) {
      return ctx.dataSources.bookClassify.findList();
    },
  },
};

export default bookClassifyResolver;
