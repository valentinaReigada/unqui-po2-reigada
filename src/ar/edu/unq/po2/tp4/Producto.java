package ar.edu.unq.po2.tp4;

public class Producto {
	private String nombre;
	private double precio;
	private boolean esPrecioCuidado = false;
	
	
	public Producto(String nombre, double precio, boolean esPrecioCuidado) {
		this.nombre = nombre;
		this.precio = precio;
		this.esPrecioCuidado = esPrecioCuidado;
	}

	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public Producto() {

	}
	
	

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public void setEsPrecioCuidado(boolean esPrecioCuidado) {
		this.esPrecioCuidado = esPrecioCuidado;
	}
	
	
	public boolean esPrecioCuidado() {
		return esPrecioCuidado;
	}

	
	public void aumentarPrecio(double nuevoPrecio) {
		this.precio += nuevoPrecio;
	}
	 
}
