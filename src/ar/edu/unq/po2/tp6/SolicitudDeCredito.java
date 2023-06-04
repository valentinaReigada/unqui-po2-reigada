package ar.edu.unq.po2.tp6;

public abstract class SolicitudDeCredito {
	private Double 	montoSolicitado;
	private Integer plazosEnMeses;
	private Cliente clienteAsociado;
	private Boolean estaAceptada 	=	false;
	
	public SolicitudDeCredito(Cliente clienteAsociado, Double montoSolicitado, Integer plazosEnMeses) {
		this.clienteAsociado	=	clienteAsociado;
		this.montoSolicitado	=	montoSolicitado;
		this.clienteAsociado	=	clienteAsociado;
	}
	
	public void setEstaAceptada(Boolean estado) {
		this.estaAceptada	=	estado;
	}
	
	public Boolean getEstaAceptada() {
		return this.estaAceptada	;
	}
	
	public Double getMontoSolicitado() {
		return this.montoSolicitado;
	}
	
	public Integer getPlazosEnMeses() {
		return this.plazosEnMeses;
	}
	
	public Cliente getClienteAsociado() {
		return this.clienteAsociado;
	}
	
	public Double montoDeCuotaMensual(){
		return this.getMontoSolicitado() / this.getPlazosEnMeses();
	}
	
	
	public Boolean tieneCuotasMenoresAl_DelSueldoCliente(int porcentaje) {
		return this.montoDeCuotaMensual() < this.clienteAsociado.el_DelSueldoNeto(porcentaje);
	}
	
	public abstract Boolean cumpleLosRequisitos();
}



