package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connectdatabase {
	public static Connection getConnection() {
		String query ;
		String dbsotaikhoan, dbmatkhau ;
		boolean login =false;
		Connection c = null;
		try {
			// đăng kí my sql với drivermanager
			String url = "jdbc:mysql://localhost:3306/hoteldata";
			String username = "root";
			String password = "";
			
			// tạo ket nối
			c = DriverManager.getConnection(url, username, password);
			// check đăng nhập 
		
		
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
				;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
