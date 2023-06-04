package ejerciciosSOLID_ClasesQueDebenArreglarse;

import java.util.ArrayList;

public class ClienteEMail {
		
		 ServidorPop servidor;
		 String nombreUsuario;
		 String passusuario;
		 ArrayList<Correo> inbox;
		private ArrayList<Correo> borrados;
		
		public ClienteEMail(ServidorPop servidor, String nombreUsuario, String pass){
			this.servidor=servidor;
			this.nombreUsuario=nombreUsuario;
			this.passusuario=pass;
			this.inbox = new ArrayList<Correo>();
			this.borrados = new ArrayList<Correo>();
			this.conectar();
		}
		
		public void conectar(){
			this.servidor.conectar(this.nombreUsuario,this.passusuario);
		}//viola el principio de inversion de dependencia, porque uso una clase concreta, en vez de abstraerme.
		
		public void borrarCorreo(Correo correo){
			this.inbox.remove(correo);
			this.borrados.remove(correo);
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
			this.servidor.recibirNuevos(this.nombreUsuario, this.passusuario);
		}
		
		public void enviarCorreo(String asunto, String destinatario, String cuerpo){
			//viola el principio de open close, porque me limita la forma de mandarme un correo, si quisiera agregar un archivo tendria q tocar el codigo para agrregar esa funcionalidad
			Correo correo = new Correo(asunto, destinatario, cuerpo);
			this.servidor.enviar(correo);
		}

}









