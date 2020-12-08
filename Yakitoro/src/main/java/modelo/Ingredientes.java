package modelo;

public class Ingredientes {

	private int id;
	private String nombre;
	private int cantidad;

	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param cantidad
	 */
	public Ingredientes(int id, String nombre, int cantidad) {
		this.id = id;
		this.nombre= nombre;
		this.cantidad=cantidad;
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean insert() {
		// TODO - implement Ingredientes.insert
		throw new UnsupportedOperationException();
	}

	public void obtenerIngredientes() {
		// TODO - implement Ingredientes.obtenerIngredientes
		throw new UnsupportedOperationException();
	}

	public void eliminarIngrediente() {
		// TODO - implement Ingredientes.eliminarIngrediente
		throw new UnsupportedOperationException();
	}

}