package com.hcl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		Connection conn = null;
		Statement st = null;
		try {
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		st = conn.createStatement();
		conn.setAutoCommit(false);
		
		st.execute("drop table emp");
		st.execute("create table emp(eno number, ename varchar(100))");
		st.execute("insert into emp values(1, 'alatf')");
		st.execute("insert into emp values(2, 'john')");
		st.execute("insert into emp values(3, 'sam')");
		st.execute("insert into emp values(4, 'abc')");
		
		
		st.execute("update emp set ename='xyz' where eno=2");
		
		st.execute("delete from emp where eno=4");
		conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
		ResultSet rs = st.executeQuery("select * from emp");
		while(rs.next()) {
			System.out.println("Eno: " + rs.getInt("eno"));
			System.out.println("Ename: " + rs.getString("ename"));
		}
		
		conn.close();
	}
}
