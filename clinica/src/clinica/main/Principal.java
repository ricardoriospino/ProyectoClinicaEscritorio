package clinica.main;



/// cargar la data de paciente y medicina 
// validaciones
//  fundamentos base de datos teorias platzi
// entender el codigo 



import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import clinica.arreglos.ArregloAtencion;
import clinica.arreglos.ArregloCamas;
import clinica.arreglos.ArregloDetalleAtencion;
import clinica.arreglos.ArregloInternamiento;
import clinica.arreglos.ArregloMedicinas;
import clinica.arreglos.ArregloPacientes;
import clinica.beans.Atencion;
import clinica.beans.Cama;
import clinica.beans.DetalleAtencion;
import clinica.beans.Internamiento;
import clinica.beans.Medicina;
import clinica.beans.Paciente;
import clinica.common.Constantes;
import clinica.common.Utilitario;

// validacion numero de cama se esta cayendo cuando esta vacio 

public class Principal extends Pantalla implements ActionListener{
	
	
	
	
     
	   public void init() {
			
			getContentPane().setLayout(null);
			setSize(800,600);
			
			construirPanelLogeo();
			construirPanelMenuPrincipal();
			construirPanelMenuMantenimiento();
			construirPanelMantenimientoCamas();
			construirPanelMantenimientoMedicinas();
			construirPanelMantenimientoPacientes();
			construirPanelInternamiento();
			construirPanelAtencionM();
			construirPanelPagos();
			construirPanelReportes();
		
	   }
	   
	   
	   @Override
	   public void actionPerformed( ActionEvent e ){
		   
	   // Botones de panel logeo
			
			if (e.getSource() == btnLogear) {
				Logear();	
			}
			
	    // boton salir de menu principal
			
			if (e.getSource() == btnSalir) {
			pnlLogeo.setVisible(true);
			pnlMenuPrincipal.setVisible(false);
			}
			
		// Botones entrar menu mantenimiento
			
			if (e.getSource() == btnMantenimiento) {
			pnlMenuPrincipal.setVisible(false);
			pnlMenuMantenimiento.setVisible(true);
			}
			
		//boton salir  mantenimiento
			if(e.getSource() == btnMenuMantenimientoSalir){
			pnlMenuPrincipal.setVisible(true);
			pnlMenuMantenimiento.setVisible(false);
			
			}
		//--------------------------------------------------------------
		//boton entrar mantenimiento camas 
			
			if(e.getSource()==btnMenuMantenimientoCamas) {
			pnlMenuMantenimiento.setVisible(false);
			pnlMenuMantenimientoCamas.setVisible(true);
			
				autogenerarCodigoCama();
				listarCama();
			}
			
			if (e.getSource()==btnMantenimientoBuscar) {
				buscarCama();
			}
			
			if (e.getSource()==btnMantenimientoListar) {
				listarCama();
			}
			
			if (e.getSource()==btnMantenimientoNuevo) {
				nuevoCama();
				autogenerarCodigoCama();
			}
			
			if (e.getSource()==btnMantenimientoEliminar) {
				eliminarCama();
			}
			
			if (e.getSource()==btnMantenimientoIngresar) {
				ingresarCama();
				autogenerarCodigoCama();
			}
			if (e.getSource()==btnMantenimientoModificar) {
				modificarCama();
			}
			
		//boton volver a menu mantenimiento de camas
			
			if(e.getSource()==btnMantenimientoCamaVolver) {
			pnlMenuMantenimientoCamas.setVisible(false);
			pnlMenuMantenimiento.setVisible(true);
			limpiarcajasCama();
			}
		//------------------------------------------------------------------
			
        //boton entrar mantenimiento medicinas
			
			if(e.getSource()==btnMenuMantenimientoMedicinas) {
			pnlMenuMantenimiento.setVisible(false);
			pnlMenuMantenimientoMedicinas.setVisible(true);
			
			autogenerarCodigoMedicina();
			listarMedicina();
			}
			
			if (e.getSource()==btnMantenimientoBuscarMedicinas) {
				buscarMedicina();
			}
			if (e.getSource()==btnMantenimientoListarMedicina) {
				listarMedicina();
			}
			
			if (e.getSource()==btnMantenimientoNuevoMedicina) {
				nuevoMedicina();
				autogenerarCodigoMedicina();
			}
			if (e.getSource()==btnMantenimientoEliminarMedicina) {
				eliminarMedicina();
			}
			
			if (e.getSource()==btnMantenimientoAdicionarMedicina) {
				adicionarMedicina();
				autogenerarCodigoMedicina();
			}
			
			if (e.getSource()==btnMantenimientoModificarMedicina) {
				modificarMedicina();
			}
			
        //boton volver a menu mantenimiento de Medicinas
			
			if(e.getSource()==btnMantenimientoMedicinaVolver) {
			pnlMenuMantenimientoMedicinas.setVisible(false);
			pnlMenuMantenimiento.setVisible(true);
			limpiarcajasCama();
			}
			
		//--------------------------------------------------------------------------
			
        //boton entrar mantenimiento pacientes
			
			if(e.getSource()==btnMenuMantenimientoPacientes) {
			pnlMenuMantenimiento.setVisible(false);
			pnlMenuMantenimientoPacientes.setVisible(true);
			
			autogenerarCodigoPaciente();
			}
			
			if (e.getSource()==btnMantenimientoBuscarPacientes) {
				buscarPaciente();
			}
			
			if (e.getSource()==btnMantenimientoNuevoPaciente) {
				nuevoPaciente();
				autogenerarCodigoPaciente();
			}
			
			if (e.getSource()==btnMantenimientoAdicionarPaciente) {
				adicionarPaciente();
				autogenerarCodigoPaciente();
				
			}
			if (e.getSource()==btnMantenimientoListarPaciente) {
				listarPaciente();
			}
			
			if (e.getSource()==btnMantenimientoEliminarPaciente) {
				eliminarPaciente();
			}
			
			if (e.getSource()==btnMantenimientoModificarPaciente) {
				modificarPaciente();
			}
			
        //boton volver a menu mantenimiento de pacientes
			
			if(e.getSource()==btnMantenimientoPacienteVolver) {
			pnlMenuMantenimientoPacientes.setVisible(false);
			pnlMenuMantenimiento.setVisible(true);
			limpiarcajasCama();
			}
			
			
		//----------------------------------------------------------------------
		//boton entrar internamiento
			
			if(e.getSource()==btnInternamiento) {
				pnlMenuPrincipal.setVisible(false);
				pnlInternamiento.setVisible(true);
				
				autogenerarCodigoInternamiento();
			}
			
			if (e.getSource()==btnBuscarCodigoPaciente) {
				buscarCodigoPaciente();
			}
			
			if (e.getSource()==btnGuardarInternamiento) {
				guardarInternamiento();
				autogenerarCodigoInternamiento();
			}
			
			
		//boton volver a principal
			if(e.getSource()==btnInternamientoVolver) {
				pnlInternamiento.setVisible(false);
				pnlMenuPrincipal.setVisible(true);
			}
			
		//---------------------------------------------------------------------
		//boton entrar Atencion
			if(e.getSource()==btnAtencion) {
				pnlMenuPrincipal.setVisible(false);
				pnlAtencion.setVisible(true);
				
				autogenerarCodigoAtencion();
			}
			
			if (e.getSource()==btnBuscarDNIPacienteAtencion) {
				buscarDniPacienteAtencion();
			}
			
			if (e.getSource()==btnBuscarCodigoMedicinaAtencion) {
				 buscarMedicinaAtencion();
			}
			if(e.getSource()==btnAgregaTablaAtencion) {
				guardarDetalle();
				//autogenerarCodigoAtencion();
			}
			
			if (e.getSource()==btnGuardarAtencion) {
				guardarAtencion();
				autogenerarCodigoAtencion();
			}
			
		//boton volver a principal
			if(e.getSource()==btnAtencionVolver) {
				pnlAtencion.setVisible(false);
				pnlMenuPrincipal.setVisible(true);
			}
			
		//--------------------------------------------------------------------
		//boton entrar Pagos
			if(e.getSource()==btnPagos) {
				pnlMenuPrincipal.setVisible(false);
				pnlPagos.setVisible(true);
			}
		//boton buscar paciente
			
			if(e.getSource()==btnbuscarCodigo) {
				buscarDniPacientePago();
			}
			
		//boton volver a principal
			if(e.getSource()==btnPagosVolver) {
				pnlPagos.setVisible(false);
				pnlMenuPrincipal.setVisible(true);
			}
			
		//--------------------------------------------------------------------
			
		//boton entrar Reportes
			if(e.getSource()==btnReportes) {
				pnlMenuPrincipal.setVisible(false);
				pnlReportes.setVisible(true);
			}
			
		//boton volver a principap
			if(e.getSource()==btnReportesVolver) {
				pnlReportes.setVisible(false);
				pnlMenuPrincipal.setVisible(true);
			}
		
		//----------------------------------------------------------------------
			
		}
	   
		
	   
