package negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Asignatura;
import dto.AsignaturaNota;
import dto.Usuario;
import facade.INegocio;
import factory.Factory;

public class Negocio implements INegocio {

	private final Factory factory;

	public Negocio() {
		this.factory = new Factory();
	}

	@Override
	public Usuario usuarioValidarLogin(String username, String password) {
		try {

			return factory.getUsuario().validarLogin(username, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario usuarioFindByUsername(String username) {
		try {

			return factory.getUsuario().findByUsername(username);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Usuario> usuarioList() {
		try {

			return factory.getUsuario().list();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario usuarioFind(Long id) {
		try {

			return factory.getUsuario().find(id);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void usuarioInsert(Usuario o) {
		try {

			factory.getUsuario().insert(o);
			;

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void usuarioUpdate(Usuario o) {
		try {

			factory.getUsuario().update(o);
			;

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void usuarioDelete(Usuario o) {
		try {

			factory.getUsuario().delete(o);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Asignatura asignaturaPorId(Long id) {

		try {

			return factory.getAsignatura().find(id);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Asignatura> asignaturaPorUsuario(Long idUsuario) {
		try {

			return factory.getAsignatura().findByUsuario(idUsuario);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Asignatura>();
	}

	@Override
	public void asignaturaInsert(Asignatura asignatura) {

		try {

			factory.getAsignatura().insert(asignatura);;

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void asignaturaUpdate(Asignatura asignatura) {

		try {

			factory.getAsignatura().update(asignatura);;

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void asignaturaDelete(Asignatura asignatura) {

		try {

			factory.getAsignatura().delete(asignatura);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void asignaturaNotaUpdate(AsignaturaNota asignaturaNota) {
		try {

			factory.getAsignaturaNota().update(asignaturaNota);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
