package clinica.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilitario {
	
	
	// metodo de vulve la fecha actual 
	public static String obtenerFechaActualddMMyyyy() {
		
		
		String formato = "dd/MM/yyyy";
		// fecha de hoy en tipo de dato date 
		
		
		Date fecha = new Date();
		
		SimpleDateFormat sformat = new SimpleDateFormat(formato);
		
		
		// convertir de date a String 
		String fechaFormateada = sformat.format(fecha);
		
		System.out.println("fechaFormateada:"+ fechaFormateada);
		
		return fechaFormateada;
		
		
	}
	
	public static String obtenerHora () {
		
		String formato = "HH:mm";
		
		
		// fecha de hoy en tipo de dato date 
		Date fecha = new Date();
		
		SimpleDateFormat sformat = new SimpleDateFormat(formato);
		
		// convertir de date a String 
		String horaFormateada = sformat.format(fecha);
				
		System.out.println("fechaFormateada:"+ horaFormateada);
		
		return horaFormateada;
	}

}
