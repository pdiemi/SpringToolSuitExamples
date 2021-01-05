package com.hcl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

public class ConnectionPooling {

// JDBC Driver Name & Database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/hcl";

// JDBC Database Credentials
	static final String JDBC_USER = "root";
	static final String JDBC_PASS = "root";

	private static GenericObjectPool gPool = null;
	private static ResultSet rsObj = null;
	private static Connection connObj, connObj2 = null;
	private static PreparedStatement pstmtObj = null;

	public DataSource setConnPool() throws Exception {
		Class.forName(JDBC_DRIVER);

// Creates an Instance of GenericObjectPool That Holds Our Pool of Connections
// Object!
		gPool = new GenericObjectPool();
		gPool.setMaxActive(5);

// Creates a ConnectionFactory Object Which Will Be Use by the Pool to Create
// the Connection Object!
		ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL, JDBC_USER, JDBC_PASS);

// Creates a PoolableConnectionFactory That Will Wraps the Connection Object
// Created by the ConnectionFactory to Add Object Pooling Functionality!
		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
		return new PoolingDataSource(gPool);
	}

	public GenericObjectPool getConnectionPool() {
		return gPool;
	}

// This Method Is Used To Print The Connection Pool Status
	private void statusDB() {
		System.out.println("Max.: " + getConnectionPool().getMaxActive() + "; Active: "
				+ getConnectionPool().getNumActive() + "; Idle: " + getConnectionPool().getNumIdle());
	}

	public static void main(String[] args) {

		ConnectionPooling jdbcObj = new ConnectionPooling();
		try {
			DataSource dataSource = jdbcObj.setConnPool();
			jdbcObj.statusDB();
			System.out.println("_______________________________________________________");
// Performing Database Operation!
			System.out.println("Making a First Connection Object For Db Transaction");
			connObj = dataSource.getConnection();
			jdbcObj.statusDB();

			pstmtObj = connObj.prepareStatement("SELECT * from emp");
			rsObj = pstmtObj.executeQuery();
			while (rsObj.next()) {
				System.out.println("Emp No: " + rsObj.getInt("eno"));
				System.out.println("Emp name: " + rsObj.getString("ename"));
				System.out.println("Emp Sal: " + rsObj.getInt("esal"));
			}
			connObj.close();// Closing the first connection
			System.out.println("Releasing first Connection Object To Pool");

			System.out.println("_______________________________________________________");
			System.out.println("Making a second Connection Object For Db Transaction");
			connObj2 = dataSource.getConnection();
			jdbcObj.statusDB();
			System.out.println("inserting the records in second connection");
			pstmtObj = connObj2.prepareStatement("insert into emp values(?,?,?)");
			pstmtObj.setInt(1, 10);
			pstmtObj.setString(2, "Ten");
			pstmtObj.setInt(3, 12345);
			pstmtObj.executeUpdate();
			connObj2.close();// Closing the second connection
			System.out.println("Releasing second Connection Object To Pool");
			System.out.println("_______________________________________________________");
			System.out.println("Making a Third Connection Object For Db Transaction");

			connObj = dataSource.getConnection();
			jdbcObj.statusDB();

			pstmtObj = connObj.prepareStatement("SELECT * from emp");
			rsObj = pstmtObj.executeQuery();
			while (rsObj.next()) {
				System.out.println("Emp No: " + rsObj.getInt("eno"));
				System.out.println("Emp name: " + rsObj.getString("ename"));
				System.out.println("Emp Sal: " + rsObj.getInt("esal"));
			}
			connObj.close();// Closing the first connection
			System.out.println("Releasing third Connection Object To Pool");

		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
// Closing ResultSet Object
				if (rsObj != null) {
					rsObj.close();
				}

// Closing PreparedStatement Object
				if (pstmtObj != null) {
					pstmtObj.close();
				}

// Closing Connection Object
				if (connObj != null) {
					connObj.close();
				}
				if (connObj2 != null) {
					connObj2.close();
				}
			} catch (Exception sqlException) {
				sqlException.printStackTrace();
			}
		}
		jdbcObj.statusDB();
	}
}