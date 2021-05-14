package isi.died.parcial01.ejercicio01.dominio;

import java.time.Month;

public class ReciboDeSueldo {
	
	private Integer numeroDeRecibo;
	private Month mes;
	private Double totalPago;
	private Cobrable empleado;
	public ReciboDeSueldo(Integer numeroDeRecibo, Month mes, Double totalPago, Cobrable empleado) {
		this.numeroDeRecibo = numeroDeRecibo;
		this.mes = mes;
		this.totalPago = totalPago;
		this.empleado = empleado;
	}
	
	public Double getTotalPago() {
		return totalPago;
	}
}
