var http = require('http');
var express = require('express');
var app = express();
var server = http.createServer(app);
var static = require('serve-static');
var bodyParser = require('body-parser');
var socketio = require('socket.io');
var path = require('path');

app.set('port', process.env.PORT || 3000);

app.use('/', static(path.join(__dirname, '/public')));

server.listen(app.get('port'), function () {
    console.log('서버가 실행:', app.get('port'));
});

var io = socketio.listen(server);

io.sockets.on('connection', function (socket) {
    console.log('소켓 연결 됨:', socket.request.connection._peername);

    socket.on('linesend', function(data) {
        console.log(data);
        
        socket.broadcast.emit('linesend_tocllinet', data);
    });
    
    socket.on('disconnect', function() {
        console.log('user disconnected');
    });
});
