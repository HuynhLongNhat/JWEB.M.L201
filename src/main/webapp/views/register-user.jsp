<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register User</title>
    <link rel="stylesheet" type="text/css" href="/css/register-user.css">
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<link rel="stylesheet" type="text/css" href="/resources/css/register-user.css">

</head>
<body>
    <h2>USER DETAIL</h2>
  <p id="formMessage">Please fill all mandatory fields</p>


    <form id="registerForm" action="register" method="POST">
      <label for="firstName">First Name *</label>
<input type="text" id="firstName" name="firstName" placeholder="Enter first name" >


<label for="lastName">Last Name *</label>
<input type="text" id="lastName" name="lastName" placeholder="Enter last name" >

<label for="email">Email *</label>
<input type="email" id="email" name="email" placeholder="Enter email" >


<label for="userName">User Name *</label>
<input type="text" id="userName" name="userName" placeholder="Enter user name" >

<label for="password">Password *</label>
<input type="password" id="password" name="password" placeholder="Enter password" >
<p class="error-message" id="passwordError" style="color: red;"></p>

<label for="confirmPassword">Confirm Password *</label>
<input type="password" id="confirmPassword" name="confirmPassword" placeholder="Enter password again" >


        <button type="submit">Register</button>
         <a href="/JWEB_M_L101/login" class="btn btn-link text-center">Click here to Login</a> 
    </form>

  <script src="/resources/js/register-user.js"></script>
  


</body>
</html>
