module.exports = {
  client: {
    service: {
      name: 'vue-app',
      url: 'http://localhost:4000/graphql',
    },
    includes: [
      'src/**/*.vue',
      'src/**/*.ts',
    ],
  },
};
