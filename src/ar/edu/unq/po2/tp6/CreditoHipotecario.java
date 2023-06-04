package ar.edu.unq.po2.tp6;


public class CreditoHipotecario extends SolicitudDeCredito{
	private PropiedadInmobiliaria propiedad;
	
	public CreditoHipotecario(Cliente clienteAsociado, Double montoSolicitado, Integer plazosEnMeses, PropiedadInmobiliaria propiedad) {
		super(clienteAsociado, montoSolicitado, plazosEnMeses);
		this.propiedad	=	propiedad;
	}

	public PropiedadInmobiliaria getPropiedad() {
		return this.propiedad;
	}
	
	public Boolean laSolicitudEsMenorAl_DelValorFiscal(int porcentaje) {
		return this.getMontoSolicitado() < this.getPropiedad().el_DelValorFiscal(porcentaje);
	}
	
	public int totalDeAñosSegunCuotas() {
		int años = this.getPlazosEnMeses() / 12;
		int cantidadFinal	= años > 0 ? años : 0;
		return cantidadFinal;
	}
	
	
	public Boolean terminaElCreditoAntesDeLos65() {
		return this.getClienteAsociado().getEdad() + this.totalDeAñosSegunCuotas() < 65;
	}
	
	
	public Boolean cumpleLosRequisitos() {
		return this.tieneCuotasMenoresAl_DelSueldoCliente(50) &&  this.laSolicitudEsMenorAl_DelValorFiscal(70) 
				&& this.terminaElCreditoAntesDeLos65() ;
	}
	
	
}






