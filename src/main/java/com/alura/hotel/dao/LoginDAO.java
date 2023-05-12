package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.model.User;


public class LoginDAO {
	
	private Connection con;
	
	public LoginDAO(Connection com) {
		this.con =  com;
	}
	public LoginDAO() {
		
	}
	
	public List<User> access(User usuario){
		
		List<User> loginSuccess = new ArrayList<>();
		
		try {
			
			con.setAutoCommit(false);
			
			
			final PreparedStatement statement = con.prepareStatement(
					"SELECT r.role, u.nombre, u.apellido, u.email, u.role_id "
					+ "FROM tbl_role r "
					+ "INNER JOIN tbl_users u "
					+ "ON r.role_id = u.role_id "
					+ "WHERE u.email = ? AND u.password = ? ");
			
		
			try(statement){
				
				statement.setString(1,usuario.getEmail());
				statement.setString(2,usuario.getPassword());
				
				
				final ResultSet resulSet = statement.executeQuery();
				


				try(resulSet){
					
					
					while (resulSet.next()) {
						
						User fila = new User(resulSet.getString("nombre"),resulSet.getString("apellido"),resulSet.getString("email"),resulSet.getString("role"));
				
						loginSuccess.add(fila);
						
					}
					
					
					return loginSuccess;
				}
				
					
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}

		
		
	}

}
