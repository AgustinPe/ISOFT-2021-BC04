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
		String opcion2 = "";
		boolean quedan = false;
		int x =0;
		
		quedan = quedanIngredientes(ingredientes);
		
		if(quedan == false) {
			log.info("No quedan ingredientes");
		}else {
			for(Ingredientes m : ingredientes) {
					boolean ok = false;
					m.toString();
					log.info("¿Quieres reponer este ingrediente?");
					opcion = teclado.nextLine();
					if(opcion.equals("S")) {
						log.info("¿Cuantos desea pedir?");
						int numeroIngredientes = elegirNumIngredientes(teclado);
						ok = aprovisionarIngredientes(numeroIngredientes, m);
						if(ok) {
							log.info("Se han repuesto correctamente");
						}else log.info("No se puede reponer este producto");
						
					}else if(!opcion.equals("N")) {
						log.info("Opcion elegida incorrecta");
						log.info("Introduzca denuevo la opcion");
					}else {
						log.info("No se ha repuesto");	
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
	
	public boolean quedanIngredientes(ArrayList<Ingredientes> ingrediente){
		boolean x= false;
		for(Ingredientes m : ingrediente) {
			if(m.getCantidad() != 0)
				x=true;
		}
		return x;
	}

	public boolean aprovisionarIngredientes(int x, Ingredientes ingrediente) {
		return false;
	}

}