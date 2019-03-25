package facade;

import java.util.List;

import dao.GenericDao;
import dto.Asignatura;

public interface IAsignaturaDao extends GenericDao<Asignatura, Long> {

	public List<Asignatura> findByUsuario(Long idUsuario);
	
}
