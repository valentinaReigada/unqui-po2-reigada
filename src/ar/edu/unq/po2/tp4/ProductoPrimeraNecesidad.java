package ar.edu.unq.po2.tp4;

public class ProductoPrimeraNecesidad extends Producto{
	private double porcentaje;
	
	public ProductoPrimeraNecesidad() {}
	
	
	public ProductoPrimeraNecesidad(String nombre, double precio, boolean esPrecioCuidado, double porcentaje) {
		super(nombre, precio, esPrecioCuidado);
		this.porcentaje = porcentaje;
	}
	
	
	@Override
	public double getPrecio() {
		double descuento = super.getPrecio() * (this.porcentaje/100);
		return super.getPrecio() - descuento;
		
	}
}