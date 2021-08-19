package clinica.arreglos;

import clinica.beans.Medicina;

public class ArregloMedicinas {
	
	public Medicina arregloMedicinas[] ;
	public int indiceMedicinas; //almacena cantidad de medicinas
	public int tamanioM = 5;
	
	//Constructor
	
	public ArregloMedicinas() {
		System.out.println("Entro Constructor");
		
		arregloMedicinas = new Medicina[tamanioM];
		indiceMedicinas =0;
	}
	
	public int buscarPorCodigo(int numMedicinas) {
		System.out.println("entro buscador codigo: " + numMedicinas);
		
		for (int i=0;i<indiceMedicinas;i++) {
			
			if (arregloMedicinas[i].getNumMedicina()==numMedicinas)
				return i;
		}
		
		return -1;
	}
	
	public int nuevoCodigoMedicina() {
		
		return indiceMedicinas+1;
		
	}
	
	public void modificar (int pos,Medicina M) {
		
		System.out.println("entro modificador");
		
		arregloMedicinas[pos].setNumMedicina(M.getNumMedicina());
		arregloMedicinas[pos].setNombreMedicina(M.getNombreMedicina());
		arregloMedicinas[pos].setNombreLaboratorio(M.getNombreLaboratorio());
		arregloMedicinas[pos].setPrecioMedicina(M.getPrecioMedicina());
		arregloMedicinas[pos].setStockMedicina(M.getStockMedicina());
	}
	
	public Medicina obtenerMedicinaPorCodigo (int codigo) {
		System.out.println("entro obtenerMedicinaPorCodigo: " );
		
		for (int i=0;i<indiceMedicinas;i++) {
			
			if(arregloMedicinas[i].getNumMedicina()==codigo)
				
				return arregloMedicinas[i];
		}
		
		return null;
	}
	
		
	
	
	
	public void eliminar (int pos) {
		System.out.println("Entro eliminar:"  + pos);
		
		for (int i=pos;i<indiceMedicinas-1; i++) {
			
			arregloMedicinas[i]= arregloMedicinas[i+1];
			
		}
		
		indiceMedicinas --;
		
	}

	public void adicionar(Medicina M) {
		
		System.out.println("Entro adicionar" + M);
		
		if ( arregloMedicinas.length == tamanioM) {
			
			ampliarArreglo();
		}
		arregloMedicinas[indiceMedicinas]=M;
		indiceMedicinas++;
		
	}

	private void ampliarArreglo() {
		Medicina[]aux = arregloMedicinas;
			
			tamanioM +=10;
			arregloMedicinas=new Medicina[tamanioM];
			
			for(int i=0;i<aux.length;i++)
				arregloMedicinas[i]=aux[i];
		}
	
	public Medicina obtenerNombreMedicina (String nombreMedicina) {
		System.out.println("entro buscar nombre medicina: " );
		
		for (int i=0;i<indiceMedicinas;i++) {
			
			if(arregloMedicinas[i].getNombreMedicina().equals(nombreMedicina))
				
				return arregloMedicinas[i];
		}
		
		return null;
	}
	
	public Medicina obtenerMedicina (int pos) {
		
		return arregloMedicinas[pos];
		
	}
	public int getIndiceMedicinas() {
		return indiceMedicinas;
	}
	public Medicina[]getArregloMedicinas(){
		return arregloMedicinas;
	}

}
