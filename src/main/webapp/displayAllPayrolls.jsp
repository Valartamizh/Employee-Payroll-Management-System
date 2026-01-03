<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.wipro.payroll.bean.PayrollBean" %>
<html>
<head>
    <title>All Payroll Records</title>
</head>
<body>

<%
PayrollBean roll =new PayrollBean();
List<PayrollBean> list = new ArrayList<>();

if (list == null || list.isEmpty()) {
%>
    <h3>No records available!</h3>
<%
} else {
%>
<table border="1">
<tr>
    <th>Record ID</th>
    <th>Employee Name</th>
    <th>Designation</th>
    <th>Payment Date</th>
    <th>Salary</th>
    <th>Department</th>
    <th>Remarks</th>
</tr>

<%
for (PayrollBean p : list) {
%>
<tr>
    <td><%= p.getRecordId() %></td>
    <td><%= p.getEmployeeName() %></td>
    <td><%= p.getDesignation() %></td>
    <td><%= p.getPaymentDate() %></td>
    <td><%= p.getSalary() %></td>
    <td><%= p.getDepartment() %></td>
    <td><%= p.getRemarks() %></td>
</tr>
<%
}
}
%>
</table>

<a href="menu.html">Back to Menu</a>

</body>
</html>
