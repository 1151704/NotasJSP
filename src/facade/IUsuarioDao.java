package facade;

import dao.GenericDao;
import dto.Usuario;

public interface IUsuarioDao extends GenericDao<Usuario, Long> {

	public Usuario findByUsername(String username);
	
	public Usuario validarLogin(String username, String password);
	
}
