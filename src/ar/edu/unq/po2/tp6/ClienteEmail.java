package ar.edu.unq.po2.tp6;

import java.util.List;

import java.util.ArrayList;


public class ClienteEmail {
	private Usuario usuario;
	private IServidorGestionCorreo servidor;
	private List<Correo> inbox		=	new ArrayList<Correo>();
	private List<Correo> borrados	=	new ArrayList<Correo>();
	
	
	public ClienteEmail(Usuario usuario, IServidorGestionCorreo servidor) {
		this.usuario	=	usuario;
		this.servidor	=	servidor;
		this.conectar();
	}

	
	public void conectar() {
		this.servidor.conectar(usuario);
	}
	
	public void borrarCorreo(Correo correo){
		this.inbox.remove(correo);
		this.borrados.add(correo);
	}
	
	public int contarBorrados(){
		return this.borrados.size();
	}
	
	public int contarInbox(){
		return this.inbox.size();
	}
	
	public void eliminarBorrado(Correo correo){
		this.borrados.remove(correo);
	}
	
	public void recibirNuevos(){
		this.servidor.recibirNuevos(usuario);
	}
	
	public void enviarCorreo(Correo correo){
		this.servidor.enviar(correo);
	}
	
}
