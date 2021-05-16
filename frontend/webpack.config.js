const path = require('path');
const webpack = require("webpack");

module.exports = {

    entry: [
      'react-hot-loader/patch',
      './src/index.js',
    ],

    output: {
        filename: 'bundle.js',
        path: path.join(__dirname, 'public/dist'),
        publicPath: '/'
    },

    plugins: [
        new webpack.HotModuleReplacementPlugin()
    ],

    module: {
       rules: [
         {
          loader: ['react-hot-loader/webpack', 'babel-loader'],
          test: /\.js$/,
          exclude: /node_modules/
         },
         {
           test: /\.(sa|sc|c)ss$/,
           use: ["style-loader", "css-loader"],
         },
       ]
    },

    mode: 'development',

    devServer: {
      contentBase: path.join(__dirname, 'public'),
      hot: true,
      port: 9000,
      proxy: {
        '/backend': {
          target: 'http://localhost:8080',
          pathRewrite: {'^/backend' : '/api'}
        }
      },
      historyApiFallback: true,
    },

};