		public void Logear() {
		
			String usuario = getValorTxtString(txtUsuario);
		   
			String password = pwfPassword.getText();
		
				if(usuario.equals("")|| password.equals("")  ) {
		
						JOptionPane.showMessageDialog(this, "Datos Incompletos","Alerta",JOptionPane.WARNING_MESSAGE);
					
				}else {
				
					if (usuario.equals("ricardo")&&password.equals("123")) {
							pnlLogeo.setVisible(false);
							pnlMenuPrincipal.setVisible(true);
					}else {
							JOptionPane.showMessageDialog(this,"Usuario o Clave Incorrecta","Mensaje del sistema", JOptionPane.WARNING_MESSAGE);
		
		
					}
				}
	     }
	
	/*************************************/
	// Operacion cama 
	/*************************************/
		
		private void autogenerarCodigoCama() {
			
			txtMantenimientoNumeroCama.setText(""+aCamas.nuevoCodigoCama());
			
		}
		
		private void ingresarCama() {
				
		    	int numeroCama = obtenerCodigoCama();
		    	
		    	
		    	
		    	if (aCamas.buscarPorCodigo(numeroCama)==-1) {// no existe codigo
		    			
		    		//capturamos valores de pantalla y generamos objetos camas
		    		
			    	Cama cama = new Cama(numeroCama,obtenerCategoriaCama(),obtenerEstado() );
			   
			    	aCamas.adicionar(cama);
			    	listarCama();
			    	limpiarcajasCama();
			    	mensaje("Cama ingresada");
		    	
		    	}else {
		    		
		    		mensaje ("codigo ya fue usado"); 		
		    	}	
	    }
		 
