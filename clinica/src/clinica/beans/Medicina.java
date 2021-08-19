package clinica.beans;

public class Medicina {
	
	private int numMedicina;
	private String nombreMedicina;
	private String nombreLaboratorio;
	private Double precioMedicina;
	private int stockMedicina;
	
	public Medicina() {
		
		
	}

	public Medicina(int numMedicina, String nombreMedicina, String nombreLaboratorio, Double precioMedicina,
			int stockMedicina) {
		super();
		this.numMedicina = numMedicina;
		this.nombreMedicina = nombreMedicina;
		this.nombreLaboratorio = nombreLaboratorio;
		this.precioMedicina = precioMedicina;
		this.stockMedicina = stockMedicina;
	}

	public int getNumMedicina() {
		return numMedicina;
	}

	public void setNumMedicina(int numMedicina) {
		this.numMedicina = numMedicina;
	}

	public String getNombreMedicina() {
		return nombreMedicina;
	}

	public void setNombreMedicina(String nombreMedicina) {
		this.nombreMedicina = nombreMedicina;
	}

	public String getNombreLaboratorio() {
		return nombreLaboratorio;
	}

	public void setNombreLaboratorio(String nombreLaboratorio) {
		this.nombreLaboratorio = nombreLaboratorio;
	}

	public double getPrecioMedicina() {
		return precioMedicina;
	}

	public void setPrecioMedicina(Double precioMedicina) {
		this.precioMedicina = precioMedicina;
	}

	public int getStockMedicina() {
		return stockMedicina;
	}

	public void setStockMedicina(int stockMedicina) {
		this.stockMedicina = stockMedicina;
	}

	public String datosMedicina() {
		
		return "numMedicina: " +this.numMedicina + "  - nombreMedicina: " +this.nombreMedicina  +  "  - nombreLaboratorio: "
				+this.nombreLaboratorio  + "  - precioMedicina: " +this.precioMedicina  +  " -  stockMedicina:"  +this.stockMedicina;
	}
}
