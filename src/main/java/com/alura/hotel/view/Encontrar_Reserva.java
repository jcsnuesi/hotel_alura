package com.alura.hotel.view;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import com.toedter.components.JSpinField;
import com.alura.hotel.controller.ReservaController;
import com.alura.hotel.model.DetallesReserva;
import com.alura.hotel.model.ReservasDisponibles;
import com.alura.hotel.model.User;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Window.Type;

public class Encontrar_Reserva extends DefaultTableCellRenderer {

	public JFrame ReservasFrame;
	private DefaultTableModel modelo;
	private String name;
	private String lastname;
	private String role;
	private JDateChooser dateIn, dateOut;
	private JComboBox cboxTipo;
	private ReservaController reservaController;
	private JButton btnBuscarReserva;
	public JTable table_1,tblHistorial,table;
	private JScrollPane scrollPane;
	private JLabel lblNoches,lblCantidadNoches,lblTipoHabitaciones,lblFechaOut,lblMetodoDePago,lblFechaIn;
	private Detalles details;
	private int totalDays;
	private JComboBox cboxMetodoPago;
	private JMenuItem logout,exit,history;
	private LoginFrame login;
	private JMenu menu,menuReservas;
	private JMenuBar menuBar;
	private JButton btnTrash;
	private String url = "C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\trash-bin.png";
	private JButton btnDelete;
	private JMenuItem principal;
	private EditarClientes editarCliente;
	private JButton btnBuscar;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnActualizar;
	private DetallesReserva dReservas;


	public Encontrar_Reserva(User userlogin) {
		
		this.name = userlogin.getNombre();
		this.lastname = userlogin.getApellido();
		this.role = userlogin.getRole();
		initialize();
	}

