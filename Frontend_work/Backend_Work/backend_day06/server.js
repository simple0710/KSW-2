const http = require("http");
const express = require("express");
const app = express();
const server = http.createServer(app);
const router = express.Router();
const { MongoClient } = require("mongodb");
const session = require("express-session");
const cookieParser = require("cookie-parser");

app.set("port", process.env.PORT || 3000);
app.set("views", __dirname + "/views");
app.set("view engine", "ejs");

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.static(__dirname + "/public"));

app.use(cookieParser());
app.use(
  session({
    secret: "my key",
    resave: true,
    saveUninitialized: true,
  })
);

const uri = "mongodb://127.0.0.1";
const client = new MongoClient(uri, { useUnifiedTopology: true });
let db = null;
let localDB = null;
async function connectDB() {
  try {
    // Connect the client to the server (optional starting in v4.7)
    await client.connect();
    // Establish and verify connection
    db = await client.db("vehicle");
    localDB = await client.db("local");
    console.log("Connected successfully to server");
    app.set("db", db);
    app.set("localDB", localDB);
  } finally {
    // Ensures that the client will close when you finish/error
    //await client.close();
  }
}

///////--------------------------------
const routerModule = require("./router_module");
routerModule(router, app);

app.use("/", router);

server.listen(app.get("port"), () => {
  console.log("http://localhost:" + app.get("port"));
  console.log("Node.js 서버 실행 중 ...");
  connectDB().catch(console.dir);
});
