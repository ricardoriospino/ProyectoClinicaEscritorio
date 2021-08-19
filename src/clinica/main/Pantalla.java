package clinica.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import clinica.arreglos.ArregloAtencion;
import clinica.arreglos.ArregloCamas;
import clinica.arreglos.ArregloDetalleAtencion;
import clinica.arreglos.ArregloInternamiento;
import clinica.arreglos.ArregloMedicinas;
import clinica.arreglos.ArregloPacientes;
import clinica.common.Utilitario;
import clinica.common.Validaciones;

public class Pantalla extends JApplet implements ActionListener { 
	
	

	

    // Ancho de textfield y botones
	int anchoTxtBtn = 130;
	int altoTxtBtn = 35;
	int anchoApplet = 1400, largoApplet = 1000;
	
	// contador de logeo
	int contadorFallosLogueo=0;
	
	//--------------cbo-----------
	
	String Categoria0 = "Basico";
	String Categoria1 = "Estandar";
	String Categoria2 = "Primium";
	
	//-------------cbo--------------
	
	String Listado0 = "Listado de pacientes internados";
	String Listado1 = "Listado de internamientos pagados";
	String Listado2 = "Listado de atenciones pagadas";
	String Listado3 = "Detalle de atención";
			
    // Para el panel de Logeo
    JPanel pnlLogeo, pnlInteriorLogeo;
    JLabel lblUsuario, lblPassword;
    JTextField txtUsuario;
    JPasswordField pwfPassword;
    JButton btnLogear,btnBorrarLogeo;
   
    // Para el panel del menu principal
	
	JPanel pnlMenuPrincipal, pnlInteriorMenuPrincipal;
	JButton btnMantenimiento, btnInternamiento, btnAtencion, btnPagos,btnReportes, btnSalir;
	
    // Para el panel del menu mantenimiento
	
	JPanel pnlMenuMantenimiento, pnlInteriorMenuMantenimiento;
	JButton btnMenuMantenimientoCamas,
			btnMenuMantenimientoMedicinas,
			btnMenuMantenimientoPacientes,
			btnMenuMantenimientoSalir;
	
    //Para el mantenimiento de camas 
	JPanel pnlMenuMantenimientoCamas, pnlInteriorMantenimientoCamas;
	JLabel lblMantenimientoNumeroCama,lblMantenimientoCategoriaCama,lblMantenimientoEstado;
	JButton btnMantenimientoBuscar, btnMantenimientoNuevo,btnMantenimientoIngresar,btnMantenimientoModificar,btnMantenimientoListar,
	btnMantenimientoEliminar,btnMantenimientoCamaVolver;
	JTextField txtMantenimientoNumeroCama;
	JComboBox cboMantenimientoCategoriaCama;
	JRadioButton rbnMantenimientoLibre, rbnMantenimientoOcupado;
	JTextArea txtSalidaCamas;
	JScrollPane scpScrollC;
	JTable tblMantenimientoCamas;
	DefaultTableModel dtmMantenimientoCamas;
	
    //Para el mantenimiento de Medicinas
	
	JPanel pnlMenuMantenimientoMedicinas, pnlInteriorMantenimientoMedicinas;
	JLabel lblMantenimientoCodigoMedicinas,lblMantenimientoNombreMedicina,lblMantenimientoNombreLaboratorio,
	lblMantenimientoPrecioMedicina,lblMantenimientoStockMedicina;
	JButton btnMantenimientoBuscarMedicinas,btnMantenimientoListarMedicina,btnMantenimientoNuevoMedicina,btnMantenimientoAdicionarMedicina,
	btnMantenimientoModificarMedicina,btnMantenimientoEliminarMedicina,btnMantenimientoMedicinaVolver;
	JTextField txtMantenimientoCodigoMedicinas,txtMantenimientoNombreMedicina,txtMantenimientoNombreLaboratorio,
	txtMantenimientoPrecioMedicina,txtMantenimientoStockMedicina;
	JTextArea txtSalidaMedicinas;
	JScrollPane scpScrollM;
	JTable tblMantenimientoMedicinas;
	DefaultTableModel dtmMantenimientoMedicinas;
	
    //Para el mantenimiento de Pacientes
	
	JPanel pnlMenuMantenimientoPacientes,pnlInteriorMantenimientoPacientes;
	JLabel lblMantenimientoCodigoPacientes, lblMantenimientoNombrePacientes,lblMantenimientoApellidosPacientes,
	lblMantenimientoDniPacientes,lblMantenimientoTelefonoPacientes;
	JButton btnMantenimientoBuscarPacientes,btnMantenimientoListarPaciente, btnMantenimientoNuevoPaciente,btnMantenimientoAdicionarPaciente,
	btnMantenimientoModificarPaciente,btnMantenimientoEliminarPaciente,btnMantenimientoPacienteVolver;
	JTextField txtMantenimientoCodigoPacientes,txtMantenimientoNombrePacientes,txtMantenimientoApellidosPacientes,
	txtMantenimientoDniPacientes,txtMantenimientoTelefonoPacientes;
	JTextArea txtSalidaPacientes;
	JScrollPane scpScrollP;
	JTable tblMantenimientoPacientes;
	DefaultTableModel dtmMantenimientoPacientes;
	
	//Para el internamiento
	JPanel pnlInternamiento,pnlInteriorInternamiento;
	JLabel lblCodigoInternamiento,lblnombrePacienteInternamiento,lblapellidosPacientesInternamiento, lblDniPaciente,lblCategoriaCamaInternamiento;
	JTextField txtnombrePacienteInternamiento,txtapellidosPacienteInternamiento,txtCodigoInternamiento,txtDniPaciente;
	JComboBox cboCategoriaCamaInternamiento;
	JButton btnBuscarCodigoPaciente, btnGuardarInternamiento,btnInternamientoVolver;
	
	
	// Atencion de medicinas
	
	JPanel pnlAtencion,pnlInteriorAtencion;
	JLabel lblCodigoAtencion,lblCodigoDniPaciente,lblFechaAtencion,lblCodigoMedicinaAtencion,lblCantidadMedicinaAtencion,
	lblTotalPagoAtencion,lblNombrePacienteAtencion,lblApellidoPacienteAtencion,lblNombreMedicinaAtencion,lblPrecioMedicinaAtencion;
	JTextField txtCodigoAtencion,txtCodigoDniAtencion,txtFechaAtencion,txtCodigoMedicinaAtencion,txtCantidadMedicinaAtencion,
	txtTotalPagoAtencion,txtNombrePacienteAtencion,txtApellidoPacienteAtencion,txtNombreMedicinaAtencion,txtPrecioMedicinaAtencion;
	JButton btnBuscarDNIPacienteAtencion,btnBuscarCodigoMedicinaAtencion,btnAgregaTablaAtencion,btnRestaTablaAtencion,
	btnGuardarAtencion,btnAtencionVolver;
	JTextArea txtSalidaAtencion;
	JScrollPane scpScrollA;
	JTable tblAtencionPacientes;
	DefaultTableModel dtmAtencionPacientes;
	
	//Pagos
	
