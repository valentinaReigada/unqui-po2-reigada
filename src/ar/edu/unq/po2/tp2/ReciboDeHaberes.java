package ar.edu.unq.po2.tp2;
import java.time.LocalDate;
import java.time.Period;


public class ReciboDeHaberes {
	protected String nombreDelEmpleado;
	protected String direccion;
	protected String fechaEmision;
	protected double sueldoBruto;
	protected double sueldoNeto;
	protected String informacion;
	
	public  ReciboDeHaberes(String nombreDelEmpleado, String direccion, double sueldoBruto, double sueldoNeto) {
		this.nombreDelEmpleado	=	nombreDelEmpleado;
		this.direccion	=	direccion;
		this.fechaEmision	=	LocalDate.now().toString();
		this.sueldoBruto	=	sueldoBruto;
		this.sueldoNeto		=	sueldoNeto;
		
	}
	
}
