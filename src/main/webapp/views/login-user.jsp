<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center"> 
            <div class="col-md-6"> 
                <div class="card">
                    <div class="card-header text-center ">
                       <span class="font-weight-bold h3" >LOGIN</span>    
                    </div>
                    <div class="card-body">
                        <form action="login" method="post">
                            <div class="form-group">
                                <label for="username">User Name:</label>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Enter user name" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Login</button>
                            <a href="/JWEB_M_L101/register" class="btn btn-link">Click here to Register</a> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>