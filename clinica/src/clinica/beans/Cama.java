package clinica.beans;

public class Cama {
	
	private int numCama;
	private int categoria;
	private int estado;
	
	public Cama() {
		
	}
	

	
	public Cama(int numCama, int categoria, int estado) {
		super();
		this.numCama = numCama;
		this.categoria = categoria;
		this.estado = estado;
	}



	

	public int getNumCama() {
		return numCama;
	}



	public void setNumCama(int numCama) {
		this.numCama = numCama;
	}



	public int getCategoria() {
		return categoria;
	}



	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}



	public int getEstadoC() {
		return estado;
	}



	public void setEstado(int estado) {
		this.estado = estado;
	}



	public String datosCama() {
		
		return "numCama: " +this.numCama + "  - categoria: " +this.categoria + "  - estado: "  +this.estado;
	}
	
}	

