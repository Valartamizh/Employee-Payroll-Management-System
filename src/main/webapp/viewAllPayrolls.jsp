<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>View All Payrolls</title>
</head>
<body>
<h2>View All Payroll Records</h2>

<form action="MainServlet" method="post">
    <input type="hidden" name="operation" value="viewAllRecords">
    <input type="submit" value="View All">
</form>

</body>
</html>