		private void listarCama() {
		 		
			dtmMantenimientoCamas.setRowCount(0);
		 		
				if (aCamas.getIndiceCamas()<1) {
		 			
					
				}else {
		 			
						for (int i = 0; i <aCamas.getIndiceCamas();i++) {
								Cama c = aCamas.getArregloCamas()[i];
								String categoria = "Basico";
		 				
							if (c.getCategoria()==1) categoria = "Estandar";
		 				
							else if (c.getCategoria()==2)categoria = "Premium";
		 				
								String estado = "Libre";
		 
							if (c.getEstadoC()==1) estado = "Ocupado";
		 				
								dtmMantenimientoCamas.addRow(new Object[] {c.getNumCama(),categoria,estado});
						}
				}
		}
	 
		private void limpiarcajasCama() {
	  		
	    	txtMantenimientoNumeroCama.setText("");
	  		txtMantenimientoNumeroCama.requestFocus();
	  		cboMantenimientoCategoriaCama.setSelectedIndex(0);
	  		rbnMantenimientoLibre.setSelected(true);
	  		rbnMantenimientoOcupado.setSelected(false);
	    }	
	 
		private void buscarCama() {
			
		  
			int numeroCama= obtenerCodigoCama();
			
			dtmMantenimientoCamas.setRowCount(0);
			
			int pos=aCamas.buscarPorCodigo(numeroCama);
				
				if (pos!=-1) {
			   
					btnMantenimientoEliminar.setEnabled(true);
					btnMantenimientoModificar.setEnabled(true);
					btnMantenimientoIngresar.setEnabled(false);
			 
					Cama x = aCamas.obtenerCama(pos);
				
					String categoria = "Basico";
					
						if (x.getCategoria()==1) categoria = "Estandar";
						else if (x.getCategoria()==2)categoria = "Premium";
						
						String estado = "Libre";
						if (x.getEstadoC()==1) estado = "Ocupado";
					
						dtmMantenimientoCamas.addRow(new Object[] {x.getNumCama(),categoria,estado});
						cboMantenimientoCategoriaCama.setSelectedIndex(x.getCategoria());
						
						if (x.getEstadoC()==0) {
					
							rbnMantenimientoLibre.setSelected(true);
							rbnMantenimientoOcupado.setSelected(false);
					
						}else {
							rbnMantenimientoLibre.setSelected(false);
							rbnMantenimientoOcupado.setSelected(true);	
						}	   
				
						}else {
							mensaje("cama no existe");
						}
		}
	 
		private void nuevoCama() {
		
			btnMantenimientoEliminar.setEnabled(false);
			btnMantenimientoModificar.setEnabled(false);
			btnMantenimientoIngresar.setEnabled(true);
			limpiarcajasCama();	
			listarCama();
		}
	
		
	
		private void mensaje(String texto) {
			
			JOptionPane.showMessageDialog(this, texto ,"Informacion",JOptionPane.INFORMATION_MESSAGE);
		}
		
		private void mensajeError(String texto) {
			
			JOptionPane.showMessageDialog(this, texto ,"Error",JOptionPane.ERROR_MESSAGE);
		}
		
		private void mensajeAlerta(String texto) {
			
			JOptionPane.showMessageDialog(this, texto ,"Alerta",JOptionPane.WARNING_MESSAGE);
		}
	
	
		/*** obtener valores de la caja de texto */
	
		int obtenerCodigoCama() {
		
			return Integer.parseInt(txtMantenimientoNumeroCama.getText());
		}
		
		int ObtenerCamaLibre() {
			
			return cboCategoriaCamaInternamiento.getSelectedIndex();
    
		}
    
		int obtenerCategoriaCama() {
    	
			return cboMantenimientoCategoriaCama.getSelectedIndex();
		}
    
		int obtenerEstado() {
		
			int estado =0; // o libre , 1 : ocupado
		
			if (rbnMantenimientoOcupado.isSelected())
			estado =1;
		
				return estado; 
		}
	 
		private void modificarCama() {
		 
			Cama cama=new Cama();
			cama.setNumCama(obtenerCodigoCama());
			cama.setCategoria(obtenerCategoriaCama());
			cama.setEstado(obtenerEstado());
		 
			int pos = aCamas.buscarPorCodigo(cama.getNumCama());
		 
			if (pos==-1) {
				
				mensaje("cama no existe");
			}else {
					aCamas.modificar(pos, cama);
					mensaje("Modificado Exitosamente");
		 
					dtmMantenimientoCamas.setRowCount(0);
		 
					Cama x = aCamas.obtenerCama(pos);
				
					String categoria = "Basico";
					
					if (x.getCategoria()==1) categoria = "Estandar";
						
					else if (x.getCategoria()==2)categoria = "Premium";
					
					String estado = "Libre";
					if (x.getEstadoC()==1) estado = "Ocupado";
				
				dtmMantenimientoCamas.addRow(new Object[] {x.getNumCama(),categoria,estado});
			}	   
		   
			limpiarcajasCama();
        }
	 
		private void eliminarCama() {
			
			int pos = aCamas.buscarPorCodigo(obtenerCodigoCama());
			
			if(pos!=-1) {
				
				aCamas.eliminar(pos);
				listarCama();
				mensaje("cama eliminada correctamente!!");
				
			}else {
				
				mensaje("cama no existe!");
			}
		}
		//-------------------------------------------------------------------
		/*************************************/
		// Operacion Medicina
		/*************************************/
		
