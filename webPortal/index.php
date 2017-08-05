<?php 
	try{	
		$pdo = new PDO("mysql:host=localhost;dbname=erail","root","");
		$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

		$query = "SELECT name FROM station";

		$stmt = $pdo->prepare($query);
		$stmt->execute();
		$result = $stmt->fetchAll(PDO::FETCH_ASSOC);
		// print_r($result);

	}catch(PDOException $e){
		echo "Could not connect...";
	}
 ?>
<!DOCTYPE html>
<html>
<head>
	<title>E Rail</title>
</head>
<body>
<div>
	<form action="check.php" method="post">
		<label>Source : </label>
		<select name="sStn">
		<?php
			foreach ($result as $key) {			
				echo "<option>".$key['name']."</option>";
			}
		?>
		</select>
		<br><br>
		<label>Destination : </label>
		<select name="dStn">
		<?php
			foreach ($result as $key) {			
				echo "<option>".$key['name']."</option>";
			}
		?>
		</select>
		<br><br>
		<button type="submit" name="print">Print</button>
	</form>
</div>
</body>
</html>
<?php 
		
 ?>