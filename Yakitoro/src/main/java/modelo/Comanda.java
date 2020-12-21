
package modelo;

import java.util.ArrayList;


public class Comanda {

	private ArrayList<String> bebida;
	private ArrayList<String> entrante;
	private ArrayList<String> primerPlato;
	private ArrayList<String> segundoPlato;
	private ArrayList<String> postre;

	/**
	 * 
	 * @param bebida
	 * @param entrante
	 * @param primerPlato
	 * @param segundoPlato
	 * @param postre
	 * 
	 */
	
	public Comanda(ArrayList<String> bebida, ArrayList<String> entrante, ArrayList<String> primerPlato,
			ArrayList<String> segundoPlato, ArrayList<String> postre) {
		this.bebida = bebida;
		this.entrante = entrante;
		this.primerPlato = primerPlato;
		this.segundoPlato = segundoPlato;
		this.postre = postre;
	}
	
	public boolean guardarComanda() {
		// TODO - implement Comanda.guardarComanda
		throw new UnsupportedOperationException();
	}
	public ArrayList<String> getBebida() {
		return bebida;
	}

	public void setBebida(ArrayList<String> bebida) {
		this.bebida = bebida;
	}

	public ArrayList<String> getEntrante() {
		return entrante;
	}

	public void setEntrante(ArrayList<String> entrante) {
		this.entrante = entrante;
	}

	public ArrayList<String> getPrimerPlato() {
		return primerPlato;
	}

	public void setPrimerPlato(ArrayList<String> primerPlato) {
		this.primerPlato = primerPlato;
	}

	public ArrayList<String> getSegundoPlato() {
		return segundoPlato;
	}

	public void setSegundoPlato(ArrayList<String> segundoPlato) {
		this.segundoPlato = segundoPlato;
	}

	public ArrayList<String> getPostre() {
		return postre;
	}

	public void setPostre(ArrayList<String> postre) {
		this.postre = postre;
	}
}