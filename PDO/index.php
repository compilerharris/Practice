<html>
<head>
	<title>Home</title>
</head>
<body>
	<?php 
		//include register and login class
		include 'register.php';
		include 'login.php';

		$register = new RegisterFrom();
		echo "<br><br><br>";
		$login = new LoginFrom();
 	?>
</body>
</html>