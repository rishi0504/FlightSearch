/**
 * Created by Rishabh on 1/31/2016.
 */

var express = require("express");
var bodyParser = require("body-parser");
var mongoose = require("mongoose");
var morgan = require("morgan");
var config = require("./config");
var app = express();
var fs = require('fs');
var path = require('path');
var rename = require("gulp-rename");
var gulp = require('gulp');
var cron = require('node-crontab');
var node_dir = require('node-dir');
var multipart = require('connect-multiparty');
var multipartMiddleware = multipart({uploadDir: uploadDir});


var jobId = cron.scheduleJob("*/30 * * * *", function () {
    node_dir.readFiles('./tmp', function (err, content, filename, next) {
        fs.unlinkSync(filename);
        next();
    });
});

app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());
mongoose.connect(config.database);
var uploadDir = './tmp';


app.use(morgan('dev'));
app.post('/file', multipartMiddleware, function (req, res) {
    gulp.src(req.files.files.path)
        .pipe(rename(req.files.files.originalFilename))
        .pipe(gulp.dest("./images"));
});
require('./server/routes/signup.route')(app, express);
require('./server/routes/signin.route')(app, express);
require('./server/routes/current.user.route')(app, express);


app.get('/', function (req, res) {
    res.json({method: "Get method is called."});
});

app.listen(config.port, function () {
    console.log("Server is running on " + config.port);
})

