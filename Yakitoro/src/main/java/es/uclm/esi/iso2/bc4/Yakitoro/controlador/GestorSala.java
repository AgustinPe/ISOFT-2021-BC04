package es.uclm.esi.iso2.bc4.Yakitoro.controlador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import es.uclm.esi.iso2.bc4.Yakitoro.modelo.Mesa;
import es.uclm.esi.iso2.bc4.Yakitoro.modelo.MesaState;
import es.uclm.esi.iso2.bc4.Yakitoro.modelo.Reserva;

public class GestorSala {

	private ArrayList<Mesa> mesas;
	private ArrayList<Reserva> reserva;
	private GestorUsuario gestorusuario;
	private Logger log = Logger.getLogger(GestorSala.class.getName());
	
	
	
	public GestorSala(ArrayList<Mesa> mesas) {
		super();
		this.mesas = mesas;
		this.reserva = new ArrayList<Reserva>();
		this.gestorusuario = new GestorUsuario();
	}

	public GestorSala(ArrayList<Mesa> mesas, Logger logger) {
		super();
		this.mesas = mesas;
		this.reserva = new ArrayList<Reserva>();
		this.gestorusuario = new GestorUsuario();
		this.log = logger;
	}
	
	public void mostrarMesas() throws Exception {
		int mesasDisponibles = contarMesasDisponibles(mesas);
		Scanner teclado = new Scanner(System.in);
		
		if(mesasDisponibles <= 0) {
			log.info("No hay mesas disponibles");
		}else {
			
			String opcion = "";
			int reservasInsertadas = 0;
			
			while((!opcion.equals("S") && !opcion.equals("N")) || (opcion.equals("S") && reservasInsertadas == 0)) {
				log.info("Mesas disponibles: "+mesasDisponibles);
				log.info("¿Desea reservar alguna mesa? S/N");
				opcion = teclado.nextLine();
				if(opcion.equals("S")) {
					int numComensales = elegirNumComensales(teclado);
					int numComensalesDisponibles = calcularComensales(mesas);
					while(numComensales<=0 || numComensales>numComensalesDisponibles) {
						log.info("Error: Numero de comensales incorrecto");
						numComensales = elegirNumComensales(teclado);
					}
					Reserva reserva = reservarMesa(numComensales, mesas, teclado);
					reservasInsertadas = reserva.guardarReserva();
					if(reservasInsertadas>=1) {
						log.info("Reserva realizada correctamente");
					}else {
						log.info("Error al reservar");
					}
				}else if(!opcion.equals("N")) {
					log.info("Opcion elegida incorrecta");
					log.info("Introduzca denuevo la opcion");
				}else {
					log.info("Ha salido de la reserva correctamente");
				}
			}
			
		}
		teclado.close();
	}

	private int contarMesasDisponibles(ArrayList<Mesa> mesas) {
		int cont = 0;
		for(Mesa m : mesas) {
			if(m.getState().equals(MesaState.LIBRE))
				cont++;
		}
		return cont;
	}

	private int calcularComensales(ArrayList<Mesa> mesasLibres) {
		int numComensales = 0;
		for(Mesa mesa : mesasLibres) {
			numComensales += mesa.getNumeroComensales();
		}
		return numComensales;
	}

	private int elegirNumComensales(Scanner teclado) {
		
		log.info("Introduzca el numero de comensales de la reserva");
		int comensales;
		try {
			String numeroComensales = teclado.nextLine();
			comensales = Integer.parseInt(numeroComensales);
		}catch(Exception e){
			return -1;
		}		
		return comensales;
		
	}

	public ArrayList<Reserva> mostrarReservas() {
		// TODO - implement GestorSala.mostrarReservas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param mesa
	 */
	public Reserva reservarMesa(int numComensales, ArrayList<Mesa> mesas, Scanner teclado) {
		log.info("Introduzca el nombre de la persona que realiza la reserva");
		String nombre = teclado.nextLine();
		DateFormat dtF = new SimpleDateFormat("dd/MM/yyyy");
		boolean validDate = false;
		String fecha = "";
		while(!validDate) {
			log.info("Introduzca la fecha de la reserva");
			fecha = teclado.nextLine();
			try {
				dtF.parse(fecha);
				validDate = true;
			} catch (ParseException e) {
				log.info("Fecha introducida incorrecta");
			}
		}
		int comensalesConAsiento = 0;
		ArrayList<Mesa> mesasReserva = new ArrayList<Mesa>();
		for(Mesa mesa : mesas) {
			if(mesa.getState().equals(MesaState.LIBRE) && comensalesConAsiento<numComensales) {
				mesasReserva.add(mesa);
				mesa.setState(MesaState.RESERVADA);
				comensalesConAsiento = comensalesConAsiento+mesa.getNumeroComensales();
			}
		}
		return new Reserva(fecha, nombre, numComensales, mesasReserva);
	}

	public void asignarCamarero() {
		// TODO - implement GestorSala.asignarCamarero
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reserva
	 */
	public void cancelarReserva(Reserva reserva) {
		// TODO - implement GestorSala.cancelarReserva
		throw new UnsupportedOperationException();
	}

}