	JPanel pnlPagos,pnlInteriorPagos;
	JLabel lblDniPacientePagos,lblNombrePacientePago, lblSubTotalPagos,lblIGVPagos,lblTotalPagos;
	JTextField txtDniPacientePagos,txtNombrePacientePago, txtSubTotalPagos,txtIGVPagos,txtTotalPagos;
	JButton btnbuscarCodigo,btnFacturarPagos,btnImprimirPagos,btnPagosVolver;
	JTextArea txtSalidPagos;
	JScrollPane scpScrollPagos;
	JTable tblPagos;
	DefaultTableModel dtmPagos;
	
	//pagos1
	
	JPanel pnlPagos1,pnlInteriorPagos1;
	JLabel lblCodigoPacientePagos1;
	JButton btnFacturarPagos1,btnImprimirPagos1,btnPagosVolver1;
	JTextArea txtSalidPagos1;
	JScrollPane scpScrollPagos1;
		
	//Reportes
	JPanel pnlReportes,pnlInteriorReportes;
	JLabel lblTipoReportes,lblCodigoAtencionReportes;
	JButton btnBuscarReportes,btnReportesVolver;
	JTextField txtCodigoAtencionReportes;
	JComboBox cboTipoReportes;
	JTextArea txtSalidReportes;
	JScrollPane scpScrollReportes;
	JTable tblReportes;
	DefaultTableModel dtmReportes;
	
	//________________________________________________
	
	//Arreglos
	
	ArregloCamas aCamas = new ArregloCamas();
	ArregloMedicinas aMedicinas = new ArregloMedicinas();
	ArregloPacientes aPacientes = new ArregloPacientes();
	ArregloInternamiento aInternamiento = new ArregloInternamiento();
	ArregloAtencion aAtencion = new ArregloAtencion();
	ArregloDetalleAtencion aDetalleAtencion  = new ArregloDetalleAtencion();
	Utilitario utilitario = new Utilitario();
	Validaciones v = new Validaciones();

   
	 // Crea la interfaz grafica de usuario
	 // Procedimientos para construccion de Panel
	 // Panel Logeo
    public void construirPanelLogeo() {
    	
   
   
    pnlLogeo = new JPanel();
	pnlLogeo.setLayout(null);
	pnlLogeo.setBounds(0, 0, anchoApplet, largoApplet);

	pnlInteriorLogeo = new JPanel();
	pnlInteriorLogeo.setLayout(null);
	pnlInteriorLogeo.setBounds(280, 130, 250, 250);
	
	TitledBorder title = BorderFactory.createTitledBorder(" CLINICA R&R ");
	title.setTitleJustification(TitledBorder.CENTER);
	Font font = new Font("Serif", Font.BOLD, 25);
	title.setTitleFont(font);
	
	//pnlInteriorLogeo.setIcon(icono);
	pnlInteriorLogeo.setBorder(title);
	
	lblUsuario = new JLabel("Usuario:");
	lblUsuario.setBounds(45, 65, 60, 25);
	lblUsuario.setForeground(Color.RED);
	lblUsuario.setFont(new Font ("Comic Sans MS",Font.ROMAN_BASELINE, 13));
	pnlInteriorLogeo.add(lblUsuario);

	lblPassword = new JLabel("Password:");
	lblPassword.setBounds(35, 85 + altoTxtBtn,80, 25);
	lblPassword.setForeground(Color.RED);
	lblPassword.setFont(new Font ("Comic Sans MS",Font.ROMAN_BASELINE, 13));
	pnlInteriorLogeo.add(lblPassword);

	txtUsuario = new JTextField();
	//txtUsuario.setText("admin");
	txtUsuario.setBounds(100, 65, anchoTxtBtn, altoTxtBtn);
	txtUsuario.setToolTipText("Ingrese su Usuario");
	pnlInteriorLogeo.add(txtUsuario);

	pwfPassword = new JPasswordField();
	//pwfPassword.setText("123");
	pwfPassword.setBounds(100, 85 + altoTxtBtn, anchoTxtBtn, altoTxtBtn);
	pwfPassword.setToolTipText("Ingrese su Clave");
	pnlInteriorLogeo.add(pwfPassword);

	btnLogear = new JButton("Entrar");
	btnLogear.addActionListener(this);
	btnLogear.setBounds(60, 145 + altoTxtBtn, anchoTxtBtn, altoTxtBtn);
	pnlInteriorLogeo.add(btnLogear);
	
	pnlLogeo.add(pnlInteriorLogeo);
	add(pnlLogeo);
	pnlLogeo.setVisible(true);
	
   }
   
    // Panel menu principal
    public void construirPanelMenuPrincipal() {
   	
    pnlMenuPrincipal = new JPanel();
	pnlMenuPrincipal.setLayout(null);
	pnlMenuPrincipal.setBounds(0, 0, anchoApplet, largoApplet);

	pnlInteriorMenuPrincipal = new JPanel();
	pnlInteriorMenuPrincipal.setLayout(null);
	pnlInteriorMenuPrincipal.setBounds(220, 70, 350, 400);
	
	Icon icono = new ImageIcon("imagenes/mantenimiento.png");
	Icon icono1 = new ImageIcon("imagenes/configuracion.png");
	Icon icono2 = new ImageIcon("imagenes/ventas.png");
	Icon icono3 = new ImageIcon("imagenes/reporte.png");
	Icon icono4 = new ImageIcon("imagenes/volver.png");
	
	TitledBorder title = BorderFactory.createTitledBorder("MENU PRINCIPAL");
	title.setTitleJustification(TitledBorder.CENTER);
	Font font = new Font("Serif", Font.BOLD, 25);
	title.setTitleFont(font);
	pnlInteriorMenuPrincipal.setBorder(title);

	btnMantenimiento = new JButton("Mantenimiento");
    btnMantenimiento.addActionListener(this);
	btnMantenimiento.setBounds(80, 90, 180, altoTxtBtn);
	btnMantenimiento.setIcon(icono);
	pnlInteriorMenuPrincipal.add(btnMantenimiento);

	btnInternamiento = new JButton("Internamiento");
	btnInternamiento.addActionListener(this);
	btnInternamiento.setBounds(80, 140, 180, altoTxtBtn);
	btnInternamiento.setIcon(icono2);
	pnlInteriorMenuPrincipal.add(btnInternamiento);

	btnAtencion = new JButton("Atencion");
	btnAtencion.addActionListener(this);
	btnAtencion.setBounds(80, 190, 180, altoTxtBtn);
	btnAtencion.setIcon(icono1);
	pnlInteriorMenuPrincipal.add(btnAtencion);
	
	btnPagos = new JButton("Pagos");
	
	btnPagos.addActionListener(this);
	btnPagos.setBounds(80, 240, 180, altoTxtBtn);
	btnPagos.setIcon(icono1);
	pnlInteriorMenuPrincipal.add(btnPagos);
	
	btnReportes = new JButton("Reportes");
	btnReportes.addActionListener(this);
	btnReportes.setBounds(80, 290, 180, altoTxtBtn);
	btnReportes.setIcon(icono3);
	pnlInteriorMenuPrincipal.add(btnReportes);

	btnSalir = new JButton("Volver");
	btnSalir.addActionListener(this);
	btnSalir.setBounds(80, 340, 180, altoTxtBtn);
	btnSalir.setIcon(icono4);
	pnlInteriorMenuPrincipal.add(btnSalir);

	pnlMenuPrincipal.add(pnlInteriorMenuPrincipal);
	add(pnlMenuPrincipal);
	pnlMenuPrincipal.setVisible(false);
	}
   
