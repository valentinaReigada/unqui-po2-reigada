package tpFinal;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class SistemaVinchucas {
	private ArrayList<Muestra> listaDeMuestras;
	private ArrayList<Usuario> listaDeUsuarios;
	private Map<IEntidad, ArrayList<ZonaDeCobertura>> listaDeSubscriptores;
	
	public  SistemaVinchucas() {
		this.listaDeMuestras		=	new ArrayList<Muestra>();
		this.listaDeUsuarios		=	new ArrayList<Usuario>();
		this.listaDeSubscriptores	=	new HashMap<IEntidad, ArrayList<ZonaDeCobertura>>();	
	}
	
	 
	//Setter 
	public void agregarMuestra(Muestra muestra){
		this.listaDeMuestras.add(muestra);
		this.notificarSubscriptores(muestra, Evento.NUEVA);
	}
	
	public void agregarUsuario(Usuario usuario){
		this.listaDeUsuarios.add(usuario);
	}
	
	
	public void agregarSubscriptor(IEntidad entidad, ZonaDeCobertura zonaDeCobertura) {
		
		if(this.existeEntidad(entidad)) {
			this.agregarZona_AEntidad(zonaDeCobertura, entidad);
		} else {
			agregarNuevoSubscriptor(entidad, zonaDeCobertura);
		}
		 
	} 
	

	//Getter
	public Map<IEntidad, ArrayList<ZonaDeCobertura>> getSubscriptores(){
		return this.listaDeSubscriptores;
	}

	public ArrayList<Muestra> getMuestras(){
		return this.listaDeMuestras;
	}
	
	public ArrayList<Usuario> getUsuarios(){
		return this.listaDeUsuarios;
	} 
	 
	
	//Metodos indicacos en UML:
	
	public void darDeBajaSubscriptor(IEntidad entidad, ZonaDeCobertura zonaDeCobertura) {
	    ArrayList<ZonaDeCobertura> zonasActuales = zonasDeCoberturaDe_(entidad);
	    zonasActuales.remove(zonaDeCobertura);	    
	    
	    if (zonasActuales.size() > 0) {
	    	 this.actualizarSubscriptores_(entidad, zonasActuales);
	    }else {
	    	this.eliminarSuscriptor(entidad);
	    }    
	}
	 
	   
	public void notificarSubscriptores(Muestra muestra, Evento evento) {
		
		for (IEntidad entidad : this.getSubscriptores().keySet()){
			entidad.notificarMuestra(muestra, evento);
		}
	}  
	 
	public void postearMuestra(Muestra muestra) {
		this.agregarMuestra(muestra);
		this.actualizarMuestrasEn(muestra.usuarioCreador, muestra);//revisar comportamiento con usuario
		this.notificarSubscriptores(muestra, Evento.NUEVA);
	} 
	
	
	public void opinarMuestra(Muestra muestra, Opinion opinion) { //revisar comportamiento con usuario
		this.agregarOpinion_De_EnMuestra_(opinion, opinion.getUsuario(), muestra);
		
	}
	
	public void actualizarNivelUsuario(Usuario usuario) {
		usuario.cambiarNivel();
	}
	
	 
	public ArrayList<Muestra> filtrar(IFiltroDeBusqueda filtroDeBusqueda){
		return filtroDeBusqueda.filtrar();
	}
	
	
	//Mètodos extras
	 
	
	public void agregarNuevoSubscriptor(IEntidad entidad, ZonaDeCobertura zonaDeCobertura) {
		ArrayList<ZonaDeCobertura> zonasActuales = new ArrayList<ZonaDeCobertura>();
		zonasActuales.add(zonaDeCobertura);
		this.actualizarSubscriptores_(entidad, zonasActuales);
	} 

	
	public void agregarZona_AEntidad(ZonaDeCobertura zona, IEntidad entidad) {
		ArrayList<ZonaDeCobertura> zonasActuales = zonasDeCoberturaDe_(entidad);
		zonasActuales.add(zona);
		this.actualizarSubscriptores_(entidad, zonasActuales);
	}
	
	public Boolean existeEntidad(IEntidad entidad) {
		return this.getSubscriptores().containsKey(entidad);
	}
	
	public ArrayList<ZonaDeCobertura> zonasDeCoberturaDe_(IEntidad entidad){
		return this.getSubscriptores().get(entidad);
	}
	 
	public void actualizarSubscriptores_(IEntidad entidad, ArrayList<ZonaDeCobertura> listaDeZonas) {
		this.getSubscriptores().put(entidad, listaDeZonas);
	}
	
	
	public void eliminarSuscriptor(IEntidad entidad) {
		this.getSubscriptores().remove(entidad);	
	}
	
	public void actualizarMuestrasEn(Usuario usuario, Muestra muestra) { //revisar comportamiento con usuario
		usuario.agregarMuestraEnviada(muestra);
	}
	
	public void agregarOpinion_De_EnMuestra_(Opinion opinion, Usuario usuario, Muestra muestra) { //revisar comportamiento con usuario
		usuario.opinar(muestra, opinion.getComentario());
	}
	
	  
}
