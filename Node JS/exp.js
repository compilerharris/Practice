const express = require('express');
const bodyParser = require('body-parser');
const mysql = require('mysql');

const app = express();
// app.set('view engine','ejs');

var conn = mysql.createConnection({
	host : 'localhost',
	user : 'root',
	password : 'root',
	database : 'expressDb'
});

conn.connect(function(err){
	if (err) {
		console.log(err);
	}
});

app.get('/query',function(req,res){
	conn.query("create table khalil(username varchar(50),password varchar(20))",function(err,result){
		res.send("err= :"+err+"result: "+result);
	});
});

var urlencoder = bodyParser.urlencoded({
	extended:false
});



app.listen(3000,function(){
	console.log("Server is listening on PORT NO 3000");
});

// app.get('/',function(req,res){
// 	res.send('<h1>Haris</h1>');
// });

app.get('/about',function(req,res){
	res.sendFile(__dirname+'/about.html');
});

app.get('/dashboard/:id',function(req,res){
	res.send('<h1>Requested ID: </h1>'+req.params.id);
	console.log(req.params);
});

app.get('/',function(req,res){
	res.sendFile(__dirname+'/home.html');
	// console.log(req.params);
});

app.route('/contact').
get(function(req,res){
	res.render(__dirname+'/contact.ejs');
	// console.log(req.params);
}).
post(urlencoder,function(req,res){
	res.send("Username: "+req.body.username+"\nPassword: "+req.body.password);
});

app.get('/login/:id/:name',function(req,res,next){
	if (req.params.id == 1) {
		next();
	}else{
		res.send('Invalid ID...');
	}
},
function(req,res,next){
	if (req.params.name == 'haris') {
		next();
	}else{
		res.send('Invalid Name...');
	}
},function(req,res){
	res.sendFile(__dirname+"/home.html");
});

// app.post('/contact',urlencoder,function(req,res){
// 	res.send("Username: "+req.body.username+"\nPassword: "+req.body.password);
// });

// app.get('/contact',function(req,res){
// 	res.render(__dirname+'/contact.ejs');
// 	// console.log(req.params);
// });
