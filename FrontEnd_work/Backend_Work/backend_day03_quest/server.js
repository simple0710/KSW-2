const http = require("http");
const express = require("express");
const app = express();
const router = express.Router();

process.env.PORT = 3000;
app.set("port", process.env.PORT || 3001);

app.use(express.urlencoded({ extended: true }));
app.use(express.static(__dirname + "/public"));

router.route("/").get((req, res) => {
  res.end();
});

router.route("/upload").get(function (req, res) {
  console.log("POST - /get");
  res.redirect("/");
});

router.route("/upload").post((req, res) => {
  console.log("POST - /upload");
  res.redirect("/upload");
});


app.use("/", router);

const server = http.createServer(app);
server.listen(app.get("port"), () => {
  console.log("Node.js 서버 실행 중 ... http://localhost:" + app.get("port"));
})