		private void autogenerarCodigoMedicina() {
			
			txtMantenimientoCodigoMedicinas.setText(""+aMedicinas.nuevoCodigoMedicina());
		}
		private void  adicionarMedicina() {
			
			int numMedicina = obtenerCodigoMedicina();
			
			if("".equals(txtMantenimientoNombreMedicina.getText())||
					"".equals(txtMantenimientoNombreLaboratorio.getText())||
					"".equals(txtMantenimientoPrecioMedicina.getText())||
					"".equals(txtMantenimientoStockMedicina.getText())) {
				
				mensajeAlerta("Datos incompletos");
			}else {
				
				if (aMedicinas.buscarPorCodigo(numMedicina)==-1) {// no existe codigo
					 
					//capturamos valores de pantalla y generamos objetos Medicinas
				 
					 Medicina medicina = new Medicina(numMedicina,obtenerNombreMedicina(),obtenerLaboratorioMedicina(),obtenerPrecioMedicina(),obtenerStockMedicina());
			
					 aMedicinas.adicionar(medicina);
					 listarMedicina();
					 limpiarcajasMedicina();
					 mensaje("Medicina ingresada");
				 
				}else {
				 
					mensaje("codigo ya fue usado");			 
				}		
			}	
		}
	 
		private void listarMedicina() {
			
			 	dtmMantenimientoMedicinas.setRowCount(0);
		 
			 	if (aMedicinas.getIndiceMedicinas()<1 ) {
			 
			 	}else {
			 
			 		for (int i=0;i<aMedicinas.getIndiceMedicinas();i++) {
			 			Medicina m=aMedicinas.getArregloMedicinas()[i];
				 
			 			dtmMantenimientoMedicinas.addRow(new Object[]{m.getNumMedicina(),m.getNombreMedicina(),m.getNombreLaboratorio()
			 					,m.getPrecioMedicina(),m.getStockMedicina()});
			 			
			 			
			 		}
			 	}
		}
	 
		private void limpiarcajasMedicina() {
	  		
	    		txtMantenimientoCodigoMedicinas.setText("");
	    		txtMantenimientoCodigoPacientes.requestFocus();
	  		
	    		txtMantenimientoNombreMedicina.setText("");
	    		txtMantenimientoNombreMedicina.requestFocus();
	  		
	    		txtMantenimientoNombreLaboratorio.setText("");
	    		txtMantenimientoNombreLaboratorio.requestFocus();
	  		
	    		txtMantenimientoPrecioMedicina.setText("");
	    		txtMantenimientoPrecioMedicina.requestFocus();
	  		
	    		txtMantenimientoStockMedicina.setText("");
	    		txtMantenimientoStockMedicina.requestFocus();
	  		
	    }	
	 
	
		private void buscarMedicina() {
			
			int numMedicina = obtenerCodigoMedicina();
			
			
			dtmMantenimientoMedicinas.setRowCount(0);
			
			Medicina pos=aMedicinas.obtenerMedicinaPorCodigo(numMedicina);
			
			System.out.println("ENTRO BUSCAR:" + obtenerCodigoMedicina());
			
			
			if(pos!=null) {
			
				btnMantenimientoEliminarMedicina.setEnabled(true);
				btnMantenimientoModificarMedicina.setEnabled(true);
				btnMantenimientoAdicionarMedicina.setEnabled(false);
				
				Medicina M = aMedicinas.obtenerMedicina(aMedicinas.buscarPorCodigo(numMedicina));
				
				
				txtMantenimientoNombreMedicina.setText(""+M.getNombreMedicina());
				txtMantenimientoNombreLaboratorio.setText(""+M.getNombreLaboratorio());
				txtMantenimientoPrecioMedicina.setText(""+M.getPrecioMedicina());
				txtMantenimientoStockMedicina.setText(""+M.getStockMedicina());
				
				dtmMantenimientoMedicinas.addRow(new Object[] {M.getNumMedicina(),M.getNombreMedicina(),M.getNombreLaboratorio(),M.getPrecioMedicina()
						,M.getStockMedicina()});
			
	 
				
				System.out.println("pinto toda la lista ");
				
			}else {
				mensaje("codigo: " +obtenerCodigoMedicina()+" no existe.");
			}
			
			
		}
	 
		private void nuevoMedicina() {
		
			btnMantenimientoEliminarMedicina.setEnabled(false);
			btnMantenimientoModificarMedicina.setEnabled(false);
			btnMantenimientoAdicionarMedicina.setEnabled(true);
			limpiarcajasMedicina();	
			listarMedicina();
		}
	 
			/*** obtener valores de la caja de texto medicina */
		
			int obtenerCodigoMedicina() {
			
				return Integer.parseInt(txtMantenimientoCodigoMedicinas.getText());
			}
			String obtenerNombreMedicina() {
				
				return txtMantenimientoNombreMedicina.getText();
			}
	    
			String obtenerLaboratorioMedicina() {
	    	
				return txtMantenimientoNombreLaboratorio.getText();
			}
	    
			double obtenerPrecioMedicina() {
	    	
				return Double.parseDouble(txtMantenimientoPrecioMedicina.getText());
			}
	    
			int obtenerStockMedicina() {
				
				return Integer.parseInt(txtMantenimientoStockMedicina.getText());
			}
			
