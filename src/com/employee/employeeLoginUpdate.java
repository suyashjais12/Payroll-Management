package com.employee;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class employeeLoginUpdate extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	{
		try 
		{
			//response object
			res.setContentType("Text/html");
			PrintWriter out = res.getWriter();
			//request object
			String id =req.getParameter("id");
			//System.out.println(id+"this is id");
			String newp =req.getParameter("newp");
			//System.out.println(newp+"this is newp");
			String reep = req.getParameter("reep");
			//System.out.println(reep+"this is reep");
			//Jdbc
			Class.forName("com.mysql.jdbc.Driver");//loading Driver
			//connection provider url,id,password
			String url ="jdbc:mysql://localhost:3306/payroll";
			String user = "root";
			String pass = "8210166437";
			//connection 
			Connection con = DriverManager.getConnection(url,user,pass);
			//query
			String query="Select * from emp_login";
			//prepare staement
			PreparedStatement pstmt =con.prepareStatement(query);
			
			ResultSet rset =pstmt.executeQuery();
			String emni =rset.getString(1);
			System.out.println(emni+"emni");
			while(rset.next())
			{
				boolean flag=false;
				if(id.equalsIgnoreCase(rset.getString(1))) 
				{
					flag =true;
				}
				if(flag == true) 
				{
					RequestDispatcher rd = req.getRequestDispatcher("/setNewPassword");
					rd.forward(req, res);
					break;
				}
			}			
		}catch(Exception e) {System.out.println(e);}
	}
}
