package ar.edu.unq.po2.tp5;

public class ProductoDeCooperativa  extends Producto{
	int descuento;
	
	public ProductoDeCooperativa(int codigo, String nombre, double precio, int descuento) {
		super(codigo, nombre, precio);
		this.descuento	=	descuento;
	}
	
	@Override
	public double getPrecio() {
		return super.getPrecio() - (super.getPrecio() * (this.descuento / 100));
	}
	
}
