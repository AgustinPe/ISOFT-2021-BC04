import java.util.ArrayList;

public class Gestor_Usuario {

	private ArrayList<Usuario> usuario;
	private Usuario usuarioLogeado;

	/**
	 * 
	 * @param usuario
	 */
	public boolean comprobarLogin(Usuario usuario) {
		// TODO - implement Gestor_Usuario.comprobarLogin
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param usuario
	 */
	public boolean logear(Usuario usuario) {
		// TODO - implement Gestor_Usuario.logear
		throw new UnsupportedOperationException();
	}

	public ArrayList<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(ArrayList<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}

	public void setUsuarioLogeado(Usuario usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}

}