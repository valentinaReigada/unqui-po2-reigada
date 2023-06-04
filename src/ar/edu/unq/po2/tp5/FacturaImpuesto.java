package ar.edu.unq.po2.tp5;

public class FacturaImpuesto extends Factura{
	double valorDelServicio;
	
	public FacturaImpuesto(double valorDelServicio) {
		this.valorDelServicio	= valorDelServicio;
	}
	
	public double montoAPagar() {
		return this.valorDelServicio;
	}
}
