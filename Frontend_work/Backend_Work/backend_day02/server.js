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

// static 미들웨어 설정 - express에 내장.
app.use(express.static(__dirname + "/public"));

const todoList = [
  { idx: 1, title: "hello", done: false },
  { idx: 2, title: "world", done: false },
  { idx: 3, title: "node공부", done: false },
];
let seqTodoList = todoList.length + 1;

app.get("/home", (req, res) => {
  res.writeHead(200, { "Content-Type": "text/html; charset=utf8" });
  res.write("<h1>길동이의 홈페이지</h1>");
  res.end();
});

app.get("/todoList", (req, res) => {
  req.app.render("todoList", { todoList: todoList }, (err, data) => {
    if (err) throw err;
    res.end(data);
  });
});

app.post("/todoList", (req, res) => {
  console.log("POST - /todoList");
  var newItem = req.body.newItem; // bodyParser 설정.
  todoList.push({ idx: seqTodoList++, title: newItem, done: false });
  res.redirect("/todoList");
});

app.get("/todoList/update", (req, res) => {
  console.log("GET - /todoList/update");
  let idx = req.query.idx;
  let title = req.query.title;
  let done = req.query.done; // string 형태로 받아진다.
  let index = todoList.findIndex((item, i) => {
    return item.idx == idx;
  });
  console.log(idx, title, done); // 들어오는 값 확인
  if (index != -1) {
    if (title) {
      // index를 찾는는다.
      // 해당 요소의 title을 변경
      // 수정
      todoList[index].title = title;
    } else if (done) {
      // 취소선
      todoList[index].done = !todoList[index].done;
    } else {
      // 삭제
      todoList.splice(index, 1);
    }
  }
  if (idx > 0 && !done) {
    for (var i=idx;i <= todoList.length; i++){
      todoList[i-1].idx = i
    };
  };
  seqTodoList = todoList.length + 1;
  res.redirect("/todoList");
});

app.get("/json/todoList", (req, res) => {
  // res.end() - 문자열 인자만 처리
  // res.send() - (수식 or 객체)만 처리 => 결과는 JSON문자열
  res.send({ todoList });
});

const server = http.createServer(app);
server.listen(app.get("port"), () => {
  console.log("Node.js 서버 실행 중 ... http://localhost:" + app.get("port"));
});
