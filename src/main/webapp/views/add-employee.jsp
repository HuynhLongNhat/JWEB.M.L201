<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="fa.training.entities.Department" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add an Employee</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

    <%@ include file="header.jsp" %>

    <div class="container">
        <h2 class="mb-4">Add an Employee</h2>
        <form action="add-emloyee" method="post"> 
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter name" required>
            </div>
            <div class="form-group">
                <label>Gender:</label>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="male" value="Male" checked>
                    <label class="form-check-label" for="male">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="female" value="Female">
                    <label class="form-check-label" for="female">Female</label>
                </div>
            </div>
            <div class="form-group">
                <label for="dob">Date of birth:</label>
                <input type="date" class="form-control" id="dob" name="dob" placeholder="dd/mm/yyyy" required>
            </div>
            <div class="form-group">
                <label for="department">Department:</label>
                <select class="form-control" id="department" name="department">
                    <% 
                        List<Department> departments = (List<Department>) request.getAttribute("departments");
                        if (departments != null && !departments.isEmpty()) {
                            for (Department dept : departments) {
                    %>
                        <option value="<%= dept.getId() %>"><%= dept.getName() %></option>
                    <% 
                            }
                        } 
                    %>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">
                <i class="fa fa-plus"></i> Add Employee 
            </button>
        </form>
    </div>

  <div class="fixed-bottom">
  <%@ include file="footer.jsp" %>
</div>

</body>
</html>