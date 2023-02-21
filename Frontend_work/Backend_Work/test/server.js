const http = require("http");
const express = require("express");
const cors = require("cors");
const router = express.Router();
const app = express();

const server = http.createServer(app);
const { Server } = require("socket.io");
const io = new Server(server);

process.env.PORT = 3000;
app.set("port", process.env.PORT || 3001);

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.static(__dirname + "/public"));

app.use("/", router);

const clientSocketMap = {};
io.sockets.on("connetion", (socket) => {
  console.log("소켓 접속")
});

/////// error handler -----
var expressErrorHandler = require("express-error-handler");
var errorHandler = expressErrorHandler({
  static: {
    404: "./public/404.html",
  },
});
app.use(expressErrorHandler.httpError(404));
app.use(errorHandler);

server.listen(app.get("port"), () => {
  console.log("Node.js 서버 실행 중 ... http://localhost:" + app.get("port"));
});