    // Panel menu principal mantenimiento
    public void construirPanelMenuMantenimiento() {
   	
    pnlMenuMantenimiento = new JPanel();
	pnlMenuMantenimiento.setLayout(null);
	pnlMenuMantenimiento.setBounds(0, 0, anchoApplet, largoApplet);

	pnlInteriorMenuMantenimiento = new JPanel();
	pnlInteriorMenuMantenimiento.setLayout(null);
	pnlInteriorMenuMantenimiento.setBounds(220, 70, 350, 400);

	TitledBorder title = BorderFactory.createTitledBorder("MANTENIMIENTO");
	title.setTitleJustification(TitledBorder.CENTER);
	Font font = new Font("Serif", Font.ITALIC, 25);
	title.setTitleFont(font);
	pnlInteriorMenuMantenimiento.setBorder(title);

	btnMenuMantenimientoCamas = new JButton("Mantenimiento Camas");
	btnMenuMantenimientoCamas.addActionListener(this);
	btnMenuMantenimientoCamas.setBounds(80, 90, 180, altoTxtBtn);
	pnlInteriorMenuMantenimiento.add(btnMenuMantenimientoCamas);

	btnMenuMantenimientoMedicinas = new JButton("Mantenimiento Medicinas");
	btnMenuMantenimientoMedicinas.addActionListener(this);
	btnMenuMantenimientoMedicinas.setBounds(80, 140, 180,altoTxtBtn);
	pnlInteriorMenuMantenimiento.add(btnMenuMantenimientoMedicinas);

	btnMenuMantenimientoPacientes = new JButton("Mantenimiento Pacientes");
	btnMenuMantenimientoPacientes.addActionListener(this);
	btnMenuMantenimientoPacientes.setBounds(80, 190, 180, altoTxtBtn);
	pnlInteriorMenuMantenimiento.add(btnMenuMantenimientoPacientes);

	btnMenuMantenimientoSalir = new JButton("Volver");
	btnMenuMantenimientoSalir.addActionListener(this);
	btnMenuMantenimientoSalir.setBounds(80, 240, 180, altoTxtBtn);
	pnlInteriorMenuMantenimiento.add(btnMenuMantenimientoSalir);
    pnlMenuMantenimiento.add(pnlInteriorMenuMantenimiento);

	add(pnlMenuMantenimiento);
	pnlMenuMantenimiento.setVisible(false);
		
	}
   
    //Panel para el mantenimiento de camas 
   
    public void construirPanelMantenimientoCamas() {
	   
	pnlMenuMantenimientoCamas = new JPanel();
	pnlMenuMantenimientoCamas.setLayout(null);
	pnlMenuMantenimientoCamas.setBounds(0, 0, anchoApplet, largoApplet);

	pnlInteriorMantenimientoCamas = new JPanel();
	pnlInteriorMantenimientoCamas.setLayout(null);
	pnlInteriorMantenimientoCamas.setBounds(70, 40, 600, 450);
		
	TitledBorder title = BorderFactory.createTitledBorder("MANTENIMIENTO CAMAS");
	title.setTitleJustification(TitledBorder.CENTER);
	Font font = new Font("Serif", Font.BOLD, 25);
	title.setTitleFont(font);
	pnlInteriorMantenimientoCamas.setBorder(title);
	
	lblMantenimientoNumeroCama = new JLabel("Numero de Cama:");
	lblMantenimientoNumeroCama.setBounds(90, 50, 150, 30);
	pnlInteriorMantenimientoCamas.add(lblMantenimientoNumeroCama);
	
	lblMantenimientoCategoriaCama = new JLabel("Categoria de Cama:");
	lblMantenimientoCategoriaCama.setBounds(90, 80, 150, 30);
	pnlInteriorMantenimientoCamas.add(lblMantenimientoCategoriaCama);
	
	lblMantenimientoEstado= new JLabel("Estado de Cama:");
	lblMantenimientoEstado.setBounds(90, 110, 150, 30);
	pnlInteriorMantenimientoCamas.add( lblMantenimientoEstado);
	
	txtMantenimientoNumeroCama = new JTextField();
	txtMantenimientoNumeroCama.setBounds(210, 55, 100, 20);
	pnlInteriorMantenimientoCamas.add(txtMantenimientoNumeroCama);
	v.validarSoloNumeros(txtMantenimientoNumeroCama);
	
	
	pnlMenuMantenimientoCamas.add(pnlInteriorMantenimientoCamas);
	add(pnlMenuMantenimientoCamas);
	pnlMenuMantenimientoCamas.setVisible(false);
	
	cboMantenimientoCategoriaCama = new JComboBox();
	cboMantenimientoCategoriaCama.setBounds(210, 85, 100, 20);
	cboMantenimientoCategoriaCama.addItem(Categoria0);
	cboMantenimientoCategoriaCama.addItem(Categoria1);
	cboMantenimientoCategoriaCama.addItem(Categoria2);
	getContentPane().add(cboMantenimientoCategoriaCama);
	pnlInteriorMantenimientoCamas.add(cboMantenimientoCategoriaCama);
	
	rbnMantenimientoLibre =  new JRadioButton("Libre");
	rbnMantenimientoLibre.getText();
	rbnMantenimientoLibre.setBounds(200,110,90,23);
	pnlInteriorMantenimientoCamas.add(rbnMantenimientoLibre);
	
	rbnMantenimientoOcupado =  new JRadioButton("Ocupado");		
	rbnMantenimientoOcupado.setBounds(300, 110, 90, 23);
	pnlInteriorMantenimientoCamas.add(rbnMantenimientoOcupado);
	
	ButtonGroup regaloButtonGroup = new ButtonGroup();
	regaloButtonGroup.add(rbnMantenimientoLibre);
	regaloButtonGroup.add(rbnMantenimientoOcupado);
	
	btnMantenimientoBuscar = new JButton("Buscar");
	btnMantenimientoBuscar.addActionListener(this);
	btnMantenimientoBuscar.setBounds(320, 55, 100, 20);
	pnlInteriorMantenimientoCamas.add(btnMantenimientoBuscar);
	
	btnMantenimientoNuevo = new JButton("nuevo");
	btnMantenimientoNuevo.addActionListener(this);
	btnMantenimientoNuevo.setBounds(480, 30, 100, 20);
	pnlInteriorMantenimientoCamas.add(btnMantenimientoNuevo);
	
	btnMantenimientoIngresar = new JButton("Ingresar");
	btnMantenimientoIngresar.addActionListener(this);
	btnMantenimientoIngresar.setBounds(480, 55, 100, 20);
	pnlInteriorMantenimientoCamas.add(btnMantenimientoIngresar);
	
	btnMantenimientoModificar = new JButton("Modificar");
	btnMantenimientoModificar.addActionListener(this);
	btnMantenimientoModificar.setEnabled(false);
	btnMantenimientoModificar.setBounds(480, 80, 100, 20);
	pnlInteriorMantenimientoCamas.add(btnMantenimientoModificar);
	
	btnMantenimientoListar = new JButton("Listar");
	btnMantenimientoListar.addActionListener(this);
	btnMantenimientoListar.setBounds(480, 105, 100, 20);
	pnlInteriorMantenimientoCamas.add(btnMantenimientoListar);
	
	btnMantenimientoEliminar = new JButton("Eliminar");
	btnMantenimientoEliminar.addActionListener(this);
	btnMantenimientoEliminar.setEnabled(false);
	btnMantenimientoEliminar.setBounds(480, 130, 100, 20);
	pnlInteriorMantenimientoCamas.add(btnMantenimientoEliminar);
	
	btnMantenimientoCamaVolver = new JButton("Volver");
	btnMantenimientoCamaVolver.addActionListener(this);
	btnMantenimientoCamaVolver.setBounds(480, 155, 100, 20);
	pnlInteriorMantenimientoCamas.add(btnMantenimientoCamaVolver);
	
	txtSalidaCamas= new JTextArea();
	
	Object[] columnas = new Object[] {"Numero","Categoria", "Estado"};
	dtmMantenimientoCamas = new DefaultTableModel (columnas,0);
	tblMantenimientoCamas = new JTable(dtmMantenimientoCamas);
	tblMantenimientoCamas.setEnabled(true);
	scpScrollC = new JScrollPane(tblMantenimientoCamas);
	scpScrollC.setBounds(60, 185, 520, 250);
	pnlInteriorMantenimientoCamas.add(scpScrollC);
	
	pnlMenuMantenimientoCamas.add(pnlInteriorMantenimientoCamas);
	add(pnlMenuMantenimientoCamas);
	pnlMenuMantenimientoCamas.setVisible(false);
	   
	   
   }
   
