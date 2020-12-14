package es.uclm.esi.iso2.bc4.Yakitoro.modelo;

import java.util.ArrayList;

import es.uclm.esi.iso2.bc4.Yakitoro.dao.ReservaDAO;

public class Reserva {
	private int id;
	private String fecha;
	private String persona;
	private int numComensales;
	private ArrayList<Mesa> mesas;

	public Reserva(String fecha, String persona, int numComensales, ArrayList<Mesa> mesas) {
		super();
		this.fecha = fecha;
		this.persona = persona;
		this.numComensales = numComensales;
		this.mesas = mesas;
	}

	public int guardarReserva() {
		ReservaDAO reservaDAO = new ReservaDAO();
		return reservaDAO.insertReservas(this);
	}

	public String getFecha() {
		return fecha;
	}

	public String getPersona() {
		return persona;
	}

	public int getNumComensales() {
		return numComensales;
	}

	public String getMesas() {
		String mesas = "";
		for(Mesa mesa : this.mesas) {
			mesas = mesas + mesa.getId() + " ";
		}
		return mesas;
	}
	
}