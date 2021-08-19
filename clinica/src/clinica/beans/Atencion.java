package clinica.beans;

public class Atencion {
	
	private int codigoAtencion;
	private int codigoPaciente;
	private String fechaAtencion;
	private double totalPagar;
	private int estado;
	
	public Atencion() {
		
	}

	
	public Atencion(int codigoAtencion, int codigoPaciente, String fechaAtencion, double totalPagar,
			int estado) {
		super();
		this.codigoAtencion = codigoAtencion;
		this.codigoPaciente = codigoPaciente;
		this.fechaAtencion = fechaAtencion;
		this.totalPagar = totalPagar;
		this.estado = estado;
	}


	

	public int getCodigoAtencion() {
		return codigoAtencion;
	}



	public void setCodigoAtencion(int codigoAtencion) {
		this.codigoAtencion = codigoAtencion;
	}



	public int getCodigoPaciente() {
		return codigoPaciente;
	}



	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}


	


	public String getFechaAtencion() {
		return fechaAtencion;
	}



	public void setFechaAtencion(String fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}



	public double getTotalPagar() {
		return totalPagar;
	}



	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}



	public int getEstado() {
		return estado;
	}



	public void setEstado(int estado) {
		this.estado = estado;
	}



	public String datosAtencion() {
		
		return "codigoAtencion: " +this.codigoAtencion + " - codigoPaciente:" +this.codigoPaciente 
				+ "- fechaAtencion:" +this.fechaAtencion
				+ " totalPagar:" +this.totalPagar  + " - estado: " +this.estado;
	}
	

}
