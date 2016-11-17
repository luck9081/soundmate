package ar.edu.grupoesfera.cursospring.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.dao.RegistroDAOService;
import ar.edu.grupoesfera.cursospring.interfaces.BusquedaService;
import ar.edu.grupoesfera.cursospring.interfaces.RegistroService;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
@Transactional
public class RegistroServiceImpl implements RegistroService {
	
	@Inject
	public RegistroDAOService registroDAOService;
	
	@Inject
	public BusquedaService busquedaService;
	
	@Override
	public Boolean registrarUsuario(Usuario usuario){
		
		List<Usuario> listaResultados = busquedaService.buscarUsuariosPorNombreOEmail(usuario.getNombre(),usuario.getEmail());
		
		if(listaResultados.isEmpty()){
			registroDAOService.registrarUsuario(usuario);
			return true;
		}
		
		else{
			return false;
		}
	}
	
	@Override
	public Boolean loguearUsuario(Usuario usuario){
		
		Usuario resultado = busquedaService.buscarUsuariosPorNombreYContraseña(usuario.getNombre(),usuario.getPass());
		
		if(resultado != null){
			return true;
		}
		
		else{
			return false;
		}
	}
}
