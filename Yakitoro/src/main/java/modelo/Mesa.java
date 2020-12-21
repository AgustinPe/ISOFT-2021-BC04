
package modelo;

import java.util.ArrayList;

public class Mesa {

	private int id;
	private int numeroComensales;
	private MesaState estado;

	public Mesa(int id, int numeroComensales, MesaState estado) {
		this.id = id;
		this.numeroComensales = numeroComensales;
		this.estado = estado;
	}

	public ArrayList<Mesa> obtenerMesas() {
		// TODO - implement Mesa.obtenerMesas
		throw new UnsupportedOperationException();
	}

	public boolean actualizarEstado(MesaState estadoMesa) {
		// TODO - implement Mesa.actualizarEstado
		throw new UnsupportedOperationException();
	}

	public void actualizarCamarero() {
		// TODO - implement Mesa.actualizarCamarero
		throw new UnsupportedOperationException();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumeroComensales() {
		return numeroComensales;
	}
	public void setNumeroComensales(int numeroComensales) {
		this.numeroComensales = numeroComensales;
	}
	public MesaState getEstado() {
		return estado;
	}
	public void setEstado(MesaState estado) {
		this.estado = estado;
	}
}

