/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { IResolvers } from 'apollo-server';
import { DataSources } from '../dataSources';

const authorResolver: IResolvers<unknown, { dataSources: DataSources }> = {
  Mutation: {
    createAuthor(_, { input }, ctx) {
      return ctx.dataSources.author.createOne(input);
    },
    deleteAuthor(_, { id }, ctx) {
      return ctx.dataSources.author.deleteOne(id);
    },
    updateAuthor(_, { id, input }, ctx) {
      return ctx.dataSources.author.updateOne(id, input);
    },
  },
  Query: {
    findAuthor(_, { id }, ctx) {
      return ctx.dataSources.author.findOne(id);
    },
    findAuthorList(_, __, ctx) {
      return ctx.dataSources.author.findList();
    },
    findAuthorPage(_, args, ctx) {
      return ctx.dataSources.author.findPage(args);
    },
  },
};

export default authorResolver;
