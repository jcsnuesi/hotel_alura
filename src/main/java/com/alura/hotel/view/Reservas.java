package com.alura.hotel.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Label;
import com.toedter.calendar.JDateChooser;

public class Reservas {

	private JFrame frRegistration;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNacionalidad;
	private JTextField txtTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservas window = new Reservas();
					window.frRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reservas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frRegistration = new JFrame();
		frRegistration.setResizable(false);
		frRegistration.setBounds(100, 100, 1093, 852);
		frRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frRegistration.getContentPane().setLayout(null);
		
		JLabel lblPortadaInfo = new JLabel("");
		ImageIcon infoImgPortafaInfo = new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\Group 4.png");
		Image imgResizeBasic = infoImgPortafaInfo.getImage();
		
		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.setBackground(new Color(210, 105, 30));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Poor Richard", Font.BOLD, 18));
		btnNewButton.setBounds(78, 683, 374, 41);
		frRegistration.getContentPane().add(btnNewButton);
		
		lblPortadaInfo.setIcon(new ImageIcon(imgResizeBasic.getScaledInstance(504, 600, Image.SCALE_SMOOTH)));
		lblPortadaInfo.setForeground(new Color(178, 34, 34));
		lblPortadaInfo.setFont(new Font("Roboto", Font.BOLD, 18));
		lblPortadaInfo.setBounds(537, 97, 506, 600);
		frRegistration.getContentPane().add(lblPortadaInfo);
		
		JLabel lblNewLabel = new JLabel("No. reserva: ");
		lblNewLabel.setFont(new Font("Poor Richard", Font.BOLD, 24));
		lblNewLabel.setBounds(78, 632, 374, 41);
		frRegistration.getContentPane().add(lblNewLabel);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(null);
		txtTelefono.setBounds(78, 560, 374, 41);
		frRegistration.getContentPane().add(txtTelefono);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Poor Richard", Font.BOLD, 18));
		lblTelefono.setBounds(78, 517, 162, 33);
		frRegistration.getContentPane().add(lblTelefono);
		
		JDateChooser txtDOB = new JDateChooser();
		txtDOB.setForeground(new Color(0, 255, 0));
		txtDOB.setBounds(78, 362, 374, 48);
		frRegistration.getContentPane().add(txtDOB);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Poor Richard", Font.BOLD, 18));
		lblNacionalidad.setBounds(78, 420, 162, 41);
		frRegistration.getContentPane().add(lblNacionalidad);
		
		JLabel lblLastname = new JLabel("Apellido:");
		lblLastname.setFont(new Font("Poor Richard", Font.BOLD, 18));
		lblLastname.setBounds(78, 229, 162, 29);
		frRegistration.getContentPane().add(lblLastname);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Poor Richard", Font.BOLD, 18));
		lblFechaDeNacimiento.setBounds(78, 319, 229, 33);
		frRegistration.getContentPane().add(lblFechaDeNacimiento);
		
		JLabel lblName = new JLabel("Nombre");
		lblName.setFont(new Font("Poor Richard", Font.BOLD, 18));
		lblName.setBounds(78, 135, 162, 33);
		frRegistration.getContentPane().add(lblName);
		
		JLabel lblRegistration = new JLabel("");
		lblRegistration.setIcon(new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\Registration information.png"));
		lblRegistration.setBounds(78, 82, 401, 55);
		frRegistration.getContentPane().add(lblRegistration);
		
		
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtNombre.setBorder(null);
		txtNombre.setBounds(78, 178, 374, 41);
		frRegistration.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtApellido.setBorder(null);
		txtApellido.setColumns(10);
		txtApellido.setBounds(78, 268, 374, 41);
		frRegistration.getContentPane().add(txtApellido);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtNacionalidad.setBorder(null);
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(78, 463, 374, 41);
		frRegistration.getContentPane().add(txtNacionalidad);
		
		JLabel lblInfoCustomer = new JLabel("");
		lblInfoCustomer.setFont(new Font("Roboto", Font.BOLD, 18));
		lblInfoCustomer.setForeground(new Color(178, 34, 34));
		
		ImageIcon infoImg = new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\recInfo.png");
		Image imgResizeBasicInfo = infoImg.getImage();
		Image imgResized = imgResizeBasicInfo.getScaledInstance(503, 723, Image.SCALE_SMOOTH);
		lblInfoCustomer.setIcon( new ImageIcon(imgResized));
		lblInfoCustomer.setBounds(10, 30, 517, 723);
		frRegistration.getContentPane().add(lblInfoCustomer);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\pantalla.png"));
		lblBackground.setBounds(0, 0, 1090, 851);
		frRegistration.getContentPane().add(lblBackground);
		
		
//		MENU BAR AND ITEMS
		JMenuBar menuBar = new JMenuBar();
		frRegistration.setJMenuBar(menuBar);
		
		
		JMenu mnNewMenu = new JMenu("Opciones");
		mnNewMenu.setBounds(0, 0, 1079, 41);
		
		menuBar.add(mnNewMenu);
		
		JMenuItem login =  new JMenuItem("Log out");
		JMenuItem salir =  new JMenuItem("Salir");
		mnNewMenu.add(login);
		mnNewMenu.add(salir);
		
		
	}
}
