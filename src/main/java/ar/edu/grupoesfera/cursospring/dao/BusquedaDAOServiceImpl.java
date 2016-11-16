package ar.edu.grupoesfera.cursospring.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.Busqueda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
@Transactional
public class BusquedaDAOServiceImpl implements BusquedaDAOService{
	
	@Inject
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Usuario> obtenerUsuariosPorInstrumento(Busqueda busqueda){
		
		
		List resultadosQuery = sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("instrumento",busqueda.getInstrumento())).list();
		
		List<Usuario> listaResultados = new ArrayList<Usuario>();
		
		for(Object item : resultadosQuery){
			if(item == null || resultadosQuery.isEmpty()){
				break;
			}
			else{
				listaResultados.add((Usuario)item);
			}
		}
		
		
		return listaResultados;
	}

}
