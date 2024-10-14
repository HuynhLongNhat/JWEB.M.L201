<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add an Department</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

    <%@ include file="header.jsp" %>

    <div class="container">
        <h2 class="mb-4">Add an Department</h2>
        <form action="add-department" method="post"> 
            <div class="form-group">
                <label for="name">Department name:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter department name" required>
            </div>
              <button type="submit" class="btn btn-primary">Create</button>
           
        </form>
    </div>

  <div class="fixed-bottom">
  <%@ include file="footer.jsp" %>
</div>

</body>
</html>