package tpFinal;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class SistemaVinchucaTestCase {
	
	
	private SistemaVinchucas sistemaVinchuca;
	private Muestra muestra1;
	private Usuario usuario1;
	private IEntidad entidad;
	private IFiltroDeBusqueda filtro;
	private Organizacion organizacion;
	private ZonaDeCobertura zona1;
	private ZonaDeCobertura zona2;
	private ZonaDeCobertura zona3;
	private ArrayList<Muestra> listaDeMuestras;
	private ArrayList<ZonaDeCobertura> listaDeZonas;
	private Map<IEntidad, ArrayList<ZonaDeCobertura>> listaDeSubscriptores;
	private Evento evento;
	
	
	@BeforeEach
	public void setUp(){
		
		muestra1		=	mock(Muestra.class);	
		usuario1		=	mock(Usuario.class);
		entidad			=	mock(IEntidad.class);
		organizacion	=	mock(Organizacion.class);
		filtro			=   mock(IFiltroDeBusqueda.class);
		zona1 			= mock(ZonaDeCobertura.class);
		zona2 			= mock(ZonaDeCobertura.class);
		zona3 			= mock(ZonaDeCobertura.class);
		evento			=	mock(Evento.class);
		listaDeMuestras			= new ArrayList<Muestra>();		
		listaDeZonas			= new ArrayList<ZonaDeCobertura>();
		sistemaVinchuca			=	new SistemaVinchucas();
		listaDeSubscriptores	=	new HashMap<IEntidad, ArrayList<ZonaDeCobertura>>();
		
	}
	
	
	@Test
	public void creoUnSistemaVinchuca_Entonces_TieneListasDeMuestrasUsuariosYSuscriptorVacias() {
		assertEquals(0, sistemaVinchuca.getMuestras().size());
		assertEquals(0, sistemaVinchuca.getUsuarios().size());
		assertEquals(0, sistemaVinchuca.getSubscriptores().size());
	}
	 
	
	@Test
	public void agrego1MuestraAlSistemaYVerificoQueElSistemaTieneUnaListaDeMuestrasConTamaño1(){

		sistemaVinchuca.agregarMuestra(muestra1);
		assertEquals(1, sistemaVinchuca.getMuestras().size());
	}
	
	@Test
	public void agrego1UsuarioAlSistemaYVerificoQueElSistemaTieneUnaListaDeUsuarioConTamaño1(){

		sistemaVinchuca.agregarUsuario(usuario1);
		assertEquals(1, sistemaVinchuca.getUsuarios().size());
	}
	
	
	//TEST DEL PATRON OBSERVER  - START
	
	@Test
	public void agrego1SubscriptorAlSistemaYVerificoQueElSistemaTieneUnaListaDeSubscriptoresConTamaño1(){

		sistemaVinchuca.agregarNuevoSubscriptor(entidad, zona1);
		assertEquals(1, sistemaVinchuca.getSubscriptores().size());
	} 
	
	@Test
	public void doyDeBajaZona1DeSubscriptor1_YVerificoQueElSubscriptor1NoContieneLaZona1(){ 
		
		listaDeZonas.add(zona1);
		listaDeZonas.add(zona2);
		sistemaVinchuca.actualizarSubscriptores_(entidad, listaDeZonas);
		
		sistemaVinchuca.darDeBajaSubscriptor(entidad, zona1);
		
		assertFalse(sistemaVinchuca.zonasDeCoberturaDe_(entidad).contains(zona1));
	} 

	
	@Test
	public void agregoZona2AEntidadYVerificoQueTieneLaZona2() {
		sistemaVinchuca.agregarNuevoSubscriptor(entidad, zona1);
		sistemaVinchuca.agregarZona_AEntidad(zona2, entidad);
		
		assertEquals(zona2, sistemaVinchuca.zonasDeCoberturaDe_(entidad).get(1));
	}
	
	@Test
	public void eliminoZona1DeEntidadQueTieneUnaSolaZonaAsociada_Entonces_SeBorraSuscriptorDeLaLista() {
		sistemaVinchuca.agregarNuevoSubscriptor(organizacion, zona1);
		sistemaVinchuca.darDeBajaSubscriptor(organizacion, zona1);
		
		assertFalse(sistemaVinchuca.existeEntidad(organizacion));
	}
	 
	@Test
	public void seAgregaUnSubscriptorYUnaMuestraASistema_Entonces_SistemaNotificaASubscriptorDeLaNuevaMuestra() {
		sistemaVinchuca.agregarNuevoSubscriptor(organizacion, zona1);
		sistemaVinchuca.agregarMuestra(muestra1);
		verify(organizacion).notificarMuestra(muestra1, evento.NUEVA);
		
	} 
	
	//TEST PATRON OBSERVER - END
	
	 
	//TEST DE MUESTRA Y USUARIO - START

//	public void elSistemaPosteaUnaMuestraQueLeLlegaDeAlgunUsuario_EntoncesAvisaASusSubscriptoresDeSuNuevaMuestra() {
//		sistemaVinchuca.postearMuestra(muestra1);
//		//verify(sistemaVinchuca).notificarSubscriptores(muestra1, evento.NUEVA);
//	
//		assertEquals(1, sistemaVinchuca.getMuestras().size());
//	}
	
	
	//TEST DE MUESTRA Y USUARIO - END
	
	@Test
	public void sistemaFiltraYLeDevuelveUnaListaConUnaMuestra() {
		listaDeMuestras.add(muestra1);
		
		sistemaVinchuca.filtrar(filtro);
		
		when(filtro.filtrar()).thenReturn(listaDeMuestras);
	}
	 
}  
 


 




 


 