	private void modificarMedicina() {
		
		Medicina medicina = new  Medicina();
		
		medicina.setNumMedicina(obtenerCodigoMedicina());
		medicina.setNombreMedicina(obtenerNombreMedicina());
		medicina.setNombreLaboratorio(obtenerLaboratorioMedicina());
		medicina.setPrecioMedicina(obtenerPrecioMedicina());
		medicina.setStockMedicina(obtenerStockMedicina());
		
		int pos = aMedicinas.buscarPorCodigo(medicina.getNumMedicina());
		
		if (pos==-1) {
			
			mensaje("Medicina no existe");
		}else {
			
			aMedicinas.modificar(pos, medicina);
			mensaje("Modificacion exitosa");
			
			dtmMantenimientoMedicinas.setRowCount(0);
			
			Medicina M = aMedicinas.obtenerMedicina(pos);
			
			dtmMantenimientoMedicinas.addRow(new Object[] {M.getNumMedicina(),M.getNombreMedicina(),M.getNombreLaboratorio(),M.getPrecioMedicina()
					,M.getStockMedicina()});
			
		}
			limpiarcajasMedicina();
		
	}
	
	private void eliminarMedicina() {
		
		int pos = aMedicinas.buscarPorCodigo(obtenerCodigoMedicina());
		
		// significa elemento ya existe en el arreglo 
		if (pos!=-1) {
			aMedicinas.eliminar(pos);
			limpiarcajasMedicina();
			listarMedicina();
			mensaje("Medicina eliminada correctamnete !!");
			
		}else {
			mensaje("Medicina no existe!!");
		}
	}
			
	/*************************************/
	// Operacion Pacientes
	/*************************************/
	
	private void autogenerarCodigoPaciente() {
		
		txtMantenimientoCodigoPacientes.setText(""+aPacientes.nuevoCodigoPaciente());
		
	}
		 
	 private void adicionarPaciente() {
			 
		int numPaciente = obtenerCodigoPaciente();
				
		if("".equals(txtMantenimientoNombrePacientes.getText())||
				"".equals(txtMantenimientoApellidosPacientes.getText())||
				"".equals(txtMantenimientoDniPacientes.getText())||
				"".equals(txtMantenimientoTelefonoPacientes.getText())) {
					
				mensajeAlerta("Datos incompletos");
				
		}else {
			 
				if (aPacientes.buscarPorCodigo(numPaciente)==-1) {// NO EXISTE CODIGO
				 
				 // CAPTURAMOS VALORES DE PANTALLA Y GENERAMOS OBJETOS PACIENTES
				 
					Paciente paciente = new Paciente(numPaciente,obtenerNombresPaciente(),obtenerApellidosPaciente(),obtenerDniPaciente(),
						 obtenerTelefonoPaciente());
				 
					 aPacientes.adicionar(paciente);
					 listarPaciente();
					 limpiarcajasPacientes();
					 mensaje("Paciente ingresado");
				 
				}else {
					 mensajeAlerta("codigo ya fue usado");
				}
		} 
	}
		 
	private void listarPaciente() {
			 
				dtmMantenimientoPacientes.setRowCount(0);
			 
				
				if(aPacientes.getIndicePacientes()<1) {
				
				}else {
					
					for (int i=0;i<aPacientes.getIndicePacientes();i++) {
					Paciente p= aPacientes.getArregloPacientes()[i];
					
					dtmMantenimientoPacientes.addRow(new Object[] {p.getNumPaciente(),p.getNombresPaciente(),p.getApellidosPaciente(),
							p.getDniPaciente(),p.getTelefonoPaciente()});
					}
				}
	}
		 
	private void limpiarcajasPacientes() {
			 
				txtMantenimientoCodigoPacientes.setText("");
				txtMantenimientoCodigoPacientes.requestFocus();
			 
				txtMantenimientoNombrePacientes.setText("");
				txtMantenimientoNombrePacientes.requestFocus();
			 
				txtMantenimientoApellidosPacientes.setText("");
				txtMantenimientoApellidosPacientes.requestFocus();
			 
				txtMantenimientoDniPacientes.setText("");
				txtMantenimientoDniPacientes.requestFocus();
			 
				txtMantenimientoTelefonoPacientes.setText("");
				txtMantenimientoTelefonoPacientes.requestFocus();
		 
	}
			
	private void buscarPaciente() {
			 
			 
				int numPaciente = obtenerCodigoPaciente();
				
				dtmMantenimientoPacientes.setRowCount(0);
				
				Paciente pos =aPacientes.obtenerPaciente(numPaciente);
				
				System.out.println("ENTRO BUSCAR:" + obtenerCodigoPaciente());
				
				if (pos!=null) {
					
					btnMantenimientoEliminarPaciente.setEnabled(true);
					btnMantenimientoModificarPaciente.setEnabled(true);
					btnMantenimientoAdicionarPaciente.setEnabled(false);
					
					Paciente x = aPacientes.obtenerPaciente(aPacientes.buscarPorCodigo(numPaciente));
					
					txtMantenimientoNombrePacientes.setText(""+x.getNombresPaciente());
					txtMantenimientoApellidosPacientes.setText(""+x.getApellidosPaciente());
					txtMantenimientoDniPacientes.setText(""+x.getDniPaciente());
					txtMantenimientoTelefonoPacientes.setText(""+x.getTelefonoPaciente());
					
		    		 dtmMantenimientoPacientes.addRow(new Object[] {x.getNumPaciente(), x.getNombresPaciente(),x.getApellidosPaciente(),x.getDniPaciente()
		    		  ,x.getTelefonoPaciente()});
		    		 
		    		 System.out.println("Pinto toda la lista Paciente ");
		    		 
				}else {
					
					mensaje("codigo: " +obtenerCodigoPaciente()+ " no existe" );
				}
	}
		 
