package isi.died.parcial01.ejercicio01.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import isi.died.parcial01.ejercicio01.dominio.*;

public class App {

	public static void main(String[] args) {
		//ACLARACION: Clase generada solo para probar el metodo. No pedida en el enunciado
		
		EmpleadoEfectivo e1 = new EmpleadoEfectivo(123, "Tomas", LocalDate.of(2020, 03, 24), "tassenza@frsf.utn.edu.ar");
		EmpleadoJerarquico e2 = new EmpleadoJerarquico(321, "Pedro", LocalDate.of(2020, 03, 10), "pedro@frsf.utn.edu.ar");
		List<Cobrable> empleados = new ArrayList<>();
		RRHH rrhh = new RRHH();
		
		List<ReciboDeSueldo> recibos = new ArrayList<ReciboDeSueldo>();
		empleados.add(e1);
		empleados.add(e2);
		recibos = rrhh.generaListaDeRecibos(empleados, Double.valueOf(25000));
		
		for(ReciboDeSueldo r : recibos) {
			System.out.println(r.getTotalPago());
		}
	}

}
