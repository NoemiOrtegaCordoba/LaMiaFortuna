package clases;

public class CartonLoteria extends CosaComprable {

    private byte[][] casillas;

    public CartonLoteria(double precio) {
		super(precio);
	}
    
	public CartonLoteria(double precio, byte[][] casillas) {
		super(precio);
		this.casillas = casillas;
	}

	public byte[][] getCasillas() {
		return casillas;
	}

	public void setCasillas(byte[][] casillas) {
		this.casillas = casillas;
	}
    
    
}
