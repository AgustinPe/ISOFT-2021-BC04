package es.uclm.esi.iso2.bc4.Yakitoro.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import es.uclm.esi.iso2.bc4.Yakitoro.dao.MesaDAO;

public class Mesa {

	private int id;
	private int numeroComensales;
	private MesaState estado;

	public Mesa(int id, int numeroComensales, MesaState estado) throws Exception {
		super();
		if(!isValidNumComensales(numeroComensales))
			throw new Exception("Configuracion de mesa no permitida");
		this.id = id;
		this.numeroComensales = numeroComensales;
		this.estado = estado;
	}	
	
	public Mesa(int numeroComensales, MesaState estado) throws Exception {
		super();
		if(!isValidNumComensales(numeroComensales))
			throw new Exception("Configuracion de mesa no permitida");
		this.numeroComensales = numeroComensales;
		this.estado = estado;
	}

	private boolean isValidNumComensales(final int numComensales) {
		ArrayList<String> configuraciones = new ArrayList<String>();
		for(MesaConfiguraciones mesaConf : MesaConfiguraciones.values()) {
			configuraciones.add(mesaConf.getValor());
		}
		return configuraciones.contains(Integer.toString(numComensales));
	}
	
	public ArrayList<Mesa> obtenerMesas() {
		// TODO - implement Mesa.obtenerMesas
		MesaDAO mesadao = new MesaDAO();
		return mesadao.selectTodas();
	}

	/**
	 * 
	 * @param estadoMesa
	 */
	public boolean actualizarEstado(MesaState estadoMesa) {
		// TODO - implement Mesa.actualizarEstado
		throw new UnsupportedOperationException();
	}

	public void actualizarCamarero() {
		// TODO - implement Mesa.actualizarCamarero
		throw new UnsupportedOperationException();
	}

	public int getNumeroComensales() {
		return numeroComensales;
	}
	
	public MesaState getState() {
		return estado;
	}

	public void setState(MesaState estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

}