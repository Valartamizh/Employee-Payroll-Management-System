<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<html>
<head>
    <title>Add Payroll</title>
</head>
<body>
<h2>Add Payroll Record</h2>

<form action="MainServlet" method="post">

    <input type="hidden" name="operation" value="newRecord">

    Employee Name: <input type="text" name="employeeName"><br><br>
    Designation: <input type="text" name="designation"><br><br>
    Payment Date: <input type="date" name="paymentDate"><br><br>
    Salary: <input type="number" name="salary"><br><br>
    Department: <input type="text" name="department"><br><br>
    Remarks: <input type="text" name="remarks"><br><br>

    <input type="submit" value="Add Payroll">
</form>

</body>
</html>
