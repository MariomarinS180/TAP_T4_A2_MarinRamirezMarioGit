package vista;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import javax.swing.*;
import controlador.AlumnoDAO;
import modelo.Alumno;
public class VenInicio extends JFrame{
	JMenuBar menuBar;
	JMenu menuInicio;
	JMenuItem menuAltas, menuBajas, menuCambios, menuConsultas;
	JInternalFrame IF_Altas, IF_Bajas, IF_Cambios ,IF_Consultas;
	public VenInicio() {
			getContentPane().setLayout(new BorderLayout());
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("ABCC");
			setSize(710, 600);
			setLocationRelativeTo(null);
			setVisible(true);
			getContentPane().setBackground(Color.WHITE);	
		
			menuBar = new JMenuBar();
			menuInicio = new JMenu("OPCIONES");
			menuAltas = new JMenuItem("ALTAS");
			menuBajas = new JMenuItem("BAJAS"); 
			menuCambios = new JMenuItem("CAMBIOS");
			menuConsultas = new JMenuItem("CONSULTAS");
			menuAltas.setMnemonic(KeyEvent.VK_A);
			menuBajas.setMnemonic(KeyEvent.VK_B);
			menuCambios.setMnemonic(KeyEvent.VK_C);
			menuConsultas.setMnemonic(KeyEvent.VK_D);
			menuAltas.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
				menuAltas.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						IF_Altas.setVisible(true);
					}
				});
			menuBajas.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
				menuBajas.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						IF_Bajas.setVisible(true);
					}
				});
			menuCambios.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
						menuCambios.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								IF_Cambios.setVisible(true);
							}
						});
			menuConsultas.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
						menuConsultas.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
						IF_Consultas.setVisible(true);
							}
					});	
			menuInicio.add(menuAltas);
			menuInicio.add(menuBajas);
			menuInicio.add(menuCambios);
			menuInicio.add(menuConsultas);
			
			menuBar.add(menuInicio);
			setJMenuBar(menuBar);
			JDesktopPane desktopPane = new JDesktopPane();
			
			IF_Altas = new JInternalFrame();
				IF_Altas.getContentPane().setLayout(null);
				IF_Altas.setDefaultCloseOperation(HIDE_ON_CLOSE);
				IF_Altas.setTitle("Altas");
				IF_Altas.setSize(700, 550);
				IF_Altas.setMaximizable(true);
				IF_Altas.setIconifiable(true);
				IF_Altas.setClosable(true);
				IF_Altas.setResizable(true);
				IF_Altas.setLayout(null);
				
				JLabel label_fondo, label_txt, label_numCntrl, label_nombres, label_apPaterno, label_apMaterno, label_semestre, label_carrera; 
				JTextField caja_numCntrl, caja_nombres, caja_apPaterno, caja_apMaterno;
				JComboBox<String> combo_semestre, combo_carrera;
				JButton btn_agregar, btn_borrar,btn_cancelar;
				
				label_txt = new JLabel("ALTAS ALUMNOS");
				label_txt.setFont(new Font("Helvetica", Font.PLAIN, 30));
				label_txt.setForeground(Color.white);
				label_txt.setBounds(60, 0, 684, 60);
				IF_Altas.add(label_txt);
				label_fondo = new JLabel(); 
				label_fondo.setBounds(0, 0, 684, 60); 
				label_fondo.setBackground(Color.green);
				label_fondo.setOpaque(true);
				IF_Altas.add(label_fondo);
				
				label_numCntrl = new JLabel("NUMERO DE CONTROL:");
				label_numCntrl.setBounds(100, 95, 150, 10);
				IF_Altas.add(label_numCntrl);
				caja_numCntrl = new JTextField();
				caja_numCntrl.setBounds(250, 90, 170, 20);
				IF_Altas.add(caja_numCntrl);
				
				label_nombres = new JLabel("NOMBRES:");
				label_nombres.setBounds(100, 120, 150, 10);
				IF_Altas.add(label_nombres);
				caja_nombres = new JTextField();
				caja_nombres.setBounds(170, 115, 250, 20);
				IF_Altas.add(caja_nombres);
				
				label_apPaterno = new JLabel("APELLIDO PATERNO:");
				label_apPaterno.setBounds(100, 155, 150, 10);
				IF_Altas.add(label_apPaterno);
				caja_apPaterno = new JTextField();
				caja_apPaterno.setBounds(250, 150, 170, 20);
				IF_Altas.add(caja_apPaterno);
				
				label_apMaterno = new JLabel("APELLIDO MATERNO:");
				label_apMaterno.setBounds(100, 195, 150, 10);
				IF_Altas.add(label_apMaterno);
				caja_apMaterno = new JTextField();
				caja_apMaterno.setBounds(250, 190, 170, 20);
				IF_Altas.add(caja_apMaterno);
					
				label_semestre = new JLabel("SEMESTRE:");
				label_semestre.setBounds(100, 250, 150, 10);
				IF_Altas.add(label_semestre);
				String [] items = {"Elige Semestre...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
				combo_semestre = new JComboBox<>(items);
				combo_semestre.setBounds(250, 245, 170, 20);
				IF_Altas.add(combo_semestre);
				
				label_carrera = new JLabel("CARRERA:");
				label_carrera.setBounds(100, 280, 150, 10);
				IF_Altas.add(label_carrera);
				String [] items2 = {"Elige Carrera:", "I.S.C", "I.M", "I.I.A", "L.A", "C.P"};
				combo_carrera = new JComboBox<>(items2);
				combo_carrera.setBounds(250, 275, 170, 20);
				IF_Altas.add(combo_carrera);
				
				btn_agregar = new JButton("AGREGAR");
				btn_agregar.setBounds(460, 100, 100, 20);
				IF_Altas.add(btn_agregar);
				btn_agregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(caja_apMaterno.getText().equals("") || caja_apPaterno.getText().equals("") || caja_nombres.getText().equals("") || caja_numCntrl.getText().equals("") || combo_carrera.getSelectedIndex()==0 || combo_semestre.getSelectedIndex()==0){
							JOptionPane.showMessageDialog(getParent(), "LLENE LOS DATOS", "AVISO", JOptionPane.ERROR_MESSAGE);
						}else {
							try {
								boolean resultado = new AlumnoDAO().agregarAlumno(new Alumno(caja_numCntrl.getText(), 
								caja_nombres.getText(), caja_apPaterno.getText(), caja_apMaterno.getText(), 
								Byte.parseByte("19"), combo_semestre.getSelectedIndex(), String.valueOf(combo_carrera.getSelectedIndex())));
								JOptionPane.showMessageDialog(getParent(), "SE REGISTRO CORRECTAMENTE");
							} catch (Exception e) {
							JOptionPane.showMessageDialog(getParent(), "LLENE LOS DATOS", "AVISO", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}); //ACTION LISTENER AGREGAR
				btn_borrar = new JButton("BORRAR");
				btn_borrar.setBounds(460, 170, 100, 20);
				IF_Altas.add(btn_borrar);
				btn_borrar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						caja_numCntrl.setText("");
						caja_nombres.setText("");
						caja_apPaterno.setText("");
						caja_apMaterno.setText("");
						combo_carrera.setSelectedIndex(0);
						combo_semestre.setSelectedIndex(0);
					}
				});//ACTION LISTENER BORRAR
				btn_cancelar = new JButton("CANCELAR");
				btn_cancelar.setBounds(460, 240, 100, 20);
				IF_Altas.add(btn_cancelar);
			
			IF_Bajas = new JInternalFrame();
				IF_Bajas.getContentPane().setLayout(null);
				IF_Bajas.setDefaultCloseOperation(HIDE_ON_CLOSE);
				IF_Bajas.setTitle("Bajas");
				IF_Bajas.setSize(700, 550);
				IF_Bajas.setMaximizable(true);
				IF_Bajas.setIconifiable(true);
				IF_Bajas.setClosable(true);
				IF_Bajas.setResizable(true);
				IF_Bajas.setLayout(null);
				
				
				ImageIcon imagen; 
				Icon icono;
				JLabel label_txt2, label_fondo2, label_numControl2, label_nombre2, label_apPaterno2, label_apMaterno2, label_semestre2, label_carrera2; 
				JTextField caja_nombre2, caja_numControl2 ,caja_apPaterno2, caja_apMaterno2;
				JButton botonLupa, botonBorrar2, botonEliminar2, botonCancelar2; 
				JComboBox<String> comboBox_carrera2, comboListaSemestre2;
				
				label_txt2 = new JLabel("BAJAS ALUMNOS");
				label_txt2.setFont(new Font("Helvetica", Font.PLAIN, 30));
				label_txt2.setForeground(Color.white);
				label_txt2.setBounds(60, 0, 684, 60);
				IF_Bajas.add(label_txt2); 
				label_fondo2 = new JLabel(); 
				label_fondo2.setBounds(0, 0, 684, 60); 
				label_fondo2.setBackground(Color.red);
				label_fondo2.setOpaque(true);
				IF_Bajas.add(label_fondo2);
				
				label_numControl2 = new JLabel("NUMERO DE CONTROL:");
				label_numControl2.setBounds(75, 95, 150, 10);
				IF_Bajas.add(label_numControl2); 
				caja_numControl2 = new JTextField(); 
				caja_numControl2.setBackground(Color.cyan);
				caja_numControl2.setBounds(225, 80, 100, 40);
				IF_Bajas.add(caja_numControl2);
				
				label_nombre2 = new JLabel("NOMBRE(S):");
				label_nombre2.setBounds(75, 180, 150, 10);
				IF_Bajas.add(label_nombre2); 
				caja_nombre2 = new JTextField();  
				caja_nombre2.setBounds(250, 170, 150, 35);
				IF_Bajas.add(caja_nombre2);
				
				label_apPaterno2 = new JLabel("APELLIDO PATERNO:");
				label_apPaterno2.setBounds(75, 225, 150, 10);
				IF_Bajas.add(label_apPaterno2); 
				caja_apPaterno2 = new JTextField();  
				caja_apPaterno2.setBounds(250, 215, 150, 35);
				IF_Bajas.add(caja_apPaterno2);
				
				label_apMaterno2 = new JLabel("APELLIDO MATERNO:");
				label_apMaterno2.setBounds(75, 270, 150, 10);
				IF_Bajas.add(label_apMaterno2); 
				caja_apMaterno2 = new JTextField();  
				caja_apMaterno2.setBounds(250, 260, 150, 35);
				IF_Bajas.add(caja_apMaterno2);
				
				label_semestre2 = new JLabel("SEMESTRE:");
				label_semestre2.setBounds(75, 340, 150, 10);
				IF_Bajas.add(label_semestre2); 
				String semestres [] = {"Elige Semestre...","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
				comboListaSemestre2 = new JComboBox<>(semestres);
				comboListaSemestre2.setBounds(250, 330, 150, 35);
				IF_Bajas.add(comboListaSemestre2); 
				
				label_carrera2 = new JLabel("CARRERA:");
				label_carrera2.setBounds(75, 410, 150, 10);
				IF_Bajas.add(label_carrera2); 
				String carrera [] = {"Elige Carrera...","I.S.C", "I.I.A", "I.M", "L.A", "C.P"};
				comboBox_carrera2 = new JComboBox<>(carrera);
				comboBox_carrera2.setBounds(250, 400, 150, 35);
				IF_Bajas.add(comboBox_carrera2); 
				
				botonEliminar2 = new JButton("ELIMINAR"); 
				botonEliminar2.setBounds(515, 225, 100, 30);
				botonEliminar2.setBackground(Color.white);
				IF_Bajas.add(botonEliminar2);
				botonEliminar2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(caja_numControl2.getText().equals("")) {
							JOptionPane.showMessageDialog(getParent(), "SE ELIMINA POR MEDIO DEL NUMERO DE CONTROL", "AVISO", JOptionPane.INFORMATION_MESSAGE);
						}if(caja_nombre2.getText().equals("") || caja_apPaterno2.getText().equals("") || caja_apMaterno2.getText().equals("") || comboBox_carrera2.getSelectedIndex()==0|| comboListaSemestre2.getSelectedIndex()==0) {
							JOptionPane.showMessageDialog(getParent(), "NO PUEDE DEJAR ESPACIOS VACIOS", "AVISO", JOptionPane.INFORMATION_MESSAGE);
						}else {
							try {
								boolean res = new AlumnoDAO().eliminarAlumno(caja_numControl2.getText());
								JOptionPane.showMessageDialog(getParent(), "SE ELIMINO CORRECTAMENTE");
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(getParent(), "NO PUEDE DEJAR ESPACIOS VACIOS", "AVISO", JOptionPane.INFORMATION_MESSAGE);
							}
							
						}
						
					}
				});
				botonLupa = new JButton(); 
				botonLupa.setBounds(375, 80, 110, 50);
				botonLupa.setBackground(Color.gray);
				imagen = new ImageIcon("icono/lupa.png");
				icono = new ImageIcon(imagen.getImage().getScaledInstance(botonLupa.getWidth(), botonLupa.getHeight(), Image.SCALE_DEFAULT));
				botonLupa.setIcon(icono);
				IF_Bajas.add(botonLupa);
				botonLupa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(caja_numControl2.getText().equals("")) {
						JOptionPane.showMessageDialog(getParent(), "NO HAY NADA QUE BUSCAR", "AVISO", JOptionPane.ERROR_MESSAGE);
						}else {
						JOptionPane.showMessageDialog(getParent(), "SE REALIZO LA BUSQUEDA...");
						}
					}
				});
				botonCancelar2 = new JButton("CANCELAR"); 
				botonCancelar2.setBounds(515, 300, 100, 30);
				botonCancelar2.setBackground(Color.white);
				IF_Bajas.add(botonCancelar2);
				
				botonBorrar2 = new JButton("BORRAR"); 
				botonBorrar2.setBounds(515, 90, 100, 30);
				botonBorrar2.setBackground(Color.white);
				IF_Bajas.add(botonBorrar2);
				botonBorrar2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						caja_numControl2.setText("");
						caja_nombre2.setText("");
						caja_apPaterno2.setText("");
						caja_apMaterno2.setText("");
						comboBox_carrera2.setSelectedIndex(0);
						comboListaSemestre2.setSelectedIndex(0);
					}
				});
				IF_Cambios = new JInternalFrame();
				IF_Cambios.getContentPane().setLayout(null);
				IF_Cambios.setDefaultCloseOperation(HIDE_ON_CLOSE);
				IF_Cambios.setTitle("Cambios");
				IF_Cambios.setSize(700, 550);
				IF_Cambios.setMaximizable(true);
				IF_Cambios.setIconifiable(true);
				IF_Cambios.setClosable(true);
				IF_Cambios.setResizable(true);
				IF_Cambios.setLayout(null);
				
				JLabel label_txt3, label_fondo3, label_numControl3, label_nombre3, label_apPaterno3, label_apMaterno3, label_semestre3, label_carrera3; 
				JTextField caja_nombre3, caja_numControl3 ,caja_apPaterno3, caja_apMaterno3;
				JButton botonLupa3, botonBorrar3, botonGuardarCambios, botonCancelar3; 
				JComboBox<String> comboBox_carrera3, comboListaSemestre3;
				
				label_txt3 = new JLabel("MODIFICACIONES ALUMNOS");
				label_txt3.setFont(new Font("Helvetica", Font.PLAIN, 30));
				label_txt3.setForeground(Color.white);
				label_txt3.setBounds(60, 0, 684, 60);
				IF_Cambios.add(label_txt3); 
				label_fondo3 = new JLabel(); 
				label_fondo3.setBounds(0, 0, 684, 60); 
				label_fondo3.setBackground(Color.orange);
				label_fondo3.setOpaque(true);
				IF_Cambios.add(label_fondo3);
				
				label_numControl3 = new JLabel("NUMERO DE CONTROL:");
				label_numControl3.setBounds(75, 95, 150, 10);
				IF_Cambios.add(label_numControl3); 
				caja_numControl3 = new JTextField(); 
				caja_numControl3.setBackground(Color.cyan);
				caja_numControl3.setBounds(225, 80, 100, 40);
				IF_Cambios.add(caja_numControl3);
				
				label_nombre3 = new JLabel("NOMBRE(S):");
				label_nombre3.setBounds(75, 180, 150, 10);
				IF_Cambios.add(label_nombre3); 
				caja_nombre3 = new JTextField();  
				caja_nombre3.setBounds(250, 170, 150, 35);
				IF_Cambios.add(caja_nombre3);
				
				label_apPaterno3 = new JLabel("APELLIDO PATERNO:");
				label_apPaterno3.setBounds(75, 225, 150, 10);
				IF_Cambios.add(label_apPaterno3); 
				caja_apPaterno3 = new JTextField();  
				caja_apPaterno3.setBounds(250, 215, 150, 35);
				IF_Cambios.add(caja_apPaterno3);
				
				label_apMaterno3 = new JLabel("APELLIDO MATERNO:");
				label_apMaterno3.setBounds(75, 270, 150, 10);
				IF_Cambios.add(label_apMaterno3); 
				caja_apMaterno3 = new JTextField();  
				caja_apMaterno3.setBounds(250, 260, 150, 35);
				IF_Cambios.add(caja_apMaterno3);
				
				label_semestre3 = new JLabel("SEMESTRE:");
				label_semestre3.setBounds(75, 340, 150, 10);
				IF_Cambios.add(label_semestre3); 
				String semestre3 [] = {"Elija Semestre...","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
				comboListaSemestre3 = new JComboBox<>(semestre3);
				comboListaSemestre3.setBounds(250, 330, 150, 35);
				IF_Cambios.add(comboListaSemestre3); 
				
				label_carrera3 = new JLabel("CARRERA:");
				label_carrera3.setBounds(75, 410, 150, 10);
				IF_Cambios.add(label_carrera3); 
				String carrera3 [] = {"Elija Carrera...","I.S.C", "I.I.A", "I.M", "L.A", "C.P"};
				comboBox_carrera3 = new JComboBox<>(carrera3);
				comboBox_carrera3.setBounds(250, 400, 150, 35);
				IF_Cambios.add(comboBox_carrera3); 
				
				botonLupa3 = new JButton(); 
				botonLupa3.setBounds(375, 80, 110, 50);
				botonLupa3.setBackground(Color.gray);
				imagen = new ImageIcon("icono/lupa.png");
				icono = new ImageIcon(imagen.getImage().getScaledInstance(botonLupa3.getWidth(), botonLupa3.getHeight(), Image.SCALE_DEFAULT));
				botonLupa3.setIcon(icono);
				IF_Cambios.add(botonLupa3);
				botonLupa3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(caja_numControl3.getText().equals("")) {
							JOptionPane.showMessageDialog(getParent(), "NO HAY NADA QUE BUSCAR", "AVISO", JOptionPane.ERROR_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(getParent(), "SE REALIZO LA BUSQUEDA...");
						}
					}
				});
				botonBorrar3 = new JButton("BORRAR"); 
				botonBorrar3.setBounds(515, 90, 100, 30);
				botonBorrar3.setBackground(Color.white);
				IF_Cambios.add(botonBorrar3);
				botonBorrar3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						caja_numControl3.setText("");
						caja_nombre3.setText("");
						caja_apPaterno3.setText("");
						caja_apMaterno3.setText("");
						comboBox_carrera3.setSelectedIndex(0);
						comboListaSemestre3.setSelectedIndex(0);
					}
				});
				botonGuardarCambios = new JButton("GUARDAR CAMBIOS"); 
				botonGuardarCambios.setBounds(490, 225, 150, 30);
				botonGuardarCambios.setBackground(Color.white);
				IF_Cambios.add(botonGuardarCambios);
				botonGuardarCambios.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(caja_numControl3.getText().equals("") || caja_nombre3.getText().equals("") || caja_apPaterno3.getText().equals("") || caja_apMaterno3.getText().equals("") || comboListaSemestre3.getSelectedIndex() == 0 || comboBox_carrera3.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(getParent(), "LLENE LOS DATOS", "AVISO", JOptionPane.ERROR_MESSAGE);	
						}else {
						try {
						boolean res = new AlumnoDAO().modificarAlumno(new Alumno(caja_numControl3.getText(), caja_nombre3.getText(), caja_apPaterno3.getText(), caja_apMaterno3.getText(), Byte.parseByte("20"), comboListaSemestre3.getSelectedIndex(), String.valueOf(comboBox_carrera3.getSelectedIndex())));
						JOptionPane.showMessageDialog(getParent(), "SE GUARDARON LOS CAMBIOS");
						} catch (Exception e2) {
						JOptionPane.showMessageDialog(getParent(), "LLENE LOS DATOS", "AVISO", JOptionPane.ERROR_MESSAGE);	
						}
					}
						
					}
				});
				botonCancelar3 = new JButton("CANCELAR"); 
				botonCancelar3.setBounds(490, 300, 150, 30);
				botonCancelar3.setBackground(Color.white);
				IF_Cambios.add(botonCancelar3);
				
				IF_Consultas = new JInternalFrame();
				IF_Consultas.getContentPane().setLayout(null);
				IF_Consultas.setDefaultCloseOperation(HIDE_ON_CLOSE);
				IF_Consultas.setTitle("Consultas");
				IF_Consultas.setSize(700, 550);
				IF_Consultas.setMaximizable(true);
				IF_Consultas.setIconifiable(true);
				IF_Consultas.setClosable(true);
				IF_Consultas.setResizable(true);
				IF_Consultas.setLayout(null);
				
				//Cuarta INTERFACE
				label_txt3 = new JLabel("CONSULTAS ALUMNOS");
				label_txt3.setFont(new Font("Helvetica", Font.PLAIN, 30));
				label_txt3.setForeground(Color.white);
				label_txt3.setBounds(60, 0, 684, 60);
				IF_Consultas.add(label_txt3); 
				label_fondo3 = new JLabel(); 
				label_fondo3.setBounds(0, 0, 684, 60); 
				label_fondo3.setBackground(Color.blue);
				label_fondo3.setOpaque(true);
				IF_Consultas.add(label_fondo3);
				
				JRadioButton botonRadioTodos, botonNombre, botonAp1, botonAp2, botonSem, botonCarr; 
				JComboBox<String> comboBoxSemestre4, comboBoxCarrera4; 
				
				JLabel seleccion = new JLabel("Seleccione Criterio de Busqueda");
				seleccion.setBounds(60, 60, 500, 30);
				IF_Consultas.add(seleccion);
				
				botonRadioTodos = new JRadioButton("TODOS"); 
				botonRadioTodos.setBounds(60, 120, 80, 30);
				IF_Consultas.add(botonRadioTodos); 
				
				botonNombre = new JRadioButton("NOMBRE:"); 
				botonNombre.setBounds(200, 120, 80, 30);
				IF_Consultas.add(botonNombre); 
				
				JTextField txtNombre = new JTextField(); 
				txtNombre.setBounds(350, 120, 120, 30);
				IF_Consultas.add(txtNombre); 
				
				botonAp1 = new JRadioButton("APELLIDO PATERNO:"); 
				botonAp1.setBounds(200, 160, 150, 30);
				IF_Consultas.add(botonAp1); 
				
				JTextField txtAp1 = new JTextField(); 
				txtAp1.setBounds(350, 160, 120, 30);
				IF_Consultas.add(txtAp1); 
				
				botonAp2 = new JRadioButton("APELLIDO MATERNO:"); 
				botonAp2.setBounds(200, 210, 150, 30);
				IF_Consultas.add(botonAp2); 
				
				JTextField txtAp2 = new JTextField(); 
				txtAp2.setBounds(350, 210, 120, 30);
				IF_Consultas.add(txtAp2); 
				
				botonSem= new JRadioButton("SEMESTRE:"); 
				botonSem.setBounds(200, 260, 150, 30);
				IF_Consultas.add(botonSem); 
				
				String semestre4 [] = {"Elija Semestre...","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
				comboBoxSemestre4 = new JComboBox<>(semestre4);
				comboBoxSemestre4.setBounds(350, 260, 150, 30);
				IF_Consultas.add(comboBoxSemestre4); 
				
				botonCarr = new JRadioButton("CARRERA:"); 
				botonCarr.setBounds(200, 310, 150, 30);
				IF_Consultas.add(botonCarr); 
				
				String carr4 [] = {"Elige Carrera...","I.S.C", "I.I.A", "I.M", "L.A", "C.P"};
				comboBoxCarrera4 = new JComboBox<>(carr4);
				comboBoxCarrera4.setBounds(350, 310, 150, 30);
				IF_Consultas.add(comboBoxCarrera4); 
				
				JButton botonLupa4 = new JButton(); 
				botonLupa4.setBounds(530, 135, 100, 40);
				imagen = new ImageIcon("icono/lupa.png");
				icono = new ImageIcon(imagen.getImage().getScaledInstance(botonLupa4.getWidth(), botonLupa4.getHeight(), Image.SCALE_DEFAULT));
				botonLupa4.setIcon(icono);
				IF_Consultas.add(botonLupa4);
				
				JButton canc = new JButton("CANCELAR");
				canc.setBounds(530, 280, 100, 40);
				IF_Consultas.add(canc); 
	
				JButton canc1 = new JButton("BORRAR");
				canc1.setBounds(530, 200, 100, 40);
				IF_Consultas.add(canc1);
	
				desktopPane.add(IF_Altas); // agregar InternalFrame al DesktopPane
				desktopPane.add(IF_Bajas); 
				desktopPane.add(IF_Cambios); 
				desktopPane.add(IF_Consultas);
				add(desktopPane, BorderLayout.CENTER); //agreagr desktopPane al JFrame principal
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VenInicio();
			}
		});
	}//main
}//class