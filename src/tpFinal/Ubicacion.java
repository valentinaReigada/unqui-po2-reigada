package tpFinal;

public class Ubicacion {
	private double latitud;
	private double longitud;
	
	public Ubicacion(int latitud, int longitud) {
		this.latitud		=	latitud;
		this.longitud		=	longitud;
	}
	
	public double getLatitud(){
		return this.latitud;
	}
	
	public double getLongitud(){
		return this.longitud;
	}
	
}
 