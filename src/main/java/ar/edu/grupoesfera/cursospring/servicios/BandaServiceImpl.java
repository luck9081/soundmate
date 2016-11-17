package ar.edu.grupoesfera.cursospring.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.dao.BandaDaoService;
import ar.edu.grupoesfera.cursospring.interfaces.BandaService;
import ar.edu.grupoesfera.cursospring.modelo.Banda;


@Service
@Transactional
public class BandaServiceImpl implements BandaService {

	@Inject
	public BandaDaoService nuevaBandaDAO;
	
	@Override
	public void registrarBanda (Banda banda){
		
		nuevaBandaDAO.crearNuevaBanda(banda);
		
		return;
	}
	
}
