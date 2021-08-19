package clinica.arreglos;

import clinica.beans.Paciente;

public class ArregloPacientes {
	
	public Paciente arregloPacientes[];
	public int indicePacientes;// almacena cantidad de pacientes
	public int tamanioP = 5;
	
	//CONSTRUCTOR
	
	public ArregloPacientes() {
		
		System.out.println("Entro constructor");
		
		arregloPacientes = new Paciente [tamanioP];
		indicePacientes =0;
	}
	public int buscarPorCodigo (int numPaciente) {
		System.out.println("entro buscar por codigo:"  + numPaciente);
		
		for (int i=0;i<indicePacientes;i++) {
			
			if (arregloPacientes[i].getNumPaciente()==numPaciente)
				
				return i;
		}
		
		return -1;
	}
	
	public int nuevoCodigoPaciente() {
		
		return indicePacientes+1;
		
	}
	
	public void modificar (int pos, Paciente x) {
		
		System.out.println("Entro Modificar");
		
		arregloPacientes[pos].setNumPaciente(x.getNumPaciente());
		arregloPacientes[pos].setApellidosPaciente(x.getApellidosPaciente());
		arregloPacientes[pos].setNombresPaciente(x.getNombresPaciente());
		arregloPacientes[pos].setTelefonoPaciente(x.getTelefonoPaciente());
		arregloPacientes[pos].setDniPaciente(x.getDniPaciente());
	
	}
	
	public void Eliminar (int pos) {
		
		System.out.println("Entro eliminar:"  + pos );
		
		for (int i=pos; i<indicePacientes -1; i++) {
			
			arregloPacientes[i]= arregloPacientes[i+1];
			
		}
		indicePacientes--;
		
	}

	public void adicionar (Paciente x) {
		
		System.out.println("Entro adicionar:" + x);
		
		if (arregloPacientes.length == tamanioP) {
			ampliarArreglo();
			
		}
		
		arregloPacientes[indicePacientes]= x ;
		indicePacientes ++;
	}
	private void ampliarArreglo() {
		Paciente []aux = arregloPacientes;
		tamanioP += 10;
		arregloPacientes = new Paciente[tamanioP];
		
		for (int i=0;i<aux.length;i++)
			arregloPacientes[i]=aux[i];
	
	}
	
	public Paciente obtenerPacientePorDni (String dni) {
		System.out.println("entro buscar codigo Dni: " );
		
		for (int i=0;i<indicePacientes;i++) {
			
			if(arregloPacientes[i].getDniPaciente().equals(dni))
				
				return arregloPacientes[i];
		}
		
		return null;
	}
	
	public Paciente buscarDniPacienteAtencion (String dni) {
		System.out.println("entro buscar codigo Dni: " );
		
		for (int i=0;i<indicePacientes;i++) {
			
			if(arregloPacientes[i].getDniPaciente().equals(dni))
				
				return arregloPacientes[i];
		}
		
		return null;
	}
	
	public Paciente obtenerPaciente(int pos) {
		
		return arregloPacientes[pos];
	}
	public int getIndicePacientes() {
		return indicePacientes;
	}
	public Paciente[]getArregloPacientes(){
		return arregloPacientes;
	}
	
}
