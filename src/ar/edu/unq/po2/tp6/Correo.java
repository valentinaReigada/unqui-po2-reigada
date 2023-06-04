package ar.edu.unq.po2.tp6;

public abstract class  Correo {
	protected	String asunto;
	protected	String destinatario;
	protected	String cuerpo;
	
	
	public Correo(String asunto, String destinatario, String cuerpo) {
		this.asunto	=	asunto;
		this.destinatario	=	destinatario;
		this.cuerpo	=	cuerpo;
	}

}
