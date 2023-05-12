package com.alura.hotel.model;

public class ReservasDisponibles {
	
	private Integer num_hab;
	private String tipo;
	private Integer idHabitacion;

	private float precioNoche;
	
	//ro.numero_hab, ro.tipo_de_habitacion, ro.precio_x_noche, re.id_reserva FROM
	
	public ReservasDisponibles(int num_hab, String tipo, float precioNoche, int idHabitacion) {
		this.num_hab = num_hab;
		this.tipo = tipo;
		this.idHabitacion = idHabitacion;
		this.precioNoche = precioNoche;
		
	}
	
	
	public Integer getIdHabitacion() {
		return idHabitacion;
	}
	public void setIdHabitacion(Integer idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getNum_hab() {
		return num_hab;
	}
	public void setNum_hab(Integer num_hab) {
		this.num_hab = num_hab;
	}
	public float getPrecioNoche() {
		return precioNoche;
	}
	public void setPrecioNoche(float precioNoche) {
		this.precioNoche = precioNoche;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("{num_hab: %d, tipo: %s, precioNoche: %f}", 
				this.num_hab, 
				this.tipo, 
				this.precioNoche
				);
	}
	

}
