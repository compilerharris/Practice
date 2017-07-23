<html>
<head>
	<title>Register Form</title>
</head>
<body>

</body>
</html>

	<?php
	class RegisterFrom{
		public function __construct(){
			?>
				<form method="POST" action="constraints.php">
					<input type="text" name="name" placeholder="Name">
					<input type="text" name="rollNo" placeholder="15DCO67">
					<input type="submit" name="register" value="Register">
				</form>
			<?php
		}
	}

	 ?>
</body>
</html>