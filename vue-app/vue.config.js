module.exports = {
  lintOnSave: false,
  devServer: {
    port: 5000,
    proxy: {
      '/graphql': { target: 'http://localhost:4000' },
    },
  },
};
