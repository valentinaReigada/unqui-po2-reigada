package ar.edu.unq.po2.tp6;

public class PropiedadInmobiliaria {
	private String descripcion;
	private String direccion;
	private Double valorFiscal;
	
	public PropiedadInmobiliaria(String descripcion, String direccion, Double valorFiscal) {
		this.descripcion	=	descripcion;
		this.direccion		=	direccion;
		this.valorFiscal	=	valorFiscal;
	}
	
	public Double getValorFiscal() {
		return this.valorFiscal;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public double el_DelValorFiscal(int porcentaje) {
		Double descuento = this.getValorFiscal() * (porcentaje/100);
		return this.getValorFiscal() - descuento;
	}
}

