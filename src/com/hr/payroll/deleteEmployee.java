package com.hr.payroll;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deleteEmployee extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	{
		try 
		{
			res.setContentType("Text/html");
			PrintWriter out = res.getWriter();
			
			String id=req.getParameter("uID");
			
			//Jdbc
			Class.forName("com.mysql.jdbc.Driver");//loading Driver
			//connection provider url,id,password
			String url ="jdbc:mysql://localhost:3306/payroll";
			String user = "root";
			String pass = "8210166437";
			//connection 
			Connection con = DriverManager.getConnection(url,user,pass);
			//Query
			String dQuery3="DELETE FROM emp WHERE Emp_ID = ?";
			String dQuery2="DELETE FROM emp_Info WHERE Emp_ID = ?";
			String dQuery1="DELETE FROM emp_Salary WHERE Emp_ID = ?";
			//Prepared Statement
			PreparedStatement pstmt1=con.prepareStatement(dQuery1);
			PreparedStatement pstmt2=con.prepareStatement(dQuery2);
			PreparedStatement pstmt3=con.prepareStatement(dQuery3);
			
			pstmt1.setString(1, id);
			pstmt2.setString(1, id);
			pstmt3.setString(1, id);
			
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
			out.println("Row Deleted Successfully.............");
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
}
