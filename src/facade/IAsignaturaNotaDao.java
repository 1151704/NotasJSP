package facade;

import java.util.List;

import dao.GenericDao;
import dto.AsignaturaNota;

public interface IAsignaturaNotaDao extends GenericDao<AsignaturaNota, Long> {
	
	public List<AsignaturaNota> findNotaByAsignatura(Long id);
	
}
