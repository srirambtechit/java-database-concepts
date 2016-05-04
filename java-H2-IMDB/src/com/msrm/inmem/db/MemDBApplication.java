package com.msrm.inmem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemDBApplication {

	public static void main(String[] args) {
		insert("Shankar");
		insert("Kannan");
		
		select();
	}

	public static void insert(String name) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("org.h2.Driver");
			// Remote connection URL which helps to connect without launching H2
			// in server mode
			String url = "jdbc:h2:tcp://localhost/~/test";

			// Normal mode, server is already running and holding connection
			// by followed URL string. H2 must be launched in server mode
//			url = "jdbc:h2:~/test";

			con = DriverManager.getConnection(url, "sa", "");
			ps = con.prepareStatement("INSERT INTO employee (name) VALUES (?)");
			ps.setString(1, name);
			int count = 0;
			if (!ps.execute()) {
				count = ps.getUpdateCount();
			}
			System.out.println(count + " rows affected");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void select() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("org.h2.Driver");
			// Remote connection URL which helps to connect without launching H2
			// in server mode
			String url = "jdbc:h2:tcp://localhost/~/test";

			// Normal mode, server is already running and holding connection
			// by followed URL string. H2 must be launched in server mode
			url = "jdbc:h2:~/test";

			con = DriverManager.getConnection(url, "sa", "");
			ps = con.prepareStatement("SELECT * FROM employee", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.printf("%3d\t%s%n", rs.getInt(1), rs.getString(2));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
