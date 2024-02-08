package com.durante;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class preferenza extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public preferenza() {
        // TODO Auto-generated constructor stub
    }
    
    String db_url = null;
    String db_usr = null;
    String db_psw = null;
    Connection conn = null;
    
	
	public void init(ServletConfig cfg){
    	try{
	    	super.init(cfg);
	    	
	    	db_url = cfg.getInitParameter("db_url");
	    	db_usr = cfg.getInitParameter("db_usr");
	    	db_psw = cfg.getInitParameter("db_psw");
	    	
	    	db_url="jdbc:mysql://"+db_url;
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	
	    	conn = DriverManager.getConnection(db_url,db_usr,db_psw);
	    	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
	
	public void doGet(HttpServletRequest reqt, HttpServletResponse res)
	{
		res.setContentType("text/html");
		String username = reqt.getParameter("username");
		String password = reqt.getParameter("password");
		
		String query = "SELECT username WHERE username = '"+ username + "' AND password = '"+ password + "'";
		
		try {
			
			ResultSet result = conn.createStatement().executeQuery(query);
			result.next();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void doPost(HttpServletRequest reqt, HttpServletResponse res)
	{
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

}
