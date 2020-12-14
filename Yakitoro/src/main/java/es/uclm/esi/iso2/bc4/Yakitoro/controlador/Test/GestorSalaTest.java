package es.uclm.esi.iso2.bc4.Yakitoro.controlador.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

import org.junit.Test;

import es.uclm.esi.iso2.bc4.Yakitoro.controlador.GestorSala;
import es.uclm.esi.iso2.bc4.Yakitoro.modelo.Mesa;
import es.uclm.esi.iso2.bc4.Yakitoro.modelo.MesaState;

public class GestorSalaTest {
	
	/* Los casos con mesasDisponibles negativos no son posibles de testear: (-2, “S”, -2, -2, -2)
	 * (-2, “N”, 0, 3, 4) (-2, “k”, 1, 0, 0) (-1, “S”, 1, 0, -1) (-1, “N”, -2, -1, 1)
	 * (-1, “k”, -1, 1, -2) (-1, "N", 0, -1, -1) (-1, "k", 2, -2, 1) (-1, "S", 1, 3, -2)
	 * (-1, "S", 1, -1, 4) (-1, "N", 1, -2, 0) (-1, "S", -1, -2, 1) (-1, "N", 2, -2, 4) */
	
	/* Los casos con reservasInsertadas negativos no son posibles de testear: (5, "S", -1, 1, 0) */
	
	/* Los casos con numComensablesDisponibles negativos o impares debe dar error 
	 * Casos de prueba que satisface el metodo TestMostrarMesas_whenException1: 
	 * (5, “S”, 0, -2, -2) (5, “k”, -2, -2, -1) (1, “S”, 2, -1, 0) (1, “N”, -1, -2, 4)
	 * (1, "N", -1, -1, -1) (0, "k", 0, -2, 1) (1, "S", 1, -2, 0) (5, "k", 2, -1, -2)
	 * (0, “N”, -2, -1, 0) */  
	@Test
	public void TestMostrarMesas_whenException1() {
		ArrayList<Mesa> mesas = new ArrayList<>();
		
		try {
			mesas.add(new Mesa(-2, MesaState.LIBRE));
			fail();
		} catch (Exception e) {
			assert(e.getMessage().contains("Configuracion de mesa no permitida"));
		}
	}
	
	/* Los casos de prueba con mesasDisponibles > 0 y opcion = N deben salirse de añadir reservas
	 * Casos de prueba que satisface el metodo TestMostrarMesas_whenSayN: 
	 * (5, “N”, 1, 0, 0) (5, “N”, -2, 3, 1) (1, "N", -2, 3, -2)*/
	@Test
	public void TestMostrarMesas_whenSayN() {
		Logger logger = Logger.getLogger(GestorSala.class.getName());
		ArrayList<Mesa> mesas = new ArrayList<>();
		Formatter formatter = new SimpleFormatter();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Handler handler = new StreamHandler(out, formatter);
	    logger.addHandler(handler);

		try {
			mesas.add(new Mesa(2, MesaState.LIBRE));
			mesas.add(new Mesa(4, MesaState.LIBRE));
			mesas.add(new Mesa(6, MesaState.LIBRE));
			mesas.add(new Mesa(6, MesaState.LIBRE));
			mesas.add(new Mesa(4, MesaState.LIBRE));
			GestorSala gestor = new GestorSala(mesas, logger);
			String input = "N";
		    InputStream in = new ByteArrayInputStream(input.getBytes());
		    System.setIn(in);
			gestor.mostrarMesas();
			handler.flush();
			assert(out.toString().contains("Ha salido de la reserva correctamente"));		
		} catch (Exception e) {
			fail();
		}
	}
	
	/* Los casos de prueba con mesasDisponibles == 0 debe salir que no hay mesas y salir
	 * de añadir reserva. Casos de prueba que satisface el metodo TestMostrarMesas_whenZeroMesas:
	 * (0, “S”, -1, 3, -2) (0, “N”, 2, 1, 1) (0, “k”, 0, 0, 4) (0, "S", 1, 3, -1) 
	 * (0, "N", -2, 1, 4) */
	@Test
	public void TestMostrarMesas_whenZeroMesas() {
		Logger logger = Logger.getLogger(GestorSala.class.getName());
		ArrayList<Mesa> mesas = new ArrayList<>();
		Formatter formatter = new SimpleFormatter();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Handler handler = new StreamHandler(out, formatter);
	    logger.addHandler(handler);
	    GestorSala gestor = new GestorSala(mesas, logger);
	    try {
			gestor.mostrarMesas();
			handler.flush();
			assert(out.toString().contains("No hay mesas disponibles"));
		} catch (Exception e) {
			fail();
		}
	}
	
	/* Los casos de prueba con mesasDisponibles > 0 y opcion != "S" y opcion != "N"
	 * debe mostrar aviso de opcion no valida. 
	 * Casos de prueba que satisface el metodo TestMostrarMesas_whenInvalidOption:
	 * (1, “k”, 2, 0, 1) (5, "k", 0, 3, 4) (1, "k", 0, 1, 0) */
	@Test
	public void TestMostrarMesas_whenInvalidOption() {
		Logger logger = Logger.getLogger(GestorSala.class.getName());
		ArrayList<Mesa> mesas = new ArrayList<>();
		Formatter formatter = new SimpleFormatter();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Handler handler = new StreamHandler(out, formatter);
	    logger.addHandler(handler);
	    try {
	    	mesas.add(new Mesa(2, MesaState.LIBRE));
	    	GestorSala gestor = new GestorSala(mesas, logger);
	    	String input = "k\nN";
		    InputStream in = new ByteArrayInputStream(input.getBytes());
		    System.setIn(in);
			gestor.mostrarMesas();
			handler.flush();
			assert(out.toString().contains("Opcion elegida incorrecta"));
			assert(out.toString().contains("Ha salido de la reserva correctamente"));
		} catch (Exception e) {
			fail();
		}
	}
	
	/* Los casos de prueba que tengan mesasDisponibles > 0 
	 * opcion == S, numComensales<=numComensalesDisponibles
	 * y datos de reserva validos (fechas, nombres...)
	 * Todos los casos de prueba en el que se meten datos validos
	 * son testados por el metodo TestMostrarMesas_whenAllGood*/
	@Test
	public void TestMostrarMesas_whenAllGood() {
		Logger logger = Logger.getLogger(GestorSala.class.getName());
		ArrayList<Mesa> mesas = new ArrayList<>();
		Formatter formatter = new SimpleFormatter();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Handler handler = new StreamHandler(out, formatter);
	    logger.addHandler(handler);
	    try {
	    	mesas.add(new Mesa(1, 4, MesaState.LIBRE));
	    	GestorSala gestor = new GestorSala(mesas, logger);
	    	String input = "S\n2\nJose Luis\n14/12/2020";
		    InputStream in = new ByteArrayInputStream(input.getBytes());
		    System.setIn(in);
			gestor.mostrarMesas();
			handler.flush();
			assert(out.toString().contains("Reserva realizada correctamente"));
		} catch (Exception e) {
			fail();
		}
	}
}

