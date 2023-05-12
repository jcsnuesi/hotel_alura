package com.alura.hotel.view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.alura.hotel.controller.LoginController;
import com.alura.hotel.controller.ReservaController;
import com.alura.hotel.model.User;

import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class LoginFrame extends JFrame{

	public JFrame frame;
	private JTextField txtEmail;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private LoginController login;
	private User usuarios;
	private Encontrar_Reserva reservar;
	
	
	/**
	 * Launch the application.
	 */



	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
	}
	



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		login = new LoginController();
		
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Lucida Bright", Font.BOLD, 17));
		frame.setBounds(100, 100, 943, 789);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon icon = new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\login.png");
		Image image = icon.getImage(); // Obtenemos la imagen desde el ImageIcon
		Image newImage = image.getScaledInstance(236, 222, Image.SCALE_SMOOTH); // Escalamos la imagen
	    ImageIcon newImageIcon = new ImageIcon(newImage); // Creamos un nuevo ImageIcon a part
		
		JLabel lblNewLabel_3 = new JLabel("Desarrollado por Hector Santos 2023©");
		lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(347, 702, 232, 40);
		frame.getContentPane().add(lblNewLabel_3);
		
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 204));
		panel.setBounds(262, 135, 400, 532);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtEmail.setBounds(99, 255, 207, 45);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(70, 10, 236, 222);
		panel.add(lblNewLabel);
		
		lblNewLabel.setIcon(newImageIcon);
		
		JLabel lblNewLabel_2 = new JLabel("Your password:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(99, 310, 127, 43);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Your email:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(99, 216, 92, 43);
		panel.add(lblNewLabel_2_1);
		
		btnLogin = new JButton("Login");
	
		btnLogin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnLogin.setBackground(new Color(210, 105, 30));
		btnLogin.setBounds(139, 422, 127, 43);
		panel.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setBounds(99, 348, 207, 45);
		panel.add(passwordField);
		
		
		ImageIcon btnIcon = new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\back.png");
		Image img = btnIcon.getImage();
		Image imgScaled = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon iconBtn = new ImageIcon(imgScaled);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\Desktop - 2.png"));
		lblNewLabel_1.setBounds(-193, -15, 1127, 1038);
		frame.getContentPane().add(lblNewLabel_1);
		

		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usuarios = new User();
							
				char[] paswordChar = passwordField.getPassword();
				String pass = new String(paswordChar);
				
				usuarios.setEmail(txtEmail.getText());
				usuarios.setPassword(pass);
				List<User> userlogin = login.loginController(usuarios);
				User newUser = userlogin.get(0);
				
				

				 if(userlogin.size() > 0) {
					 
								
					frame.dispose();
					reservar = new Encontrar_Reserva(newUser);					
					reservar.ReservasFrame.setVisible(true);				
					
					}else {
						
						 JOptionPane.showMessageDialog(null, "Usuario/Clave incorrecto.","Denied",JOptionPane.ERROR_MESSAGE);
						
					}
				
				
				
			}
		});

	}
	
	
}
