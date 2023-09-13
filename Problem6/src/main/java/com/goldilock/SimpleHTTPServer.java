package com.goldilock;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.json.JSONObject;

import com.goldilock.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleHTTPServer {

	public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new MyHandler());
        server.start();
        server.join();
    }

    static class MyHandler extends AbstractHandler {
        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            if ("/database".equals(target)) { // Customize the URL here
                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("employees", getDataFromDatabase());

                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_OK);
                baseRequest.setHandled(true);
                response.getWriter().println(jsonResponse.toString());
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }
    public static List<Employee> getDataFromDatabase() {
    	Connection con=null;
		String url="jdbc:mysql://localhost:3306/test";
		String user="root";
		String pass="anand123";
		List<Employee> data=new ArrayList<>();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			String query="Select employeeName,employeeAge from test";
			PreparedStatement statement=con.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			
			while (result.next()) {
	                String empName = result.getString("employeeName");
	                String empAge = result.getString("employeeAge");
	                data.add(new Employee(empName, Integer.parseInt(empAge)));
	            }
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
    }

}
