package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.dev.beans.User;

public class JDBCImpl implements UserDAO {

	@Override
	public Boolean createProfile(User user) {
		String fname="fname";
		String lname="lname";
		String passwd = "password";
		int uid=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			//1. Load the Driver
			Class.forName("com.mysql.jdbc.Driver");

			//2. Get the DB connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/cleveridiots_db";
			con = DriverManager.getConnection(dbUrl,"JDBC","abcd");

			//3. Issue the SQL query via connection
			String sql = "insert into u_info values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, uid);
			pstmt.setString(2, fname);
			pstmt.setString(3, lname);
			pstmt.setString(4, passwd);

			int count = pstmt.executeUpdate();

			//4. Process the Result
			if(count > 0) {
				System.out.println("Profile Created");
			}else {
				System.out.println("Profile Creation Failed");
			}


		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//5. Close all the JDBC Objects
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public User searchUser(Integer userId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;

		try {
			//1. Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//2. Get the Connection
			String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db"
					+ "?user=JDBC&password=abcd";
			con = DriverManager.getConnection(dbUrl);

			//3. Issue the SQL Query
			String sql = "SELECT * FROM u_info WHERE u_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);

			rs = pstmt.executeQuery();

			//4. Process the results
			if(rs.next()) {
				userId = rs.getInt("u_id");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String passwd = rs.getString("password");

				user = new User();
				user.setUserID(userId);
				user.setFirstName(fname);
				user.setLastName(lname);
				user.setPassword(passwd);
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//5. Close all the JDBC Objects
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return user;
	}

	@Override
	public Boolean updatePassword(Integer userId, String oldPassword, String newPassword) {
		

	    
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			//1. Load the Driver
			Class.forName("com.mysql.jdbc.Driver");

			//2. Get the DB connection via Driver
			String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db"
					+ "?user=JDBC&password=abcd";
            con = DriverManager.getConnection(dbUrl);

			//3. Issue the SQL query via connection
			String sql = "update u_info set password=? where password=? and u_id=?";
			pstmt = con.prepareStatement(sql);
			//pstmt.setInt(1, userId);
			pstmt.setString(3, newPassword);
			pstmt.setString(2, oldPassword);
			pstmt.setInt(1, userId);
			

			int count = pstmt.executeUpdate();

			//4. Process the Result
			if(count > 0) {
				System.out.println("password updated");
			}else {
				System.out.println("not updated");
			}


		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//5. Close all the JDBC Objects
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public Boolean deleteUser(Integer userId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(Integer userID, String password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/cleveridiots_db";
			con = DriverManager.getConnection(dbUrl,"JDBC","abcd");
			String sql = "select * from u_info where u_id=? and password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userID);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUserID(rs.getInt("u_id"));
				user.setFirstName(rs.getString("fname"));
				user.setLastName(rs.getString("lname"));
				user.setPassword(rs.getString("password"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return user;
	}

	

}