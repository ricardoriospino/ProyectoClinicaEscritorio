package clinica.arreglos;

import clinica.beans.Atencion;

public class ArregloAtencion {
	
	public Atencion arregloAtencion[]; // almacena 
	
	public int indiceAtencion;
	
	public int tamanioA = 5;
	
	// constructor
	
	public ArregloAtencion() {
	
	
		System.out.println("Entro constructor");
		
		arregloAtencion = new Atencion[tamanioA];
		
		indiceAtencion = 0;
	
	}
	
	public int buscarPorCodigo (int codigoAtencion) {
		
		System.out.println("entro buscar por codigo:" + codigoAtencion);
		
		for (int i=0;i<indiceAtencion;i++) {
			
			if (arregloAtencion[i].getCodigoAtencion()==codigoAtencion)
				
				return i;
		}
		return -1;
	}
	
	public int nuevoCodigoAtencion() {
		
		return indiceAtencion+1;
	}
	
	public void adicionar (Atencion x) {
		
		if (arregloAtencion.length== tamanioA) {
			
			ampliarArreglo();
		}
		arregloAtencion[indiceAtencion]=x;
		indiceAtencion++;
	}
	
	private void ampliarArreglo() {
		
		Atencion[]aux = arregloAtencion;
		tamanioA +=10;
		arregloAtencion = new Atencion[tamanioA];
		
		
			for (int i=0;i<aux.length;i++)
				arregloAtencion[i]=aux[i];
	}
	
	public Atencion obtenerAtencion(int pos) {
		
		return arregloAtencion[pos];
	}
	public int getIndiceAtencion() {
		return indiceAtencion;
	}
	
	public Atencion[]getArregloAtencion(){
		return arregloAtencion;
	}
	public Atencion[]getAtencion(){
		return arregloAtencion;
	}
	public int getIndicePaciente() {
		return indiceAtencion;
	}
	
	
	
}


