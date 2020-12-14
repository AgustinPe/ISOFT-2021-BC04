package es.uclm.esi.iso2.bc4.Yakitoro.modelo;

public enum MesaConfiguraciones {
	DOSCOMENSALES(2),
	CUATROCOMENSALES(4),
	SEISCOMENSALES(6);
	
	private int value;
	
	private MesaConfiguraciones(int value) {
		this.value = value;
	}
	
	public String getValor() {
		return Integer.toString(value);
	}
}
