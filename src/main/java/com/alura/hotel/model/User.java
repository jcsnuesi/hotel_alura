package com.alura.hotel.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
	
	
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	private String role;
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public User() {
	
	}


	public User(String nombre, String apellido, String email, String role) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.role =  role;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("{email: %s}",getEmail());
	}

}
