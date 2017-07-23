<?php 
	//include database class
	include 'database.class.php';

	//define configuration
	define("DB_HOST", "localhost");
	define("DB_USER", "root");
	define("DB_PASS", "root");
	define("DB_NAME", "pdodb");

	//instantiate database
	$database = new Database();

	if (isset($_POST['register'])) {
		$name = $_POST['name'];
		$rollNo = $_POST['rollNo'];


		//Database Query
		$database->query("INSERT INTO student (id,name,rollNo) VALUES (:id, :name, :rollNo)");


		//Bind values
		$database->bind(":id","");
		$database->bind(":name",$name);
		$database->bind(":rollNo",$rollNo);

		//execute
		$success = $database->execute();
		if($success){
			// echo "Data Insert. <br>Inserted Id is: ".$database->lastInsertId();
			header("location: login.php");
		}
		else{
			alert("There is an Error...");
			header("location: index.php");
		}	
	}

	if (isset($_POST['login'])) {
		$name = $_POST['name'];
		$rollNo = $_POST['rollNo'];

		//Database Query
		$database->query("SELECT name, rollNo FROM student WHERE name = :name AND rollNo = :rollNo");


		//Bind values
		$database->bind(":name",$name);
		$database->bind(":rollNo",$rollNo);

		//execute
		$success = $database->execute();
		if($success){

			if($database->rowCount() == 1){
				// echo "Data Insert. <br>Inserted Id is: ".$database->lastInsertId();
				header("location: home.php");	
			}
			else{
				$message = "There is an Error...";
				// echo "<script type='text/javascript'>alert('$message');</script>";
				header("location: index.php");
			}
		}
		else{
			echo "Database Error...";
		}	
	}
	
 ?>