    //Panel para el mantenimiento de Medicinas
   
    public void construirPanelMantenimientoMedicinas() {
	   
	pnlMenuMantenimientoMedicinas = new JPanel();
	pnlMenuMantenimientoMedicinas.setLayout(null);
	pnlMenuMantenimientoMedicinas.setBounds(0, 0, anchoApplet, largoApplet);

	pnlInteriorMantenimientoMedicinas = new JPanel();
	pnlInteriorMantenimientoMedicinas.setLayout(null);
	pnlInteriorMantenimientoMedicinas.setBounds(70, 40, 600, 500);
  		
  	TitledBorder title = BorderFactory.createTitledBorder("MANTENIMIENTO MEDICINAS");
	title.setTitleJustification(TitledBorder.CENTER);
	Font font = new Font("Serif", Font.BOLD, 25);
	title.setTitleFont(font);
	pnlInteriorMantenimientoMedicinas.setBorder(title);
		
	lblMantenimientoCodigoMedicinas = new JLabel("Codigo:");
	lblMantenimientoCodigoMedicinas.setBounds(90, 50, 150, 30);
	pnlInteriorMantenimientoMedicinas.add(lblMantenimientoCodigoMedicinas);
	
	lblMantenimientoNombreMedicina = new JLabel("Nombres:");
	lblMantenimientoNombreMedicina.setBounds(90, 80, 150, 30);
	pnlInteriorMantenimientoMedicinas.add(lblMantenimientoNombreMedicina);
	
	lblMantenimientoNombreLaboratorio= new JLabel("Laboratorio:");
	lblMantenimientoNombreLaboratorio.setBounds(90, 110, 150, 30);
	pnlInteriorMantenimientoMedicinas.add( lblMantenimientoNombreLaboratorio);
	
	lblMantenimientoPrecioMedicina = new JLabel("Precio:");
	lblMantenimientoPrecioMedicina.setBounds(90, 140, 150, 30);
	pnlInteriorMantenimientoMedicinas.add(lblMantenimientoPrecioMedicina);
	
	lblMantenimientoStockMedicina= new JLabel("Stock:");
	lblMantenimientoStockMedicina.setBounds(90, 170, 150, 30);
	pnlInteriorMantenimientoMedicinas.add( lblMantenimientoStockMedicina);
	
	txtMantenimientoCodigoMedicinas = new JTextField();
	txtMantenimientoCodigoMedicinas.setBounds(210, 55, 100, 20);
	pnlInteriorMantenimientoMedicinas.add(txtMantenimientoCodigoMedicinas);
	v.validarSoloNumeros(txtMantenimientoCodigoMedicinas);
	
	txtMantenimientoNombreMedicina = new JTextField();
	txtMantenimientoNombreMedicina.setBounds(210, 85, 100, 20);
	pnlInteriorMantenimientoMedicinas.add(txtMantenimientoNombreMedicina);
	v.validarSoloLetras(txtMantenimientoNombreMedicina);
	
	txtMantenimientoNombreLaboratorio = new JTextField();
	txtMantenimientoNombreLaboratorio.setBounds(210, 115, 100, 20);
	pnlInteriorMantenimientoMedicinas.add(txtMantenimientoNombreLaboratorio);
	v.validarSoloLetras(txtMantenimientoNombreLaboratorio);
	
	txtMantenimientoPrecioMedicina = new JTextField();
	txtMantenimientoPrecioMedicina.setBounds(210, 145, 100, 20);
	pnlInteriorMantenimientoMedicinas.add(txtMantenimientoPrecioMedicina);
	v.validarSoloNumeros(txtMantenimientoPrecioMedicina);
	
	txtMantenimientoStockMedicina = new JTextField();
	txtMantenimientoStockMedicina.setBounds(210,175 , 100, 20);
	pnlInteriorMantenimientoMedicinas.add(txtMantenimientoStockMedicina);
	v.validarSoloNumeros(txtMantenimientoStockMedicina);
	
	btnMantenimientoBuscarMedicinas = new JButton("Buscar");
	btnMantenimientoBuscarMedicinas.addActionListener(this);
	btnMantenimientoBuscarMedicinas.setBounds(320, 55, 100, 20);
	pnlInteriorMantenimientoMedicinas.add(btnMantenimientoBuscarMedicinas);
	
	btnMantenimientoNuevoMedicina = new JButton("Nuevo");
	btnMantenimientoNuevoMedicina.addActionListener(this);
	btnMantenimientoNuevoMedicina.setBounds(480, 55, 100, 20);
	pnlInteriorMantenimientoMedicinas.add(btnMantenimientoNuevoMedicina);
	
	btnMantenimientoAdicionarMedicina = new JButton("Adicionar");
	btnMantenimientoAdicionarMedicina.addActionListener(this);
	btnMantenimientoAdicionarMedicina.setBounds(480, 80, 100, 20);
	pnlInteriorMantenimientoMedicinas.add(btnMantenimientoAdicionarMedicina);
	
	btnMantenimientoModificarMedicina = new JButton("Modificar");
	btnMantenimientoModificarMedicina.addActionListener(this);
	btnMantenimientoModificarMedicina.setEnabled(false);
	btnMantenimientoModificarMedicina.setBounds(480, 105, 100, 20);
	pnlInteriorMantenimientoMedicinas.add(btnMantenimientoModificarMedicina);
	
	btnMantenimientoListarMedicina = new JButton("Listar");
	btnMantenimientoListarMedicina.addActionListener(this);
	btnMantenimientoListarMedicina.setBounds(480, 130, 100, 20);
	pnlInteriorMantenimientoMedicinas.add(btnMantenimientoListarMedicina);
	
	
	btnMantenimientoEliminarMedicina = new JButton("Eliminar");
	btnMantenimientoEliminarMedicina.addActionListener(this);
	btnMantenimientoEliminarMedicina.setEnabled(false);
	btnMantenimientoEliminarMedicina.setBounds(480, 155, 100, 20);
	pnlInteriorMantenimientoMedicinas.add(btnMantenimientoEliminarMedicina);
	
	btnMantenimientoMedicinaVolver = new JButton("Volver");
	btnMantenimientoMedicinaVolver.addActionListener(this);
	btnMantenimientoMedicinaVolver.setBounds(480, 180, 100, 20);
	pnlInteriorMantenimientoMedicinas.add(btnMantenimientoMedicinaVolver);
	
	txtSalidaMedicinas= new JTextArea();
	
	Object[] columnas = new Object[] {"Codigo","Nombre", "Laboratorio","Precio","Stock"};
	dtmMantenimientoMedicinas = new DefaultTableModel (columnas,0);
	tblMantenimientoMedicinas = new JTable(dtmMantenimientoMedicinas);
	tblMantenimientoMedicinas.setEnabled(true);
	scpScrollM = new JScrollPane(tblMantenimientoMedicinas);
	scpScrollM.setBounds(60, 200, 520, 250);
	pnlInteriorMantenimientoMedicinas.add(scpScrollM);
	
	pnlMenuMantenimientoMedicinas.add(pnlInteriorMantenimientoMedicinas);
	add(pnlMenuMantenimientoMedicinas);
	pnlMenuMantenimientoMedicinas.setVisible(false);
	
	
   }	
   //Panel para el mantenimiento de Medicinas
   
