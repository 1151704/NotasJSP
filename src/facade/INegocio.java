package facade;

import java.util.List;

import dto.Usuario;

public interface INegocio {

	Usuario usuarioValidarLogin(String username, String password);
	
	Usuario usuarioFindByUsername(String username);
	
	List<Usuario> usuarioList();

	Usuario usuarioFind(Long id);

	void usuarioInsert(Usuario o);

	void usuarioUpdate(Usuario o);

	void usuarioDelete(Usuario o);
	
}
