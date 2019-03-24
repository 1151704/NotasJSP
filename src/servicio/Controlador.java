package servicio;

import java.util.List;

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

}
