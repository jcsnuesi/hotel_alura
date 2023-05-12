package com.alura.hotel.view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;

import com.alura.hotel.controller.ReservaController;
import com.alura.hotel.model.DetallesReserva;
import com.alura.hotel.model.User;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.WindowStateListener;

public class Detalles extends JFrame{


	public JFrame detallesFrame;
	private JLabel lblLogo;
	private JLabel lbltitle;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblEmail;
	private JLabel lblDOB;
	private JLabel lblTelefono;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private DefaultTableModel modeloDetalle;
	private JLabel lblNewLabel;
	private JTable table;
	private String habitacion;
	private String tipoHabitacion;
	private float precioNoche;
	private int totalNoches;
	private String metodopago;
	private JButton btnReservar;
	private JDateChooser dateChooser;
	private JComboBox cbNacionalidad;
	private float totalgeneral;
	private ReservaController rcontroller;
	private Date fechaIn;
	private Date fechaOut;
	private int idhab;
	private int metodoPagoIndex;
	private DetallesReserva detalle;
	private Encontrar_Reserva ereservas;
	
	
	public Detalles (
		int idhab,
		int metodoPagoIndex, 
		Date fechaIn, 
		Date fechaOut,
		String habitacion,
		String tipoHabitacion,
		String metodopago, 
		float precioNoche,
		int total) {
		
		
		this.metodoPagoIndex = metodoPagoIndex;
		this.idhab = idhab;
		this.fechaIn = fechaIn;
		this.fechaOut = fechaOut;
		this.habitacion = habitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.metodopago = metodopago;
		this.precioNoche = precioNoche;
		this.totalNoches = total;
		datallesReservas();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void datallesReservas() {
		
		rcontroller = new ReservaController();
		detallesFrame = new JFrame("Completar reserva");
	
		detallesFrame.getContentPane().setBackground(new Color(128, 0, 0));
		detallesFrame.setBounds(100, 100, 469, 786);
		detallesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		detallesFrame.getContentPane().setLayout(null);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setForeground(new Color(184, 134, 11));
		lblNacionalidad.setFont(new Font("Poor Richard", Font.PLAIN, 22));
		lblNacionalidad.setBounds(76, 418, 145, 33);
		detallesFrame.getContentPane().add(lblNacionalidad);
		
		cbNacionalidad = new JComboBox();
		cbNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 14));
		cbNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"Republica Dominicana", 			"Brazil", "Colombia", "Venezuela", "Puerto Rico"}));
		cbNacionalidad.setBounds(76, 451, 293, 30);
		detallesFrame.getContentPane().add(cbNacionalidad);
		
		JScrollPane scrollTableDetalles = new JScrollPane();
		scrollTableDetalles.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTableDetalles.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollTableDetalles.setBounds(27, 63, 393, 86);
		detallesFrame.getContentPane().add(scrollTableDetalles);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
		
		modeloDetalle = (DefaultTableModel) table.getModel();
		modeloDetalle.addColumn("Fecha entrada");
		modeloDetalle.addColumn("Fecha salida");
		modeloDetalle.addColumn("Habitacion");
		modeloDetalle.addColumn("Tipo de habitacion");
		modeloDetalle.addColumn("Metodo de pago");
		modeloDetalle.addColumn("Total noches");
		modeloDetalle.addColumn("Precio por noche");
		modeloDetalle.addColumn("Total");
		scrollTableDetalles.setViewportView(table);

		fillTableOut();
		
		
		lblLogo = new JLabel("");
		ImageIcon iconFullSize =  new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\recInfo.png");
		Image iconImage =  iconFullSize.getImage();
		Image iconResize = iconImage.getScaledInstance(400, 500, Image.SCALE_SMOOTH);
		
		lblNewLabel = new JLabel("Detalles:");
		lblNewLabel.setFont(new Font("Poor Richard", Font.BOLD, 26));
		lblNewLabel.setBounds(27, 10, 103, 33);
		detallesFrame.getContentPane().add(lblNewLabel);
		
		JLabel lbldetalles = new JLabel("");
		lbldetalles.setIcon(new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\rec.png"));
		lbldetalles.setBackground(new Color(255, 255, 255));
		lbldetalles.setForeground(new Color(255, 215, 0));
		lbldetalles.setFont(new Font("Roboto", Font.BOLD, 18));
		lbldetalles.setBounds(0, 10, 234, 33);
		detallesFrame.getContentPane().add(lbldetalles);
		
		btnReservar = new JButton("Reservar");		
		btnReservar.setBackground(new Color(210, 105, 30));
		btnReservar.setForeground(new Color(255, 255, 255));
		btnReservar.setFont(new Font("Roboto", Font.BOLD, 14));
		btnReservar.setBounds(109, 643, 219, 46);
		detallesFrame.getContentPane().add(btnReservar);
		placeReservation();
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(76, 389, 293, 30);
		detallesFrame.getContentPane().add(dateChooser);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(76, 514, 293, 30);
		detallesFrame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(76, 581, 293, 30);
		detallesFrame.getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		
		txtApellido = new JTextField();
		txtApellido.setBounds(76, 323, 293, 30);
		detallesFrame.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
	
		
		txtNombre = new JTextField();
		txtNombre.setBounds(76, 254, 293, 30);
		detallesFrame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(new Color(184, 134, 11));
		lblTelefono.setFont(new Font("Poor Richard", Font.PLAIN, 22));
		lblTelefono.setBounds(76, 554, 145, 33);
		detallesFrame.getContentPane().add(lblTelefono);
		
		lblDOB = new JLabel("Fecha de nacimiento:");
		lblDOB.setForeground(new Color(184, 134, 11));
		lblDOB.setFont(new Font("Poor Richard", Font.PLAIN, 22));
		lblDOB.setBounds(76, 361, 185, 33);
		detallesFrame.getContentPane().add(lblDOB);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(184, 134, 11));
		lblEmail.setFont(new Font("Poor Richard", Font.PLAIN, 22));
		lblEmail.setBounds(76, 488, 85, 33);
		detallesFrame.getContentPane().add(lblEmail);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(new Color(184, 134, 11));
		lblApellido.setFont(new Font("Poor Richard", Font.PLAIN, 22));
		lblApellido.setBounds(76, 294, 85, 33);
		detallesFrame.getContentPane().add(lblApellido);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(184, 134, 11));
		lblNombre.setFont(new Font("Poor Richard", Font.PLAIN, 22));
		lblNombre.setBounds(76, 224, 145, 33);
		detallesFrame.getContentPane().add(lblNombre);
		
		lbltitle = new JLabel("");
		lbltitle.setIcon(new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\Completar reserva.png"));
		lbltitle.setBounds(76, 176, 282, 57);
		detallesFrame.getContentPane().add(lbltitle);
		lblLogo.setIcon(new ImageIcon(iconResize));
		lblLogo.setBounds(27, 168, 401, 509);
		detallesFrame.getContentPane().add(lblLogo);
		ImageIcon iconFullForm =  new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\Group 4.png");
		Image iconImageForm =  iconFullForm.getImage();
		Image iconResizeForm = iconImageForm.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		
		
		JLabel lblFooter = new JLabel("");
		lblFooter.setIcon(new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\Group 3.png"));
		lblFooter.setBounds(-442, 699, 920, 40);
		detallesFrame.getContentPane().add(lblFooter);
	
	}

	
	private void fillTableOut(){

		DecimalFormat number = new DecimalFormat("#,###.00");
		totalgeneral = precioNoche * totalNoches;
		String formatedNumber = number.format(totalgeneral);
		
		
		modeloDetalle.addRow(new String[] {
				String.valueOf(fechaIn ),String.valueOf(fechaOut),habitacion,tipoHabitacion,metodopago,String.valueOf(totalNoches),String.valueOf(precioNoche) ,formatedNumber
		});
		
	
	
	
	}
	


	private void placeReservation() {
		
		btnReservar.addMouseListener(new MouseAdapter() {
	

			@Override
			public void mouseClicked(MouseEvent e) {
				
				String fechaNacimiento =  ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
				String nacionalidad = String.valueOf(cbNacionalidad.getSelectedItem());	
				String email = txtEmail.getText();
				String telefono = txtTelefono.getText();
				System.out.println(email.contains("@"));
				if (email.contains("@") && fechaNacimiento.length() > 0 && nacionalidad.length() > 0 &&  telefono.length() > 0) {
					
				
					detalle = new DetallesReserva(fechaIn,fechaOut, txtNombre.getText(), txtApellido.getText(), java.sql.Date.valueOf(fechaNacimiento), nacionalidad, txtTelefono.getText(), txtEmail.getText(), precioNoche, idhab, metodoPagoIndex,totalgeneral);
					
					boolean response = rcontroller.makeReserva(detalle);
					
					if (response) {
					
						JOptionPane.showMessageDialog(null,"Reserva no. '"+detalle.getIdNewCustomer()+"' completada exitosamente ","Reserva exitosa!",JOptionPane.INFORMATION_MESSAGE);
						detallesFrame.dispose();
					
					}else {
						
						JOptionPane.showMessageDialog(null,"No se pude guardar su reserva","Error",JOptionPane.ERROR_MESSAGE);

						
					}

				}else {
					
					JOptionPane.showMessageDialog(null,"No pueden hacer campos vacios","Error",JOptionPane.ERROR_MESSAGE);
					
					
				}
				
				
				

				
			
			}

			
		});
	}
	


}
