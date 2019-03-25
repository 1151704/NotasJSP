package servicio;

import java.util.List;

import dto.Asignatura;
import dto.AsignaturaNota;
import dto.Usuario;
import facade.INegocio;
import negocio.Negocio;

public class Controlador {

	private final INegocio negocio;

	public Controlador() {
		this.negocio = new Negocio();
	}

	public void usuarioRegistrar(String nombre, String apellido, String usuario, String email, String telefono,
			String password) {
		this.negocio.usuarioInsert(new Usuario(nombre, apellido, usuario, email, telefono, password));
	}

	public void usuarioEditar(Long id, String nombre, String apellido, String usuario, String email, String telefono,
			String password) {
		this.negocio.usuarioUpdate(new Usuario(id, nombre, apellido, usuario, email, telefono, password));
	}

	public void usuarioBorrar(Long id) {
		this.negocio.usuarioDelete(new Usuario(id));
	}

	public List<Usuario> usuarioListar() {
		return this.negocio.usuarioList();
	}

	public Usuario usuarioPorId(Long id) {
		return this.negocio.usuarioFind(id);
	}

	public Usuario usuarioPorUsuario(String username) {
		return this.negocio.usuarioFindByUsername(username);
	}

	public Usuario validarLogin(String username, String password) {
		return this.negocio.usuarioValidarLogin(username, password);
	}

	// ASIGNATURA

	public Asignatura asignaturaPorId(Long id) {
		return this.negocio.asignaturaPorId(id);
	}

	public List<Asignatura> asignaturaPorUsuario(Long idUsuario) {
		return this.negocio.asignaturaPorUsuario(idUsuario);
	}

	public void asignaturaRegistrar(String nombre, int creditos, String profesor, Long idUsuario) {

		Asignatura asignatura = new Asignatura();
		asignatura.setNombre(nombre);
		asignatura.setProfesor(profesor);
		asignatura.setCreditos(creditos);
		asignatura.setUsuario(new Usuario(idUsuario));

		this.negocio.asignaturaInsert(asignatura);
	}

	public void asignaturaActualizar(Long id, String nombre, int creditos, String profesor, Long idUsuario) {

		Asignatura asignatura = new Asignatura();
		asignatura.setId(id);
		asignatura.setNombre(nombre);
		asignatura.setProfesor(profesor);
		asignatura.setCreditos(creditos);
		asignatura.setUsuario(new Usuario(idUsuario));

		this.negocio.asignaturaUpdate(asignatura);
	}

	public void asignaturaEliminar(Long id) {

		this.negocio.asignaturaDelete(new Asignatura(id));
	}

	// ASIGNATURA NOTA
	public void asignaturaNotaActualizar(String nombre, Long idAsignatura, double nota, double porcentaje) {
		Asignatura asignatura = new Asignatura(idAsignatura);

		this.negocio.asignaturaNotaUpdate(new AsignaturaNota(asignatura, nombre, nota, porcentaje));
	}

}
