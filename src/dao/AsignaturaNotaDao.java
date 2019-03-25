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
import dto.AsignaturaNota;
import facade.IAsignaturaNotaDao;

public class AsignaturaNotaDao implements IAsignaturaNotaDao {

	@Override
	public List<AsignaturaNota> list() {
		return new ArrayList<AsignaturaNota>();
	}

	@Override
	public AsignaturaNota find(Long id) {
		return null;
	}

	@Override
	public void insert(AsignaturaNota o) {
		PreparedStatement ps;
		Connection cnn = null;
		try {

			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement(
					"INSERT INTO asignaturaNota (nombre, nota, porcentaje, idAsignatura) values(?,?,?,?)");

			ps.setString(1, o.getNombre());
			ps.setDouble(2, o.getNota());
			ps.setDouble(3, o.getPorcentaje());
			ps.setLong(4, o.getAsignatura().getId());

			if (ps.executeUpdate() > 0) {
				// return (true);
			}
		} catch (SQLException ex) {
			Logger.getLogger(AsignaturaNotaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}
	}

	@Override
	public void update(AsignaturaNota o) {

		PreparedStatement ps;
		Connection cnn = null;
		try {

			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement(
					"UPDATE asignaturaNota SET nota = ?, porcentaje = ? WHERE idAsignatura = ? and nombre = ?");

			ps.setDouble(1, o.getNota());
			ps.setDouble(2, o.getPorcentaje());
			ps.setLong(3, o.getAsignatura().getId());
			ps.setString(4, o.getNombre());

			if (ps.executeUpdate() > 0) {
				// return (true);
			}
		} catch (SQLException ex) {
			Logger.getLogger(AsignaturaNotaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}
		
	}

	@Override
	public void delete(AsignaturaNota o) {

		PreparedStatement ps;
		Connection cnn = null;
		try {

			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement("DELETE from asignaturaNota where idAsignatura = ? AND nombre = ?");

			ps.setLong(1, o.getAsignatura().getId());
			ps.setString(2, o.getNombre());

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
	public List<AsignaturaNota> findNotaByAsignatura(Long id) {
		Connection cnn = null;
		PreparedStatement ps;
		ResultSet rs = null;
		List<AsignaturaNota> asignaturaNotas = new ArrayList<AsignaturaNota>();
		try {
			cnn = Conexion.getCnn();

			ps = cnn.prepareStatement("SELECT * FROM asignaturaNota where idAsignatura = ? order by nombre;");

			ps.setLong(1, id);

			rs = ps.executeQuery();
			
			AsignaturaNota nota;
			
			while (rs.next()) {
				nota = new AsignaturaNota();

				nota.setNombre(rs.getString("nombre"));
				nota.setNota(rs.getDouble("nota"));
				nota.setPorcentaje(rs.getDouble("porcentaje"));
				
				asignaturaNotas.add(nota);

			}
		} catch (SQLException ex) {
			Logger.getLogger(AsignaturaNotaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			Conexion.close();
		}
		return asignaturaNotas;
	}

}
