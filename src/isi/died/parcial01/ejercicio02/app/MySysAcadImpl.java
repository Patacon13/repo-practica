package isi.died.parcial01.ejercicio02.app;

import java.util.ArrayList;
import java.util.List;

import isi.died.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died.parcial01.ejercicio02.db.BaseDeDatosExcepcion;
import isi.died.parcial01.ejercicio02.dominio.*;

import isi.died.parcial01.ejercicio02.excepcion.DocenteNoDictaMateria;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	private boolean docentePertenece(List<Docente> docentes, Docente d) {
		return docentes.stream()
					   .filter(i -> i == d)
					   .count() > 0;
	}
	
	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) throws DocenteNoDictaMateria {
		if(!docentePertenece(m.getDocentes(), d)) throw new DocenteNoDictaMateria();
		Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
		d.agregarInscripcion(insc);
		a.addCursada(insc);
		m.addInscripcion(insc);
		// DESCOMENTAR Y gestionar excepcion
		try {
			DB.guardar(insc);
		}
		catch(BaseDeDatosExcepcion exception) {
			System.out.println("Hay un problema al guardar en la base de datos.");
		}
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		// DESCOMENTAR Y gestionar excepcion
		try {
			DB.guardar(e);
		}
		catch(BaseDeDatosExcepcion exception) {
			System.out.println("Hay un problema al guardar en la base de datos.");
		}
	}
	
	public void registrarNota(Examen e, Integer nota) {
		e.setNota(nota);
		if(nota >= 6) {
			for(Alumno a : alumnos) {
				if(e.getAlumno().equals(a)) {
					a.promocionaMateria(e.getMateria());
				}
			}
				   
		}
	}
	
	public List<Examen> topNExamenes(Alumno a, Integer n, Integer nota) {
		return a.topNExamenes(n,nota);
	}

}
