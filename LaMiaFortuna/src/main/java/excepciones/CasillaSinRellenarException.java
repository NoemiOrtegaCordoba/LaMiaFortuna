package excepciones;

public class CasillaSinRellenarException extends Exception {

	public CasillaSinRellenarException() {
		
		super("Para jugar debes rellenar todas las casillas de la lotería");
		
	}	
	
	public CasillaSinRellenarException(String mensaje) {
		
		super(mensaje);
		
	}	
	
}
