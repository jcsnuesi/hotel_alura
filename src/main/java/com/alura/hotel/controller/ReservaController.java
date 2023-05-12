package com.alura.hotel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.alura.hotel.model.DetallesReserva;
import com.alura.hotel.model.ReservasDisponibles;
import com.alura.hotel.model.User;

import com.alura.hotel.dao.LoginDAO;
import com.alura.hotel.dao.EncontrarReservaDAO;
import com.alura.hotel.jdbc.factory.JDBC_Conexion;

public class ReservaController {
	
		private EncontrarReservaDAO reservas;
		
		
		public ReservaController() {
			var conexion = new JDBC_Conexion();
			this.reservas = new EncontrarReservaDAO(conexion.mainConexion());
			               
		}
			
			
		public List<ReservasDisponibles> findReserva(String dateIN, String dateOUT, String tipo) {		
		
			return reservas.habitacionesDisponibles(dateIN,dateOUT, tipo);
			 
			
		}
		
		public boolean makeReserva(DetallesReserva reservaDetalles ) {
			
			return reservas.crearReserva(reservaDetalles);
			
		}
		
		public List<DetallesReserva> historialReservas(){
			
			return reservas.historialReservasDao();
		}
		
		public boolean actualizar(DetallesReserva reservaDetalles){
			
			return reservas.actualizarDAO(reservaDetalles);
		}
		
		public List<DetallesReserva> buscarReservaRealizada(ArrayList<String> data, int query) {
			
			return reservas.busquedaParametrizadaDAO(data, query);
		}
		
		public boolean eliminarRegistro(int id) {
			
			return reservas.eliminarDAO(id);
		}
	
	}
