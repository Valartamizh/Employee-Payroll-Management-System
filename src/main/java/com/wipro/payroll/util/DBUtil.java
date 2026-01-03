package com.wipro.payroll.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection con;

	public static Connection getDBConnection() {
		if (con == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
				return con;
			} catch (SQLException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return con;
	}
	public static void main(String[] args) {
		try{
			Connection con=DBUtil.getDBConnection();
		if(con!=null) {
			System.out.println("Working");
		}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
