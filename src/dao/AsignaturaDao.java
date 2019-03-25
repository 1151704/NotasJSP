package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import conexion.Conexion;
import dto.Asignatura;
import dto.AsignaturaNota;
import dto.Usuario;
import facade.IAsignaturaDao;
import facade.IAsignaturaNotaDao;

public class AsignaturaDao implements IAsignaturaDao {

	@Override
	public List<Asignatura> list() {
		return new ArrayList<Asignatura>();
	}

	@Override
	public Asignatura find(Long id) {
		Connection cnn = null;
		PreparedStatement ps;
		ResultSet rs = null;
		Asignatura asignatura = null;
		try {
			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement("SELECT * FROM asignatura where id = ?;");

			ps.setLong(1, id);

			rs = ps.executeQuery();

			IAsignaturaNotaDao notasDao = new AsignaturaNotaDao();			

			while (rs.next()) {
				asignatura = new Asignatura();

				asignatura.setId(rs.getLong("id"));
				asignatura.setNombre(rs.getString("nombre"));
				asignatura.setCreditos(rs.getInt("creditos"));
				asignatura.setProfesor(rs.getString("profesor"));
				asignatura.setPromedioTotal(rs.getDouble("promedioTotal"));
				asignatura.setUsuario(new Usuario(rs.getLong("idUsuario")));
				asignatura.setNotas(notasDao.findNotaByAsignatura(asignatura.getId()));

			}
		} catch (SQLException ex) {
			Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}
		return asignatura;
	}

	@Override
	public void insert(Asignatura o) {
		PreparedStatement ps;
		Connection cnn = null;
		try {

			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement(
					"INSERT INTO asignatura (nombre, creditos, profesor, promedioTotal, idUsuario) values(?,?,?,?,?)");

			ps.setString(1, o.getNombre());
			ps.setInt(2, o.getCreditos());
			ps.setString(3, o.getProfesor());
			ps.setDouble(4, o.getPromedioTotal());
			ps.setLong(5, o.getUsuario().getId());

			IAsignaturaNotaDao notaDao = new AsignaturaNotaDao();

			if (ps.executeUpdate() > 0) {

				Long id = getTableAutoIncrement() - 1;

				if (id > 0) {
					Asignatura asignatura = new Asignatura();
					asignatura.setId(id);

					for (int i = 0; i < 4; i++) {

						notaDao.insert(new AsignaturaNota(asignatura, "Nota " + (i + 1), 0d, 0d));

					}

				}

			}
		} catch (SQLException ex) {
			Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}

	}

	private Long getTableAutoIncrement() {
		Long id = 0l;

		String consultaId = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE "
				+ "TABLE_SCHEMA=? AND TABLE_NAME=?";

		PreparedStatement ps;
		ResultSet rs;
		Connection cnn = null;
		try {

			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement(consultaId);

			ps.setString(1, Conexion.getDb());
			ps.setString(2, "asignatura");

			rs = ps.executeQuery();

			while (rs.next()) {

				id = rs.getLong(1);

			}

		} catch (SQLException ex) {
			Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}

		return id;
	}

	@Override
	public void update(Asignatura o) {
		PreparedStatement ps;
		Connection cnn = null;
		try {

			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement(
					"UPDATE asignatura SET nombre = ?, creditos = ?, promedioTotal =?, profesor = ? where id = ?");

			ps.setString(1, o.getNombre());
			ps.setInt(2, o.getCreditos());
			ps.setDouble(3, o.getPromedioTotal());
			ps.setString(4, o.getProfesor());
			ps.setLong(5, o.getId());

			if (ps.executeUpdate() > 0) {
				// return (true);
			}
		} catch (SQLException ex) {
			Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}

	}

	@Override
	public void delete(Asignatura o) {

		PreparedStatement ps;
		Connection cnn = null;
		try {

			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement("DELETE from asignatura where id = ?");

			ps.setLong(1, o.getId());

			if (ps.executeUpdate() > 0) {
				// return (true);
			}
		} catch (SQLException ex) {
			Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}

	}

	@Override
	public List<Asignatura> findByUsuario(Long idUsuario) {
		Connection cnn = null;
		PreparedStatement ps;
		ResultSet rs = null;
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		try {
			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement("SELECT * FROM asignatura where idUsuario = ?");

			ps.setLong(1, idUsuario);

			rs = ps.executeQuery();

			IAsignaturaNotaDao notasDao = new AsignaturaNotaDao();

			Asignatura asignatura;

			while (rs.next()) {
				asignatura = new Asignatura();

				asignatura.setId(rs.getLong("id"));
				asignatura.setNombre(rs.getString("nombre"));
				asignatura.setCreditos(rs.getInt("creditos"));
				asignatura.setProfesor(rs.getString("profesor"));
				asignatura.setPromedioTotal(rs.getDouble("promedioTotal"));
				asignatura.setUsuario(new Usuario(rs.getLong("idUsuario")));
				asignatura.setNotas(notasDao.findNotaByAsignatura(asignatura.getId()));

				asignaturas.add(asignatura);

			}
		} catch (SQLException ex) {
			Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}
		return asignaturas;
	}

}
