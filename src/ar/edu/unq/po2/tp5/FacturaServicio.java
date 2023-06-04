package ar.edu.unq.po2.tp5;

public class FacturaServicio extends Factura{
	double costoPorUnidad;
	int cantidadConsumida;
	
	public FacturaServicio(double costoPorUnidad, int cantidadConsumida) {
		this.costoPorUnidad 	= costoPorUnidad;
		this.cantidadConsumida	= cantidadConsumida;
	};
	
	public double montoAPagar() {
		return this.costoPorUnidad * this.cantidadConsumida;
	}
	

}