   public void construirPanelMantenimientoPacientes() {
	   
	pnlMenuMantenimientoPacientes = new JPanel();
	pnlMenuMantenimientoPacientes.setLayout(null);
	pnlMenuMantenimientoPacientes.setBounds(0, 0, anchoApplet, largoApplet);

	pnlInteriorMantenimientoPacientes = new JPanel();
	pnlInteriorMantenimientoPacientes.setLayout(null);
	pnlInteriorMantenimientoPacientes.setBounds(70, 40, 600, 500);
  		
  	TitledBorder title = BorderFactory.createTitledBorder("MANTENIMIENTO PACIENTES");
	title.setTitleJustification(TitledBorder.CENTER);
	Font font = new Font("Serif", Font.BOLD, 25);
	title.setTitleFont(font);
	pnlInteriorMantenimientoPacientes.setBorder(title);
		
	lblMantenimientoCodigoPacientes = new JLabel("Codigo:");
	lblMantenimientoCodigoPacientes.setBounds(90, 50, 150, 30);
	pnlInteriorMantenimientoPacientes.add(lblMantenimientoCodigoPacientes);
	
	lblMantenimientoNombrePacientes = new JLabel("Nombres:");
	lblMantenimientoNombrePacientes.setBounds(90, 80, 150, 30);
	pnlInteriorMantenimientoPacientes.add(lblMantenimientoNombrePacientes);
	
	lblMantenimientoApellidosPacientes= new JLabel("Apellidos:");
	lblMantenimientoApellidosPacientes.setBounds(90, 110, 150, 30);
	pnlInteriorMantenimientoPacientes.add( lblMantenimientoApellidosPacientes);
	
	lblMantenimientoDniPacientes = new JLabel("DNI:");
	lblMantenimientoDniPacientes.setBounds(90, 140, 150, 30);
	pnlInteriorMantenimientoPacientes.add(lblMantenimientoDniPacientes);
	
	lblMantenimientoTelefonoPacientes= new JLabel("Telefono:");
	lblMantenimientoTelefonoPacientes.setBounds(90, 170, 150, 30);
	pnlInteriorMantenimientoPacientes.add( lblMantenimientoTelefonoPacientes);
	
	txtMantenimientoCodigoPacientes= new JTextField();
	txtMantenimientoCodigoPacientes.setBounds(210, 55, 100, 20);
	pnlInteriorMantenimientoPacientes.add(txtMantenimientoCodigoPacientes);
	v.validarSoloNumeros(txtMantenimientoCodigoPacientes);
	
	txtMantenimientoNombrePacientes = new JTextField();
	txtMantenimientoNombrePacientes.setBounds(210, 85, 100, 20);
	pnlInteriorMantenimientoPacientes.add(txtMantenimientoNombrePacientes);
	v.validarSoloLetras(txtMantenimientoNombrePacientes);
	
	
	txtMantenimientoApellidosPacientes = new JTextField();
	txtMantenimientoApellidosPacientes.setBounds(210, 115, 100, 20);
	pnlInteriorMantenimientoPacientes.add(txtMantenimientoApellidosPacientes);
	v.validarSoloLetras(txtMantenimientoApellidosPacientes);
	
	txtMantenimientoDniPacientes = new JTextField();
	txtMantenimientoDniPacientes.setBounds(210, 145, 100, 20);
	pnlInteriorMantenimientoPacientes.add(txtMantenimientoDniPacientes);
	v.validarSoloNumeros(txtMantenimientoDniPacientes);
	v.limitarCaracteres(txtMantenimientoDniPacientes, 8);
	
	txtMantenimientoTelefonoPacientes = new JTextField();
	txtMantenimientoTelefonoPacientes.setBounds(210,175 , 100, 20);
	pnlInteriorMantenimientoPacientes.add(txtMantenimientoTelefonoPacientes);
	v.validarSoloNumeros(txtMantenimientoTelefonoPacientes);
	v.limitarCaracteres(txtMantenimientoTelefonoPacientes, 7);
	
	btnMantenimientoBuscarPacientes = new JButton("Buscar");
	btnMantenimientoBuscarPacientes.addActionListener(this);
	btnMantenimientoBuscarPacientes.setBounds(320, 55, 100, 20);
	pnlInteriorMantenimientoPacientes.add(btnMantenimientoBuscarPacientes);
	
	btnMantenimientoNuevoPaciente = new JButton("Nuevo");
	btnMantenimientoNuevoPaciente.addActionListener(this);
	btnMantenimientoNuevoPaciente.setBounds(480, 55, 100, 20);
	pnlInteriorMantenimientoPacientes.add(btnMantenimientoNuevoPaciente);
	
	btnMantenimientoAdicionarPaciente = new JButton("Adicionar");
	btnMantenimientoAdicionarPaciente.addActionListener(this);
	btnMantenimientoAdicionarPaciente.setBounds(480, 80, 100, 20);
	pnlInteriorMantenimientoPacientes.add(btnMantenimientoAdicionarPaciente);
	
	btnMantenimientoModificarPaciente = new JButton("Modificar");
	btnMantenimientoModificarPaciente.addActionListener(this);
	btnMantenimientoModificarPaciente.setEnabled(false);
	btnMantenimientoModificarPaciente.setBounds(480, 105, 100, 20);
	pnlInteriorMantenimientoPacientes.add(btnMantenimientoModificarPaciente);
	
	btnMantenimientoListarPaciente = new JButton("Listar");
	btnMantenimientoListarPaciente.addActionListener(this);
	btnMantenimientoListarPaciente.setBounds(480, 130, 100, 20);
	pnlInteriorMantenimientoPacientes.add(btnMantenimientoListarPaciente);
	
	btnMantenimientoEliminarPaciente = new JButton("Eliminar");
	btnMantenimientoEliminarPaciente.addActionListener(this);
	btnMantenimientoEliminarPaciente.setEnabled(false);
	btnMantenimientoEliminarPaciente.setBounds(480, 155, 100, 20);
	pnlInteriorMantenimientoPacientes.add(btnMantenimientoEliminarPaciente);
	
	btnMantenimientoPacienteVolver = new JButton("Volver");
	btnMantenimientoPacienteVolver.addActionListener(this);
	btnMantenimientoPacienteVolver.setBounds(480, 180, 100, 20);
	pnlInteriorMantenimientoPacientes.add(btnMantenimientoPacienteVolver);
	
	txtSalidaPacientes= new JTextArea();
	
	Object[] columnas = new Object[] {"Codigo","Nombre", "Apellidos","DNI","Telefono"};
	dtmMantenimientoPacientes = new DefaultTableModel (columnas,0);
	tblMantenimientoPacientes = new JTable(dtmMantenimientoPacientes);
	tblMantenimientoPacientes.setEnabled(true);
	scpScrollP = new JScrollPane(tblMantenimientoPacientes);
	scpScrollP.setBounds(60, 200, 520, 250);
	pnlInteriorMantenimientoPacientes.add(scpScrollP);
	
	pnlMenuMantenimientoPacientes.add(pnlInteriorMantenimientoPacientes);
	add(pnlMenuMantenimientoPacientes);
	pnlMenuMantenimientoPacientes.setVisible(false);
	
   }
   
