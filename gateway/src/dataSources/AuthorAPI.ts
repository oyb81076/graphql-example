/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
/* eslint-disable @typescript-eslint/no-explicit-any */
import { RESTDataSource } from 'apollo-datasource-rest';

export default class AuthorAPI extends RESTDataSource {
  baseURL = 'http://localhost:8080/api/author';

  createOne = async (payload: any) => this.post(payload);

  deleteOne = async (id: string) => this.delete(id);

  updateOne = async (id: string, input: any) => this.put(id, input);

  findOne = async (id: string) => this.get(id);

  findList = async () => this.get('');

  findPage = async (params: any) => this.get('', params);
}
