package ar.edu.unq.po2.tp2;
import java.util.ArrayList;
import java.util.List;



public  class Empresa {
	private String nombre;
	private String cuit;
	private List<Empleado> listaDeEmpleados = new ArrayList<Empleado>();
	private List<ReciboDeHaberes> recibosDeHaberes = new ArrayList<ReciboDeHaberes>();

	
	public Empresa(String nombre, String cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
	};
	
	private double  montoTotal() {
		return this.listaDeEmpleados.stream().mapToDouble(empleado -> empleado.sueldoNeto()).sum() ;
	};
	
	private double  totalSueldosBrutos() {
		return this.listaDeEmpleados.stream().mapToDouble(empleado -> empleado.sueldoBruto()).sum() ;
	};
	
	private double  totalRetenciones() {
		return this.listaDeEmpleados.stream().mapToDouble(empleado -> empleado.retenciones()).sum() ;
	};
	
	public void guardarRecibo(ReciboDeHaberes recibo) {
		this.recibosDeHaberes.add(recibo);
	}
	public ReciboDeHaberes reciboDe(Empleado empleado) {
		ReciboDeHaberes recibo	=	new ReciboDeHaberes(empleado.getNombre(), empleado.getDireccion(), empleado.sueldoBruto(), empleado.sueldoNeto());
		return recibo;
	}
	
	private void generarYGuardarReciboDe(Empleado empleado) {
		this.guardarRecibo(this.reciboDe(empleado));
	}
	
	
	private void  liquidarSueldos() {
		listaDeEmpleados.forEach(empleado  -> this.generarYGuardarReciboDe(empleado));	
	};
	
}








