package ar.edu.unq.po2.tp4;
import java.util.ArrayList;
import java.util.List;


public class Trabajador {
	private List<Ingreso> ingresosNormales = new ArrayList<Ingreso>();
	private List<Ingreso> ingresosHorasExtras	= new ArrayList<Ingreso>();
	
	
	public double impuestosAPagar() {
		//retornar el monto a pagar por el trabajador, calculado como el 2% del monto imponible
		double impuestosAPagar = this.getMontoImponible() * 2 / 100;
		return impuestosAPagar;
	}
	
	public double totalDeIngresos(List<Ingreso> ingresos) {
		return ingresos.stream().mapToDouble(ingreso -> ingreso.getMonto()).sum();
	}
	
	
	public double getMontoImponible() {//retornar el monto imponible al impuesto al trabajador
		return this.totalDeIngresos(this.ingresosNormales);
	}
	
	public double getTotalPercibido () {//retornar el monto total percibido por el trabajador
		return this.totalDeIngresos(this.ingresosNormales) +  this.totalDeIngresos(this.ingresosHorasExtras);
	}

}
