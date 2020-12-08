
package modelo;

import java.util.ArrayList;

public class Usuario {

	private String nick;
	private String pass;

	public Usuario(String nick, String pass) {
		super();
		this.nick = nick;
		this.pass = pass;
	}

	public boolean indentify() {
		// TODO - implement Usuario.indentify
		throw new UnsupportedOperationException();
	}

	public ArrayList<Usuario> obtenerCamareros() {
		// TODO - implement Usuario.obtenerCamareros
		throw new UnsupportedOperationException();
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


}