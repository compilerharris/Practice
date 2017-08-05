<?php 
	try{	
		$pdo = new PDO("mysql:host=localhost;dbname=erail","root","");
		$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	}catch(PDOException $e){
		echo "Could not connect...";
	}

	if(isset($_POST['print'])){
		echo "<div><center>";
		echo "Source: ".$_POST['sStn'];
		echo "<br><br>Destination: ".$_POST['dStn'];
		echo "</center></div>";
	}
 ?>