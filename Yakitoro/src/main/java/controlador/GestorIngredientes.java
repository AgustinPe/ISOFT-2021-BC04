package controlador;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import modelo.Ingredientes;

public class GestorIngredientes {

	private ArrayList<Ingredientes> ingredientes;
	private Logger log = Logger.getLogger(GestorSala.class.getName());
	
	public GestorIngredientes(ArrayList<Ingredientes> ingredientes, Logger log) {
		this.ingredientes = ingredientes;
		this.log = log;
	}

	public void mostrarIngredientes() {
		Scanner teclado = new Scanner(System.in);
		Ingredientes ingrediente = new Ingredientes();
		String opcion = "";
		int x = 0;
		x = quedanIngredientes(ingredientes);
		if (x <= 0) {
			log.info("No quedan ingredientes");
		} else {
			for (Ingredientes m : ingredientes) {
				boolean ok = false;
				m.toString();
				while (!opcion.equals("S") && !opcion.equals("N")) {
					log.info("¿Quieres reponer este ingrediente?");
					opcion = teclado.nextLine();
					if (opcion.equals("S")) {
						log.info("¿Cuantos desea pedir?");
						int numeroIngredientes = elegirNumIngredientes(teclado);
						if (numeroIngredientes <= 0) {
							log.info("Numero introducido incorrecto");
						} else {
							ok = aprovisionarIngredientes(numeroIngredientes, m);
							if (ok) {
								log.info("Se han repuesto correctamente");
							} else
								log.info("No se puede reponer este producto");
						}
					} else if (!opcion.equals("N")) {
						log.info("Opcion elegida incorrecta");
						log.info("Introduzca denuevo la opcion");
					} else {
						log.info("No se ha repuesto");
					}
				}
			}
		}
		teclado.close();
	}
	
	private int elegirNumIngredientes(Scanner teclado) {
		
		log.info("Introduzca el numero de ingredientes");
		int ingredientes;
		try {
			String numeroIngredientes = teclado.nextLine();
			ingredientes = Integer.parseInt(numeroIngredientes);
		}catch(Exception e){
			return -1;
		}		
		return ingredientes;
		
	}
	
	public int quedanIngredientes(ArrayList<Ingredientes> ingrediente){
		int x= 0;
		for(Ingredientes m : ingrediente) {
			if(m.getCantidad() != 0)
				x=x+1;
		}
		return x;
	}

	public boolean aprovisionarIngredientes(int x, Ingredientes ingrediente) {
		return false;
	}

}