	public Encontrar_Reserva() {
		
		
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	
		login = new LoginFrame();
		reservaController = new ReservaController();
		ReservasFrame = new JFrame("Menu principal");
		ReservasFrame.setResizable(false);
		ReservasFrame.setBounds(100, 100, 1096, 710);
		ReservasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ReservasFrame.getContentPane().setLayout(null);
		
		
		
		JLabel lblBackground = new JLabel("");
		ImageIcon imgBackground = new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\desktop.png");
		Image imgBkResize =  imgBackground.getImage();
		Image ResizedImg = imgBkResize.getScaledInstance(1092, 670, Image.SCALE_SMOOTH);
		
		JLabel lblEncabezado = new JLabel("");
		ImageIcon encIcon =  new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\Hotel Alura.png");
		Image iconToResize = encIcon.getImage();
		Image iconNewImg =  iconToResize.getScaledInstance(580, 80, Image.SCALE_SMOOTH);
		
		JLabel lblControlles = new JLabel("");
		ImageIcon imgControl = new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\rec.png");
		Image controlToResize = imgControl.getImage();
		Image controlResized = controlToResize.getScaledInstance(1006, 130, Image.SCALE_SMOOTH);
		
		btnActualizar = new JButton("");
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\updated.png"));
		btnActualizar.setBounds(951, 278, 85, 78);
		ReservasFrame.getContentPane().add(btnActualizar);
		btnActualizar.setVisible(false);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(322, 212, 121, 36);
		ReservasFrame.getContentPane().add(txtApellido);
		txtApellido.setVisible(false);
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(156, 212, 121, 36);
		ReservasFrame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setVisible(false);
		
		btnBuscar = new JButton("Buscar");
		ReservasFrame.getContentPane().add(btnBuscar);
		
		
		btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\Hardware Gaming PC\\eclipse-workspace\\hotel-reservation\\assets\\remove.png"));
		btnDelete.setBounds(951, 366, 85, 78);
		ReservasFrame.getContentPane().add(btnDelete);
		btnDelete.setVisible(false);
		
		lblCantidadNoches = new JLabel("No. de noches");
		lblCantidadNoches.setForeground(new Color(128, 0, 0));
		lblCantidadNoches.setFont(new Font("Roboto", Font.BOLD, 15));
		lblCantidadNoches.setBounds(930, 131, 107, 36);
		ReservasFrame.getContentPane().add(lblCantidadNoches);
		lblCantidadNoches.setVisible(false);
		
		lblNoches = new JLabel("");
		lblNoches.setForeground(new Color(178, 34, 34));
		lblNoches.setFont(new Font("Poor Richard", Font.BOLD, 24));
		lblNoches.setBackground(new Color(210, 105, 30));
		lblNoches.setBounds(959, 174, 53, 36);
		ReservasFrame.getContentPane().add(lblNoches);
		
		//Btn reservas
		btnBuscarReserva = new JButton("Reservar");	
		btnBuscarReserva.setForeground(new Color(255, 255, 255));
		btnBuscarReserva.setBackground(new Color(210, 105, 30));
		btnBuscarReserva.setFont(new Font("Poor Richard", Font.BOLD, 14));
		btnBuscarReserva.setBounds(790, 174, 121, 36);
		ReservasFrame.getContentPane().add(btnBuscarReserva);
		
	
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(119, 278, 818, 287);
		ReservasFrame.getContentPane().add(scrollPane);
		
		table_1 = new JTable() {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};

		mainTable();
		
		tblHistorial = new JTable() {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		
		JLabel lblRole = new JLabel(role);
		lblRole.setForeground(Color.WHITE);
		lblRole.setFont(new Font("Poor Richard", Font.BOLD, 12));
		lblRole.setBounds(10, 23, 177, 29);		
		ReservasFrame.getContentPane().add(lblRole);
	
	
		
		cboxMetodoPago = new JComboBox();
		cboxMetodoPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta", "Efectivo", "Cheque", "Transferencia"}));
		cboxMetodoPago.setFont(new Font("Poor Richard", Font.PLAIN, 16));
		cboxMetodoPago.setBounds(610, 173, 146, 36);
		ReservasFrame.getContentPane().add(cboxMetodoPago);
	
		
		lblMetodoDePago = new JLabel("Metodo de pago:");
		lblMetodoDePago.setForeground(new Color(128, 0, 0));
		lblMetodoDePago.setFont(new Font("Roboto", Font.BOLD, 15));
		lblMetodoDePago.setBounds(610, 131, 124, 36);
		ReservasFrame.getContentPane().add(lblMetodoDePago);
		
		cboxTipo = new JComboBox();
		cboxTipo.setFont(new Font("Poor Richard", Font.PLAIN, 16));
		cboxTipo.setModel(new DefaultComboBoxModel(new String[] {"Simple", "Doble", "Presidencial"}));
		cboxTipo.setBounds(419, 174, 146, 36);
		ReservasFrame.getContentPane().add(cboxTipo);
		
		dateIn = new JDateChooser();
		dateIn.setDateFormatString("yyyy-MM-dd");
		dateIn.setBounds(59, 173, 146, 36);
		ReservasFrame.getContentPane().add(dateIn);
		
		dateOut = new JDateChooser();
		dateOut.setDateFormatString("yyyy-MM-dd");
		dateOut.setBounds(239, 174, 146, 36);
		ReservasFrame.getContentPane().add(dateOut);
		
		
		lblTipoHabitaciones = new JLabel("Tipo de habitacion:");
		lblTipoHabitaciones.setForeground(new Color(128, 0, 0));
		lblTipoHabitaciones.setFont(new Font("Roboto", Font.BOLD, 15));
		lblTipoHabitaciones.setBounds(419, 131, 132, 36);
		ReservasFrame.getContentPane().add(lblTipoHabitaciones);
		
		lblFechaOut = new JLabel("Fecha de salida:");
		lblFechaOut.setForeground(new Color(128, 0, 0));
		lblFechaOut.setFont(new Font("Roboto", Font.BOLD, 15));
		lblFechaOut.setBounds(239, 131, 124, 36);
		ReservasFrame.getContentPane().add(lblFechaOut);

		
		lblFechaIn = new JLabel("Fecha de entrada:");
		lblFechaIn.setForeground(new Color(128, 0, 0));
		lblFechaIn.setFont(new Font("Roboto", Font.BOLD, 15));
		lblFechaIn.setBounds(59, 131, 141, 36);
		ReservasFrame.getContentPane().add(lblFechaIn);
		lblControlles.setIcon(new ImageIcon(controlResized) );
		lblControlles.setBounds(31, 108, 1006, 140);
		ReservasFrame.getContentPane().add(lblControlles);
		
		JLabel lblUser = new JLabel("Hola, " + name + " " + lastname);
		lblUser.setFont(new Font("Poor Richard", Font.BOLD, 18));
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setBounds(10, 7, 177, 29);
		ReservasFrame.getContentPane().add(lblUser);
		
		//Fecha y hora
		Date fecha = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:ss");
		String dateString = dateFormat.format(fecha);
		
		JLabel lblDate = new JLabel(dateString);
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setFont(new Font("Poor Richard", Font.BOLD, 18));
		lblDate.setBounds(930, 0, 152, 42);
		ReservasFrame.getContentPane().add(lblDate);
		
		lblEncabezado.setIcon(new ImageIcon(iconNewImg));
		lblEncabezado.setBounds(240, 7, 589, 91);
		ReservasFrame.getContentPane().add(lblEncabezado);
		
		lblBackground.setIcon(new ImageIcon(ResizedImg));
		lblBackground.setBounds(-11, 0, 1090, 651);
		ReservasFrame.getContentPane().add(lblBackground);
				
		
		menuBar = new JMenuBar();
		ReservasFrame.setJMenuBar(menuBar);			
		
		menu = new JMenu("Opciones");		
		menuBar.add(menu);
		
		principal = new JMenuItem("Principal");
		
		logout = new JMenuItem("Log out");		
		exit = new JMenuItem("Exit");
		
	
		menu.add(principal);
		menu.add(logout);
		menu.add(exit);
		
		menuReservas = new JMenu("Reservas");		
		menuBar.add(menuReservas);
		
		history = new JMenuItem("Historial de reservas");
		menuReservas.add(history);
		
		configurarAccionesDelFormulario();
		
	}
	
	public void mainTable() {
		
	
		table_1.setRowHeight(30);
		table_1.setFillsViewportHeight(true);
		table_1.setBounds(98, 290, 818, 287);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		table_1.setFont(new Font("Poor Richard", Font.PLAIN, 18));	
		
		scrollPane.setViewportView(table_1);
		modelo = (DefaultTableModel) table_1.getModel();
	     
		modelo.setColumnCount(0);
		modelo.addColumn("ID");
		modelo.addColumn("Habitacion");
		modelo.addColumn("Tipo de habitacion");
		modelo.addColumn("Precio por noche");
		modelo.addColumn("Total");
		
		modelo.setRowCount(0);
	}
	
	
	
	 private void configurarAccionesDelFormulario() {
		 
			
			btnBuscarReserva.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
		
					
					tableBehavior();
					
				}
			});
			
	
			principal.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					mainTable();
					
					habilitarControlesReservas();
			
					
				}
			});
	
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if (e.getClickCount() == 2) {
						
						fillFormTableOut();
						details.detallesFrame.setVisible(true);
					
					
						
					}
				
				}
			});
		
			tblHistorial.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
	
					
					btnDelete.setEnabled(true);
					
					if (e.getClickCount() == 2) {
						
						editarCliente = new EditarClientes(modelo,tblHistorial);
						
						editarCliente.editarframe.setVisible(true);
					}
				
				}
			});
			
			btnBuscar.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
				ArrayList<String> query = new ArrayList<>();
					
				String nombre =	txtNombre.getText();
				String apellido = txtApellido.getText();
				String dateI = ((JTextField) dateIn.getDateEditor().getUiComponent()).getText();
				String dateO = ((JTextField) dateOut.getDateEditor().getUiComponent()).getText();


				List<DetallesReserva> queryResult = null;
				if (nombre.length() > 0) {
					
					query.add(nombre);
				
					queryResult = reservaController.buscarReservaRealizada(query, 1);
				}
				
				
				if (apellido.length() > 0) {
					query.add(apellido);
				
					queryResult =  reservaController.buscarReservaRealizada(query, 2);
				}
				
				if (dateI.length() > 0 && dateO.length() > 0) {
					
					query.add(String.valueOf(java.sql.Date.valueOf(dateO)) );
					query.add(String.valueOf(java.sql.Date.valueOf(dateI)));
					
					System.out.println(query.get(0));
					System.out.println(query.get(1));
					queryResult =  reservaController.buscarReservaRealizada(query, 3);
				}
				
				modelo.setRowCount(0);
				queryResult.forEach(encontrados -> modelo.addRow(new Object[] {
						
						encontrados.getId_reserva(),
						encontrados.getNombre(),
						encontrados.getApellido(),
						encontrados.getEmail(),
						encontrados.getTelefono(),
						encontrados.getFechaNacimiento(),
						encontrados.getNacionalidad(),
						encontrados.getNumeroHabitacion(),
						encontrados.getPrecioNoche(),
						encontrados.getTipoHabitacion(),
						encontrados.getMetodopagoString(),
						encontrados.getFechaIn(),
						encontrados.getFechaOut(),
						encontrados.getTotalgeneral(),
						encontrados.getEstatus(),//14
						encontrados.getFechaRegistro(),//15
						encontrados.getId(),
						encontrados.getCustomerId(),
						encontrados.getMetodoPagoId()
						
						
				}));
					
				}
			});
			
			btnActualizar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					tablaHistorial();
					limpiarCampos();
				}

			
				
			});
			
			btnDelete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					Integer id =0;
					
					try {
						
						id = Integer.valueOf(modelo.getValueAt(tblHistorial.getSelectedRow(),0).toString());
						
						boolean delete = reservaController.eliminarRegistro(id);

						if (delete) {
							
							JOptionPane.showMessageDialog(null,"Registro id: '"+id+"' eliminado correctamente!","Registro eliminado", JOptionPane.INFORMATION_MESSAGE);
							tablaHistorial();
						}else {
							JOptionPane.showMessageDialog(null,"Registro id: '"+id+"' no puedo ser eliminado","Registro NO eliminado", JOptionPane.ERROR_MESSAGE);
							
						}
					} catch (ArrayIndexOutOfBoundsException e2) {
						JOptionPane.showMessageDialog(null,"Haga click en el registro que desea eliminar de manera permanente","Registro NO eliminado", JOptionPane.ERROR_MESSAGE);
						
					}
					

				
				}
			});
			
			exit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
										
					System.exit(0);
				}
			});
			logout.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					login.frame.setVisible(true);
					ReservasFrame.dispose();
					
				}
			});
			
			exit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					ReservasFrame.dispose();
					
				}
			});
			
			history.addActionListener(new ActionListener() {
								
				@Override
				public void actionPerformed(ActionEvent e) {
					
				
					tablaHistorial();			
					limpiarCampos();
				}
			});

			
			
	 }
	 
		private void limpiarCampos() {

			txtNombre.setText("");
			txtApellido.setText("");
			dateIn.setDate(null);
			dateOut.setDate(null);
			
		}
	 
	 private void tablaHistorial() {
		 
			habilitarControlesParaHistorial();
			
			tblHistorial.setRowHeight(30);
			tblHistorial.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tblHistorial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
			tblHistorial.setFont(new Font("Poor Richard", Font.PLAIN, 18));
			tblHistorial.setAutoCreateRowSorter(true);

			scrollPane.setViewportView(tblHistorial);
						
			modelo = (DefaultTableModel) tblHistorial.getModel();
			
			modelo.setColumnCount(0);
			modelo.addColumn("No. reserva");
			modelo.addColumn("Nombre");
			modelo.addColumn("Apellido");
			modelo.addColumn("Email");
			modelo.addColumn("Telefono");
			modelo.addColumn("Fecha de nacimiento");
			modelo.addColumn("Nacionalidad");
			modelo.addColumn("Numero de habitacion");
			modelo.addColumn("Precio por noche");
			modelo.addColumn("Tipo de habitacion");
			modelo.addColumn("Metodo de pago");
			modelo.addColumn("Fecha reserva");
			modelo.addColumn("Fecha salida");
			modelo.addColumn("Total pagado");
			modelo.addColumn("Estatus");
			modelo.addColumn("Fecha de registro");
			modelo.addColumn("idHabitacion");
			modelo.addColumn("idCustomer");
			modelo.addColumn("idMetodoPago");
		
			modelo.setRowCount(0);
			
			
			try {
				var historialReservas = reservaController.historialReservas();
				
				historialReservas.forEach(reservas -> modelo.addRow(new Object[] {
						
						reservas.getId_reserva(),
						reservas.getNombre(),
						reservas.getApellido(),
						reservas.getEmail(),
						reservas.getTelefono(),
						reservas.getFechaNacimiento(),
						reservas.getNacionalidad(),
						reservas.getNumeroHabitacion(),
						reservas.getPrecioNoche(),
						reservas.getTipoHabitacion(),
						reservas.getMetodopagoString(),
						reservas.getFechaIn(),
						reservas.getFechaOut(),
						reservas.getTotalgeneral(),
						reservas.getEstatus(),//14
						reservas.getFechaRegistro(),//15
						reservas.getId(),
						reservas.getCustomerId(),
						reservas.getMetodoPagoId()
						
					
						
				}));
			} catch (Exception e) {
				
				throw new RuntimeException("No se realizo la consulta.");
				
			}
					
	 }
	 
	 
	 private void habilitarControlesReservas() {
		 
		 	
			btnDelete.setVisible(false);
			btnBuscar.setVisible(false);
			btnActualizar.setVisible(false);
			
			btnBuscarReserva.setVisible(true);
			lblNoches.setVisible(true);
			lblNoches.setText("");
			
			cboxMetodoPago.setVisible(true);
			lblCantidadNoches.setVisible(true);
						
			cboxTipo.setVisible(true);			
			dateIn.setBounds(59, 173, 146, 36);
			dateOut.setBounds(239, 174, 146, 36);
						
			lblFechaIn.setText("Fecha de reserva:");
			lblFechaOut.setText("Fecha de salida:");
			lblTipoHabitaciones.setText("Tipo de habitacion:");
			lblMetodoDePago.setText("Metodo de pago:");
			
			txtNombre.setVisible(false);
			txtApellido.setVisible(false);


		 }

	 
	 private void habilitarControlesParaHistorial() {
		 
		lblCantidadNoches.setVisible(false);
		lblNoches.setVisible(false);
		btnBuscarReserva.setVisible(false);
				
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Poor Richard", Font.BOLD, 14));
		btnBuscar.setBackground(new Color(210, 105, 30));
		btnBuscar.setBounds(778, 174, 121, 36);
	
		btnBuscar.setVisible(true);		
	
		btnDelete.setVisible(true);
		btnDelete.setEnabled(false);
		
		btnActualizar.setVisible(true);
		 
		cboxMetodoPago.setVisible(false);
		cboxTipo.setVisible(false);
		 
		lblTipoHabitaciones.setText("Fecha de reserva:");
		lblMetodoDePago.setText("Fecha de salida:");
		lblFechaIn.setText("Nombre:");
		lblFechaOut.setText("Apellido:");
		
		
		txtNombre.setVisible(true);
		txtApellido.setVisible(true);

		txtNombre.setBounds(59, 173, 146, 36);
		txtApellido.setBounds(239, 174, 146, 36);
	
		
		dateIn.setBounds(610, 173, 146, 36);
		dateOut.setBounds(419, 174, 146, 36);
		
	 }

	private void tableBehavior() {	
	
		
		String dateI = ((JTextField) dateIn.getDateEditor().getUiComponent()).getText();
		String dateO = ((JTextField) dateOut.getDateEditor().getUiComponent()).getText();
		String tipo = ((String) cboxTipo.getSelectedItem());
		
		if (dateI.length() == 0 || dateO.length() == 0) {

			JOptionPane.showMessageDialog(null, "Date must be fill out", "Error", JOptionPane.ERROR_MESSAGE);		

		}
	
		String [] dayInSplit = dateI.split("-");
		String [] dayOutSplit = dateO.split("-");
		
		totalDays = Integer.parseInt(dayOutSplit[2]) - Integer.parseInt(dayInSplit[2]);
		lblNoches.setText(String.valueOf(totalDays));
		lblCantidadNoches.setVisible(true);
	 
		var hospedaje = reservaController.findReserva(dateI, dateO, tipo);	
	

		
		modelo.setRowCount(0);
		hospedaje.forEach(disponibles -> modelo.addRow(new Object[] { 
				disponibles.getIdHabitacion() ,
				disponibles.getNum_hab(),
				disponibles.getTipo(),
				disponibles.getPrecioNoche(),
				String.format("%.2f",(disponibles.getPrecioNoche() * totalDays))}));
		


		}
	
	
	 private void fillFormTableOut() {
		 
		 // Datos para la reserva
		 
		 int Idhab = (int) modelo.getValueAt(table_1.getSelectedRow(), 0);
		 int metodopagoIndex = cboxMetodoPago.getSelectedIndex() + 1;
		 
		 
		 // Datos para del detalle de la reserva
		 
		 String dateI = ((JTextField) dateIn.getDateEditor().getUiComponent()).getText();
		 String dateO = ((JTextField) dateOut.getDateEditor().getUiComponent()).getText();
		 
		 String habitacion = String.valueOf(modelo.getValueAt(table_1.getSelectedRow(),1).toString());		
		 String tipoHabitacion = String.valueOf(modelo.getValueAt(table_1.getSelectedRow(),2).toString());		
		 float precioNoche = Float.valueOf(modelo.getValueAt(table_1.getSelectedRow(),3).toString()) ;		
		 String metodopago = String.valueOf(cboxMetodoPago.getSelectedItem());		
		
		 details = new Detalles(Idhab,metodopagoIndex,java.sql.Date.valueOf(dateI),java.sql.Date.valueOf(dateO), habitacion,tipoHabitacion,metodopago,precioNoche,totalDays);
		 
		
		}
}


