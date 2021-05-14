package isi.died.parcial01.ejercicio01.dominio;

import java.time.LocalDate;
import java.util.List;

public abstract class Empleado {
	protected Integer DNI;
	protected String nombre;
	protected LocalDate fechaDeContratacion;
	protected String correoElectronico;
	protected List<Gasto> listaDeGastos;
	
	public Empleado(Integer DNI, String nombre, LocalDate fechaDeContratacion, String correoElectronico) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.fechaDeContratacion = fechaDeContratacion;
		this.correoElectronico = correoElectronico;
	}
	
	public void realizarGasto(Gasto gasto) {
		listaDeGastos.add(gasto);
	}
}
