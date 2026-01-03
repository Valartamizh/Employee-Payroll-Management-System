package com.wipro.payroll.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;
import java.sql.Date;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import com.wipro.payroll.bean.PayrollBean;
import com.wipro.payroll.service.Administrator;

public class MainServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Administrator admin = new Administrator();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String op = request.getParameter("operation");

        try {
            if ("newRecord".equals(op)) {
                PayrollBean bean = new PayrollBean();
                bean.setEmployeeName(request.getParameter("employeeName"));
                bean.setDesignation(request.getParameter("designation"));
                bean.setSalary(Integer.parseInt(request.getParameter("salary")));
                bean.setDepartment(request.getParameter("department"));
                bean.setRemarks(request.getParameter("remarks"));

                Date date = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("paymentDate"));
                bean.setPaymentDate(date);

                String result = admin.addRecord(bean);

                if ("FAIL".equals(result) || "INVALID INPUT".equals(result))
                    response.sendRedirect("error.html");
                else
                    response.sendRedirect("success.html");

            } else if ("viewRecord".equals(op)) {
            	
                String name = request.getParameter("employeeName");
                Date date = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("paymentDate"));

                PayrollBean bean = admin.viewRecord(name, date);

                if (bean == null) {
                    request.setAttribute("message", "No matching records exists! Please try again!");
                } else {
                    request.setAttribute("payroll", bean);
                }
                request.getRequestDispatcher("displayPayroll.jsp").forward(request, response);

            } else if ("viewAllRecords".equals(op)) {
                List<PayrollBean> list = admin.viewAllRecords();
                request.setAttribute("payrollList", list);
                request.getRequestDispatcher("displayAllPayrolls.jsp").forward(request, response);
            }

        } catch (Exception e) {
            response.sendRedirect("error.html");
        }
    }
}
