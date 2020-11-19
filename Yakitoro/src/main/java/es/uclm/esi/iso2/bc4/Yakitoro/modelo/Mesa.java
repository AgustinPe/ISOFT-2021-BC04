public class Mesa {

	private int id;
	private int numeroComensales;
	private MesaState estado;
	
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