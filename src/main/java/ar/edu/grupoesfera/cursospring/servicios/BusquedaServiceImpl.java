package ar.edu.grupoesfera.cursospring.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import ar.edu.grupoesfera.cursospring.modelo.Busqueda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
public class BusquedaServiceImpl implements BusquedaService {

	@Override
	public ModelMap buscarUsuarios(Busqueda busqueda) {				// Recibo el tipo de búsqueda que debo efectuar
		// TODO Auto-generated method stub		
		
		Usuario usuarioResultado = new Usuario();					// Defino un objeto de tipo "Usuario" que utilizaré para guardar en la colección.
		List<Usuario> listaResultados = new ArrayList<Usuario>();	// Defino la colección de usuarios de tipo "Usuario" que contendrá los usuarios resultados de la búsqueda.
		
		// MOTOR DE BUSQUEDA
		
		ModelMap modelListaResultado = new ModelMap();				// Construyo un ModelMap que me permitirá llevar mis resultados a la vista.
		modelListaResultado.addAllAttributes(listaResultados);		// Le asigno la lista de resultados para que se lleve a la vista.
		
		return modelListaResultado;									// Retorno el modelmap
	}

}
