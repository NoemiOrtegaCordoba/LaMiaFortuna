package excepciones;

public class CartonesCeroException extends Exception {

	public CartonesCeroException() {
		
		super("Para jugar necesitas pones sobre la mesa algún cartón de bingo");
		
	}	
	
	public CartonesCeroException(String mensaje) {
		
		super(mensaje);
		
	}
	
}
