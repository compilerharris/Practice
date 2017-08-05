<?php 
	try{	
		$pdo = new PDO("mysql:host=localhost;dbname=erail","root","");
		$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		if(isset($_GET['submit'])){
			$s = $_GET['sStn'];
			$d = $_GET['dStn'];

			$stmt = $pdo->prepare("SELECT km FROM kilometer WHERE source = :source AND destination = :destination");

			$stmt->bindParam(":source",$s);
			$stmt->bindParam(":destination",$d);

			$stmt->execute();
			$result = $stmt->fetchAll(PDO::FETCH_ASSOC);
			var_dump($result);
			foreach ($result as $key) {
				echo "<center>";
				echo "Kilometer : ".$key["km"];
				echo "</center>";
			}
		}else{
			echo "There is an ERROR...";
		}

	}catch(PDOException $e){
		echo "Could not connect...";
	}

 ?>