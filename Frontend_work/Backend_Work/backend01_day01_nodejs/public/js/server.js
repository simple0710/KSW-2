const http = require("http");
const fs = require("fs");
const url = require("url");

const server = http.createServer();
server.listen(3000, () => {
  console.log("Node.js 서버 실행 중...");
});

server.on("request", (req, res) => {
  if (req.url === "/") {
    res.writeHead(200, { "Content-Type": "text/html; charset=utf8" });
    res.write("<h1>길동이의 홈페이지</h1>");
    res.end();
  }
  if (req.url === "/house") {
    let filename = "../길쭉싫은데요.jpg";
    fs.readFile(filename, function (err, data) {
      if (err) throw err;
      res.writeHead(200, { "Content-Type": "image/jpg" });
      res.write(data);
      res.end();
    });
  }
});
