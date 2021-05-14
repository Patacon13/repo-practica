package isi.died.parcial01.ejercicio01.dominio;

import java.time.LocalDate;
import java.time.Month;

public class EmpleadoJerarquico extends Empleado implements Cobrable {

	public EmpleadoJerarquico(Integer DNI, String nombre, LocalDate fechaDeContratacion, String correoElectronico) {
		super(DNI, nombre, fechaDeContratacion, correoElectronico);
		
	}
	
	public Double calculaSueldo(double sueldoBasico, Month mes) {
		Double sueldo = Double.valueOf(sueldoBasico*0.95); //Sueldo basico - 5% jubilacion
		if(mes == Month.JUNE || mes == Month.DECEMBER) { 
			sueldo *= 1.50; //Cobra el sueldo anual complementario
			sueldo += listaDeGastos.stream()
	                .filter(estaAprobado -> estaAprobado.gastoAprobado)
	                .mapToDouble(gasto -> gasto.totalGasto)
	                .sum() * 1.10; //Recupero los gastos y los sumo a su sueldo con un 10% mas en concepto de costo financiero.
		}
		return sueldo;
	}
}
