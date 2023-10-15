package com.project;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HotelMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		String foodName = request.getParameter("foods");
		String quntity = request.getParameter("quantity");
		String userName = request.getParameter("user_name");
		String userPhone = request.getParameter("user_phone");
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?useSSL=false", "root", "root");
			
			// Query..
			String query = "select * from food_menu where food_name =?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, foodName);
			
			ResultSet rSet =pstmt.executeQuery();
			if (rSet.next()) {
				int price = Integer.parseInt(rSet.getString(3));
				out.println("<h1> Bill Generated for</h1>");
				out.println("<h4>Name : "+ userName+"</h4>");
				out.println("<h4>Phone : "+ userPhone+"</h4>");
				out.println("<h4>Item : "+ foodName+"</h4>");
				out.println("<h4>Quntity : "+ quntity+"</h4>");
				out.println("<h4>-------------------------</h4>");
				out.println("<h4>Total: "+ price*Integer.parseInt(quntity)+"/-</h4>");
			}
			else {
				out.println("Something Went Wrong");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
		
		
	}
	
	

}
