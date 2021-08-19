package clinica.common;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;



public class Validaciones {
	
	public void  validarSoloNumeros(JTextField campo) {
		campo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)){
					e.consume();
				}
				}
			
		});	
	}
	public void  validarSoloLetras(JTextField campo) {
		campo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(Character.isDigit(c)){
					e.consume();
				}
				}
			
		});	
	}
	public void  limitarCaracteres(JTextField campo,int cantidad) {
		campo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				int tam = campo.getText().length();
				if(tam>=cantidad) {
					e.consume();
					
				}	
				}
			
		});	
	}
}



	
	



