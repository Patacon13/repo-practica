package isi.died.parcial01.ejercicio01.dominio;

public class Gasto {
	Integer nroComprobante;
	String descripcion;
	Boolean gastoAprobado;
	Double totalGasto;
	
	public Gasto(Integer nroComprobante, String descripcion, Double totalGasto) {
		this.nroComprobante = nroComprobante;
		this.descripcion = descripcion;
		this.totalGasto = totalGasto;
	}
	
	public void aprobarGasto() {
		gastoAprobado = true;
	}
}
