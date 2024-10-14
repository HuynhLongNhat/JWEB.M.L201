<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="fa.training.entities.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Employees</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>

<%@ include file="header.jsp" %>

<div class="container">
    <h2 class="mb-4">Employee List</h2>

    <% 
        List<Employee> employees = (List<Employee>) request.getAttribute("employees");
        if (employees != null && !employees.isEmpty()) {
    %>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Employee Name</th>
                    <th>Gender</th>
                    <th>Date of Birth</th>
                    <th>Department Name</th>
                </tr>
            </thead>
            <tbody>
                <% for (Employee emp : employees) { %>
                    <tr>
                        <td><%= emp.getId() %></td>
                        <td><%= emp.getName() %></td>
                        <td><%= emp.getGender() %></td>
                        <td><%= emp.getDob() %></td>
                      <td><%= emp.getDepartmentName() %></td>

                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } else { %>
        <p>No employees found.</p>
    <% } %>
</div>

<div class="fixed-bottom">
    <%@ include file="footer.jsp" %>
</div>

</body>
</html>
