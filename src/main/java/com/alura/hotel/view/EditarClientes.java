package com.alura.hotel.view;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

import com.alura.hotel.controller.ReservaController;
import com.alura.hotel.model.DetallesReserva;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Window.Type;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarClientes {

	public JFrame editarframe;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtNacionalidad;
	private JTextField txtNumeroHabitacion;
	private JTextField txtMetodoPago;
	private JTextField txtEstado;
	private JTextField txtCantidadNoches;
	private JTextField txtPrecioXNoche;

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
	private String estatus;
	private Date fechaRegistro;
	private DefaultTableModel modelado;
	private JTable tabla;
	private JTextField txtEmail;
	private JDateChooser dcFechaNacimiento;
	private JTextField txtTipoHabitacion;
	private JLabel lblTipoHabitacion;
	private JDateChooser dcFechaSalida;
	private JDateChooser dcFechaReserva;
	private JButton btnUpdate;
	private ReservaController controller;
	private DetallesReserva detallesReserva;
	private int idReserva;
	private String tipoHabitaciones;
	private String metodoPago;
	private Date fEntrada;
	private Date fSalida;
	private int habitacionId;
	private int customer_id;
	private int MetodoPagoId;
	private JComboBox cboxTipo;
	private JComboBox cboxMetodoPago;

	public EditarClientes(DefaultTableModel modelado, JTable tabla) {
		this.modelado = modelado;
		this.tabla = tabla;
		initialize();
	}

	private void initialize() {

		controller = new ReservaController();
		editarframe = new JFrame("Editar reserva");
		editarframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		editarframe.setResizable(false);
		editarframe.getContentPane().setBackground(new Color(160, 82, 45));
		editarframe.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		ImageIcon formTemplate = new ImageIcon(
				"C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\recInfo.png");
		Image imgToScale = formTemplate.getImage();
		Image scaled = imgToScale.getScaledInstance(671, 500, Image.SCALE_SMOOTH);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(
				"C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\Hotel Alura.png"));
		lblNewLabel_2.setBounds(40, 0, 581, 93);
		editarframe.getContentPane().add(lblNewLabel_2);

		dcFechaSalida = new JDateChooser();
		dcFechaSalida.setDateFormatString("yyyy-MM-dd");
		dcFechaSalida.setBounds(40, 530, 193, 33);
		editarframe.getContentPane().add(dcFechaSalida);

		dcFechaReserva = new JDateChooser();
		dcFechaReserva.setDateFormatString("yyyy-MM-dd");
		dcFechaReserva.setBounds(468, 446, 193, 33);
		editarframe.getContentPane().add(dcFechaReserva);

//		txtTipoHabitacion = new JTextField();
//		txtTipoHabitacion.setText((String) null);
//		txtTipoHabitacion.setColumns(10);
//		txtTipoHabitacion.setBounds(40, 364, 193, 33);
//		editarframe.getContentPane().add(txtTipoHabitacion);
		
		cboxTipo = new JComboBox();
		cboxTipo.setFont(new Font("Poor Richard", Font.PLAIN, 16));
		cboxTipo.setModel(new DefaultComboBoxModel(new String[] {"Simple", "Doble", "Presidencial"}));
		cboxTipo.setBounds(40, 364, 193, 33);
		editarframe.getContentPane().add(cboxTipo);

		lblTipoHabitacion = new JLabel("Tipo de habitacion:");
		lblTipoHabitacion.setFont(new Font("Poor Richard", Font.PLAIN, 18));
		lblTipoHabitacion.setBounds(38, 316, 169, 38);
		editarframe.getContentPane().add(lblTipoHabitacion);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Poor Richard", Font.PLAIN, 18));
		lblEmail.setBounds(468, 153, 152, 38);
		editarframe.getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEmail.setColumns(10);
		txtEmail.setBounds(468, 189, 193, 33);
		editarframe.getContentPane().add(txtEmail);

		btnUpdate = new JButton("Actualizar");

		btnUpdate.setFont(new Font("Poor Richard", Font.BOLD, 16));
		btnUpdate.setIcon(new ImageIcon(
				"C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\updated.png"));
		btnUpdate.setBounds(528, 518, 133, 53);
		editarframe.getContentPane().add(btnUpdate);

		dcFechaNacimiento = new JDateChooser();
		dcFechaNacimiento.setDateFormatString("yyyy-MM-dd");
		dcFechaNacimiento.setBounds(252, 280, 193, 33);
		editarframe.getContentPane().add(dcFechaNacimiento);

		JLabel lblNewLabel_1 = new JLabel("ACTUALIZAR RESERVA");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Poor Richard", Font.BOLD, 32));
		lblNewLabel_1.setBounds(150, 95, 353, 61);
		editarframe.getContentPane().add(lblNewLabel_1);

		txtPrecioXNoche = new JTextField();
		txtPrecioXNoche.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPrecioXNoche.setColumns(10);
		txtPrecioXNoche.setBounds(252, 446, 193, 33);
		editarframe.getContentPane().add(txtPrecioXNoche);

		JLabel lblPrecioXNoche = new JLabel("Precio por noche:");
		lblPrecioXNoche.setFont(new Font("Poor Richard", Font.PLAIN, 18));
		lblPrecioXNoche.setBounds(252, 407, 139, 38);
		editarframe.getContentPane().add(lblPrecioXNoche);

		txtCantidadNoches = new JTextField();
		txtCantidadNoches.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCantidadNoches.setColumns(10);
		txtCantidadNoches.setBounds(252, 364, 193, 33);
		editarframe.getContentPane().add(txtCantidadNoches);


		cboxMetodoPago = new JComboBox();
		cboxMetodoPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta", "Efectivo", "Cheque", "Transferencia"}));
		cboxMetodoPago.setFont(new Font("Poor Richard", Font.PLAIN, 16));
		cboxMetodoPago.setBounds(468, 364, 193, 33);
		editarframe.getContentPane().add(cboxMetodoPago);

		txtApellido = new JTextField();
		txtApellido.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtApellido.setColumns(10);
		txtApellido.setBounds(252, 189, 193, 33);
		editarframe.getContentPane().add(txtApellido);

		txtTelefono = new JTextField();
		txtTelefono.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(38, 280, 193, 33);
		editarframe.getContentPane().add(txtTelefono);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(466, 280, 193, 33);
		editarframe.getContentPane().add(txtNacionalidad);

		txtNumeroHabitacion = new JTextField();
		txtNumeroHabitacion.setColumns(10);
		txtNumeroHabitacion.setBounds(40, 446, 193, 33);
		editarframe.getContentPane().add(txtNumeroHabitacion);

		txtEstado = new JTextField();
		txtEstado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEstado.setColumns(10);
		txtEstado.setBounds(252, 530, 193, 33);
		editarframe.getContentPane().add(txtEstado);

		txtNombre = new JTextField();
		
		txtNombre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNombre.setBounds(38, 189, 193, 33);
		editarframe.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblEstado = new JLabel("Estado de reserva:");
		lblEstado.setFont(new Font("Poor Richard", Font.PLAIN, 18));
		lblEstado.setBounds(253, 491, 122, 38);
		editarframe.getContentPane().add(lblEstado);

		JLabel lblCantidadNoches = new JLabel("Cantidad noches:");
		lblCantidadNoches.setFont(new Font("Poor Richard", Font.PLAIN, 18));
		lblCantidadNoches.setBounds(252, 323, 139, 38);
		editarframe.getContentPane().add(lblCantidadNoches);

		JLabel lblfsalida = new JLabel("Fecha de salida:");
		lblfsalida.setFont(new Font("Poor Richard", Font.PLAIN, 18));
		lblfsalida.setBounds(40, 489, 169, 38);
		editarframe.getContentPane().add(lblfsalida);

		JLabel lblfreserva = new JLabel("Fecha de reserva:");
		lblfreserva.setFont(new Font("Poor Richard", Font.PLAIN, 18));
		lblfreserva.setBounds(468, 407, 152, 38);
		editarframe.getContentPane().add(lblfreserva);

		JLabel lblMetodoPago = new JLabel("Metodo de pago:");
		lblMetodoPago.setFont(new Font("Poor Richard", Font.PLAIN, 18));
		lblMetodoPago.setBounds(468, 323, 152, 38);
		editarframe.getContentPane().add(lblMetodoPago);

		JLabel lblNumeroHabitacion = new JLabel("Numero de habitacion:");
		lblNumeroHabitacion.setFont(new Font("Poor Richard", Font.PLAIN, 18));
		lblNumeroHabitacion.setBounds(40, 407, 169, 38);
		editarframe.getContentPane().add(lblNumeroHabitacion);

		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Poor Richard", Font.PLAIN, 18));
		lblNacionalidad.setBounds(466, 232, 103, 38);
		editarframe.getContentPane().add(lblNacionalidad);

		JLabel lblFnacimiento = new JLabel("Fecha de nacimiento:");
		lblFnacimiento.setFont(new Font("Poor Richard", Font.PLAIN, 18));
		lblFnacimiento.setBounds(252, 232, 152, 38);
		editarframe.getContentPane().add(lblFnacimiento);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Poor Richard", Font.PLAIN, 18));
		lblTelefono.setBounds(38, 232, 103, 38);
		editarframe.getContentPane().add(lblTelefono);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Poor Richard", Font.PLAIN, 18));
		lblApellido.setBounds(255, 153, 103, 38);
		editarframe.getContentPane().add(lblApellido);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Poor Richard", Font.PLAIN, 18));
		lblNombre.setBounds(38, 153, 103, 38);
		editarframe.getContentPane().add(lblNombre);
		lblNewLabel.setIcon(new ImageIcon(scaled));
		lblNewLabel.setBounds(10, 51, 671, 584);
		editarframe.getContentPane().add(lblNewLabel);
		editarframe.setBounds(100, 100, 707, 661);
		llenarCampos();
		accionesDelForm();
		rules();
	}

	public void accionesDelForm() {

		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				infoToUpdate();
				
		
				var detallesReserva = new DetallesReserva(nombre, apellido, email, telefono, fechaNacimiento,
						nacionalidad, habitacionId, MetodoPagoId, fEntrada, fSalida, precioNoche, estatus, customer_id,
						idReserva);

				boolean actualizado = controller.actualizar(detallesReserva);

				if (actualizado) {

					JOptionPane.showMessageDialog(null, "Actualizado correctamente",
							"La registro fue actualizado correctamente", JOptionPane.INFORMATION_MESSAGE);
					editarframe.dispose();
				} else {

					JOptionPane.showMessageDialog(null, "Error", "El registro no pudo ser actualizado",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});
	}

	public void rules() {

		Date reservaOut = (Date) modelado.getValueAt(tabla.getSelectedRow(), 11);
		Date fechaActual = new Date(System.currentTimeMillis());

		int fechaResult = reservaOut.compareTo(fechaActual);

		if (fechaResult == -1) {

			dcFechaReserva.setEnabled(false);
			dcFechaSalida.setEnabled(false);
			txtEstado.setEnabled(false);
			txtCantidadNoches.setEditable(false);
			txtPrecioXNoche.setEditable(false);
			cboxTipo.setEnabled(false);

		}
	}

	public void llenarCampos() {

		idReserva = (int) modelado.getValueAt(tabla.getSelectedRow(), 0);

		nombre = modelado.getValueAt(tabla.getSelectedRow(), 1).toString();
		apellido = modelado.getValueAt(tabla.getSelectedRow(), 2).toString();
		email = modelado.getValueAt(tabla.getSelectedRow(), 3).toString();
		telefono = modelado.getValueAt(tabla.getSelectedRow(), 4).toString();
		fechaNacimiento = (Date) modelado.getValueAt(tabla.getSelectedRow(), 5);


		nacionalidad = modelado.getValueAt(tabla.getSelectedRow(), 6).toString();
		numeroHabitacion = modelado.getValueAt(tabla.getSelectedRow(), 7).toString();
		precioNoche = (Float) modelado.getValueAt(tabla.getSelectedRow(), 8);
		tipoHabitaciones = modelado.getValueAt(tabla.getSelectedRow(), 9).toString();

		metodoPago = modelado.getValueAt(tabla.getSelectedRow(), 10).toString();

		fEntrada = (Date) modelado.getValueAt(tabla.getSelectedRow(), 11);
		fSalida = (Date) modelado.getValueAt(tabla.getSelectedRow(), 12);

		estatus = modelado.getValueAt(tabla.getSelectedRow(), 14).toString();

		txtNombre.setText(nombre);

		txtApellido.setText(apellido);

		txtEmail.setText(email);

		txtTelefono.setText(telefono);

		dcFechaNacimiento.setDate(fechaNacimiento);

		txtNacionalidad.setText(nacionalidad);

		txtNumeroHabitacion.setText(numeroHabitacion);

		txtPrecioXNoche.setText(String.valueOf(precioNoche));

		cboxTipo.setSelectedItem(tipoHabitaciones);

		cboxMetodoPago.setSelectedItem(metodoPago);
		
		

		dcFechaReserva.setDate(fEntrada);

		dcFechaSalida.setDate(fSalida);

		String reservaIn = modelado.getValueAt(tabla.getSelectedRow(), 11).toString();

		String reservaOut = modelado.getValueAt(tabla.getSelectedRow(), 12).toString();

		String[] totalDiasIn = reservaIn.split("-");
		int entrada = Integer.valueOf(totalDiasIn[2]);

		String[] totalDiasOut = reservaOut.split("-");
		int salird = Integer.valueOf(totalDiasOut[2]);

		int totaldia = salird - entrada;

		txtCantidadNoches.setText(String.valueOf(totaldia));
		txtEstado.setText(estatus);

		habitacionId = (int) modelado.getValueAt(tabla.getSelectedRow(), 16);
		customer_id = (int) modelado.getValueAt(tabla.getSelectedRow(), 17);
		MetodoPagoId = (int) modelado.getValueAt(tabla.getSelectedRow(), 18);

	}
	
	private void infoToUpdate() {
		
		nombre = txtNombre.getText();
		apellido = txtApellido.getText();
		email = txtEmail.getText();
		telefono = txtTelefono.getText();
		fechaNacimiento =  java.sql.Date.valueOf(((JTextField)dcFechaNacimiento.getDateEditor().getUiComponent()).getText()) ;
		nacionalidad = txtNacionalidad.getText();
		MetodoPagoId = cboxMetodoPago.getSelectedIndex();
		fEntrada = java.sql.Date.valueOf(((JTextField)dcFechaReserva.getDateEditor().getUiComponent()).getText());
		fSalida = java.sql.Date.valueOf(((JTextField)dcFechaSalida.getDateEditor().getUiComponent()).getText());
		estatus = txtEstado.getText();

	}

}
