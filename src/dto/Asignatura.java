package dto;

import java.io.Serializable;
import java.util.List;

public class Asignatura implements Serializable {

	private Long id;

	private Usuario usuario;

	private String nombre;

	private String profesor;

	private int creditos;

	private double promedioTotal;

	private List<AsignaturaNota> notas;

	public Asignatura() {
	}

	public Asignatura(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getNombre() {
		return nombre;
	}

	public List<AsignaturaNota> getNotas() {
		return notas;
	}

	public void setNotas(List<AsignaturaNota> notas) {
		this.notas = notas;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public double getPromedioTotal() {
		return promedioTotal;
	}

	public void setPromedioTotal(double promedioTotal) {
		this.promedioTotal = promedioTotal;
	}

	private static final long serialVersionUID = 1L;

}
