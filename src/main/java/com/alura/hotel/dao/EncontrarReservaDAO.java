package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alura.hotel.model.DetallesReserva;
import com.alura.hotel.model.ReservasDisponibles;
import com.alura.hotel.model.User;
import com.mysql.cj.protocol.Resultset;


public class EncontrarReservaDAO {
	
	private Connection con;
	
	
	public EncontrarReservaDAO(Connection com) {
		this.con =  com;
	}
	public EncontrarReservaDAO() {
		
	}
	
	public List<ReservasDisponibles> habitacionesDisponibles(String dateIn, String dateOut, String tipo){
		
	
		List<ReservasDisponibles> reservasD = new ArrayList<>();
		
		
		try {
			
				
			final PreparedStatement statement = con.prepareStatement(
					"SELECT * FROM rooms "
					+ "WHERE id_room NOT IN (SELECT id_room FROM reservas  WHERE (fecha_de_reserva BETWEEN '"+dateIn+"' AND '"+dateOut+"') "
					+ "OR (fecha_de_partida BETWEEN '"+dateIn+"' AND '"+dateOut+"') "
					+ "OR ('"+dateIn+"' BETWEEN fecha_de_partida AND fecha_de_partida) "
					+ "OR ('"+dateOut+"' BETWEEN fecha_de_partida AND fecha_de_partida)) AND tipo_de_habitacion = '"+tipo+"'");
			
		
			try(statement){
						
				
				statement.clearParameters(); 
				final ResultSet resulSet = statement.executeQuery();
				

				
				try(resulSet){
					
				
					while (resulSet.next()) {
						
						
						ReservasDisponibles fila = new ReservasDisponibles(resulSet.getInt("numero_hab"),resulSet.getString("tipo_de_habitacion"),resulSet.getFloat("precio_x_noche"),resulSet.getInt("id_room"));
				
					
						reservasD.add(fila);
					}
					
				
					return reservasD;
				}
				
					
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}

		
	}
	
	public boolean crearReserva(DetallesReserva reservaDetalles) {
			
			
		try {
			
			 
			final PreparedStatement statement = con.prepareStatement("INSERT INTO customers (nombre, apellido, email, telefono,fecha_nacimiento,nacionalidad) VALUES (?, ?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
			
			
			try(statement){
				
				statement.setString(1,reservaDetalles.getNombre());
				statement.setString(2, reservaDetalles.getApellido());
				statement.setString(3, reservaDetalles.getEmail());
				statement.setString(4, reservaDetalles.getTelefono());
				statement.setDate(5,reservaDetalles.getFechaNacimiento() );
				statement.setString(6, reservaDetalles.getNacionalidad());
				
				statement.execute();		

				ResultSet resulset = statement.getGeneratedKeys();
				
				try(resulset){
					
					while (resulset.next()) {
						
						reservaDetalles.setIdNewCustomer(resulset.getInt(1));
					
					}
					
				}
				
				
				int idCustomer = reservaDetalles.getIdNewCustomer();
			
				

				String sqlreservas = "INSERT INTO reservas ("
						+ "id_customer, id_room, "
						+ "fecha_de_reserva, fecha_de_partida, "
						+ "cantidad_adultos, cantidad_niños,"
						+ "id_pago, precio_total, estado) VALUES (?,?,?,?,?,?,?,?,?)";
				
				final PreparedStatement statementReserva = con.prepareStatement(sqlreservas,Statement.RETURN_GENERATED_KEYS);
				
				try(statementReserva){
					
					statementReserva.setInt(1, idCustomer);
					statementReserva.setInt(2, reservaDetalles.getId());
					statementReserva.setDate(3, reservaDetalles.getFechaIn());
					statementReserva.setDate(4, reservaDetalles.getFechaOut());
					statementReserva.setInt(5, 0);
					statementReserva.setInt(6, 0);
					statementReserva.setInt(7, reservaDetalles.getMetodoPagoId());
					statementReserva.setFloat(8, reservaDetalles.getTotalgeneral());
					statementReserva.setString(9, "Reservado");				
					
					statementReserva.execute();
					
					final ResultSet resulsetReserva = statementReserva.getGeneratedKeys();
					
				
					
					while(resulsetReserva.next()) {
						
					
						reservaDetalles.setIdNewCustomer(resulsetReserva.getInt(1));
						System.out.println("Reserva confirmada " + resulsetReserva.getInt(1));
						
					}
					
					
				
				}
				
			
				
			}
			
			return true;
			
		} catch (SQLException e) {
			
			
			System.out.println(e);
			return false;
			
		}
		
	}
	
	public List<DetallesReserva> historialReservasDao(){
		
		List<DetallesReserva> historial = new ArrayList<>();
		
		String query = "SELECT c.nombre, c.apellido, c.email,c.id_customer, c.telefono, c.fecha_nacimiento, c.nacionalidad, room.numero_hab,room.id_room,room.precio_x_noche,room.tipo_de_habitacion, \r\n"
				+ "p.metodo_pago, p.id_pago,re.id_reserva , re.fecha_de_reserva,re.fecha_de_partida, re.precio_total, re.estado, re.fecha_creacion FROM customers c \r\n"
				+ "INNER JOIN reservas re\r\n"
				+ "ON c.id_customer = re.id_customer\r\n"
				+ "INNER JOIN rooms room\r\n"
				+ "ON room.id_room = re.id_room\r\n"
				+ "INNER JOIN metodo_de_pago p\r\n"
				+ "ON p.id_pago = re.id_pago";
		
		try {
			
			PreparedStatement statement = con.prepareStatement(query);
			
			try(statement){
				
				final ResultSet resultSet = statement.executeQuery();
				
				try(resultSet){
					
					while(resultSet.next()) {
						
						var reservasHistorial = new DetallesReserva(
								resultSet.getString("nombre"),
								resultSet.getString("apellido"),
								resultSet.getString("email"),
								resultSet.getString("telefono"),
								resultSet.getDate("fecha_nacimiento"),
								resultSet.getString("nacionalidad"),
								resultSet.getString("numero_hab"),
								resultSet.getFloat("precio_x_noche"),
								resultSet.getString("tipo_de_habitacion"),
								resultSet.getString("metodo_pago"),
								resultSet.getDate("fecha_de_reserva"),
								resultSet.getDate("fecha_de_partida"),
								resultSet.getFloat("precio_total"),
								resultSet.getString("estado"),
								resultSet.getDate("fecha_creacion"),
								resultSet.getInt("id_customer"),
								resultSet.getInt("id_room"),
								resultSet.getInt("id_reserva"),
								resultSet.getInt("id_pago"),
								resultSet.getInt("id_reserva")
								);
						
						historial.add(reservasHistorial);
					}
					
					
				}
				
				return historial;
			}
		}catch(SQLException e) {
			
			throw new RuntimeException("Error al solicitar datos");
		}
		
		
		
	}
	
	public boolean actualizarDAO(DetallesReserva actualizarReserva){
			
		
		try {
					
			
			String sql = "UPDATE reservas re "
					+ "INNER JOIN customers c ON re.id_customer = c.id_customer "
					+ "INNER JOIN rooms room ON re.id_room = room.id_room "
					+ "INNER JOIN metodo_de_pago p ON re.id_pago = p.id_pago "
					+ "SET c.nombre = ?, c.apellido = ?, c.email = ?, c.telefono = ?,"
					+ "c.fecha_nacimiento = ?, c.nacionalidad = ?, re.id_room = ?, re.id_pago = ?, "
					+ "re.fecha_de_reserva = ?, re.fecha_de_partida = ?, re.estado = ? "
					+ "WHERE re.id_reserva = ? ";
			
			PreparedStatement statement = con.prepareStatement(sql);
			
			try(statement){

				System.out.println(actualizarReserva.getMetodoPagoId());

				statement.setString(1,actualizarReserva.getNombre());
				statement.setString(2, actualizarReserva.getApellido());
				statement.setString(3, actualizarReserva.getEmail());
				statement.setString(4, actualizarReserva.getTelefono());
				statement.setDate(5,actualizarReserva.getFechaNacimiento() );
				statement.setString(6, actualizarReserva.getNacionalidad());
				statement.setInt(7, actualizarReserva.getId());				
				statement.setInt(8,  actualizarReserva.getMetodoPagoId() + 1);
				statement.setDate(9,actualizarReserva.getFechaIn() );
				statement.setDate(10,actualizarReserva.getFechaOut());			
				statement.setString(11, actualizarReserva.getEstatus());
				statement.setInt(12, actualizarReserva.getId_reserva());
				
				statement.execute();
				
								
			}
			
			
			return true;
			
		} catch (SQLException e) {

			throw new RuntimeException("Error al actualizar" + e);
		}
	}
	
	
	public List<DetallesReserva> busquedaParametrizadaDAO(ArrayList<String> datos, int query) {
		
		List<DetallesReserva> reservaEncontrada = new ArrayList<>();
		
		String sql = "";
		
	
		
	if (query == 1) {
		
		sql = "SELECT c.nombre, c.apellido, c.email,c.id_customer, c.telefono, c.fecha_nacimiento, c.nacionalidad, room.numero_hab,room.id_room,room.precio_x_noche,room.tipo_de_habitacion, \r\n"
				+ "p.metodo_pago, p.id_pago,re.id_reserva , re.fecha_de_reserva,re.fecha_de_partida, re.precio_total, re.estado, re.fecha_creacion \r\n"
				+ "FROM customers c "
				+ "INNER JOIN reservas re "
				+ "ON c.id_customer = re.id_customer "
				+ "INNER JOIN rooms room "
				+ "ON room.id_room = re.id_room "
				+ "INNER JOIN metodo_de_pago p "
				+ "ON p.id_pago = re.id_pago "
				+ "WHERE c.nombre = ?";
	}
	
	if (query == 2) {
		
		sql = "SELECT c.nombre, c.apellido, c.email,c.id_customer, c.telefono, c.fecha_nacimiento, c.nacionalidad, room.numero_hab,room.id_room,room.precio_x_noche,room.tipo_de_habitacion, \r\n"
				+ "p.metodo_pago, p.id_pago,re.id_reserva , re.fecha_de_reserva,re.fecha_de_partida, re.precio_total, re.estado, re.fecha_creacion \r\n"
				+ "FROM customers c "
				+ "INNER JOIN reservas re "
				+ "ON c.id_customer = re.id_customer "
				+ "INNER JOIN rooms room "
				+ "ON room.id_room = re.id_room "
				+ "INNER JOIN metodo_de_pago p "
				+ "ON p.id_pago = re.id_pago "
				+ "WHERE c.apellido = ?";
	}
	
	if (query == 3) {
		
		
		sql = "SELECT c.nombre, c.apellido, c.email,c.id_customer, c.telefono, c.fecha_nacimiento, c.nacionalidad, room.numero_hab,room.id_room,room.precio_x_noche,room.tipo_de_habitacion, "
				+ "p.metodo_pago, p.id_pago,re.id_reserva , re.fecha_de_reserva,re.fecha_de_partida, re.precio_total, re.estado, re.fecha_creacion "
				+ "FROM customers c "
				+ "INNER JOIN reservas re "
				+ "ON c.id_customer = re.id_customer "
				+ "INNER JOIN rooms room "
				+ "ON room.id_room = re.id_room "
				+ "INNER JOIN metodo_de_pago p "
				+ "ON p.id_pago = re.id_pago "
				+ "WHERE re.fecha_de_reserva BETWEEN  ? AND  ?  ";
		
		
	}
		
		
		try {
			
			
			
			PreparedStatement stm = con.prepareStatement(sql);
			
			try(stm){
				
				if (query == 1 || query == 2) {
					stm.setString(1,datos.get(0));
				}
				
				if (query == 3) {
					stm.setDate(1, java.sql.Date.valueOf(datos.get(0)) );
					stm.setDate(2,java.sql.Date.valueOf(datos.get(1)));
				}
				
				
				
				final ResultSet resultSet = stm.executeQuery();
				
				try(resultSet){
					
					while(resultSet.next()) {
						
						var founds =  new DetallesReserva(
								resultSet.getString("nombre"),
								resultSet.getString("apellido"),
								resultSet.getString("email"),
								resultSet.getString("telefono"),
								resultSet.getDate("fecha_nacimiento"),
								resultSet.getString("nacionalidad"),
								resultSet.getString("numero_hab"),
								resultSet.getFloat("precio_x_noche"),
								resultSet.getString("tipo_de_habitacion"),
								resultSet.getString("metodo_pago"),
								resultSet.getDate("fecha_de_reserva"),
								resultSet.getDate("fecha_de_partida"),
								resultSet.getFloat("precio_total"),
								resultSet.getString("estado"),
								resultSet.getDate("fecha_creacion"),
								resultSet.getInt("id_customer"),
								resultSet.getInt("id_room"),
								resultSet.getInt("id_reserva"),
								resultSet.getInt("id_pago"),
								resultSet.getInt("id_reserva"));
						
						reservaEncontrada.add(founds);
					}
				}
				
				
			}
			
			return reservaEncontrada;
			
		} catch (SQLException e) {
			throw new RuntimeException("Error al buscar: " + datos.get(0)+ " " + e);
		}
		
	}
	
	public boolean eliminarDAO(int id) {
		
		try {
			
			String sql = "DELETE reservas, customers FROM reservas JOIN customers  ON reservas.id_customer = customers.id_customer WHERE  reservas.id_reserva = ?";
			
			PreparedStatement stm = con.prepareStatement(sql);
			
			try(stm){
				
				stm.setInt(1, id);				
				stm.executeUpdate();		
			
			
			}
			
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
		
	}

}
