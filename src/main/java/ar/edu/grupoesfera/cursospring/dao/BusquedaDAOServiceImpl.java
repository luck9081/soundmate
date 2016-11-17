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
	
	
	/* ------- BUSQUEDA POR INSTRUMENTO Y UBICACION -------- */
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Usuario> obtenerUsuariosPorInstrumentoYUbicacion(Busqueda busqueda){
		
		
		List resultadosQuery = sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(
						Restrictions.and(
								Restrictions.eq("instrumento",busqueda.getInstrumento()),
								Restrictions.eq("instrumento",busqueda.getInstrumento())
						)
				)
				.list();
		
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
	
	/* ------- BUSQUEDA POR NOMBRE O EMAIL -------- */
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Usuario> obtenerUsuariosPorNombreOEmail(String nombre, String email){
		
		
		List resultadosQuery = sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(
						Restrictions.or(
								Restrictions.eq("nombre",nombre),
								Restrictions.eq("email",email)
						)
				)
				.list();
		
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
	
/* ------- BUSQUEDA POR NOMBRE Y CONTRASEÑA -------- */
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Usuario> obtenerUsuariosPorNombreYContraseña(String nombre, String pass){
		
		
		List resultadosQuery = sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(
						Restrictions.and(
								Restrictions.eq("nombre",nombre),
								Restrictions.eq("pass",pass)
						)
				)
				.list();
		
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
