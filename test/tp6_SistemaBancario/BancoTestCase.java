package tp6_SistemaBancario;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp6.Banco;
import ar.edu.unq.po2.tp6.Cliente;
import ar.edu.unq.po2.tp6.ClienteBasico;
import ar.edu.unq.po2.tp6.SolicitudDeCredito;

import static org.mockito.Mockito.*;


class BancoTestCase {
	//Inicializo las variables de instancia.
	private Banco banco;
	private ClienteBasico cliente1;
	private ClienteBasico cliente2;
	private SolicitudDeCredito solicitud;
	private List<Cliente> listaClientes;
	
	//CONFIGURO EL DOC
	@BeforeEach
	public void setUp(){
		//DOC
		cliente1 = mock(ClienteBasico.class);
		cliente2 = mock(ClienteBasico.class);
		solicitud	=	mock(SolicitudDeCredito.class);
		listaClientes.add(cliente1);
		listaClientes.add(cliente2);
		//SUT
		banco	=	new Banco(listaClientes);
		listaClientes	=	new ArrayList<Cliente>();
	}
	
	
	@Test
	public void elBancoTieneUnaSolicitudRechazada() {
		when(this.solicitud.cumpleLosRequisitos()).thenReturn(false);
		assertFalse(solicitud.cumpleLosRequisitos());

	}	
	  
} 

