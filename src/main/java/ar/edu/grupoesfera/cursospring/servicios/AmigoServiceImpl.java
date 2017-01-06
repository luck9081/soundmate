package ar.edu.grupoesfera.cursospring.servicios;

import java.util.ArrayList;
import java.util.List;

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
		
		//Devuelve 0 para saber si ya ha se le ha sido enviado una solicitud a este usuario
		//y aparece el boton "cancelar solicitud" correspondiente
		for(UsuarioEsAmigo item : usuarioLogueado.getUsuario_amigos()){
			
			if(item.getAmigo().getIdusuario() == idamigo && item.getEstado()==0){
			
				return 0;
				
			}
			//Devuelve -1 para que el usuario receptor sepa si se le envio una solicitud
			//y aparece el boton "aceptar solicitud" correspondiente 
			if(item.getAmigo().getIdusuario() == idamigo && item.getEstado()==-1){
				
				return -1;
				
			}
			//devuelve 1 si la amistad ya ha sido concretada
			//muestra el boton "eliminar amigo"
			if(item.getAmigo().getIdusuario() == idamigo && item.getEstado()==1){
				
				return 1;
				
			}
			
		}
		return 2;
	}//buscarAmigo
	
	public void eliminarAmigos(Usuario usuarioLogueado,Usuario amigo){
		
		amigoDaoService.eliminarAmigos(usuarioLogueado, amigo);
	}
	
	public void aceptarSolicitudDeAmistad(Usuario miUsuarioLogueado, Usuario amigo){
		
		amigoDaoService.aceptarSolicitudDeAmistad(miUsuarioLogueado, amigo);
		
	}

	@Override
	public List<UsuarioEsAmigo> buscarSolicitudesDeAmistad(Usuario miUsuarioLogueado) {
		
		List<UsuarioEsAmigo> lista =  new ArrayList<UsuarioEsAmigo>();
		
		for(UsuarioEsAmigo item : miUsuarioLogueado.getUsuario_amigos()){
			
			if(item.getEstado()==-1){
				
				lista.add(item);
				
			}
		}
		
		return lista;
	}




}//class AmigoServiceImpl
