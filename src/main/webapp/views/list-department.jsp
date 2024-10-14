<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="fa.training.entities.Department" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Departments</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>

<%@ include file="header.jsp" %>

<div class="container">
    <h2 class="mb-4">Department List</h2>

    <% 
        List<Department> departments = (List<Department>) request.getAttribute("departments");
        if (departments != null && !departments.isEmpty()) {
    %>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Department Name</th>
                </tr>
            </thead>
            <tbody>
                <% for (Department dept : departments) { %>
                    <tr>
                        <td><%= dept.getId() %></td>
                        <td><%= dept.getName() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } else { %>
        <p>No departments found.</p>
    <% } %>
</div>

  <div class="fixed-bottom">
  <%@ include file="footer.jsp" %>
</div>

</body>
</html>
