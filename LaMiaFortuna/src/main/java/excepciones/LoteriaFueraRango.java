package excepciones;

public class LoteriaFueraRango extends Exception {

	public LoteriaFueraRango() {
		
		super("Se ha escrito un número del cartón de lotería fuera del rango admitido: debe estar entre 1 y 50, inclusive");
		
	}	
	
	public LoteriaFueraRango(String mensaje) {
		
		super(mensaje);
		
	}	
	
}
