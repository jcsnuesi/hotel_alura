package com.alura.hotel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.alura.hotel.model.User;


import com.alura.hotel.dao.LoginDAO;
import com.alura.hotel.jdbc.factory.JDBC_Conexion;

public class LoginController {
	
		private LoginDAO loginDao;
		
		
		public LoginController() {
			var conexion = new JDBC_Conexion();
			this.loginDao = new LoginDAO(conexion.mainConexion());
			               
		}
			
			
		public List<User> loginController(User user) {		
			
			return loginDao.access(user);
			
		}
	
	}
