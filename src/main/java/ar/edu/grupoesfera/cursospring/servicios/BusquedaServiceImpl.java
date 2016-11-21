package ar.edu.grupoesfera.cursospring.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.dao.BusquedaDAOService;
import ar.edu.grupoesfera.cursospring.interfaces.BusquedaService;
import ar.edu.grupoesfera.cursospring.modelo.Busqueda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
@Transactional
public class BusquedaServiceImpl implements BusquedaService {
	
	@Inject
	public BusquedaDAOService busquedaDAO;
	
	@Override
	public List<Usuario> buscarUsuariosPorInstrumentoYUbicacion(Busqueda busqueda, String nombre) {		// Recibo el tipo de b�squeda que debo efectuar
		// TODO Auto-generated method stub		
		
		// Defino la colecci�n de usuarios de tipo "Usuario" que contendr� los usuarios resultados de la b�squeda, y se los asigno
		
		List<Usuario> listaResultados = busquedaDAO.buscarUsuariosPorInstrumentoYUbicacion(busqueda,nombre);
		
		return listaResultados;		// Retorno la lista de resultados
	}
	
	@Override
	public List<Usuario> buscarUsuariosPorNombreOEmail(String nombre, String email) {
		// TODO Auto-generated method stub		
		
		List<Usuario> listaResultados = busquedaDAO.buscarUsuariosPorNombreOEmail(nombre, email);
		
		return listaResultados;
	}
	
	@Override
	public Usuario buscarUsuariosPorNombreYContrase�a(String nombre, String pass) {
		// TODO Auto-generated method stub
		
		Usuario resultado = busquedaDAO.buscarUsuariosPorNombreYContrase�a(nombre, pass);
		
		return resultado;
	}

}