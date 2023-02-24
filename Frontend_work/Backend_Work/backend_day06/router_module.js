module.exports = function (router, app) {
  const localDB = app.get("localDB");
  router.route("/login").post((req, res) => {
    console.log("POST - /login");
    const userId = req.body.id;
    const passwd = req.body.passwd;
    if (localDB) {
      let users = localDB
        .collection("users")
        .findOne({ id: userId, passwd: passwd }, function (err, result) {
          if (err) throw err;
          if (result) {
            // session에 정보를 저장 하고 이동...
            req.session.user = {
              id: userId,
              name: result.name,
            };
            res.redirect("/product");
          } else {
            console.log("불일치한다.");
            res.redirect("/login.html");
          }
        });
    } else {
      console.log("localDB 없습니다.");
    }
  });

  router.route("/logout").get(async (req, res) => {
    req.session.user = null;
    res.redirect("/login.html");
  });

  router.route("/product").get(async (req, res) => {
    res.writeHead(200, { "Content-Type": "text/html; charset=utf8" });
    res.write("<h1>product page!</h1>");
    if (req.session.user) {
      res.write("Hi : " + req.session.user.name + " login!");
      res.write("<p><a href='/logout'>Logout</a></p>");
      res.end();
    } else {
      res.redirect("/login.html");
    }
  });

  router.route("/test/car/list").get(async (req, res) => {
    const db = app.get("db");
    console.log("GET - /test/car/list 요청 됨.");
    res.writeHead(200, { "Content-Type": "text/html; charset=utf8" });
    res.write("<h1>Test page!</h1>");
    if (db) {
      const car = db.collection("car");
      car.find({}).toArray(function (findErr, carList) {
        if (findErr) throw err;
        req.app.render("car/list", { carList }, function (err, html) {
          res.end(html);
        });
      });
      console.log("출력 완료 !");
    } else {
      console.log("db 연결 안됨");
    }
  });
};
