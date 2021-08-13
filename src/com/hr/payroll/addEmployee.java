package com.hr.payroll;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addEmployee extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		try {
			//For 1st table
		String id =req.getParameter("empId") ;
		String fName =req.getParameter("fName") ;
		String lName =req.getParameter("lName") ;
		String D =req.getParameter("D") ;
		//for date
		String sdt = req.getParameter("doj");
		System.out.println();
		System.out.println(sdt+"sdt");
		java.util.Date sdf = new SimpleDateFormat("dd/MM/yyyy").parse(sdt);
		System.out.println(sdf+"sdf");
		long ms1 = sdf.getTime();
		System.out.println(ms1+"ms1");
		java.sql.Date sqlDate =new java.sql.Date(ms1);
		System.out.println(sqlDate+"sqlDate");
		//1st table end
		
		//2nd table start
		String age =req.getParameter("age") ;
		String na =req.getParameter("na") ;
		String addr =req.getParameter("addr") ;
		String mail =req.getParameter("mail") ;					
		String ph =req.getParameter("ph") ;
		//2nd table end
		
		//3rd table start
		String acc =req.getParameter("acc") ;
		float its =Float.parseFloat(req.getParameter("ts")) ;
		float ma =Float.parseFloat(req.getParameter("ma")) ;
		float sa =Float.parseFloat(req.getParameter("sa") );
		float ta =Float.parseFloat(req.getParameter("ta") );
		float da1 =Float.parseFloat(req.getParameter("da")) ;
		float da =its * (da1/100);
		float cca =Float.parseFloat(req.getParameter("cca")) ;
		float bo =Float.parseFloat(req.getParameter("bo") );
		float sh =Float.parseFloat(req.getParameter("sh") );
		float bs =bo+sh;
		float ts =its+ma+sa+ta+da+cca+bs;
		//float tds1 =Float.parseFloat(req.getParameter("tds")) ;
		float tds =0;
		if(ts>25000 && ts<=41666.66) 
		{
			tds =(float) (0.00416*(ts-25000));
		}
		else if(ts>41666.66 && ts<=83333.33) 
		{
			tds =(float) (10000+(0.01666*(ts-41666.66)));
		}
		else if(ts>1000000) 
		{
			tds = (float) (110000 +(0.025*(ts-1000000)));
		}
		
		float is =(ts+ma+ta+sa+bs+da+cca)-tds ;
		
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
		String Query1 = "Insert into emp values(?,?,?,?,?)";
		PreparedStatement pSt1=con.prepareStatement(Query1);
		//adding to emp table
		String Query2 = "Insert into emp_Info values(?,?,?,?,?,?)";
		PreparedStatement pSt2=con.prepareStatement(Query2);
		//adding to emp_info table
		String Query3 = "Insert into emp_Salary values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pSt3=con.prepareStatement(Query3);
		//adding to emp_salary table
		
		pSt1.setString(1,id);
		pSt1.setString(2, fName);
		pSt1.setString(3, lName);
		pSt1.setString(4, D);
		pSt1.setDate(5, sqlDate);
		pSt1.executeUpdate();
		//for 1st table
		pSt2.setString(1,id);
		pSt2.setString(2, age);
		pSt2.setString(3, na);
		pSt2.setString(4,addr);
		pSt2.setString(5, mail);
		pSt2.setString(6, ph);
		pSt2.executeUpdate();
		//for 2nd table
		pSt3.setString(1,id);
		pSt3.setString(2,acc);
		pSt3.setFloat(3, its);
		pSt3.setFloat(4, ma);
		pSt3.setFloat(5, sa);
		pSt3.setFloat(6, ta);
		pSt3.setFloat(7, da);
		pSt3.setFloat(8, cca);
		pSt3.setFloat(9, tds);
		pSt3.setFloat(10, bs);
		pSt3.setFloat(11, is);
		pSt3.executeUpdate();
		//for 3rd table
				
		out.println("Succesfully Inserted");
		out.println("<a href=NewEmpReg.html><button>Go To Main Page</button></a>");
		con.close();out.close();
		}catch(Exception e) 
		{
			res.setContentType("Text/html");
			PrintWriter out = res.getWriter();
			out.println(e);
			out.close();
			System.out.println(e);
		}
	} 
}
