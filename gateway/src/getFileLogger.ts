import { configure, getLogger, Logger } from 'log4js';
import { join } from 'path';

configure({
  appenders: { std: { type: 'console' } },
  categories: { default: { appenders: ['std'], level: 'all' } },
});
const start = join(__dirname, '.').length + 1;
export default function getFileLogger(filename: string): Logger {
  const end = filename.length - 3;
  return getLogger(filename.substring(start, end));
}
