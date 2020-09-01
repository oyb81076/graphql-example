import { IMocks } from 'apollo-server';
import snowflake from 'node-snowflake.js';
import { Random } from 'mockjs';

const nextId = snowflake();

const mocks: IMocks = {
  ID: nextId,
  Date: () => new Date(Random.datetime()).toISOString(),
  Book: () => ({
    name: Random.ctitle(),
  }),
  Author: () => ({
    name: Random.cname(),
  }),
  BookClassify: () => ({
    name: Random.ctitle(),
  }),
};

export default mocks;
