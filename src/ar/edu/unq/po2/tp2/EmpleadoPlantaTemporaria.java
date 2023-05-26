package ar.edu.unq.po2.tp2;

public class EmpleadoPlantaTemporaria extends Empleado{
	private String fechaFin;
	private int cantidadHorasExtras;
	
	//CONSTRUCTOR.
	public EmpleadoPlantaTemporaria(String nombre, String direccion, String estadoCivil, String fechaNacimiento, double sueldoBasico, String fechaFin, int cantidadDeHorasExtras) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.fechaFin	=	fechaFin;
		this.cantidadHorasExtras	=	cantidadDeHorasExtras;
		
	}
	
	public String getFechaFin() {
		return this.fechaFin;
	}
	public void setFechaFin(String fecha) {
		this.fechaFin	=	fecha;
	}
	
	public int getCantidadDeHorasExtras() {
		return this.cantidadHorasExtras;
	}
	
	public void setCantidadDeHorasExtras(int horasDedicadas) {
		this.cantidadHorasExtras	=	horasDedicadas;
	}
	
	public int gananciasPorHorasExtras() {
		return  40 * this.getCantidadDeHorasExtras() ;
	}
	
	public double sueldoBruto() {
		return this.getSueldoBasico() + this.gananciasPorHorasExtras();
	};
	
	public int retencionDeObraSocialPorEdad() {
		return this.edad() > 50 ? 25 : 0;
	}
	public double retencionDeObraSocial() {
		return this.sueldoBruto()  * 0.1;
	}
	
	public double retencionesTotalesDeObraSocial() {
		return this.retencionDeObraSocial() + this.retencionDeObraSocialPorEdad();
	}
	
	public int  retencionPorCantHorasExtras() {
		return this.getCantidadDeHorasExtras() * 5;
	}
	public double retencionPorAportesJubilatorios() {
		return this.sueldoBruto() * 0.1;
	}
	
	public double retencionesTotalesPorAportesJubilatorios() {
		return this.retencionPorCantHorasExtras() + this.retencionPorAportesJubilatorios();
	}
	
	public double retenciones() {
		return this.retencionesTotalesDeObraSocial() + this.retencionesTotalesPorAportesJubilatorios();
		
	};
	
	
	public double sueldoNeto() {
		return this.sueldoBruto() - this.retenciones();
	};
}


/**
 * el sueldo bruto del empleado de planta temporaria se compone de:
Sueldo Básico
Horas Extras: $40 por cada hora extra

Las retenciones que se realizan a este empleado son:
Obra Social: 10% de su sueldo bruto + $25 si supera los 50 años
 Aportes Jubilatorios: 10% de su sueldo bruto + $5 por cada hora extra.
 * /
 */












