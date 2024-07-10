const PROXY_CONFIG = [
{
  context: ['/api'],
  target: "http://localhost:8080",
  secure: false,
  changeOrigin: true,
  pathRewrite:{
    "^/": ""
  }
},
{
  context: ['/json'],
  target: "http://ipapi.co/json",
  secure: false,
  changeOrigin: true,
  pathRewrite:{
    "^/": ""
  }
},

]
module.exports = PROXY_CONFIG;