	private void nuevoPaciente() {
				btnMantenimientoEliminarPaciente.setEnabled(false);
				btnMantenimientoModificarMedicina.setEnabled(false);
				btnMantenimientoAdicionarMedicina.setEnabled(true);
				limpiarcajasPacientes();
				listarPaciente();
	}
		 
	
			
	/*** obtener valores de la caja de texto pacientes */
			
				int obtenerCodigoPaciente() {
				
					return Integer.parseInt(txtMantenimientoCodigoPacientes.getText());
				}
				String obtenerNombresPaciente() {
					
					return txtMantenimientoNombrePacientes.getText();
				}
		    
				String obtenerApellidosPaciente() {
		    	
					return txtMantenimientoApellidosPacientes.getText();
				}
		    
				String obtenerDniPaciente() {
		    	
					return txtMantenimientoDniPacientes.getText();
				}
		    
				String obtenerTelefonoPaciente() {
					
					return txtMantenimientoTelefonoPacientes.getText();
				}
				
	private void modificarPaciente() {
			
				Paciente paciente = new Paciente();
			
				paciente.setNumPaciente(obtenerCodigoPaciente());
				paciente.setNombresPaciente(obtenerNombresPaciente());
				paciente.setApellidosPaciente(obtenerApellidosPaciente());
				paciente.setDniPaciente(obtenerDniPaciente());
				paciente.setTelefonoPaciente(obtenerTelefonoPaciente());
			
				int pos =aPacientes.buscarPorCodigo(paciente.getNumPaciente());
			
				if (pos==-1) {
				
					mensajeAlerta("Paciente no existe");
				}else {
					
					aPacientes.modificar(pos, paciente);
					mensaje("Modificacion Exitosa");
					
					dtmMantenimientoPacientes.setRowCount(0);
					
					Paciente x = aPacientes.obtenerPaciente(pos);
					
					dtmMantenimientoPacientes.addRow(new Object[] {x.getNumPaciente(), x.getNombresPaciente(),x.getApellidosPaciente(),x.getDniPaciente()
				    		  ,x.getTelefonoPaciente()});
				}
				
				limpiarcajasPacientes();
			
	}
		
	private void eliminarPaciente() {
			
				int pos = aPacientes.buscarPorCodigo(obtenerCodigoPaciente());
				
				// sigmifica elemento ya existe en el arreglo 
				
				if (pos!=-1) {
					aPacientes.Eliminar(pos);
					limpiarcajasPacientes();
					listarPaciente();
					mensaje("Paciente eliminado correctamente");
				}else {
					mensaje("Paciente no existe!!");
				}
	}
		
	/*************************************/
	// Operacion Internamiento
	/*************************************/
		
	private void autogenerarCodigoInternamiento() {
			
			txtCodigoInternamiento.setText(""+aInternamiento.nuevoCodigoInternamiento());
			txtCodigoInternamiento.setEnabled(false);
			
	}
		
	private void buscarCodigoPaciente() {
			
			int numDniPaciente = obtenerDniInternamiento();
			
			Paciente pac = aPacientes.obtenerPacientePorDni(""+numDniPaciente);
			
			if (pac!=null) {
				
				txtnombrePacienteInternamiento.setText(pac.getNombresPaciente());
				txtapellidosPacienteInternamiento.setText(pac.getApellidosPaciente());
				
				
			}else {
				mensaje ("El paciente no esta registrado!!");
			}
			
	}
		
		
	private void guardarInternamiento() {
			
			
			int codigoInternamiento = obtenerCodigoInternamiento();
			int categoriaCama = obtenerCategoriaCamaInternamiento();
			
			if (aInternamiento.buscarPorCodigo(codigoInternamiento)==-1) {// NO EXISTE CODIGO
				 
				 // CAPTURAMOS VALORES DE PANTALLA Y GENERAMOS OBJETOS PACIENTES
				
				String DniPaciente = txtDniPaciente.getText();
				
				if("".equals(DniPaciente)) {
					mensajeAlerta("datos incompletos ");

				}else {
					int  numDniPaciente = obtenerDniInternamiento();
				
					int camaAsignada = aCamas.obtenerCamaLibre(categoriaCama);
					
					if(camaAsignada!=-1) {
						
					Paciente pac = aPacientes.obtenerPacientePorDni(""+numDniPaciente);	
				 
					Internamiento internamiento = new Internamiento(codigoInternamiento,
							camaAsignada,pac.getNumPaciente(),
							Utilitario.obtenerFechaActualddMMyyyy(),
							Utilitario.obtenerHora(),
							"","",Constantes.INTERNAMIENTO_ALOJADO);
					
					
						 aInternamiento.adicionar(internamiento);
						 limpiarcajasInternamiento();
						 listarInternamientoConsola();
						 actualizarEstadoCama(camaAsignada);
						 mensaje("Internamiento ingresado correctamente ");
					
					
					
						}else {
							mensajeAlerta("No hay camas disponible");
						}
					}
						
						
						}else {
						mensajeAlerta("codigo ya fue Usado ");
					
						}
		}
	
						
			
