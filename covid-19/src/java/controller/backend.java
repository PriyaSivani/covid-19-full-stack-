/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
 *
 * @author tharu
 */
public class backend extends HttpServlet {

public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    response.setContentType("text/html");
    String username = request.getParameter("username");
    String useremail = request.getParameter("useremail");
    String userpassword = request.getParameter("userpassword");
    
    Connection con=null;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","12345");
          String insert = "insert into covid19(name,email,password)values(?,?,?)";
          PreparedStatement ps = con.prepareStatement(insert);
          ps.setString(1,username);
          ps.setString(2,useremail);
          ps.setString(3,userpassword);
        
          int status = ps.executeUpdate();
          if(status>0) {
              
              out.print("have registered successfully");
              out.print("<!DOCTYPE html><html><a href='restauranthome.html'>click here</a></html>");
          }
          else {
              out.print("ERROR OCCURED");
          }
    } catch(Exception e) {
        out.print(e);
    }
    finally {
        try {
            
        }catch(Exception e1) {
            out.print(e1);
        }
    }
}
}