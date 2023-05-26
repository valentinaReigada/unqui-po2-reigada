package ar.edu.unq.po2.tp4;

public class IngresoPorHorasExtras extends Ingreso {
	private int cantidadDeHorasExtras;

	public IngresoPorHorasExtras(String mes, String concepto, double monto, int cantidadDeHorasExtras) {
		super(mes, concepto, monto);
		this.cantidadDeHorasExtras = cantidadDeHorasExtras;
	}
	
	

}
