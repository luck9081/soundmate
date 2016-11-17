package ar.edu.grupoesfera.cursospring.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.dao.RegistrarBandaDaoService;
import ar.edu.grupoesfera.cursospring.interfaces.RegistrarBandaService;
import ar.edu.grupoesfera.cursospring.modelo.Banda;


@Service
@Transactional
public class RegistrarBandaServiceImpl implements RegistrarBandaService {

	@Inject
	public RegistrarBandaDaoService nuevaBandaDAO;
	
	@Override
	public void registrarBanda (Banda banda){
		
		nuevaBandaDAO.crearNuevaBanda(banda);
		
		return;
	}
	
}
