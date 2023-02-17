const http = require("http");
const express = require("express");
const app = express();
const cors = require("cors");

// view engine - 템플릿 엔진
app.set("views", __dirname + "/views"); // prefix
app.set("view engine", "ejs"); // suffix

process.env.PORT = 3000;
app.set("port", process.env.PORT || 3000);
// console.log(process.env.PORT ? process.env.PORT : 3000);
// console.log(process.env.PORT || 3000); // 3항 연산자의 줄임 표현

// set(name, value), get(name) 같은 쌍
// get("경로", function) 특정 경로 정보 처리
app.get("/home", (req, res) => {
  res.write("<h1>Welcome</h1>");
  res.end(); // end() 안하면 무한 루프 발생
}); // 특정 패스로 요청된 정보를 처리하는 이벤트 핸들러

// bodyParser 미들웨어 설정 - express의 설정으로 변경
// POST 요청 방식에서 body의 파라미터 사용 가능.
app.use(express.json()); // application/json
app.use(express.urlencoded({ extended: true })); // application/x-www-form-urlencoded
const carList = [
  { no: 1, title: "SONNTA", price: 2000, company: "HYUNDAI", year: 2022 },
  { no: 2, title: "GRAND", price: 3000, company: "HYUNDAI", year: 2019 },
  { no: 3, title: "K2", price: 7000, company: "KIA", year: 2020 },
];

// ejs 템플릿 뷰 엔진 사용
app.get("/car", (req, res) => {
  // req.app.render(뷰, data, 콜백(err, data){});
  let userName = "홍길동";
  req.app.render("car", { userName, carList }, (err, data) => {
    if (err) {
      console.log(err);
      return;
    }
    res.end(data);
  });
});

const todoList = [
  { idx: 1, title: "hello", done: false },
  { idx: 2, title: "world", done: false },
  { idx: 3, title: "node 공부", done: false },
];
// get 요청 방식에서 처리
app.get("/todoList", (req, res) => {
  console.log("GET - /todoList");
  req.app.render("todoList", { todoList }, (err, data) => {
    res.end(data);
  });
});
// post 요청일 때 처리
app.post("/todoList", (req, res) => {
  console.log("Post - /todoList");
  // post방식에서 파라미터 받기 - bodyParser미들웨어 사용
  var newItem = req.body.newItem;
  console.log("new item: " + newItem);
  // 저장 후 목록 갱신
  // res.end()
  // res.send()
  res.redirect("/todoList");
});

// http와 express를 합쳐준다. - 같은 port 사용.
const server = http.createServer(app);
server.listen(app.get("port"), () => {
  console.log("Node.js 서버 실행 중 ... http://localhost:" + app.get("port"));
});
