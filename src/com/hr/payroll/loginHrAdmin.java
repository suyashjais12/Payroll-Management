package com.hr.payroll;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginHrAdmin extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	{
		try 
		{
			String ID = req.getParameter("id") ;
			String pwd =req.getParameter("pass");
			res.setContentType("Text/html");
			PrintWriter out = res.getWriter();
			
			//Jdbc
			Class.forName("com.mysql.jdbc.Driver");//loading Driver
			//connection provider url,id,password
			String url ="jdbc:mysql://localhost:3306/payroll";
			String user = "root";
			String pass = "8210166437";
			//connection 
			Connection con = DriverManager.getConnection(url,user,pass);
			//Connection con = ConnectionProvider.getConnection();
			PreparedStatement pSt=con.prepareStatement("select * from HrAdmin_Login");
			/*
			pSt.setString(1,m);
			pSt.setString(2, p);
			*/
			ResultSet rSet = pSt.executeQuery();
			boolean flag = false;
			while(rSet.next()) 
			{
				
				if(ID.equalsIgnoreCase(rSet.getString(1)) && pwd.equals(rSet.getString(2))) 
				{
					flag =true;
				}
				
				if(flag==true) 
				{
					out.println("<h2><b>Welcome ___" + rSet.getString(1)+"</b></h2><br>");
					out.println("<a href = NewEmpReg.html><h2><button>Registretion</button></h2></a><br>");
					break;
				}
				
			} 
			
				if(flag == false) 
				{
					out.println("<h1>TRY AGAIN</h1>");
					RequestDispatcher rd = req.getRequestDispatcher("hrAdminLogin.html");
					rd.include(req, res);
				}
				
			con.close();out.close();
		}catch(Exception e) {System.out.println(e);}
	}
	}
