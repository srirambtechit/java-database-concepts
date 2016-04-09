package com.jlearn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {

	private String user = "root";
	private String password = "root";
	private String url = "jdbc:mysql://localhost:3306/learnerdb";

	public void saveAddress(Address address) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			String sql = "INSERT INTO address (street, area, city, pincode) VALUES ( ?, ?, ?, ? )";

			st = con.prepareStatement(sql);
			con.setAutoCommit(false);

			st.setString(1, address.getStreet());
			st.setString(2, address.getArea());
			st.setString(3, address.getCity());
			st.setInt(4, address.getPincode());
			st.executeUpdate(sql);

			con.commit();

			System.out.println("Inserted successfully");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Application app = new Application();
		Address addr = new Address();
		addr.setStreet("22, south mada street");
		addr.setArea("Thiruvanmiyur");
		addr.setCity("Chennai");
		addr.setPincode(600041);
		app.saveAddress(addr);
	}

}
