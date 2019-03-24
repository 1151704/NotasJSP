package factory;

import java.sql.SQLException;

import dao.UsuarioDao;

public class Factory {
	
	public UsuarioDao getUsuario() throws SQLException {
        return new UsuarioDao();
    }

}