    //Panel para el Internamiento
   
    public void construirPanelInternamiento() {
	   
	pnlInternamiento = new JPanel();
	pnlInternamiento.setLayout(null);
	pnlInternamiento.setBounds(0, 0,800, 600);

   	pnlInteriorInternamiento = new JPanel();
   	pnlInteriorInternamiento.setLayout(null);
   	pnlInteriorInternamiento.setBounds(175, 50, 600, 300);
     		
    TitledBorder title = BorderFactory.createTitledBorder("INTERNAMIENTO");
    title.setTitleJustification(TitledBorder.CENTER);
  	Font font = new Font("Serif", Font.BOLD, 25);
  	title.setTitleFont(font);
  	pnlInteriorInternamiento.setBorder(title);
  	
  	lblCodigoInternamiento = new JLabel("Codigo Internamiento:");
  	lblCodigoInternamiento.setBounds(90, 50, 150, 30);
  	pnlInteriorInternamiento.add(lblCodigoInternamiento);
  	
  	lblnombrePacienteInternamiento = new JLabel("Nombre Paciente:");
  	lblnombrePacienteInternamiento.setBounds(90, 80, 150, 30);
  	pnlInteriorInternamiento.add(lblnombrePacienteInternamiento);
  	
  	lblapellidosPacientesInternamiento = new JLabel("Apellidos Pacientes:");
  	lblapellidosPacientesInternamiento.setBounds(90, 110, 150, 30);
  	pnlInteriorInternamiento.add(lblapellidosPacientesInternamiento);
  	
  	lblDniPaciente = new JLabel("DNI de Paciente:");
  	lblDniPaciente.setBounds(90, 140, 150, 30);
	pnlInteriorInternamiento.add(lblDniPaciente);
	
	lblCategoriaCamaInternamiento= new JLabel("Categoria de Cama:");
	lblCategoriaCamaInternamiento.setBounds(90, 170, 150, 30);
	pnlInteriorInternamiento.add( lblCategoriaCamaInternamiento);
	
	txtCodigoInternamiento= new JTextField();
	txtCodigoInternamiento.setBounds(220, 55, 100, 20);
	pnlInteriorInternamiento.add(txtCodigoInternamiento);
	
	
	txtnombrePacienteInternamiento= new JTextField();
	txtnombrePacienteInternamiento.setBounds(220, 85, 100, 20);
	txtnombrePacienteInternamiento.setEditable(false);
	pnlInteriorInternamiento.add(txtnombrePacienteInternamiento);
	
	
	txtapellidosPacienteInternamiento= new JTextField();
	txtapellidosPacienteInternamiento.setBounds(220, 115, 100, 20);
	txtapellidosPacienteInternamiento.setEditable(false);
	pnlInteriorInternamiento.add(txtapellidosPacienteInternamiento);
	
	
	txtDniPaciente = new JTextField();
	txtDniPaciente.setBounds(220, 145, 100, 20);
	pnlInteriorInternamiento.add(txtDniPaciente);
	v.limitarCaracteres(txtDniPaciente, 8);
	v.validarSoloNumeros(txtDniPaciente);

	
	cboCategoriaCamaInternamiento = new JComboBox();
	cboCategoriaCamaInternamiento.setBounds(220, 175, 100, 20);
	cboCategoriaCamaInternamiento.addItem(Categoria0);
	cboCategoriaCamaInternamiento.addItem(Categoria1);
	cboCategoriaCamaInternamiento.addItem(Categoria2);
	getContentPane().add(cboCategoriaCamaInternamiento);
	pnlInteriorInternamiento.add(cboCategoriaCamaInternamiento);
	
	btnBuscarCodigoPaciente = new JButton("Buscar");
	btnBuscarCodigoPaciente.addActionListener(this);
	btnBuscarCodigoPaciente.setBounds(330, 145, 80, 20);
	pnlInteriorInternamiento.add(btnBuscarCodigoPaciente);
	
	btnGuardarInternamiento = new JButton("Guardar");
	btnGuardarInternamiento.addActionListener(this);
	btnGuardarInternamiento.setBounds(220, 220, 100, 20);
	pnlInteriorInternamiento.add(btnGuardarInternamiento);
	
	btnInternamientoVolver = new JButton("Volver");
	btnInternamientoVolver.addActionListener(this);
	btnInternamientoVolver.setBounds(330, 220, 100, 20);
	pnlInteriorInternamiento.add(btnInternamientoVolver);
	
	pnlInternamiento.add(pnlInteriorInternamiento);
	add(pnlInternamiento);
	pnlInternamiento.setVisible(false);
	   
   }
   //Panel para la Atencion de medicinas
   
