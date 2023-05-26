package ar.edu.unq.po2.tp5;

public abstract class Producto {
	int codigo;
	String nombre;
	double precio;
	
	
	public Producto(int codigo, String nombre, double precio) {
		this.codigo	=	codigo;
		this.nombre	=	nombre;
		this.precio	=	precio;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	
	
	
}
