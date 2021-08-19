package clinica.beans;

public class Internamiento {

	private int codigoInternamiento;
	private int numeroCama;
	private int codigoPaciente;
	private String fechaIngreso;
	private String horaIngreso;
	private String fechaSalida;
	private String horaSalida;
	private int estado;
	
	public Internamiento() {
		
	}

	
	public Internamiento(int codigoInternamiento, int numeroCama, int codigoPaciente, String fechaIngreso,
			String horaIngreso, String fechaSalida, String horaSalida, int estado) {
		super();
		this.codigoInternamiento = codigoInternamiento;
		this.numeroCama = numeroCama;
		this.codigoPaciente = codigoPaciente;
		this.fechaIngreso = fechaIngreso;
		this.horaIngreso = horaIngreso;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.estado = estado;
	}


	public int getCodigoInternamiento() {
		return codigoInternamiento;
	}


	public void setCodigoInternamiento(int codigoInternamiento) {
		this.codigoInternamiento = codigoInternamiento;
	}


	public int getNumeroCama() {
		return numeroCama;
	}


	public void setNumeroCama(int numeroCama) {
		this.numeroCama = numeroCama;
	}


	public int getNumeroPaciente() {
		return codigoPaciente;
	}


	public void setNumeroPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}


	public String getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public String getHoraIngreso() {
		return horaIngreso;
	}


	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}


	public String getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public String getHoraSalida() {
		return horaSalida;
	}


	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	
	public String datosInternamiento() {
		return "CodigoInternamiento: " +this.codigoInternamiento + "  - numeroCama: " +this.numeroCama + " - codigoPaciente: " +this.codigoPaciente
				+ " fechaIngreso: " +this.fechaIngreso + " - horaIngreso: " +this.horaIngreso + " - fechaSalida:" +this.fechaSalida
				+ " horaSalida: " +this.horaSalida + " - estado: " +this.estado ;
	}
}
