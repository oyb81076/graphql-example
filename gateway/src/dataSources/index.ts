import AuthorAPI from './AuthorAPI';
import BookAPI from './BookAPI';
import BookClassifyAPI from './BookClassifyAPI';

// eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types
const dataSources = () => ({
  author: new AuthorAPI(),
  book: new BookAPI(),
  bookClassify: new BookClassifyAPI(),
});
export default dataSources;

export type DataSources = ReturnType<typeof dataSources>;
