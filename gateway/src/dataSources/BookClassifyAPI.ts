/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
/* eslint-disable @typescript-eslint/no-explicit-any */
import { RESTDataSource } from 'apollo-datasource-rest';

export default class BookClassifyAPI extends RESTDataSource {
  baseURL = 'http://localhost:8080/api/book-classify';

  createOne = async (payload: any) => this.post(payload);

  deleteOne = async (id: string) => this.delete(id);

  updateOne = async (id: string, input: any) => this.put(id, input);

  findOne = async (id: string) => (id === '0' ? null : this.get(id));

  findList = async () => this.get('');
}
