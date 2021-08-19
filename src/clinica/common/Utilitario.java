package clinica.common;

import java.text.ParseException;
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
	
	
	public static int restarFechas(String fechaInicio, String fechaFin) throws ParseException {
		String formato ="dd/MM/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(formato);


		Date fechaInicial=dateFormat.parse(fechaInicio);
		Date fechaFinal=dateFormat.parse(fechaFin);

		int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000); //  milisegundos

		 
		//System.out.println("Hay "+dias+" dias de diferencia");
		return dias+1;
	}
	
	
//	public static void main(String[] args) {
//		
//		try {
//			int resta = restarFechas("11/10/2019", "11/10/2019");
//			
//			System.out.println(resta);
//			
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//	}

}
