package tpFinal;


public interface Nivel {
	public void opinar(Muestra muestra, Comentario comentario);
	public void actualizarNivelUsuario(Usuario usuario);
	public void setUsuario(Usuario usuario);
	public Boolean esExperto();

}
