package ar.edu.unq.po2.tp2;

public class EmpleadoPlantaPermanente extends Empleado {
	private int cantidadDeHijos;
	private int antiguedad;
	
	//CONSTRUCTOR.
	public EmpleadoPlantaPermanente(String nombre, String direccion, String estadoCivil, String fechaNacimiento, double sueldoBasico, int cantidadDeHijos, int antiguedad) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.cantidadDeHijos	=	cantidadDeHijos;
		this.antiguedad	=	antiguedad;
	}
	
	public int getAntiguedad() {
		return this.antiguedad;
	}
	public int getCantidadDeHijos() {
		return this.cantidadDeHijos;
	}
	
	
	private int asignacionSalarioFamiliar(){
		return 150 * this.cantidadDeHijos;
	}
	private int asignacionPorConyuge() {
		return (this.getEstadoCivil() == "CASADO" || this.getEstadoCivil() == "CASADA") ? 100 : 0;
	}
	
	private int asignacionPorAntiguedad() {
		return 50 * this.getAntiguedad();
	}
	
	public double sueldoBruto() {
		return this.getSueldoBasico() + this.asignacionSalarioFamiliar()  +  this.asignacionPorConyuge() + this.asignacionPorAntiguedad();
	};
	
	public int retencionPorCantHijos() {
		return 20 * this.getCantidadDeHijos();
	}
	public double retencionPorObraSocial() {
		return this.sueldoBruto() * 0.1;
	}
	
	
	public double retencionesTotalesPorObraSocial() {
		return this.retencionPorObraSocial() + this.retencionPorCantHijos();
	}
	
	public double retencionPorAportesJubilatorios() {
		return this.sueldoBruto() * 0.15;
	}
	
	
	public double retenciones() {
		return this.retencionesTotalesPorObraSocial() + this.retencionPorAportesJubilatorios();
		
	};
	
	
	public double sueldoNeto() {
		return this.sueldoBruto() - this.retenciones();
	};
	

}

/*
 *  
El sueldo bruto del empleado de planta permanente se compone de:
Sueldo Básico
Salario Familiar, que se compone de: Asignación por hijo: $150 por cada hijo.
Asignación por cónyuge: $100 si tiene cónyuge
 Antigüedad: $50 por cada año de antigüedad.
 
Las retenciones que se realizan a este empleado son:
Obra Social: 10% de su sueldo bruto + $20 por cada hijo. 
Aportes Jubilatorios: 15% de su sueldo bruto

*
*/













