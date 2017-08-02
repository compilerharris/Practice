<?php 
	try{	
		$pdo = new PDO("mysql:host=localhost;dbname=erail","root","root");
		$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	}catch(PDOException $e){
		echo ;
	}

 ?>
<!DOCTYPE html>
<html>
<head>
	<title>E Rail</title>
</head>
<body>
<div>
	<form action="" method="post">
		<label>Source : </label>
		<select name="sStn">
			<option name="PL">Panvel</option>
			<option name="BR">Belapur CBD</option>
			<option name="VA">Vashi</option>
			<option name="KH">Khandeshwar</option>
		</select>
		<br><br>
		<label>Destination : </label>
		<select name="dStn">
			<option name="PL">Panvel</option>
			<option name="BR">Belapur CBD</option>
			<option name="VA">Vashi</option>
			<option name="KH">Khandeshwar</option>
		</select>
		<br><br>
		<button type="submit">Print</button>
	</form>
</div>
</body>
</html>
<?php 
		
 ?>