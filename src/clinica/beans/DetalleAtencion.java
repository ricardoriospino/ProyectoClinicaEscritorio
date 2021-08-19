package clinica.beans;

public class DetalleAtencion {
	
	private int codigoAtencion;
	private int codigoMedicina;
	private int cantidad;
	private double precioUnitario;
	
	
	// MEJORAS 
	
	private String nombreMedicina;
	private double subTotal;
	
	public DetalleAtencion() {
		
		
	}
	
	
	public DetalleAtencion(int codigoAtencion, int codigoMedicina, int cantidad, double precioUnitario,
			String nombreMedicina, double subTotal) {
		super();
		this.codigoAtencion = codigoAtencion;
		this.codigoMedicina = codigoMedicina;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.nombreMedicina = nombreMedicina;
		this.subTotal = subTotal;
	}


	public int getCodigoAtencion() {
		return codigoAtencion;
	}


	public void setCodigoAtencion(int codigoAtencion) {
		this.codigoAtencion = codigoAtencion;
	}


	public int getCodigoMedicina() {
		return codigoMedicina;
	}


	public void setCodigoMedicina(int codigoMedicina) {
		this.codigoMedicina = codigoMedicina;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public String getNombreMedicina() {
		return nombreMedicina;
	}


	public void setNombreMedicina(String nombreMedicina) {
		this.nombreMedicina = nombreMedicina;
	}


	public double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}


	public String datosdetalleAtencion() {
		
		return " codigoAtencion:" +this.codigoAtencion + "  - codigoMedicina: " +this.codigoMedicina + " - cantidad: " +this.cantidad
				+ "  - precioUnitario:" +this.precioUnitario;
	}
	

}
