package isi.died.parcial01.ejercicio02.excepcion;

public class DocenteNoDictaMateria extends Exception {
	public DocenteNoDictaMateria() {
		super("El docente no dicta la materia a la que se quiere inscribir");
	}
}
