package clinica.beans;

public class Paciente {

	private int numPaciente;
	private String nombresPaciente;
	private String apellidosPaciente;
	private String dniPaciente;
	private String telefonoPaciente;
	
	public Paciente() {
		
		
	}
	
	public Paciente(int numPaciente, String nombresPaciente, String apellidosPaciente, String dniPaciente,
			String telefonoPaciente) {
		super();
		this.numPaciente = numPaciente;
		this.nombresPaciente = nombresPaciente;
		this.apellidosPaciente = apellidosPaciente;
		this.dniPaciente = dniPaciente;
		this.telefonoPaciente = telefonoPaciente;
	}


	
	public int getNumPaciente() {
		return numPaciente;
	}

	public void setNumPaciente(int numPaciente) {
		this.numPaciente = numPaciente;
	}

	public String getNombresPaciente() {
		return nombresPaciente;
	}

	public void setNombresPaciente(String nombresPaciente) {
		this.nombresPaciente = nombresPaciente;
	}

	public String getApellidosPaciente() {
		return apellidosPaciente;
	}

	public void setApellidosPaciente(String apellidosPaciente) {
		this.apellidosPaciente = apellidosPaciente;
	}

	public String getDniPaciente() {
		return dniPaciente;
	}

	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente = dniPaciente;
	}

	public String getTelefonoPaciente() {
		return telefonoPaciente;
	}

	public void setTelefonoPaciente(String telefonoPaciente) {
		this.telefonoPaciente = telefonoPaciente;
	}

	public String datosPaciente() {
		
		
		return "numPaciente: " +this.numPaciente  +  "  - nombresPaciente: "+this.nombresPaciente  + " - apellidosPaciente:  " +this.apellidosPaciente + 
				"dniPaciente: "+this.dniPaciente  +  "   -telefonoPaciente: "+this.telefonoPaciente;
	}
}