	private void actualizarEstadoCama(int numeroCama) {
		//OBTENGO LA POSICION DE LA CAMA
		 int pos = aCamas.buscarPorCodigo(numeroCama);
		 
		 // OBTENER LOS DATOS DE ESA CAMA
		 Cama cama = aCamas.obtenerCama(pos);
		 
		 //CAMBIO DE ESTADO A ESA CAMA
		 cama.setEstado(Constantes.CAMA_OCUPADA);
		
		//GUARDAR LA CAMA 
		 aCamas.modificar(pos, cama);
	}

	private void limpiarcajasInternamiento() {
			 
			
			
			txtCodigoInternamiento.setText("");
			txtCodigoInternamiento.requestFocus();
			
			txtnombrePacienteInternamiento.setText("");
			txtnombrePacienteInternamiento.requestFocus();
			
			txtapellidosPacienteInternamiento.setText("");
			txtapellidosPacienteInternamiento.requestFocus();
			
			txtDniPaciente.setText("");
			txtDniPaciente.requestFocus();
			
			cboCategoriaCamaInternamiento.setSelectedIndex(0);
			
	}
		
	private void listarInternamientoConsola() {
	 		
				
				if (aInternamiento.getIndiceInternamiento()<1) {
		 			
					//imprimir ("no hay libro");
				}else {
		 			
						for (int i = 0; i <aInternamiento.getIndiceInternamiento();i++) {
								Internamiento internamiento = aInternamiento.getArregloInternamiento()[i];
								
								System.out.println(internamiento.datosInternamiento());		
								
						}
				}
	}
		
	/*** obtener valores de la caja de texto **/
			
			int obtenerCodigoInternamiento() {
				
				return Integer.parseInt(txtCodigoInternamiento.getText());
			}
			int obtenerDniInternamiento() {
				
				return Integer.parseInt(txtDniPaciente.getText());
			}
			
			int obtenerCategoriaCamaInternamiento() {
	    	
				return cboCategoriaCamaInternamiento.getSelectedIndex();
			}
			
	/*************************************/
	// Operacion Atencion
	/*************************************/
			
	private void autogenerarCodigoAtencion() {
				
			txtCodigoAtencion.setText(""+aAtencion.nuevoCodigoAtencion());
			txtCodigoAtencion.setEnabled(false);
			
			txtFechaAtencion.setText(""+utilitario.obtenerFechaActualddMMyyyy());
			txtFechaAtencion.setEnabled(false);
				
				
	}
		
	private void buscarDniPacienteAtencion () {
			
			String numDniPaciente = obtenerDniAtencion();
			
			Paciente pac = aPacientes.obtenerPacientePorDni(numDniPaciente);
			
			if (pac!=null) {
				
				txtNombrePacienteAtencion.setText(pac.getNombresPaciente());
				txtApellidoPacienteAtencion.setText(pac.getApellidosPaciente());
				
				
			}else {
				mensaje ("El paciente no esta registrado!!");
			}
			
	}
		
	private void buscarMedicinaAtencion() {
			
			String nombreMedicina = obtenerNombreMedicinaAtencion();
			
			Medicina med = aMedicinas.obtenerNombreMedicina(""+nombreMedicina);
			
			if (med!=null) {
				
				txtCodigoMedicinaAtencion.setText(""+med.getNumMedicina());
				txtPrecioMedicinaAtencion.setText(""+med.getPrecioMedicina());
				
			}else {
				
				mensaje ("La Medicina no esta  registrada");
			}
			
	}
	
	
	private void guardarDetalle() {
		
		System.out.println("Entro guardar detalle");
		
		if ("".equals(txtNombreMedicinaAtencion.getText()) ||
				"".equals(txtCantidadMedicinaAtencion.getText()) ){
			
			mensajeAlerta("Ingrese la Medicina");
			
		}else{
			

			int codigoAtencion = obtenerCodigoAtencion();
			System.out.println("obtener codigo atencion"+ codigoAtencion);
					
					
			int  codigoMedicina = obtenerCodigoMedicinaAtencion();
			Medicina medicina = aMedicinas.obtenerMedicinaPorCodigo(codigoMedicina);
			
			System.out.println("medicina:" + medicina.getNombreMedicina());
			
			int cantidadMedicina = obtenerCantidadMedicina();
			System.out.println("cantidadMedicina" + cantidadMedicina);
			
			double subTotal = cantidadMedicina * medicina.getPrecioMedicina();
		
			DetalleAtencion detalle = new DetalleAtencion(codigoAtencion, codigoMedicina, cantidadMedicina,
					medicina.getPrecioMedicina(),medicina.getNombreMedicina(),subTotal);
			
			aDetalleAtencion.adicionar(detalle);
			listarDetalle();
			
				
		}

	}
	
	private void listarDetalle() {
		
		dtmAtencionPacientes.setRowCount(0);
		double total = 0;
		if (aDetalleAtencion.getIndiceDetalleAtencion()<1) {
			
			
		}else {
			
			
			
			for (int i=0;i<aDetalleAtencion.getIndiceDetalleAtencion();i++) {
				DetalleAtencion d = aDetalleAtencion.getArregloDetalleAtencion()[i];
				
				
				dtmAtencionPacientes.addRow(new Object[] {d.getCodigoMedicina(),d.getNombreMedicina(),d.getCantidad(),d.getPrecioUnitario(),d.getSubTotal()});
			
				
				total +=d.getSubTotal();
				
				}
			
			txtTotalPagoAtencion.setText(""+total);
		}
		
	}
	
	
	
