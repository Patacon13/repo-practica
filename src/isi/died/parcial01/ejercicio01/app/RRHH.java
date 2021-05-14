package isi.died.parcial01.ejercicio01.app;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import isi.died.parcial01.ejercicio01.dominio.*;

public class RRHH {
	
	/*
	 * ACLARACION: El problema especificaba que la funcion solo recibia una listaDeEmpleados, sin embargo, para calcular 
	 * cada recibo de sueldo, necesito saber el sueldo basico. Como no estaba especificado de donde se sacaba,
	 * considere que lo mejor era recibirlo como parametro. 
	 */
	
	public RRHH() {
		
	}
	
	public List<ReciboDeSueldo> generaListaDeRecibos(List<Cobrable> listaDeEmpleados, Double sueldoBasico) {
		int nroDeRecibo = 0;
		List<ReciboDeSueldo> listaDeRecibos = new ArrayList<ReciboDeSueldo>();
		
		for(Cobrable e : listaDeEmpleados) {
			listaDeRecibos.add(generarReciboDeSueldo(Integer.valueOf(nroDeRecibo), e, sueldoBasico));
			nroDeRecibo++;
		}
		
		return listaDeRecibos;
	}
	
	public ReciboDeSueldo generarReciboDeSueldo(Integer numeroDeRecibo, Cobrable empleado, Double sueldoBasico) {
		Month mes = LocalDate.now().getMonth();
		return new ReciboDeSueldo(numeroDeRecibo, mes, empleado.calculaSueldo(sueldoBasico.doubleValue(), mes), empleado);
	}
}
