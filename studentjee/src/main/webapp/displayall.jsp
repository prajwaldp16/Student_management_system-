<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
</head>
<body>
    <h1>Student Details</h1>
    <table border="2">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
            <th>Department</th>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.address}</td>
                <td>${student.dept}</td>
                <td>
				    <button onclick="location.href='update.html?id=${student.id}'">Edit</button>
				    <button onclick="location.href='delete.html?id=${student.id}'">Delete</button>
				</td>
            </tr>
        </c:forEach>
    </table>
    
    <script type="text/javascript">
	    function redirectToEdit(studentId) {
	        window.location.href = `update.html?id=${studentId}`;
	    }
	
	    function redirectToDelete(studentId) {
	        window.location.href = `delete.html?id=${studentId}`;
	    }
    
    </script>
</body>
</html>
