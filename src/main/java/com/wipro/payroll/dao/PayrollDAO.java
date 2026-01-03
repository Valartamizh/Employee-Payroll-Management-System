package com.wipro.payroll.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.wipro.payroll.util.*;
import com.wipro.payroll.bean.PayrollBean;

public class PayrollDAO {
	Connection con = DBUtil.getDBConnection();

	public String createRecord(PayrollBean payrollBean) throws InvalidInputException {
		try {
			PreparedStatement ps = con.prepareStatement("insert into payroll_tbl values(?,?,?,?,?,?,?)");
			ps.setString(1, payrollBean.getRecordId());
			ps.setString(2, payrollBean.getEmployeeName());
			ps.setString(3, payrollBean.getDesignation());
			ps.setDate(4, payrollBean.getPaymentDate());
			ps.setInt(5, payrollBean.getSalary());
			ps.setString(6, payrollBean.getDepartment());
			ps.setString(7, payrollBean.getRemarks());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public PayrollBean fetchRecord(String employeeName, Date paymentDate) throws SQLException {
		try {
			PreparedStatement ps = con
					.prepareStatement("select * from payroll_tbl where employeeName=? and paymentDate=?");

			ps.setString(1, employeeName);
			ps.setDate(2, paymentDate);
			ResultSet rs = ps.executeQuery();
			PayrollBean payrollBean = new PayrollBean();
			while (rs.next()) {
				payrollBean.setRecordId(rs.getString("recordId"));
				payrollBean.setEmployeeName(rs.getString("employeeName"));
				payrollBean.setDepartment(rs.getString("Department"));
				payrollBean.setDesignation(rs.getString("Designation"));
				payrollBean.setSalary(rs.getInt("salary"));
				payrollBean.setPaymentDate(rs.getDate("paymentDate"));
				payrollBean.setRemarks(rs.getString("remarks"));
			}

			return payrollBean;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String generateRecordID(String employeeName, Date paymentDate) {

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select payroll_seq.nextval from dual");

			if (rs.next()) {
				return rs.getString("recordId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean recordExists(String employeeName, Date paymentDate) {

		try {
			PreparedStatement ps = con
					.prepareStatement("select * from payroll_tbl where employeeName=? and paymentDate=?");
			ps.setString(1, employeeName);
			ps.setDate(2, paymentDate);

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public List<PayrollBean> fetchAllRecords() {
		
		List<PayrollBean> list = new ArrayList<PayrollBean>();
		try {
			PreparedStatement ps = con.prepareStatement("Select * from payroll_tbl");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PayrollBean bean = new PayrollBean();

	            bean.setRecordId(rs.getString("record_id"));
	            bean.setEmployeeName(rs.getString("employee_name"));
	            bean.setDesignation(rs.getString("designation"));
	            bean.setPaymentDate(rs.getDate("payment_date"));
	            bean.setSalary(rs.getInt("salary"));
	            bean.setDepartment(rs.getString("department"));
	            bean.setRemarks(rs.getString("remarks"));

	            list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}
