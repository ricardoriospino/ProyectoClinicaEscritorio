package clinica.arreglos;

import clinica.beans.Cama;
import clinica.common.Constantes;

public class ArregloCamas {

	public Cama arregloCamas[];
	public int indiceCamas;// almacena cantidad de camas
	public int tamanioC = 5;
	
	
	//Constructor
	
	public ArregloCamas() {
		
		System.out.println("Entro constructor");
		
		arregloCamas= new Cama[tamanioC];
		indiceCamas= 0;
	}
	
	public int buscarPorCodigo(int numCama ) {
		
		System.out.println("entro buscar por codigo :" + numCama);
		
		for (int i=0;i<indiceCamas;i++) {
			
		   if (arregloCamas[i].getNumCama()==numCama)
			   return i;
			
		}
		
		return -1;	
	}
	
	
	
	public int nuevoCodigoCama() {
		
		return indiceCamas+1;
		
	}
	
	public void modificar (int pos,Cama x) {
		
		System.out.println("Entro modificar");
		
		arregloCamas[pos].setNumCama(x.getNumCama());
		arregloCamas[pos].setCategoria(x.getCategoria());
		arregloCamas[pos].setEstado(x.getEstadoC());

	}
	
	public void eliminar (int pos) {
		
		System.out.println("Entro eliminar:"  + pos);
		
		for(int i=pos; i<indiceCamas-1;i++) {
			arregloCamas[i]=arregloCamas[i+1];
	}
	indiceCamas--;
	
    }
	
	public void adicionar(Cama x) {
		
		System.out.println("Entro adicionar" + x);
		
		if (arregloCamas.length== tamanioC) {
			ampliarArreglo();
		}
		arregloCamas[indiceCamas]= x;
		indiceCamas++;
	}
	private void ampliarArreglo() {
		Cama [] aux = arregloCamas;
		tamanioC +=10;
		arregloCamas = new Cama[tamanioC];
		
		for (int i=0;i<aux.length;i++)
			arregloCamas[i]=aux[i];
		
	}
	
	
		public int obtenerCamaLibre(int CategoriaCama ) {
		
			System.out.println("entro obtener cama libre:" + CategoriaCama);
		
			for (int i=0;i<indiceCamas;i++) {
			
			if(arregloCamas[i].getCategoria()==CategoriaCama
				&& arregloCamas[i].getEstadoC()==Constantes.CAMA_LIBRE)
					
					return arregloCamas[i].getNumCama();
			}
		
			return -1;

		}
	
	public Cama obtenerCama (int pos) {
		return arregloCamas[pos];
	}
	public int getIndiceCamas() {
		return indiceCamas;
	}
	public Cama[]getArregloCamas(){
		return arregloCamas;
	}
	
}
