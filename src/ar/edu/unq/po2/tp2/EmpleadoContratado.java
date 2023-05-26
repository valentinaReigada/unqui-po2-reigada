package ar.edu.unq.po2.tp2;

public class EmpleadoContratado extends Empleado {

	private int nroContrato;
	private String medioDePago;
	
	//CONSTRUCTOR.
	public EmpleadoContratado(String nombre, String direccion, String estadoCivil, String fechaNacimiento, double sueldoBasico, int nroContratado, String medioDePago) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.nroContrato	=	nroContratado;
		this.medioDePago	=	medioDePago;
		
	}
	
	public void setNroContrato(int nro) {
		this.nroContrato	=	nro;
	
	}
	public void setmedioDePago(String medioDePago) {
		this.medioDePago	=	medioDePago;
	}
	
	public int getNroContrato() {
		return this.nroContrato;
	}
	public String getMedioDePago() {
		return this.medioDePago;
	}

	public double sueldoBruto() {
		return this.getSueldoBasico();
	};
	
	public double retenciones() {
		return 50;
	};
	
	public double sueldoNeto() {
		return this.sueldoBruto() - this.retenciones();
	};
	
}
	


/*
 * El sueldo bruto de este tipo de empleados es igual a:
 *  su sueldo básico,
 *   pero su sueldo neto varía ya que tienen una retención constante igual a $50
 *    en concepto de “Gastos Administrativos Contractuales”.*/
















