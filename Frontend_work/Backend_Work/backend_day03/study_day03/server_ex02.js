const http = require("http");
const express = require("express");
const app = express();
const cors = require("cors");

app.set("views", __dirname + "/views"); // prefix
app.set("view engine", "ejs"); // suffix

process.env.PORT = 3000;
app.set("port", process.env.PORT || 3001);

app.use(express.json()); // application/json
app.use(express.urlencoded({ extended: true })); // application/x-www-form-urlencoded

// 사용자 정의 미들웨어 - Filter 역할
// 모든 요청에 적용되는 공통 처리 부분
app.use("*", (req, res, next) => {
  console.log("사용자 정의 미들웨어 1");
  console.log("name param value: ", req.query.name);

  // 미들 웨어 실행 후 다음 기능 호출
  next();
  console.log(">>>> response 미들웨어 1");
});

app.use((req, res, next) => {
  res.writeHead(200, { "Content-Type": "text/html; charset=utf8" });
  console.log("사용자 정의 미들웨어 2");
  console.log("request url: ", req.url);

  // 미들 웨어 실행 후 다음 기능 호출
  next();
  console.log(">>>> response 미들웨어 2");
});

const todoList = [
  { idx: 1, title: "hello", done: false },
  { idx: 2, title: "world", done: false },
  { idx: 3, title: "node공부", done: false },
];

app.get("/home", (req, res) => {
  res.write("<h1>길동이의 홈페이지</h1>");
  res.end(); // end() 안하면 무한루프 발생.
});

app.get("/todoList", (req, res) => {
  req.app.render("todoList", { todoList: todoList }, (err, data) => {
    res.end(data);
  });
});

app.post("/todoList", (req, res) => {
  console.log("POST - /todoList");
  var newItem = req.body.newItem; // bodyParser 설정.
  console.log("new item : " + newItem);
  res.redirect("/todoList");
});

const server = http.createServer(app);
server.listen(app.get("port"), () => {
  console.log("Node.js 서버 실행 중 ... http://localhost:" + app.get("port"));
});
