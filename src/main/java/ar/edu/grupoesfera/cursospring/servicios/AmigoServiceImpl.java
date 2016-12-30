package ar.edu.grupoesfera.cursospring.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.dao.AmigoDaoService;
import ar.edu.grupoesfera.cursospring.interfaces.AmigoService;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.modelo.UsuarioEsAmigo;


@Service
@Transactional
public class AmigoServiceImpl implements AmigoService {
	
	@Inject
	public AmigoDaoService amigoDaoService;
	
	public void agregarAListaDeAmigos(long idusuario,long idamigo){
		
		amigoDaoService.agregarAListaDeAmigos(idusuario, idamigo);
		
	}

	@Override
	public Integer buscarAmigo(Usuario usuarioLogueado, long idamigo) {
		
		
		for(UsuarioEsAmigo item : usuarioLogueado.getUsuario_amigos()){
			
			if(item.getAmigo().getIdusuario() == idamigo){
			
				return 1;
				
			}
			
		}
		return 0;
	}

}
