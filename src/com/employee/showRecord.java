package com.employee;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showRecord extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	{
		try 
		{
			String id = req.getParameter("emp_id");
			
			System.out.println(id+"id from previous servlet recived.");
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
			String query = "select * from emp"/* WHERE Emp_ID="+id*/;
			String query2 = "SELECT * FROM emp_Info ";
			String query3 = "SELECT * FROM emp_Salary";
			
			PreparedStatement pst1 = con.prepareStatement(query);
			PreparedStatement pst2 = con.prepareStatement(query2);
			PreparedStatement pst3 = con.prepareStatement(query3);
			
			ResultSet rst1 = pst1.executeQuery();
			ResultSet rst2 = pst2.executeQuery();
			ResultSet rst3 = pst3.executeQuery();
			System.out.println();
			System.out.println(rst1);
			System.out.println(rst2);
			System.out.println(rst3);
			out.println();
			/*out.println(rst1);
			out.println(rst2);
			out.println(rst3);*/
			
			while(rst1.next())
			{
				if(id.equalsIgnoreCase(rst1.getString(1))) 
				{
					
					out.println("<head><title>payroll system</title>"+"<style>table,th,td{border:2px solid black;}");
					out.println("th,td{text-align:center}");
					out.println("</style> "+"</head>");
					out.println("<table>");
					out.println("<tr>");
					out.println("<th>Employee ID</th>");
					out.println("<th>First Name</th>");
					out.println("<th>Last Name</th>");
					out.println("<th>Designetion</th>");
					out.println("<th>Date OF Joining</th>");
					out.println("</tr>");

					out.println("<tr>");
					out.println("<td>"+rst1.getString(1)+"</td>");
					out.println("<td>"+rst1.getString(2)+"</td>");
					out.println("<td>"+rst1.getString(3)+"</td>");
					out.println("<td>"+rst1.getString(4)+"</td>");
					out.println("<td>"+rst1.getString(5)+"</td>");
					out.println("</tr>");
					out.println("</table><br>");
				}
			}
			
			while(rst2.next())
			{
				if(id.equalsIgnoreCase(rst2.getString(1))) 
				{
					out.println("<h3>Your info:-</h3>");
					out.println("<head><title>payroll system</title>"+"<style>table,th,td{border:2px solid black;}");
					out.println("th,td{text-align:center}");
					out.println("</style> "+"</head>");
					out.println("<table>");
					out.println("<tr>");
					out.println("<th>Employee ID</th>");
					out.println("<th>Age</th>");
					out.println("<th>Nationality</th>");
					out.println("<th>Address</th>");
					out.println("<th>Mail_ID</th>");
					out.println("<th>Ph_NO</th>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>"+rst2.getString(1)+"</td>");
					out.println("<td>"+rst2.getString(2)+"</td>");
					out.println("<td>"+rst2.getString(3)+"</td>");
					out.println("<td>"+rst2.getString(4)+"</td>");
					out.println("<td>"+rst2.getString(5)+"</td>");
					out.println("<td>"+rst2.getString(6)+"</td>");
					out.println("</tr>");
					out.println("</table><br>");
				}
				
				
			}
			while(rst3.next())
			{
				if(id.equalsIgnoreCase(rst3.getString(1))) 
				{
					out.println("<h3>Your Salary Details:-</h3>");
					out.println("<head><title>payroll system</title>"+"<style>table,th,td{border:2px solid black;}");
					out.println("th,td{text-align:center}");
					out.println("</style> "+"</head>");
					out.println("<table>");
					out.println("<tr>");
					out.println("<th>Employee ID</th>");
					out.println("<th>Account Number</th>");
					out.println("<th>Total Salary</th>");
					out.println("<th>Medical Allowance</th>");
					out.println("<th>Stay Allowance</th>");
					out.println("<th>Travel Allowance</th>");
					
					out.println("<th>TDS</th>");
					out.println("<th>Total of Bonus &  Share</th>");
					out.println("<th>In Hand Salary</th>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>"+rst3.getString(1)+"</td>");
					out.println("<td>"+rst3.getString(2)+"</td>");
					out.println("<td>"+rst3.getString(3)+"</td>");
					out.println("<td>"+rst3.getString(4)+"</td>");
					out.println("<td>"+rst3.getString(5)+"</td>");
					out.println("<td>"+rst3.getString(6)+"</td>");
					out.println("<td>"+rst3.getString(7)+"</td>");
					out.println("<td>"+rst3.getString(8)+"</td>");
					out.println("<td>"+rst3.getString(9)+"</td>");
					out.println("</tr>");
					out.println("</table><br>");

				}
			}
		}catch(Exception e) {System.out.println(e);}
	}
}
