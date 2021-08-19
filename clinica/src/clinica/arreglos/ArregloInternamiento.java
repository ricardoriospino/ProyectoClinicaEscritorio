package clinica.arreglos;

import clinica.beans.Internamiento;

public class ArregloInternamiento {
	
	public Internamiento arregloInternamiento[];
	
	public int indiceInternamiento; // almacena 
	public int indicePacientes;
	public int indiceCamas;
	public int tamanioI = 5;
	
	// constructor 
	
	public ArregloInternamiento() {
		
		System.out.println("Entro Constructor Internamiento");
		
		arregloInternamiento = new Internamiento[tamanioI];
		indiceInternamiento=0;
	}
	
	public int  buscarPorCodigo (int codigoInternamiento) {
		
		System.out.println("entro buscar por codigo:" + codigoInternamiento);
		
		for(int i=0;i<indiceInternamiento;i++) {
			
			if (arregloInternamiento[i].getCodigoInternamiento()==codigoInternamiento)
				
				return i;
		}
		
		return -1;
	}
	
	
	
	public int nuevoCodigoInternamiento() {
		
		return indiceInternamiento+1;
		
	}
	
	public void adicionar (Internamiento x) {
		
		if (arregloInternamiento.length== tamanioI) {
			ampliarArreglo();
		}
		arregloInternamiento[indiceInternamiento]=x;
		indiceInternamiento++;
	}
	
	
	private void ampliarArreglo() {
		
		Internamiento[]aux = arregloInternamiento;
		tamanioI += 10;
		arregloInternamiento = new Internamiento[tamanioI];
		
		
		for (int i=0;i<aux.length;i++)
			arregloInternamiento[i]=aux[i];
		
	}
	
	public Internamiento obtenerInternamiento(int pos) {
		return arregloInternamiento[pos];
	}
	public int getIndiceInternamiento() {
		return indiceInternamiento;
	}
	public Internamiento[]getArregloInternamiento(){
		return arregloInternamiento;
	}
	
	public int  getIndicePaciente() {
		return indicePacientes;
	}
	
}
