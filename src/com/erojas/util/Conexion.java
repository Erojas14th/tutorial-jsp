package com.erojas.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
	public static Connection cn;
	
	public static Connection conectar() {
		if(cn!=null) {return cn;}
		
		InputStream is = Conexion.class.getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		
		try {
			properties.load(is);
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username= properties.getProperty("username");
			String password = properties.getProperty("password");
			
			Class.forName(driver);
			cn = DriverManager.getConnection(url, username, password);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cn;
	}
	public static Connection desconectar() {
		if(cn==null) {return cn;}
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}
}
