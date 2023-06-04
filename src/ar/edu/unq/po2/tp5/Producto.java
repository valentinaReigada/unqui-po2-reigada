package ar.edu.unq.po2.tp5;

public abstract class Producto {
	protected int codigo;
	protected String nombre;
	protected double precio;
		
	public int getCodigo() {
		return codigo;
	}

	
	public abstract double getPrecio();
	
}
