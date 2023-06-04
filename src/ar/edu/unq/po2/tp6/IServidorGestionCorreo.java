package ar.edu.unq.po2.tp6;

import java.util.List;

public interface IServidorGestionCorreo {
	
	public List<Correo> recibirNuevos(Usuario usuario);
	public void conectar(Usuario usuario);
	public void enviar(Correo correo);
}
