package tpFinal;


import java.util.ArrayList;
import java.time.LocalDate;

public class Usuario {
	
	
	
	//ATRIBUTOS
	private String nombre;
	private Nivel nivel;
	private ArrayList<Muestra> listaDeMuestrasPosteadas;
	private ArrayList<Opinion> listaDeOpiniones;
	
	
	
	//CONSTRUCTOR
	public Usuario (String nombre) {
		this.nombre = nombre;
		this.listaDeMuestrasPosteadas	=	new ArrayList<Muestra>();
		this.listaDeOpiniones			=   new ArrayList<Opinion>();
//		this.setNivel(new NivelBasico());
		
	}
	
	
	
	//SETTERS
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
		this.nivel.setUsuario(this);
	}
	
	
	
	//GETTERS
	public Nivel getNivel() {
		return this.nivel;
	}
	
	public ArrayList<Muestra> getListaMuestras(){
		return this.listaDeMuestrasPosteadas;
	}
	public ArrayList<Opinion> getListaOpiniones(){
		return this.listaDeOpiniones;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	
	//METODOS
	public void cambiarNivel() {
		this.getNivel().actualizarNivelUsuario(this);
	} 
	
	public void opinar(Muestra muestra, Comentario comentario) {
		this.getNivel().opinar(muestra,comentario);
	}

	public void agregarMuestraEnviada(Muestra muestra) {
		this.getListaMuestras().add(muestra);
		
	}
	public void agregarOpinionEnviada(Opinion opinion) {
		this.getListaOpiniones().add(opinion);
		
	}

//	public int cantidadMuestrasEnviadasEnElUltimoMes() {
//		int contador = 0;
//		LocalDate fechaActual = LocalDate.now();
//		for ( Muestra muestra : listaDeMuestrasPosteadas) {
//			if (muestra.getFechaCreacion().isAfter(fechaActual.minusDays(30))  ) {
//				contador ++;
//			}
//		}
//		return contador;
//	}
	
//	public int cantidadOpinionesEnviadasEnElUltimoMes() {
//		int contador = 0;
//		LocalDate fechaActual = LocalDate.now();
//		for ( Opinion opinion : this.listaDeOpiniones) {
//			if (opinion.getFechaDeOpinion().isAfter(fechaActual.minusDays(30))) {
//				contador ++;
//			}
//		}
//		return contador;
//	}



	public boolean esExperto() {

		return this.getNivel().esExperto();
	}
}
