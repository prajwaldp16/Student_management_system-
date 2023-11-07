<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
</head>
<body>
    <h1>Student Details</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
            <th>Department</th>
            <td>ALTER</td>
        </tr>
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
    </table>
</body>
</html>
