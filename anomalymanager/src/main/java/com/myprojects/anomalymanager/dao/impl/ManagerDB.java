package com.myprojects.anomalymanager.dao.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.myprojects.anomalymanager.exception.TechnicalException;

public class ManagerDB {
	private String url = "jdbc:mysql://localhost/gestion des anomalies";
	private String usr = "root";
	private String pssword = "baz";
	private static Connection conn;

	private ManagerDB() throws TechnicalException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, usr, pssword);
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			throw new TechnicalException();
		} catch (ClassNotFoundException e) {

		}
	}

	public static Connection getInstance() {
		if (conn == null) {
			try {
				new ManagerDB();
			} catch (TechnicalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;

	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
