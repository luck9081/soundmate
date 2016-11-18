package ar.edu.grupoesfera.cursospring.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.dao.BandaDaoService;
import ar.edu.grupoesfera.cursospring.interfaces.BandaService;
import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;


@Service
@Transactional
public class BandaServiceImpl implements BandaService {

	@Inject
	public BandaDaoService bandaDAO;
	
	@Override
	public void registrarBanda (Banda banda){
		
		bandaDAO.crearNuevaBanda(banda);
		
		return;
	}
	
	@Override
	public Banda consultarBandas (String nombre){
		
		Banda banda = bandaDAO.consultarBandas(nombre);
		
		return banda;
	}
	
}