    public void construirPanelAtencionM() {
	   
	pnlAtencion = new JPanel();
	pnlAtencion.setLayout(null);
	pnlAtencion.setBounds(0, 0, anchoApplet, largoApplet);

	pnlInteriorAtencion = new JPanel();
	pnlInteriorAtencion.setLayout(null);
	pnlInteriorAtencion.setBounds(50, 30, 700, 550);
     		
    TitledBorder title = BorderFactory.createTitledBorder("ATENCION MEDICINAS");
    title.setTitleJustification(TitledBorder.CENTER);
  	Font font = new Font("Serif", Font.BOLD, 25);
  	title.setTitleFont(font);
  	pnlInteriorAtencion.setBorder(title);
  	
  	lblCodigoAtencion = new JLabel("Codigo de Atencion:");
  	lblCodigoAtencion.setBounds(90, 50, 150, 30);
	pnlInteriorAtencion.add(lblCodigoAtencion);
		
	lblNombrePacienteAtencion = new JLabel("Nombre:");
	lblNombrePacienteAtencion.setBounds(420, 50, 150, 30);
	pnlInteriorAtencion.add(lblNombrePacienteAtencion);
		
	lblApellidoPacienteAtencion = new JLabel("Apellido:");
	lblApellidoPacienteAtencion.setBounds(420, 80, 150, 30);
	pnlInteriorAtencion.add(lblApellidoPacienteAtencion);
		
	lblCodigoDniPaciente = new JLabel("DNI Paciente:");
	lblCodigoDniPaciente.setBounds(90, 80, 150, 30);
	pnlInteriorAtencion.add(lblCodigoDniPaciente);
	
	lblFechaAtencion= new JLabel("Fecha:");
	lblFechaAtencion.setBounds(90, 110, 150, 30);
	pnlInteriorAtencion.add( lblFechaAtencion);
	
	lblCodigoMedicinaAtencion = new JLabel("Codigo Medicina:");
	lblCodigoMedicinaAtencion.setBounds(90, 140, 150, 30);
	pnlInteriorAtencion.add(lblCodigoMedicinaAtencion);
		
	lblNombreMedicinaAtencion= new JLabel("Medicina Nombre:");
	lblNombreMedicinaAtencion.setBounds(90, 170, 150, 30);
	pnlInteriorAtencion.add(lblNombreMedicinaAtencion);
	
	lblCantidadMedicinaAtencion= new JLabel("Cantidad:");
	lblCantidadMedicinaAtencion.setBounds(420, 160, 150, 30);
	pnlInteriorAtencion.add( lblCantidadMedicinaAtencion);
	
	lblTotalPagoAtencion= new JLabel("Total a Pagar:");
	lblTotalPagoAtencion.setBounds(490, 440, 150, 30);
	pnlInteriorAtencion.add( lblTotalPagoAtencion);
	
	lblPrecioMedicinaAtencion= new JLabel("Precio :");
	lblPrecioMedicinaAtencion.setBounds(420, 130, 150, 30);
	pnlInteriorAtencion.add( lblPrecioMedicinaAtencion);
	
	txtCodigoAtencion= new JTextField();
	txtCodigoAtencion.setBounds(210, 55, 100, 20);
	txtCodigoAtencion.setEditable(false);
	pnlInteriorAtencion.add(txtCodigoAtencion);
	
	txtNombrePacienteAtencion= new JTextField();
	txtNombrePacienteAtencion.setBounds(500, 55, 100, 20);
	txtNombrePacienteAtencion.setEditable(false);
	pnlInteriorAtencion.add(txtNombrePacienteAtencion);
	v.validarSoloLetras(txtNombrePacienteAtencion);
	
	txtApellidoPacienteAtencion = new JTextField();
	txtApellidoPacienteAtencion.setBounds(500, 85, 100, 20);
	txtApellidoPacienteAtencion.setEditable(false);
	pnlInteriorAtencion.add(txtApellidoPacienteAtencion);
	
	
	txtPrecioMedicinaAtencion = new JTextField();
	txtPrecioMedicinaAtencion.setBounds(500, 135, 100, 20);
	txtPrecioMedicinaAtencion.setEditable(false);
	pnlInteriorAtencion.add(txtPrecioMedicinaAtencion);
	
	
	txtCodigoDniAtencion = new JTextField();
	txtCodigoDniAtencion.setBounds(210, 85, 100, 20);
	pnlInteriorAtencion.add(txtCodigoDniAtencion);
	
	txtFechaAtencion = new JTextField();
	txtFechaAtencion.setBounds(210, 115, 100, 20);
	pnlInteriorAtencion.add(txtFechaAtencion);
	
	txtCodigoMedicinaAtencion = new JTextField();
	txtCodigoMedicinaAtencion.setBounds(210, 145, 100, 20);
	txtCodigoMedicinaAtencion.setEditable(false);
	pnlInteriorAtencion.add(txtCodigoMedicinaAtencion);
	
	txtNombreMedicinaAtencion = new JTextField();
	txtNombreMedicinaAtencion.setBounds(210, 175, 100, 20);
	pnlInteriorAtencion.add(txtNombreMedicinaAtencion);
	v.validarSoloLetras(txtNombreMedicinaAtencion);
	
	
	txtCantidadMedicinaAtencion = new JTextField();
	txtCantidadMedicinaAtencion.setBounds(480, 165, 60, 20);
	pnlInteriorAtencion.add(txtCantidadMedicinaAtencion);
	v.validarSoloNumeros(txtCantidadMedicinaAtencion);
	
	txtTotalPagoAtencion = new JTextField();
	txtTotalPagoAtencion.setBounds(580, 445, 100, 20);
	txtTotalPagoAtencion.setEditable(false);
	pnlInteriorAtencion.add(txtTotalPagoAtencion);
	
	btnBuscarDNIPacienteAtencion = new JButton("Buscar");
	btnBuscarDNIPacienteAtencion.addActionListener(this);
	btnBuscarDNIPacienteAtencion.setBounds(320, 85, 80, 20);
	pnlInteriorAtencion.add(btnBuscarDNIPacienteAtencion);
	
	btnBuscarCodigoMedicinaAtencion = new JButton("Buscar");
	btnBuscarCodigoMedicinaAtencion.addActionListener(this);
	btnBuscarCodigoMedicinaAtencion.setBounds(320, 175, 80, 20);
	pnlInteriorAtencion.add(btnBuscarCodigoMedicinaAtencion);
	
	btnAgregaTablaAtencion = new JButton("+");
	btnAgregaTablaAtencion.addActionListener(this);
	btnAgregaTablaAtencion.setBounds(550, 165, 50, 20);
	pnlInteriorAtencion.add(btnAgregaTablaAtencion);
	
	btnRestaTablaAtencion = new JButton("-");
	btnRestaTablaAtencion.addActionListener(this);
	btnRestaTablaAtencion.setBounds(620, 165, 50, 20);
	pnlInteriorAtencion.add(btnRestaTablaAtencion);
	
	btnGuardarAtencion = new JButton("Guardar");
	btnGuardarAtencion.addActionListener(this);
	btnGuardarAtencion.setBounds(400, 480, 100, 20);
	pnlInteriorAtencion.add(btnGuardarAtencion);
	
	btnAtencionVolver = new JButton("Volver");
	btnAtencionVolver.addActionListener(this);
	btnAtencionVolver.setBounds(520, 480, 100, 20);
	pnlInteriorAtencion.add(btnAtencionVolver);
	
	txtSalidaAtencion= new JTextArea();
	
	Object[] columnas = new Object[] {"Codigo","Nombre", "Cantidad","Precio","SubTotal"};
	dtmAtencionPacientes = new DefaultTableModel (columnas,0);
	tblAtencionPacientes = new JTable(dtmAtencionPacientes);
	tblAtencionPacientes.setEnabled(true);
	scpScrollA = new JScrollPane(tblAtencionPacientes);
	scpScrollA.setBounds(60, 220, 620, 220);
	pnlInteriorAtencion.add(scpScrollA);
	
	
	pnlAtencion.add(pnlInteriorAtencion);
	add(pnlAtencion);
	pnlAtencion.setVisible(false);
	
   }
   
   //Pantalla para Pagos 
   
