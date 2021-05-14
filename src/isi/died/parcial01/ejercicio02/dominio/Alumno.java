package isi.died.parcial01.ejercicio02.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import isi.died.parcial01.ejercicio02.dominio.Inscripcion.Estado;

public class Alumno {
	
	private static Integer ID_GENERATOR=0;
	
	private Integer id;
	private String nombre;

	private List<Inscripcion> materiasCursadas;
	private List<Examen> examenes;
	
	public Alumno() {
		this.id = ID_GENERATOR++;
		this.materiasCursadas = new ArrayList<Inscripcion>();
		this.examenes = new ArrayList<Examen>();
	}
	
	
	public Alumno(String nombre) {
		this();
		this.nombre = nombre;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addExamen(Examen e) {
		this.examenes.add(e);
		e.setAlumno(this);
	}
	
	public void addCursada(Inscripcion e) {
		this.materiasCursadas.add(e);
		e.setInscripto(this);
	}
	
	public void promocionaMateria(Materia  m) {
		for(int i = materiasCursadas.size() - 1; i > -1; i--) {
			if(materiasCursadas.get(i).getMateria().equals(m)) {
				materiasCursadas.get(i).setEstado(Estado.PROMOCIONADO);
				break;
			}
		}
		System.out.println("No se encontro la materia a promocionar"); //Esta linea fue agregada simplemente como caso adicional. Se podia generar una excepcion, pero no lo pedia el enunciado.
	}
	
	public List<Examen> topNExamenes(Integer n, Integer nota) {
		return examenes.stream()
				.filter(i -> i.getNota() >= nota)
				.sorted((a, b) -> b.getNota().compareTo(a.getNota()))
				.limit(n)
				.collect(Collectors.toList());
	}
}
