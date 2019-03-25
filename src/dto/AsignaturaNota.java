package dto;

import java.io.Serializable;

public class AsignaturaNota implements Serializable {

	private Asignatura asignatura;

	private String nombre;

	private Double nota;

	private Double porcentaje;

	public AsignaturaNota() {
	}

	public AsignaturaNota(Asignatura asignatura, String nombre, Double nota, Double porcentaje) {
		this.asignatura = asignatura;
		this.nombre = nombre;
		this.nota = nota;
		this.porcentaje = porcentaje;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	private static final long serialVersionUID = 1L;

}