	private void guardarAtencion() {
		
			System.out.println("entro a guardar A tencion ");
			
			int codigoAtencion = obtenerCodigoAtencion();
			System.out.println("codigo atencion : " +codigoAtencion);
			
			String  dniPaciente = obtenerDniAtencion();
			System.out.println("numero de dni:" + dniPaciente);
			
			String nombrePaciente = txtNombrePacienteAtencion.getText();
			
			Paciente paciente = null;
			if ("".equals(dniPaciente))
				mensajeAlerta("ingrese Dni");
			
			else {
				
				 paciente = aPacientes.buscarDniPacienteAtencion(dniPaciente);
					
					double total =obtenerTotalAtencion();
					
					Atencion a = new Atencion(codigoAtencion,paciente.getNumPaciente(),Utilitario.obtenerFechaActualddMMyyyy(),
							total,Constantes.ATENCION_PENDIENTE);
					
					
					
					if ("".equals(nombrePaciente)) {
						mensajeAlerta("busque al cliente");
					}else {
						aAtencion.adicionar(a);
						listarAtencionConsola();
						limpiarcajasAtencion();
						listarDetalle();
						mensaje("se guardo la antencion correctamente");
				
					}
			}
		
	}
	
	private void listarAtencionConsola() {
 		System.out.println("entro a listar atentncion ");
		
		if (aAtencion.getIndiceAtencion()<1) {
 			
			//imprimir ("no hay libro");
		}else {
 			
				for (int i = 0; i <aAtencion.getIndiceAtencion();i++) {
						Atencion atencion = aAtencion.getArregloAtencion()[i];
						
						System.out.println(atencion.datosAtencion());		
						
				}
		}
}
		
	private void limpiarcajasAtencion() {
			 
				txtCodigoAtencion.setText("");
				txtCodigoAtencion.requestFocus();
				
				txtCodigoDniAtencion.setText("");
				txtCodigoDniAtencion.requestFocus();
				
				txtFechaAtencion.setText("");
				txtFechaAtencion.requestFocus();
				
				txtCodigoMedicinaAtencion.setText("");
				txtCodigoMedicinaAtencion.requestFocus();
				
				txtNombreMedicinaAtencion.setText("");
				txtNombreMedicinaAtencion.requestFocus();
				
				txtNombrePacienteAtencion.setText("");
				txtNombrePacienteAtencion.requestFocus();
				
				txtApellidoPacienteAtencion.setText("");
				txtApellidoPacienteAtencion.requestFocus();
				
				txtPrecioMedicinaAtencion.setText("");
				txtPrecioMedicinaAtencion.requestFocus();
				
				txtCantidadMedicinaAtencion.setText("");
				txtCantidadMedicinaAtencion.requestFocus();
				
				
				aDetalleAtencion = new ArregloDetalleAtencion();
			
	}
		
	
		
	/*** obtener valores de la caja de texto **/
	
	
			int obtenerCodigoAtencion() {
		
				return Integer.parseInt(txtCodigoAtencion.getText());
			}
			
			double obtenerTotalAtencion() {
				
				return Double.parseDouble(txtTotalPagoAtencion.getText());
			}
			
			
			String obtenerDniAtencion() {
				
				return txtCodigoDniAtencion.getText();
			}
			
			int obtenerFechaAtencion() {
	    	
				return Integer.parseInt(txtFechaAtencion.getText());
			}
			
			int obtenerCodigoMedicinaAtencion() {
				
				return Integer.parseInt(txtCodigoMedicinaAtencion.getText());
			}
			
			String  obtenerNombreMedicinaAtencion() {
				return  txtNombreMedicinaAtencion.getText();
			}
			double obtenerPrecioMedicinaAtencion() {
				
				return Double.parseDouble(txtPrecioMedicinaAtencion.getText());
			}
		
			
			int obtenerCantidadMedicina() {
				return Integer.parseInt( txtCantidadMedicinaAtencion.getText());
			}
	/**********************************/
	// operacion Pago
	/**********************************/
	
	private void buscarDniPacientePago () {
		
			String numDniPaciente = obtenerDniPago();	
				
			Paciente pac = aPacientes.obtenerPacientePorDni(""+numDniPaciente);
				
				if (pac!=null) {
				
					txtNombrePacientePago.setText(""+pac.getNombresPaciente());
						
				}else {
					mensaje ("El paciente no esta registrado!!");
				}
				
	}
	private void limpiarCajasPago() {
		
		
		txtNombrePacientePago.setText("");
		txtNombrePacientePago.requestFocus();
		
		txtDniPacientePagos.setText("");
		txtDniPacientePagos.requestFocus();
		
		txtSubTotalPagos.setText("");
		txtSubTotalPagos.requestFocus();
		
		txtIGVPagos.setText("");
		txtIGVPagos.requestFocus();
		
		txtTotalPagos.setText("");
		txtTotalPagos.requestFocus();
		
		aInternamiento = new ArregloInternamiento();
		aAtencion = new ArregloAtencion();
				
		
		
	}
	
	
	
	
	
	
	/*** obtener valores de la caja de texto **/
	
	String obtenerDniPago () {
		return txtNombrePacientePago.getText();
	}
	
	
			
	
	
			
			
	
			
	/*********************************************/
	//METODOS GENERICOS
	/*********************************************/
		private String getValorTxtString(JTextField txt){
		
			return txt.getText();
		
		}
  	}

