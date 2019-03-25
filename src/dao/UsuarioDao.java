package dao;

import dto.Usuario;
import facade.IUsuarioDao;
import conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao implements IUsuarioDao {

	@Override
	public Usuario validarLogin(String username, String password) {
		Connection cnn = null;
		PreparedStatement ps;
		ResultSet rs = null;
		Usuario usuario = null;
		try {
			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement("SELECT u.* FROM usuario u where u.usuario=? and u.password=?;");

			ps.setString(1, username);
			ps.setString(2, password);

			rs = ps.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();

				usuario.setId(rs.getLong("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefono(rs.getString("telefono"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setPassword(rs.getString("password"));

			}
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}
		return usuario;
	}

	@Override
	public Usuario findByUsername(String username) {
		Connection cnn = null;
		PreparedStatement ps;
		ResultSet rs = null;
		Usuario usuario = null;
		try {
			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement("SELECT u.* FROM usuario u where u.usuario=?;");

			ps.setString(1, username);

			rs = ps.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();

				usuario.setId(rs.getLong("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefono(rs.getString("telefono"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setPassword(rs.getString("password"));

			}
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}
		return usuario;
	}

	@Override
	public List<Usuario> list() {
		Connection cnn = null;
		PreparedStatement ps;
		ResultSet rs = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement("SELECT u.* FROM usuario u;");

			rs = ps.executeQuery();

			Usuario usuario;

			while (rs.next()) {
				usuario = new Usuario();

				usuario.setId(rs.getLong("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefono(rs.getString("telefono"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setPassword(rs.getString("password"));

				usuarios.add(usuario);

			}
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}

		return usuarios;
	}

	@Override
	public Usuario find(Long id) {
		Connection cnn = null;
		PreparedStatement ps;
		ResultSet rs = null;
		Usuario usuario = null;
		try {
			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement("SELECT u.* FROM usuario u where u.id=?;");

			ps.setLong(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();

				usuario.setId(rs.getLong("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefono(rs.getString("telefono"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setPassword(rs.getString("password"));

			}
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}
		return usuario;
	}

	@Override
	public void insert(Usuario o) {
		PreparedStatement ps;
		Connection cnn = null;
		try {

			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement(
					"INSERT INTO usuario (nombre, apellido, telefono, email, usuario, password) values (?,?,?,?,?,?)");

			ps.setString(1, o.getNombre());
			ps.setString(2, o.getApellido());
			ps.setString(3, o.getTelefono());
			ps.setString(4, o.getEmail());
			ps.setString(5, o.getUsuario());
			ps.setString(6, o.getPassword());

			if (ps.executeUpdate() > 0) {
				// return (true);
			}
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}

	}

	@Override
	public void update(Usuario o) {

		PreparedStatement ps;
		Connection cnn = null;
		try {

			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement(
					"UPDATE usuario SET nombre = ?, apellido = ?, telefono =? , email = ?, password =? where id = ?");

			ps.setString(1, o.getNombre());
			ps.setString(2, o.getApellido());
			ps.setString(3, o.getTelefono());
			ps.setString(4, o.getEmail());
			ps.setString(5, o.getPassword());
			ps.setLong(6, o.getId());

			if (ps.executeUpdate() > 0) {
				// return (true);
			}
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}

	}

	@Override
	public void delete(Usuario o) {

		PreparedStatement ps;
		Connection cnn = null;
		try {

			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement("DELETE from usuario where id = ?");

			ps.setLong(1, o.getId());

			if (ps.executeUpdate() > 0) {
				// return (true);
			}
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}

	}

}
