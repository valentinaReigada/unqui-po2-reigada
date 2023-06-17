package tpFinal;

public class Muestra {
	public  Usuario usuarioCreador;
	private Ubicacion ubicacion;
	
	public Muestra(Ubicacion ubicacion, Usuario usuario) {
		this.ubicacion	=	ubicacion;
		this.usuarioCreador	=	usuario;
	}
	
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
	
}
