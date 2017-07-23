

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

	// //Database Query
	// $database->query("INSERT INTO student (id,name,rollNo) VALUES (:id, :name, :rollNo)");

	// //Bind values
	// $database->bind(":id","");
	// $database->bind(":name","Haris");
	// $database->bind(":rollNo","15DCO67");

	// //execute
	// $database->execute();

	// //To insert multilpe data first start transaction

	// 	$database->beginTransaction();
	
	// 	//Database Query
	// 	$database->query("INSERT INTO student (id,name,rollNo) VALUES (:id, :name, :rollNo)");


	// 	//Bind values
	// 	$database->bind(":id","");
	// 	$database->bind(":name","Taufeeq");
	// 	$database->bind(":rollNo","14CO30");

	// 	//execute
	// 	$database->execute();


	// 	//Bind values
	// 	$database->bind(":id","");
	// 	$database->bind(":name","Shahrukh");
	// 	$database->bind(":rollNo","15DCO76");

	// 	//execute
	// 	$database->execute();


	// 	//printing last inserted data
	// 	echo $database->lastInsertId();

	// 	//Terminate transaction
	// 	$database->endTransaction();

	// // printing last inserted data
	// echo $database->lastInsertId();

	// //Selecting single record

	// 	//Select query
	// 	$database->query("SELECT rollNo FROM student WHERE id = :id");

	// 	//bind values
	// 	$database->bind(":id",2);

	// 	//Call single method to execute query and fetch single record using $databse->fetch(PDO::FETCH_ASSOC)
	// 	$row = $database->single();

	// 	//Check whether $row is null or not
	// 	if (isset($row)) {
	// 		echo "Nothing is there..!";
	// 	}
	// 	else{
	// 		//Print selected value
	// 		echo "<pre>";
	// 		echo $row['rollNo'];
	// 		echo "</pre>";
	// 	}

	//Selecting multiple record

		//Select query
		$database->query("SELECT * FROM student WHERE name LIKE '%a%'");

		//bind values
		// $database->bind(":a","a");

		//Call resultset method to execute query and fetch multiple record using $databse->fetchAll(PDO::FETCH_ASSOC)
		$row = $database->resultSet();

		//Check whether $row is null or not
		if (!$row) {
			echo "Nothing is there..!";
		}
		else{
			//Print selected value
			echo "<pre>";
			// print_r($row);
			for ($i=0;$i<$database->rowCount();$i++ ) {
				echo "ID: ".$row[$i]['id']."<br>";
				echo "Name: ".$row[$i]['name']."<br>";	
				echo "Roll No: ".$row[$i]['rollNo']."<br><br><br>";
				// echo "Name: ".$row[0]['name']."<br>";
				// echo "Roll No: ".$row[0]['rollNo'];

				// echo $database->rowCount();
			}
			echo "</pre>";
		}

 ?>
