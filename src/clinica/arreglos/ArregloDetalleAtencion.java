package clinica.arreglos;

import clinica.beans.Atencion;
import clinica.beans.DetalleAtencion;

public class ArregloDetalleAtencion{
	
	public DetalleAtencion arregloDetalleAtencion[]; //almacena
	
	public int indiceDetalleAtencion;

	public int tamanioA = 5;
	
	
	public  ArregloDetalleAtencion() { 
		
			System.out.println("entro constructor ArregloDetalleAtencion");
		
			arregloDetalleAtencion = new DetalleAtencion [tamanioA];
			
			indiceDetalleAtencion =0;
	}
	
	public int nuevoCodigoAtencion() {
		
			return indiceDetalleAtencion+1;
	}
	
	public void adicionar (DetalleAtencion x) {
		
			if (arregloDetalleAtencion.length== tamanioA) {
			
			ampliarArreglo();
			}
			arregloDetalleAtencion[indiceDetalleAtencion]=x;
			indiceDetalleAtencion++;
	}
	
	private void ampliarArreglo() {
		
		DetalleAtencion[]aux = arregloDetalleAtencion;
		tamanioA +=10;
		arregloDetalleAtencion = new DetalleAtencion[tamanioA];
		
		
			for (int i=0;i<aux.length;i++)
				arregloDetalleAtencion[i]=aux[i];
	}

	public int getIndiceDetalleAtencion() {
		return indiceDetalleAtencion;
	}

	public void setIndiceDetalleAtencion(int indiceDetalleAtencion) {
		this.indiceDetalleAtencion = indiceDetalleAtencion;
	}

	public DetalleAtencion[] getArregloDetalleAtencion() {
		return arregloDetalleAtencion;
	}

	public void setArregloDetalleAtencion(DetalleAtencion[] arregloDetalleAtencion) {
		this.arregloDetalleAtencion = arregloDetalleAtencion;
	}
	
	
	
	
	

}
