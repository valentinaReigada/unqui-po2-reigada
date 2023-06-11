package ar.edu.unq.po2.tp6;
import java.util.List;
import java.util.ArrayList;

public class Banco {
	private List<Cliente> clientes	= new ArrayList<Cliente>();
	private List<SolicitudDeCredito> solicitudesDeCreditos	=	new ArrayList<SolicitudDeCredito>();
	
	public Banco(List<Cliente> listaClientes) {
		this.clientes	=	listaClientes;
	}
	
	
	public void agregarCliente(Cliente clienteNuevo) {
		clientes.add(clienteNuevo);
	}
	
	public void agregarSolicitud(SolicitudDeCredito solicitud) {
		solicitudesDeCreditos.add(solicitud);
	}
	
	
	public Double totalADesembolsar() {
		Double total = solicitudesDeCreditos.stream()
				.filter(sol-> sol.getEstaAceptada())
				.mapToDouble(sol-> sol.getMontoSolicitado())
				.sum();
		return total ;
	}
	
	
	public void registrarSolicitud(SolicitudDeCredito solicitud) {
		agregarSolicitud(solicitud);
		evaluarSolicitud(solicitud);
	}
	
	
	public void evaluarSolicitud(SolicitudDeCredito solicitud) {
		if(solicitud.cumpleLosRequisitos()) {
			solicitud.setEstaAceptada(true);
		}
	}
}







