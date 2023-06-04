package ar.edu.unq.po2.tp6;

public abstract class Cliente {
	protected	String nombre;
	protected	String apellido;
	protected 	String direccion;
	protected	Integer edad;
	protected 	Double sueldoNeto;
	protected 	Banco banco;
	
	
	public Cliente(String nombre, String apellido, String direccion, Integer edad, Double sueldoNeto) {
		this.nombre		=	nombre;
		this.apellido	=	apellido;
		this.direccion	=	direccion;
		this.edad		=	edad;
		this.sueldoNeto	=	sueldoNeto;
	}
	
	public Double getSueldoNeto(){
		return this.sueldoNeto;
	}
	
	public Integer getEdad(){
		return this.edad;
	}

	public void setSueldoNeto(Double sueldoNeto) {
		this.sueldoNeto = sueldoNeto;
	}

	public Double sueldoAnual() {
		return this.getSueldoNeto()*12;
	}
	
	public Double el_DelSueldoNeto(int porcentaje) {
		Double descuento = this.getSueldoNeto() * (porcentaje /100);
		return this.getSueldoNeto() - descuento;
	}
	
	public Boolean tieneIngresosAnualesDe1500oMas() {
		return this.sueldoAnual() >= 1500;
	}
	
	public void pedirPrestamo(SolicitudDeCredito solicitud) {
		banco.registrarSolicitud(solicitud);
	}
	

}
