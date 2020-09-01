/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { IResolvers } from 'apollo-server';
import { DataSources } from '../dataSources';

interface Book {
  authorId?: string;
  classifyId?: string;
}
const bookResolver: IResolvers<Book, { dataSources: DataSources }> = {
  Mutation: {
    createBook(_, { input }, ctx) {
      return ctx.dataSources.book.createOne(input);
    },
    deleteBook(_, { id }, ctx) {
      return ctx.dataSources.book.deleteOne(id);
    },
    updateBook(_, { id, input }, ctx) {
      return ctx.dataSources.book.updateOne(id, input);
    },
  },
  Query: {
    findBook(_, { id }, ctx) {
      return ctx.dataSources.book.findOne(id);
    },
    findBookList(_, __, ctx) {
      return ctx.dataSources.book.findList();
    },
    findBookPage(_, args, ctx) {
      return ctx.dataSources.book.findPage(args);
    },
  },
  Book: {
    author({ authorId }, _, ctx) {
      if (!authorId) { return null; }
      return ctx.dataSources.author.findOne(authorId);
    },
    classify({ classifyId }, _, ctx) {
      if (!classifyId) { return null; }
      return ctx.dataSources.book.findOne(classifyId);
    },
  },
};

export default bookResolver;
