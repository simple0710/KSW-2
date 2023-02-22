// mongojs 모듈을 이용한 monogdb 연동
var mongojs = require('mongojs');

var db = mongojs('vehicle',['car']);
console.log("car list");
db.car.find(function(err, data) {
    console.log(data);
});

db.close();