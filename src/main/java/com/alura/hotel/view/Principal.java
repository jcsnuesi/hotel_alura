package com.alura.hotel.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private LoginFrame login;
	private JLabel lblportada;
	private JButton btnLogin;

	public Principal() {
		
		super("Hotel Alura - Inicio");
		
		this.login = new LoginFrame();
		
		Container container = getContentPane();
		getContentPane().setLayout(null);
		
		generarPortada(container);
		AccionesDelFrame();
		
		
	}

	private void generarPortada(Container container) {
		
		
		btnLogin = new JButton("Login");
	
		btnLogin.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 22));
		btnLogin.setBounds(339, 345, 106, 35);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(139, 69, 19));
	
		lblportada = new JLabel();
		
		ImageIcon icon = new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\portada.png");
		Image img = icon.getImage();
		Image imgResize = img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		
		lblportada.setIcon(new ImageIcon(imgResize));		
		lblportada.setBounds(10, 10, 800, 600);		
		lblportada.setForeground(Color.BLACK);
		
	
		container.add(btnLogin);		
		container.add(lblportada);
		
		setSize(800,600);
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
	
	private void AccionesDelFrame() {
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirLogin();
				
			}
		});
		
		
	}

	private void abrirLogin() {
		
		new LoginFrame().frame.setVisible(true);
		Principal.this.dispose();
	}
	


}
