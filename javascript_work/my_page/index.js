const http = require("http");
const express = require("express");
const app = express();

app.use(express.static("public"));

app.set("view engine", "ejs");
app.set("views", "./template");

app.get("/", (req, res) => {
  res.writeHead(200, { "Content-Type": "text/html; charset=UTF-8" });
  res.write("<h1>환영합니다!</h1>");
  res.write("<ul><li><a href='/html/test.html'>test page</a></li>");
  res.write("<li><a href='/home'>home page</a></li></ul>");
  res.end();
});
app.get("/home", (req, res) => {
  var arr = [1, 2, 3, 4];
  req.app.render("home", { arr }, (err, html) => {
    if (err != null) {
      console.log("Error rendering");
      res.end();
    } else {
      res.end(html);
    }
  });
});
const server = http.createServer(app);
server.listen(3000, () => {
  console.log("서버 실행중 : ");
});
