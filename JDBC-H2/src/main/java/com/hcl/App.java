package com.hcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	Connection conn = null;
		PreparedStatement st = null;
		try {
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		
		st = conn.prepareStatement("insert into emp values(?,?)");
		st.setInt(1, 5);
		st.setString(2, "abc");
		
		int count = st.executeUpdate();
		System.out.println(count);
		
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
		ResultSet rs = conn.createStatement().executeQuery("select * from emp");
		while(rs.next()) {
			System.out.println("Eno: " + rs.getInt("eno"));
			System.out.println("Ename: " + rs.getString("ename"));
		}
		
		conn.close();
    }
}
