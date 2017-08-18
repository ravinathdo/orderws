package com.order.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public Connection getConnection() {
		Connection con = null;

		String dbhost;
		String user;
		String password;

		// get properties
		dbhost = SystemMessage.getMessage("dbhost");
		user = SystemMessage.getMessage("user");
		password = SystemMessage.getMessage("password");

//		System.out.println("S=======db Connecting======");
//		System.out.println("dbhost:" + dbhost);
//		System.out.println("user:" + user);
//		System.out.println("password:" + password);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// con =
			// DriverManager.getConnection("jdbc:mysql://192.168.64.11:3306/ebanksl","dbuser","ubc");
			con = DriverManager.getConnection(dbhost, user, password);
		} catch (Exception e) {
			System.err.println("error in connection");
			e.printStackTrace();
		}
		System.out.println("E=======db Connecting======");
		return con;
	}

	public static void main(String[] args) {
		new DBConnection().getConnection();
	}
}
