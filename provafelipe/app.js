
//npm install express --save
const express = require('express');
const app = express();
var formidable = require('formidable');
//npm install ejs --save
app.set("view engine", "ejs");

app.use(express.urlencoded({ extended: true }));
app.get('/', (req, res) => {
    res.redirect('/index.html');
});
app.get('/index.html', (req, res) => {
    res.sendFile(__dirname + '/index.html');
});

app.listen(3000);