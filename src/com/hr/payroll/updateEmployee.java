package com.hr.payroll;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updateEmployee extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
	{
		try 
		{
			//response object
			res.setContentType("Text/html");
			PrintWriter out = res.getWriter();
			//request object
			String uID = req.getParameter("uid");
			System.out.println(uID);
			String tabName = req.getParameter("tab");
			System.out.println(tabName);
			String colName = req.getParameter("col");
			System.out.println(colName);
			String value = req.getParameter("data");
			System.out.println(value);
			//jdbc
			Class.forName("com.mysql.jdbc.Driver");//loading Driver
			//connection provider url,id,password
			String url ="jdbc:mysql://localhost:3306/payroll";
			String user = "root";
			String pass = "8210166437";
			//connection 
			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement pSt=con.prepareStatement("select * from emp");
			ResultSet rSet = pSt.executeQuery();
			while(rSet.next()) 
			{
				if(uID.equalsIgnoreCase(rSet.getString(1))) 
				{
					if(tabName.equalsIgnoreCase("employee")) 
					{
						System.out.println("this clause1");
						if(colName.equalsIgnoreCase("First_Name")) 
						{
							String query1 = "update emp set First_Name=? where Emp_ID=?";
							PreparedStatement pst1=con.prepareStatement(query1);
							
							pst1.setString(1, value);
							pst1.setString(2, uID);
							pst1.executeUpdate();
							
						}
						else if(colName.equalsIgnoreCase("Last_Name")) 
						{
							String query1 = "update emp set Last_Name=? where Emp_ID=?";
							PreparedStatement pst1=con.prepareStatement(query1);
							
							pst1.setString(1, value);
							pst1.setString(2, uID);
							pst1.executeUpdate();
							
						}
						else if(colName.equalsIgnoreCase("Designetion")) 
						{
							String query1 = "update emp set Last_Name=? where Emp_ID=?";
							PreparedStatement pst1=con.prepareStatement(query1);
							
							pst1.setString(1, value);
							pst1.setString(2, uID);
							pst1.executeUpdate();							
						}
						else {out.println("Enter valid option..........");}
						out.println("row updated successfully....................");
						break;
					}
					else if(tabName.equalsIgnoreCase("employee Info"))
					{
						System.out.println("this clause2");
						if(colName.equalsIgnoreCase("Age")) 
						{
							String query2 ="UPDATE Emp_Info set Age=? Where Emp_ID=?";
							PreparedStatement pst2=con.prepareStatement(query2);
																					
							pst2.setString(1, value);
							pst2.setString(2, uID);
							
							pst2.executeUpdate();
						}
						else if(colName.equalsIgnoreCase("Nationality")) 
						{
							String query2 ="UPDATE Emp_Info set Nationality=? Where Emp_ID=?";
							PreparedStatement pst2=con.prepareStatement(query2);
																					
							pst2.setString(1, value);
							pst2.setString(2, uID);
							
							pst2.executeUpdate();
						}
						else if(colName.equalsIgnoreCase("Phone_NO")) 
						{
							String query2 ="UPDATE Emp_Info set Ph_NO=? Where Emp_ID=?";
							PreparedStatement pst2=con.prepareStatement(query2);
																					
							pst2.setString(1, value);
							pst2.setString(2, uID);
							
							pst2.executeUpdate();
						}
						else if(colName.equalsIgnoreCase("Address")) 
						{
							String query2 ="UPDATE Emp_Info set Address=? Where Emp_ID=?";
							PreparedStatement pst2=con.prepareStatement(query2);
																					
							pst2.setString(1, value);
							pst2.setString(2, uID);
							
							pst2.executeUpdate();
						}
						else if(colName.equalsIgnoreCase("Mail_ID")) 
						{
							String query2 ="UPDATE Emp_Info set Mail_ID=? Where Emp_ID=?";
							PreparedStatement pst2=con.prepareStatement(query2);
																					
							pst2.setString(1, value);
							pst2.setString(2, uID);
							
							pst2.executeUpdate();
						}
						else {out.println("Enter a valid option.....");}
						out.println("updated successfully..........");
						break;
					}
					//Salary table start
					else if(tabName.equalsIgnoreCase("employee salary")) 
					{
						System.out.println("this clause3");
						
						if(colName.equalsIgnoreCase("Net_Salary")) 
						{
							//updating selected field
							String query3_1 = "UPDATE Emp_Salary set Net_Salary=? where Emp_ID=?";
							PreparedStatement pst3_1=con.prepareStatement(query3_1);
							
							pst3_1.setString(1,value);
							pst3_1.setString(2,uID);
							pst3_1.executeUpdate();
							
							//updating inHand salary
							String query0 = "select * from emp_Salary";
							PreparedStatement pstmt = con.prepareStatement(query0);
							ResultSet rset = pstmt.executeQuery();
							
							String t1 = rset.getString(3);
							Float t = Float.parseFloat(t1);
							String t2 = rset.getString(4);
							Float ma = Float.parseFloat(t2);
							String t3 = rset.getString(5);
							Float sa = Float.parseFloat(t3);
							String t4= rset.getString(6);
							Float ta = Float.parseFloat(t4);
							String t5= rset.getString(7);
							Float da = Float.parseFloat(t5);
							String t6= rset.getString(8);
							Float cca = Float.parseFloat(t6);
							String t7 = rset.getString(8);
							Float tds = Float.parseFloat(t7);
							String t8 = rset.getString(9);
							Float bs = Float.parseFloat(t8);
							//total salary
							Float ihs = t+(bs+ta+sa+ma+da+cca)-tds;
						
							String query3_1_1 = "UPDATE Emp_Salary set InHand_Sal=? where Emp_ID=?";
							PreparedStatement pst3_1_1=con.prepareStatement(query3_1_1);
							
							pst3_1_1.setFloat(1, ihs);
							pst3_1_1.setString(2, uID);
							
							pst3_1_1.executeUpdate();
							out.println("updated Successfully......");
						}
						else if(colName.equalsIgnoreCase("Acc_NO")) 
						{
							String query ="UPDATE Emp_Salary set Acc_No=? where Emp_ID=?";
							PreparedStatement pstm = con.prepareStatement(query);
							pstm.setString(1, value);
							pstm.setString(2, uID);
							pstm.executeUpdate();
							out.println("updated successfully.......");
						}
						else if(colName.equalsIgnoreCase("Med_Allow")) 
						{
							//updating selected fields
							String query3_2 = "UPDATE Emp_Salary set Med_Allow=? where Emp_ID=?";
							PreparedStatement pst3_2=con.prepareStatement(query3_2);
							
							pst3_2.setString(1,value);
							pst3_2.setString(2,uID);
							pst3_2.executeUpdate();
														
							//updating inHand salary
							String query3_2_1 = "select * from emp_Salary";
							PreparedStatement pstmt = con.prepareStatement(query3_2_1);
							ResultSet rset = pstmt.executeQuery();
							
							String t1 = rset.getString(3);
							Float t = Float.parseFloat(t1);
							String t2 = rset.getString(4);
							Float ma = Float.parseFloat(t2);
							String t3 = rset.getString(5);
							Float sa = Float.parseFloat(t3);
							String t4= rset.getString(6);
							Float ta = Float.parseFloat(t4);
							String t5= rset.getString(7);
							Float da = Float.parseFloat(t5);
							String t6= rset.getString(8);
							Float cca = Float.parseFloat(t6);
							String t7 = rset.getString(8);
							Float tds = Float.parseFloat(t7);
							String t8 = rset.getString(9);
							Float bs = Float.parseFloat(t8);
							//total salary
							Float ihs = t+(bs+ta+sa+ma+da+cca)-tds;
						
							String query3_2_2 = "UPDATE Emp_Salary set InHand_Sal=? where Emp_ID=?";
							PreparedStatement pst3_2_2=con.prepareStatement(query3_2_2);
							
							pst3_2_2.setFloat(1, ihs);
							pst3_2_2.setString(2, uID);
							
							pst3_2_2.executeUpdate();
							out.println("updated Successfully......");
						}
						else if(colName.equalsIgnoreCase("Trav_Allow")) 
						{
							//updating selected fields
							String query3_3 = "UPDATE Emp_Salary set Trav_Allow=? where Emp_ID=?";
							PreparedStatement pst3_3=con.prepareStatement(query3_3);
							
							pst3_3.setString(1,value);
							pst3_3.setString(2,uID);
							pst3_3.executeUpdate();
														
							//updating inHand salary
							String query3_3_1 = "select * from emp_Salary";
							PreparedStatement pstmt = con.prepareStatement(query3_3_1);
							ResultSet rset = pstmt.executeQuery();
							
							String t1 = rset.getString(3);
							Float t = Float.parseFloat(t1);
							String t2 = rset.getString(4);
							Float ma = Float.parseFloat(t2);
							String t3 = rset.getString(5);
							Float sa = Float.parseFloat(t3);
							String t4= rset.getString(6);
							Float ta = Float.parseFloat(t4);
							String t5= rset.getString(7);
							Float da = Float.parseFloat(t5);
							String t6= rset.getString(8);
							Float cca = Float.parseFloat(t6);
							String t7 = rset.getString(8);
							Float tds = Float.parseFloat(t7);
							String t8 = rset.getString(9);
							Float bs = Float.parseFloat(t8);
							//total salary
							Float ihs = t+(bs+ta+sa+ma+da+cca)-tds;
						
							String query3_3_2 = "UPDATE Emp_Salary set InHand_Sal=? where Emp_ID=?";
							PreparedStatement pst3_3_2=con.prepareStatement(query3_3_2);
							
							pst3_3_2.setFloat(1, ihs);
							pst3_3_2.setString(2, uID);
							pst3_3_2.executeUpdate();
							out.println("updated Successfully......");
						}
						else if(colName.equalsIgnoreCase("Stay_Allow")) 
						{
							//updating selected fields
							String query3_4 = "UPDATE Emp_Salary set Stay_Allow=? where Emp_ID=?";
							PreparedStatement pst3_4=con.prepareStatement(query3_4);
							
							pst3_4.setString(1,value);
							pst3_4.setString(2,uID);
							pst3_4.executeUpdate();
														
							//updating inHand salary
							String query3_4_1 = "select * from emp_Salary";
							PreparedStatement pstmt = con.prepareStatement(query3_4_1);
							ResultSet rset = pstmt.executeQuery();
							
							String t1 = rset.getString(3);
							Float t = Float.parseFloat(t1);
							String t2 = rset.getString(4);
							Float ma = Float.parseFloat(t2);
							String t3 = rset.getString(5);
							Float sa = Float.parseFloat(t3);
							String t4= rset.getString(6);
							Float ta = Float.parseFloat(t4);
							String t5= rset.getString(7);
							Float da = Float.parseFloat(t5);
							String t6= rset.getString(8);
							Float cca = Float.parseFloat(t6);
							String t7 = rset.getString(8);
							Float tds = Float.parseFloat(t7);
							String t8 = rset.getString(9);
							Float bs = Float.parseFloat(t8);
							//total salary
							Float ihs = t+(bs+ta+sa+ma+da+cca)-tds;
						
							String query3_4_2 = "UPDATE Emp_Salary set InHand_Sal=? where Emp_ID=?";
							PreparedStatement pst3_4_2=con.prepareStatement(query3_4_2);
							
							pst3_4_2.setFloat(1, ihs);
							pst3_4_2.setString(2, uID);
							pst3_4_2.executeUpdate();
							out.println("updated Successfully......");
						}
						else if(colName.equalsIgnoreCase("DA")) 
						{
							//updating selected fields
							String query3_5 = "UPDATE Emp_Salary set DA=? where Emp_ID=?";
							PreparedStatement pst3_5=con.prepareStatement(query3_5);
							
							pst3_5.setString(1,value);
							pst3_5.setString(2,uID);
							pst3_5.executeUpdate();
														
							//updating inHand salary
							String query3_5_1 = "select * from emp_Salary";
							PreparedStatement pstmt = con.prepareStatement(query3_5_1);
							ResultSet rset = pstmt.executeQuery();
							String t1 = rset.getString(3);
							Float t = Float.parseFloat(t1);
							String t2 = rset.getString(4);
							Float ma = Float.parseFloat(t2);
							String t3 = rset.getString(5);
							Float sa = Float.parseFloat(t3);
							String t4= rset.getString(6);
							Float ta = Float.parseFloat(t4);
							String t5= rset.getString(7);
							Float da = Float.parseFloat(t5);
							String t6= rset.getString(8);
							Float cca = Float.parseFloat(t6);
							String t7 = rset.getString(8);
							Float tds = Float.parseFloat(t7);
							String t8 = rset.getString(9);
							Float bs = Float.parseFloat(t8);
							//total salary
							Float ihs = t+(bs+ta+sa+ma+da+cca)-tds;
						
							String query3_5_2 = "UPDATE Emp_Salary set InHand_Sal=? where Emp_ID=?";
							PreparedStatement pst3_5_2=con.prepareStatement(query3_5_2);
							
							pst3_5_2.setFloat(1, ihs);
							pst3_5_2.setString(2, uID);
							pst3_5_2.executeUpdate();
							out.println("updated Successfully......");
						}
						else if(colName.equalsIgnoreCase("cca")) 
						{
							//updating selected fields
							String query3_5 = "UPDATE Emp_Salary set CCA=? where Emp_ID=?";
							PreparedStatement pst3_5=con.prepareStatement(query3_5);
							
							pst3_5.setString(1,value);
							pst3_5.setString(2,uID);
							pst3_5.executeUpdate();
														
							//updating inHand salary
							String query3_5_1 = "select * from emp_Salary";
							PreparedStatement pstmt = con.prepareStatement(query3_5_1);
							ResultSet rset = pstmt.executeQuery();
							
							String t1 = rset.getString(3);
							Float t = Float.parseFloat(t1);
							String t2 = rset.getString(4);
							Float ma = Float.parseFloat(t2);
							String t3 = rset.getString(5);
							Float sa = Float.parseFloat(t3);
							String t4= rset.getString(6);
							Float ta = Float.parseFloat(t4);
							String t5= rset.getString(7);
							Float da = Float.parseFloat(t5);
							String t6= rset.getString(8);
							Float cca = Float.parseFloat(t6);
							String t7 = rset.getString(8);
							Float tds = Float.parseFloat(t7);
							String t8 = rset.getString(9);
							Float bs = Float.parseFloat(t8);
							//total salary
							Float ihs = t+(bs+ta+sa+ma+da+cca)-tds;
						
							String query3_5_2 = "UPDATE Emp_Salary set InHand_Sal=? where Emp_ID=?";
							PreparedStatement pst3_5_2=con.prepareStatement(query3_5_2);
							
							pst3_5_2.setFloat(1, ihs);
							pst3_5_2.setString(2, uID);
							pst3_5_2.executeUpdate();
							out.println("updated Successfully......");
						}
						else if(colName.equalsIgnoreCase("TDS")) 
						{
							//updating selected fields
							String query3_5 = "UPDATE Emp_Salary set TDS=? where Emp_ID=?";
							PreparedStatement pst3_5=con.prepareStatement(query3_5);
							
							pst3_5.setString(1,value);
							pst3_5.setString(2,uID);
							pst3_5.executeUpdate();
														
							//updating inHand salary
							String query3_5_1 = "select * from emp_Salary";
							PreparedStatement pstmt = con.prepareStatement(query3_5_1);
							ResultSet rset = pstmt.executeQuery();
							
							String t1 = rset.getString(3);
							Float t = Float.parseFloat(t1);
							String t2 = rset.getString(4);
							Float ma = Float.parseFloat(t2);
							String t3 = rset.getString(5);
							Float sa = Float.parseFloat(t3);
							String t4= rset.getString(6);
							Float ta = Float.parseFloat(t4);
							String t5= rset.getString(7);
							Float da = Float.parseFloat(t5);
							String t6= rset.getString(8);
							Float cca = Float.parseFloat(t6);
							String t7 = rset.getString(8);
							Float tds = Float.parseFloat(t7);
							String t8 = rset.getString(9);
							Float bs = Float.parseFloat(t8);
							//total salary
							Float ihs = t+(bs+ta+sa+ma+da+cca)-tds;
						
							String query3_5_2 = "UPDATE Emp_Salary set InHand_Sal=? where Emp_ID=?";
							PreparedStatement pst3_5_2=con.prepareStatement(query3_5_2);
							
							pst3_5_2.setFloat(1, ihs);
							pst3_5_2.setString(2, uID);
							pst3_5_2.executeUpdate();
							out.println("updated Successfully......");
						}
						else if(colName.equalsIgnoreCase("Bonus_or_Share")) 
						{
							//updating selected fields
							String query3_6 = "UPDATE Emp_Salary set Bonus_or_Share=? where Emp_ID=?";
							PreparedStatement pst3_6=con.prepareStatement(query3_6);
							
							pst3_6.setString(1,value);
							pst3_6.setString(2,uID);
							pst3_6.executeUpdate();
														
							//updating inHand salary
							String query3_6_1 = "select * from emp_Salary";
							PreparedStatement pstmt = con.prepareStatement(query3_6_1);
							ResultSet rset = pstmt.executeQuery();
							
							String t1 = rset.getString(3);
							Float t = Float.parseFloat(t1);
							String t2 = rset.getString(4);
							Float ma = Float.parseFloat(t2);
							String t3 = rset.getString(5);
							Float sa = Float.parseFloat(t3);
							String t4= rset.getString(6);
							Float ta = Float.parseFloat(t4);
							String t5= rset.getString(7);
							Float da = Float.parseFloat(t5);
							String t6= rset.getString(8);
							Float cca = Float.parseFloat(t6);
							String t7 = rset.getString(8);
							Float tds = Float.parseFloat(t7);
							String t8 = rset.getString(9);
							Float bs = Float.parseFloat(t8);
							//total salary
							Float ihs = t+(bs+ta+sa+ma+da+cca)-tds;
						
							String query3_6_2 = "UPDATE Emp_Salary set InHand_Sal=? where Emp_ID=?";
							PreparedStatement pst3_6_2=con.prepareStatement(query3_6_2);
							
							pst3_6_2.setFloat(1, ihs);
							pst3_6_2.setString(2, uID);
							pst3_6_2.executeUpdate();
							out.println("updated Successfully......");
						}
						else 
						{
							out.println("enter valid choise...........");
							break;
						}
						
						break;
					}
					else 
					{
						out.println("enter a field first");
					}
				}
				else 
				{
					out.println("you have entered wrong employee ID");
				}
			}
		}catch(Exception e) {System.out.println(e);}
	}
}
