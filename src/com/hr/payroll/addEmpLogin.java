package com.hr.payroll;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addEmpLogin extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	{
		try 
		{
			res.setContentType("Text/html");
			PrintWriter out = res.getWriter();
			
			String id =req.getParameter("id");
			String pwd=req.getParameter("pwd");
			//Jdbc
			Class.forName("com.mysql.jdbc.Driver");//loading Driver
			//connection provider url,id,password
			String url ="jdbc:mysql://localhost:3306/payroll";
			String user = "root";
			String pass = "8210166437";
			//connection 
			Connection con = DriverManager.getConnection(url,user,pass);
			//statement
			String entryQuery ="INSERT INTO emp_login VALUES(?,?)";
			PreparedStatement pstmt =con.prepareStatement(entryQuery);
			//pushing the data
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.executeUpdate();			
			out.println();
			out.println("<center><h3>Row Inserted Successfully</h3></center>");
		}
		catch(Exception e) {}
	}
}
