package ar.edu.grupoesfera.cursospring.servicios;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	public UsuarioServiceImpl(){
		
	}
	
	public ModelMap registrarUsuario(Usuario usuario){
		ModelMap modelCrearUser = new ModelMap();
		modelCrearUser.put("nombre", usuario.getNombre());
		modelCrearUser.put("email", usuario.getEmail());
		modelCrearUser.put("pass", usuario.getPass());
		modelCrearUser.put("instrumento", usuario.getInstrumento());
		modelCrearUser.put("localidad", usuario.getLocalidad());
		modelCrearUser.put("latitud", usuario.getLatitud());
		modelCrearUser.put("longitud", usuario.getLongitud());
		
		return modelCrearUser;	
	}
	
	public ModelMap ingresarUsuario(Usuario usuario){
		
		ModelMap ingresoUser = new ModelMap();
		ingresoUser.put("nombre", usuario.getNombre());
		ingresoUser.put("pass", usuario.getPass());
		
		return ingresoUser;
		
	}
}
