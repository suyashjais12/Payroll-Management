package com.employee;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class setNewPassword extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	{
		try 
		{
			//response object
			res.setContentType("Text/html");
			PrintWriter out = res.getWriter();
			//request object
			String newp =req.getParameter("newp");
			System.out.println();
			System.out.println(newp+"from previous one");
			String reep =req.getParameter("reep");
			System.out.println(reep+"From previous one");
			String id =req.getParameter("id");
			System.out.println(id+"From previous servlet");
			if(newp.equals(reep)) 
			{
				Class.forName("com.mysql.jdbc.Driver");//loading Driver
				//connection provider url,id,password
				String url ="jdbc:mysql://localhost:3306/payroll";
				String user = "root";
				String pass = "8210166437";
				//connection 
				Connection con = DriverManager.getConnection(url,user,pass);
				//query
				String updateQuery ="UPDATE emp_login SET Password =? where ID=?";
				//Prepare Statement
				PreparedStatement pstmt =con.prepareStatement(updateQuery);
				pstmt.setString(1, reep);
				pstmt.setString(2, id);
				pstmt.executeUpdate();
				out.println("pussword Updated Successfully....");
				RequestDispatcher rd = req.getRequestDispatcher("employeeLogin.html");
				rd.forward(req, res);
			}
			
			
			
			
			
			
			
			
			
			
			
			
		}catch(Exception e) {}
	}
}
