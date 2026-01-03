package com.wipro.payroll.service;


import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wipro.payroll.bean.PayrollBean;
import com.wipro.payroll.dao.PayrollDAO;
import com.wipro.payroll.util.InvalidInputException;

public class Administrator {
	PayrollDAO dao = new PayrollDAO();
	
	public String addRecord(PayrollBean payrollBean) throws InvalidInputException {
		if(payrollBean.getEmployeeName() == null || payrollBean.getPaymentDate() == null) {
			throw new InvalidInputException("“INVALID INPUT");
		}
		if(payrollBean.getEmployeeName().length() < 2) {
			throw new InvalidInputException("“INVALID NAME");
		}
		if(payrollBean.getPaymentDate() == null) {
			throw new InvalidInputException("“INVALID DATE");
		}
		if(dao.recordExists(payrollBean.getEmployeeName(), payrollBean.getPaymentDate())) {
			throw new InvalidInputException("Already exist");
		}
		String recordId = dao.generateRecordID(payrollBean.getEmployeeName(), payrollBean.getPaymentDate());
		PayrollBean bean = new PayrollBean();
		bean.setRecordId(recordId);
		bean.setEmployeeName(payrollBean.getEmployeeName());
		bean.setDepartment(payrollBean.getDepartment());
		bean.setDesignation(payrollBean.getDesignation());
		bean.setPaymentDate(payrollBean.getPaymentDate());
		bean.setRemarks(payrollBean.getRemarks());
		bean.setSalary(payrollBean.getSalary());
		try {
			dao.createRecord(bean);
		} catch (Exception e) {
			e.toString();
		}
		return "Created Successfully";
	}
	
	public PayrollBean viewRecord(String employeeName, Date paymentDate) throws InvalidInputException {
		
		if(employeeName == null || paymentDate == null) {
			throw new InvalidInputException("“INVALID INPUT");
		}
		
		try {
			dao.fetchRecord(employeeName, paymentDate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<PayrollBean> viewAllRecords(){
		List<PayrollBean> list = new ArrayList<PayrollBean>();
		list = dao.fetchAllRecords();
		return list;
	}
	
}
