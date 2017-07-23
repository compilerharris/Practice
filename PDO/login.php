<html>
<head>
	<title>Login Form</title>
</head>
<body>

</body>
</html>

	<?php
	class LoginFrom{
		public function __construct(){
			?>
				<form method="POST" action="constraints.php">
					<input type="text" name="name" placeholder="Name">
					<input type="text" name="rollNo" placeholder="15DCO67">
					<input type="submit" name="login" value="Login">
				</form>
			<?php
		}
	}

	 ?>
</body>
</html>