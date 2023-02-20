const http = require("http");
const express = require("express");
const app = express();
const router = express.Router();

app.set("views", __dirname + "/views");
app.set("view engine", "ejs");

process.env.PORT = 3000;
app.set("port", process.env.PORT || 3001);

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.static(__dirname + "/public"));

router.route("/").get((req, res) => {
  res.end();
});

infoList = [
  {no: 1, id: "ch", name: "kim", email: "email@naver.com"},
];

// infoView.ejs를 보여주는 코드
router.route("/infoView").get((req, res) => {
  console.log("GET - /infoView");
  req.app.render("infoView", { infoList: infoList }, (err, data) => {
    if (err) throw err;
    res.end(data);
  });
});


router.route("infoView/imgSave").post((req, res) => {
  infoImage = req.body.photo;
  req.redirect("/infoView");
});

let infoNo = 2
router.route("/infoView/upload").post((req, res) => {
  console.log("POST - infoView/upload");
  console.log(req.body);
  var newId = req.body.id;
  var newName = req.body.name;
  var newEmail = req.body.email;
  var newPhoto = req.body.photo;
  infoList.push({no: infoNo++, id: newId, name: newName, email: newEmail, photo: newPhoto});
  res.redirect("/infoView");
});

app.use("/", router);

const server = http.createServer(app);
server.listen(app.get("port"), () => {
  console.log("Node.js 서버 실행 중 ... http://localhost:" + app.get("port"));
});