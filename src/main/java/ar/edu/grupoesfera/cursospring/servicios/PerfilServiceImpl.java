package ar.edu.grupoesfera.cursospring.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.dao.PerfilDAOService;
import ar.edu.grupoesfera.cursospring.interfaces.PerfilService;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
@Transactional
public class PerfilServiceImpl implements PerfilService{
	
	@Inject
	public PerfilDAOService perfilDAO;
	
	@Override
	public Usuario buscarPerfilUsuario (String nombreUsuario){
		
		Usuario usuarioEncontrado = perfilDAO.obtenerUsuarioPorNombre(nombreUsuario);
		
		return usuarioEncontrado;
	}

}