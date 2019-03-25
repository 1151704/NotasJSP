package facade;

import java.util.List;

import dto.Asignatura;
import dto.AsignaturaNota;
import dto.Usuario;

public interface INegocio {

	// USUARIO
	
	Usuario usuarioValidarLogin(String username, String password);
	
	Usuario usuarioFindByUsername(String username);
	
	List<Usuario> usuarioList();

	Usuario usuarioFind(Long id);

	void usuarioInsert(Usuario o);

	void usuarioUpdate(Usuario o);

	void usuarioDelete(Usuario o);
	
	// ASIGNATURA
	
	Asignatura asignaturaPorId(Long id);
	
	List<Asignatura> asignaturaPorUsuario(Long idUsuario);
	
	void asignaturaInsert(Asignatura asignatura);
	
	void asignaturaUpdate(Asignatura asignatura);
	
	void asignaturaDelete(Asignatura asignatura);
	
	// ASIGNATURA NOTA
		
	void asignaturaNotaUpdate(AsignaturaNota asignaturaNota);
	
}
