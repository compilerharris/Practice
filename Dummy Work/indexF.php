<!DOCTYPE HTML>
<html>
<head>
<title>Register</title>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</script>
<script type="text/javascript" src="Script.js"></script>
</head>
<body>
    <div class="signin-form">
        <div class="container">
            <form class="form-signin" method="post" id="register-form">
                <h2 class="form-signin-heading">Sign Up</h2><hr />
                <div id="error">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Username" name="user_name" id="user_name" />
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="Email address" name="user_email" id="user_email" />
                    <span id="check-e"></span>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Password" name="password" id="password" />
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Retype Password" name="cpassword" id="cpassword" />
                </div>
                <hr />
                    <div class="form-group">
                    <button type="submit" class="btn btn-default" name="btn-save" id="btn-submit">
                        <span class="glyphicon glyphicon-log-in"></span> &nbsp; Create Account
                    </button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>