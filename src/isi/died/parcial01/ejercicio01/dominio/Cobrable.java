package isi.died.parcial01.ejercicio01.dominio;

import java.time.Month;

public interface Cobrable {
	public default Double calculaSueldo(double sueldoBasico, Month mes) {
		return Double.valueOf(0);
	}
}
