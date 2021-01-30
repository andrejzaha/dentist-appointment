const path = require('path');

module.exports = {

    entry: './src/index.js',

    output: {
        filename: 'bundle.js',
        path: path.join(__dirname, 'public')
    },

    module: {
       rules: [
         {
          loader: 'babel-loader',
          test: /\.js$/,
          exclude: /node_modules/
         },
         {
           test: /\.css$/i,
           use: ["style-loader", "css-loader"],
         },
       ]
    },

    mode: 'development',

    devServer: {
      contentBase: path.join(__dirname, 'public'),
      compress: true,
      port: 9000,
      proxy: {
        '/backend': {
          target: 'http://localhost:8080',
          pathRewrite: {'^/backend' : '/api'}
        }
      }
    },

};
