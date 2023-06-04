package ar.edu.unq.po2.tp6;

public class CreditoPersonal extends SolicitudDeCredito{
	
	public CreditoPersonal(Cliente clienteAsociado, Double montoSolicitado, Integer plazosEnMeses) {
		super(clienteAsociado, montoSolicitado, plazosEnMeses);
	}
	

	
	public Boolean cumpleLosRequisitos() {
		return this.getClienteAsociado().tieneIngresosAnualesDe1500oMas() &&
			   this.tieneCuotasMenoresAl_DelSueldoCliente(70);
	}
}