   public void construirPanelPagos() {
	   
	pnlPagos = new JPanel();
	pnlPagos.setLayout(null);
	pnlPagos.setBounds(0, 0, anchoApplet, largoApplet);

	pnlInteriorPagos = new JPanel();
	pnlInteriorPagos.setLayout(null);
	pnlInteriorPagos.setBounds(50, 30, 750, 450);
        		
    TitledBorder title = BorderFactory.createTitledBorder("PAGOS");
    title.setTitleJustification(TitledBorder.CENTER);
    Font font = new Font("Serif", Font.BOLD, 25);
    title.setTitleFont(font);
    pnlInteriorPagos.setBorder(title);
    
    lblDniPacientePagos = new JLabel("Dni Paciente:");
    lblDniPacientePagos.setBounds(90, 50, 150, 30);
  	pnlInteriorPagos.add(lblDniPacientePagos);
  	
  	lblNombrePacientePago = new JLabel("Nombre Paciente:");
  	lblNombrePacientePago.setBounds(90, 80, 150, 30);
   	pnlInteriorPagos.add(lblNombrePacientePago);
		
	lblSubTotalPagos = new JLabel("SubTotal:");
	lblSubTotalPagos.setBounds(480, 330, 150, 30);
	pnlInteriorPagos.add(lblSubTotalPagos);
		
	lblIGVPagos = new JLabel("IGV:");
	lblIGVPagos.setBounds(500, 360, 150, 30);
	pnlInteriorPagos.add(lblIGVPagos);
		
	lblTotalPagos = new JLabel("Total:");
	lblTotalPagos.setBounds(500, 390, 150, 30);
	pnlInteriorPagos.add(lblTotalPagos);
		
	txtDniPacientePagos= new JTextField();
	txtDniPacientePagos.setBounds(210, 55, 80, 20);
	pnlInteriorPagos.add(txtDniPacientePagos);
	v.validarSoloNumeros(txtDniPacientePagos);
	v.limitarCaracteres(txtDniPacientePagos, 8);
		
	txtNombrePacientePago= new JTextField();
	txtNombrePacientePago.setBounds(210, 85, 80, 20);
	txtNombrePacientePago.setEditable(false);
	pnlInteriorPagos.add(txtNombrePacientePago);
		
	txtSubTotalPagos= new JTextField();
	txtSubTotalPagos.setBounds(560, 335, 100, 20);
	txtSubTotalPagos.setEditable(false);
	pnlInteriorPagos.add(txtSubTotalPagos);
		
	txtIGVPagos= new JTextField();
	txtIGVPagos.setBounds(560, 365, 100, 20);
	txtIGVPagos.setEditable(false);
	pnlInteriorPagos.add(txtIGVPagos);
		
	txtTotalPagos= new JTextField();
	txtTotalPagos.setBounds(560, 395, 100, 20);
	txtTotalPagos.setEditable(false);
	pnlInteriorPagos.add(txtTotalPagos);
		
	btnbuscarCodigo = new JButton("Buscar");
	btnbuscarCodigo.addActionListener(this);
	btnbuscarCodigo.setBounds(300, 55, 80, 20);
	pnlInteriorPagos.add(btnbuscarCodigo);
		
	btnFacturarPagos = new JButton("Facturar");
	btnFacturarPagos.addActionListener(this);
	btnFacturarPagos.setBounds(410, 55, 90, 20);
	pnlInteriorPagos.add(btnFacturarPagos);
		
	btnImprimirPagos = new JButton("Imprimir");
	btnImprimirPagos.addActionListener(this);
	btnImprimirPagos.setBounds(510, 55, 90, 20);
	pnlInteriorPagos.add(btnImprimirPagos);
		
	btnPagosVolver = new JButton("Volver");
	btnPagosVolver.addActionListener(this);
	btnPagosVolver.setBounds(610, 55, 90, 20);
	pnlInteriorPagos.add(btnPagosVolver);
		
	txtSalidPagos= new JTextArea();
	
	Object[] columnas = new Object[] {"Cantidad","Unidad", "Descripcion","Precio","Importe"};
	dtmPagos = new DefaultTableModel (columnas,0);
	tblPagos = new JTable(dtmPagos);
	tblPagos.setEnabled(true);
	scpScrollPagos = new JScrollPane(tblPagos);
	scpScrollPagos.setBounds(70, 130, 630, 190);
	pnlInteriorPagos.add(scpScrollPagos);
	
	pnlPagos.add(pnlInteriorPagos);
	add(pnlPagos);
	pnlPagos.setVisible(false);
		
    }
    //Pantalla para reportes
   
    public void construirPanelReportes(){
	   
	pnlReportes = new JPanel();
	pnlReportes.setLayout(null);
	pnlReportes.setBounds(0, 0, anchoApplet, largoApplet);

   	pnlInteriorReportes = new JPanel();
   	pnlInteriorReportes.setLayout(null);
   	pnlInteriorReportes.setBounds(50, 30, 750, 380);
           		
    TitledBorder title = BorderFactory.createTitledBorder("REPORTES");
    title.setTitleJustification(TitledBorder.CENTER);
    Font font = new Font("Serif", Font.BOLD, 25);
    title.setTitleFont(font);
    pnlInteriorReportes.setBorder(title);
    
    lblTipoReportes = new JLabel("Tipo de Reporte:");
    lblTipoReportes.setBounds(90, 50, 150, 30);
    pnlInteriorReportes.add(lblTipoReportes);
  	
  	lblCodigoAtencionReportes = new JLabel("Codigo de Atencion:");
  	lblCodigoAtencionReportes.setBounds(90, 80, 150, 30);
  	pnlInteriorReportes.add(lblCodigoAtencionReportes);
   	
   	txtCodigoAtencionReportes = new JTextField();
   	txtCodigoAtencionReportes.setBounds(210, 85, 100, 20);
   	pnlInteriorReportes.add(txtCodigoAtencionReportes);
   	v.validarSoloNumeros(txtCodigoAtencionReportes);
   	
   	btnBuscarReportes = new JButton("Buscar");
   	btnBuscarReportes.addActionListener(this);
   	btnBuscarReportes.setBounds(590, 55, 100, 20);
   	pnlInteriorReportes.add(btnBuscarReportes);
	
   	btnReportesVolver = new JButton("Volver");
   	btnReportesVolver.addActionListener(this);
   	btnReportesVolver.setBounds(590, 85, 100, 20);
   	pnlInteriorReportes.add(btnReportesVolver);
   	
   	cboTipoReportes = new JComboBox();
   	cboTipoReportes.setBounds(210, 55, 230, 20);
   	cboTipoReportes.addItem("--Seleccione--");
   	cboTipoReportes.addItem(Listado0);
   	cboTipoReportes.addItem(Listado1);
   	cboTipoReportes.addItem(Listado2);
   	cboTipoReportes.addItem(Listado3);
	getContentPane().add(cboTipoReportes);
	pnlInteriorReportes.add(cboTipoReportes);
	
	txtSalidReportes= new JTextArea();
	
	Object[] columnas = new Object[] {"Cod Paciente","Nombre", "Apellidos","Fecha Ingreso","Nro. Cama"};
	dtmReportes = new DefaultTableModel (columnas,0);
	tblReportes = new JTable(dtmReportes);
	tblReportes.setEnabled(true);
	scpScrollReportes = new JScrollPane(tblReportes);
	scpScrollReportes.setBounds(70, 120, 630, 190);
	pnlInteriorReportes.add(scpScrollReportes);
   
    pnlReportes.add(pnlInteriorReportes);
	add(pnlReportes);
	pnlReportes.setVisible(false);
	
	//validaciones
	
	
	   
   }

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
