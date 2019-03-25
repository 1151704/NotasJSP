package factory;

import java.sql.SQLException;

import dao.AsignaturaDao;
import dao.AsignaturaNotaDao;
import dao.UsuarioDao;
import facade.IAsignaturaDao;
import facade.IAsignaturaNotaDao;
import facade.IUsuarioDao;

public class Factory {

	public IUsuarioDao getUsuario() throws SQLException {
		return new UsuarioDao();
	}

	public IAsignaturaDao getAsignatura() throws SQLException {
		return new AsignaturaDao();
	}

	public IAsignaturaNotaDao getAsignaturaNota() throws SQLException {
		return new AsignaturaNotaDao();
	}
}
