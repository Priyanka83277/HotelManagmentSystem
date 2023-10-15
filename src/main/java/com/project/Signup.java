package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		Connection con = null;
		try {
			String nameString = request.getParameter("name");
			String passwordString = request.getParameter("pass");
			String emailString = request.getParameter("email");
			String phoneString = request.getParameter("contact");

			
			//creating connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?useSSL=false", "root", "root");
			
			// Query..
			String query = "insert into users(uname, uemail, upwd, umobile) values(?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nameString);
			pstmt.setString(2, emailString);
			pstmt.setString(3, passwordString);
			pstmt.setString(4, phoneString);
			
			
		   int count = pstmt.executeUpdate();
		   dispatcher = request.getRequestDispatcher("registration.jsp");
		   if (count>0) {
			   request.setAttribute("status", "success");
			   out.println("sucess");
		   }
		   else {
			   request.setAttribute("status", "failed");
		   }
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			out.println("error");
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
