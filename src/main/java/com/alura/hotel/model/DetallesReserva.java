package com.alura.hotel.model;

import java.sql.Date;

public class DetallesReserva {
	
	private Date fechaIn;
	private Date fechaOut;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String nacionalidad;
	private String telefono;
	private String numeroHabitacion;
	private String tipoHabitacion;


	private String metodopagoString;
	private String email;	
	private int metodoPagoId;
	private float precioNoche;
	private float totalgenetal;
	private int IdHab;
	private int idNewCustomer;
	private String estatus;
	private Date fechaRegistro;
	private int customerId;
	private int id_reserva;

	public DetallesReserva() {}


	public DetallesReserva(
			// Datos para tbl detalles antes de guardar
			Date in, 
			Date out,
			String nombre, 
			String apellido, 
			Date fechaNacimiento,
			String nacionalidad,
			String telefono,
			String email,				
			Float precioNoche, 
			int IdHab,			
			int metodoPagoId, 
			Float totalgenetal) {
		
		
		this.fechaIn = in;
		this.fechaOut = out;	
		this.nombre = nombre;
		this.apellido =  apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.email = email;	
		this.IdHab = IdHab;
		this.precioNoche = precioNoche;
		this.metodoPagoId = metodoPagoId;
		this.totalgenetal = totalgenetal;
		
	}



	public DetallesReserva(
			
			//Datos para data historial reservas
			String nombre, 
			String apellido,
			String email, 
			String telefono,
			Date fechaNacimiento,
			String nacionalidad,
			String numeroHabitacion,
			Float precioNoche,
			String tipoHabitacion,
			String metodopagoString,
			Date in, 
			Date out,
			Float totalgenetal,
			String estatus,
			Date fechaRegistro,
			int customerId,
			int IdHab,
			int idNewCustomer,
			int metodoPagoId,
			int id_reserva
			) {
		this.nombre = nombre;
		this.apellido =  apellido;
		this.email = email;	
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.numeroHabitacion = numeroHabitacion;
		this.precioNoche = precioNoche;
		this.tipoHabitacion = tipoHabitacion;
		this.metodopagoString = metodopagoString;
		this.fechaIn = in;
		this.fechaOut = out;
		this.totalgenetal = totalgenetal;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.customerId =customerId;
		this.IdHab = IdHab;
		this.idNewCustomer = idNewCustomer;
		this.metodoPagoId = metodoPagoId;
		this.id_reserva =id_reserva;
		

	}
	
	public DetallesReserva(
			String nombre, 
			String apellido,
			String email, 
			String telefono,
			Date fechaNacimiento,
			String nacionalidad,
			int IdHab,
			int metodoPagoId,	
			Date in, 
			Date out,
			Float precioNoche,
			String estatus,			
			int customerId,
			int id_reserva
			
			) {
		
		this.nombre = nombre;
		this.apellido =  apellido;
		this.email = email;	
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.IdHab = IdHab;
		this.metodoPagoId = metodoPagoId;
		this.fechaIn = in;
		this.fechaOut = out;
		this.precioNoche = precioNoche;
		this.estatus = estatus;		
		this.customerId =customerId;
		this.id_reserva =id_reserva;
		

	}

	
	public int getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	
	public String getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(String numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public String getMetodopagoString() {
		return metodopagoString;
	}

	public void setMetodopagoString(String metodopagoString) {
		this.metodopagoString = metodopagoString;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	public Date getFechaIn() {
		return fechaIn;
	}



	public void setFechaIn(Date fechaIn) {
		this.fechaIn = fechaIn;
	}



	public Date getFechaOut() {
		return fechaOut;
	}



	public void setFechaOut(Date fechaOut) {
		this.fechaOut = fechaOut;
	}

	
	
	
	public int getMetodoPagoId() {
		return metodoPagoId;
	}



	public void setMetodoPagoId(int metodoPago) {
		this.metodoPagoId = metodoPago;
	}



	public float getTotalgeneral() {
		return totalgenetal;
	}



	public void setTotalgenetal(float totalgenetal) {
		this.totalgenetal = totalgenetal;
	}



	public Integer getId() {
		return IdHab;
	}



	public void setId(int id) {
		IdHab = id;
	}



	public int getIdNewCustomer() {
		return idNewCustomer;
	}

	public void setIdNewCustomer(int idNewCustomer) {
		this.idNewCustomer = idNewCustomer;
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



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public String getNacionalidad() {
		return nacionalidad;
	}



	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public float getPrecioNoche() {
		return precioNoche;
	}



	public void setPrecioNoche(float precioNoche) {
		this.precioNoche = precioNoche;
	}

	public String getInfo() {
		
		return  String.valueOf(fechaIn) + " " + 
				String.valueOf(fechaOut) + " " + 
				getNombre() + " " + 
				getApellido()  + " " +  
				String.valueOf(fechaNacimiento) + " " + 
				getNacionalidad() + " " + 
				getTelefono() +" "+
				getEmail() + " " +
				String.valueOf(getMetodoPagoId())+ " " +
				String.valueOf(getPrecioNoche())+ " " +
				String.valueOf(getTotalgeneral())+ " " +
				String.valueOf(getId());
	}

}
