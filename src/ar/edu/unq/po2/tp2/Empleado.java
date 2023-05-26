package ar.edu.unq.po2.tp2;
import java.time.LocalDate;
import java.time.Period;


public abstract class Empleado{
	
	protected String nombre;
	protected String direccion;
	protected String estadoCivil;
	protected String fechaNacimiento;
	protected double sueldoBasico;
	
	//CONSTRUCTOR.
	public Empleado(String nombre, String direccion, String estadoCivil, String fechaNacimiento, double sueldoBasico) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
	
	}	
	
	public double getSueldoBasico() {
		return this.sueldoBasico;
	}
	public String getEstadoCivil() {
		return this.estadoCivil;
	}
	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	public String getDireccion() {
		return this.direccion;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setSueldoBasico(double nuevoSueldo) {
		this.sueldoBasico = nuevoSueldo;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil	=	estadoCivil;
	}
	public void setFechaNacimiento(String fechaNac) {
		this.fechaNacimiento	=	fechaNac;
	}
	public void setDireccion(String nuevaDireccion) {
		this.direccion	=	nuevaDireccion;
	}
	public void setNombre(String nombre) {
		this.nombre	=	nombre;
	}
	
	
	public int edad(){
         // Formato: yyyy-MM-dd 
        LocalDate fechaNac = LocalDate.parse(this.fechaNacimiento);        
        // Fecha actual
        LocalDate fechaActual = LocalDate.now();
        // Calculamos la edad
        Period periodo = Period.between(fechaNac, fechaActual);
        int edad = periodo.getYears();
        return edad;
	}
	
	abstract double sueldoNeto();
	abstract double sueldoBruto();
	abstract double	retenciones();

}


//Es una clase abstracta, esto nos indica que no podemos instanciar objetos
/*
 * Es una clase abstracta, esto nos indica que no podemos instanciar objetos de la clase Empleado directamente,
 * debemos instanciar objetos de las subClases de Empleado.
 * La clase abstracta puede contener metodos abstractos (que no tienen implementación) y metodos concretos
 * (que tienen implementación). Los metodos abstractos deben ser implementados por las subclases que extienden
 * de la clase abstracta, mientras que los metodos concretos se heredan por las subclases.
 * Una de las principales ventajas de las clases abstractas es que permiten definir 
 * una funcionalidad común para un conjunto de subclases, evitando así la duplicación de código. 
 * Además, también se utilizan para definir una interfaz común para un conjunto de clases, 
 * lo que facilita el trabajo con diferentes implementaciones de la misma funcionalidad.
 * 
 * 
 * 
 * */















