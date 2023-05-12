package com.alura.hotel.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.alura.*;

public class JDBC_Conexion {
	
	private DataSource dataSource;
	
	public JDBC_Conexion() {
		
		var pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("");
		pooledDataSource.setMaxPoolSize(20);
		
		this.dataSource = pooledDataSource;
	}
	
	public Connection mainConexion() {
		
		try {
			
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		

	}
}
