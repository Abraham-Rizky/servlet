package com.javawebtutor.controller;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javawebtutor.model.User;
import com.javawebtutor.service.LoginService;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.io.BufferedWriter;

public class LoginServlet extends HttpServlet {
	

    
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	    
	 String userId = request.getParameter("userId");	
	 String password = request.getParameter("password");
	 LoginService loginService = new LoginService();
	 boolean result = loginService.authenticateUser(userId, password);
	 User user = loginService.getUserByUserId(userId);
	 
	 //Log the user and timestamp
	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	 LocalDateTime now = LocalDateTime.now();  
	 
	 
	 JSONObject obj = new JSONObject();
     obj.put("userId", userId);
     obj.put("result", result);
     obj.put("user", user);
     obj.put("timestamp", now);
     obj.put("password", password);

     
	 JSONObject obj2 = new JSONObject();
     obj2.put("userId", userId);
     obj2.put("password", password);
        
	 if(result == true){

		 request.getSession().setAttribute("user", user);		
		 response.sendRedirect("home.jsp");
	     //Save to log file
	     try {	    	 
	    	 FileWriter file = new FileWriter("c:\\jsonprojects\\test.json", true);
	    	 BufferedWriter WriteFileBuffer = new BufferedWriter(new FileWriter("c:\\jsonprojects\\test.json", true));
	    	 WriteFileBuffer.newLine();
	    	 WriteFileBuffer.append(obj.toJSONString());

	    	 FileWriter file2 = new FileWriter("c:\\jsonprojects\\data.json", true);
	    	 BufferedWriter WriteFileBuffer2 = new BufferedWriter(new FileWriter("c:\\jsonprojects\\data.json",true));
	    	 WriteFileBuffer2.append(obj2.toJSONString());	         
	         
	    	 WriteFileBuffer.close();

	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	 }
	 else{
		 response.sendRedirect("error.jsp");
	 }
}
	
	public static String concatenate(String ... strings){
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i<strings.length; i++){
            if(i>0){
                builder.append(",");
            }
            builder.append(strings[i]);
        }

        return builder.toString();
    }
	
}