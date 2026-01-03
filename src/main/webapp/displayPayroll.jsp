<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wipro.payroll.bean.PayrollBean" %>
<html>
<head>
    <title>Payroll Details</title>
</head>
<body>

<%
PayrollBean bean = (PayrollBean) request.getAttribute("payroll");
String msg = (String) request.getAttribute("message");

if (bean != null) {
%>
    <h2>Payroll Record</h2>
    Record ID: <%= bean.getRecordId() %><br>
    Employee Name: <%= bean.getEmployeeName() %><br>
    Designation: <%= bean.getDesignation() %><br>
    Payment Date: <%= bean.getPaymentDate() %><br>
    Salary: <%= bean.getSalary() %><br>
    Department: <%= bean.getDepartment() %><br>
    Remarks: <%= bean.getRemarks() %><br>

<%
} else {
%>
    <h3><%= msg != null ? msg : "No matching records exists! Please try again!" %></h3>
<%
}
%>

<a href="menu.html">Back to Menu</a>

</body>
</html>

