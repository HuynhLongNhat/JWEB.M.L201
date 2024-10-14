<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    .navbar-custom {
        background-color: #343a40; /* Màu nền navbar */
    }
    .navbar-custom .navbar-brand, 
    .navbar-custom .navbar-nav .nav-link {
        color: white; /* Màu chữ trên navbar */
    }
</style>
<%
    HttpSession userSession = request.getSession(); // Khởi tạo session
    String username = "Guest"; // Mặc định là Guest
    if (userSession != null && userSession.getAttribute("username") != null) {
        username = (String) userSession.getAttribute("username"); // Lấy username từ session
    }
%>

<nav class="navbar navbar-expand-lg navbar-custom">
    <a class="navbar-brand" href="/JWEB_M_L101/home">
        <i class="fa fa-home"></i> Home Page 
    </a>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="/JWEB_M_L101/add-department">Add an Department</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/JWEB_M_L101/list-departments">List Department</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/JWEB_M_L101/add-emloyee">Add an Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/JWEB_M_L101/list-employees">List Employees</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto"> 
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fa fa-user"></i> <%= username %>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/logout">Logout</a> <!-- Liên kết đến LogoutServlet -->
            </li>
        </ul>
    </div>
</nav>
