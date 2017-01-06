package ar.edu.grupoesfera.cursospring.dao;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.SpringTest;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.modelo.UsuarioEsAmigo;

public class AmigoDaoTest extends SpringTest {
	
	@Inject
	AmigoDaoService amigoDaoService;
	
	//@Test @Rollback @Transactional
	public void testAlmacenarYBuscarAmigo(){
		
		Usuario miUsuario = new Usuario();
		
		miUsuario.setIdusuario(14444);
		miUsuario.setNombre("username");
		miUsuario.setPass("hola");
		miUsuario.setEmail("mail@user.com");
		miUsuario.setInstrumento("bajo");
		miUsuario.setLocalidad("San Justo");
		miUsuario.setPartido("La Matanza");
		miUsuario.setProvincia("Buenos Aires");
		miUsuario.setImagen("img");
		miUsuario.setInfluencias("banda");
		miUsuario.setBanda(null);
		
		Usuario miAmigo = new Usuario();
		
		miAmigo.setIdusuario(2234);
		miAmigo.setNombre("username2");
		miAmigo.setPass("holaasdasd");
		miAmigo.setEmail("mailadasd@user.com");
		miAmigo.setInstrumento("contrabajo");
		miAmigo.setLocalidad("San Justo");
		miAmigo.setPartido("La Matanza");
		miAmigo.setProvincia("Buenos Aires");
		miAmigo.setImagen("img2");
		miAmigo.setInfluencias("banda3");
		miAmigo.setBanda(null);
		
		getSession().save(miUsuario);
		getSession().save(miAmigo);
		
		
		
		amigoDaoService.agregarAListaDeAmigos(miUsuario.getIdusuario(),miAmigo.getIdusuario());
		System.out.println("exito");

		/*long resultadoIdAmigo = amigoDaoService.buscarAmigo(miUsuario.getIdusuario(), miAmigo.getIdusuario());*/
		
		for(UsuarioEsAmigo item : miUsuario.getUsuario_amigos()){
			
			if(item.getAmigo().getIdusuario() == miAmigo.getIdusuario()){
				System.out.println("amigo almacenado con exito");
			}else{
				System.out.println("amigo no almacenado");

			}
			
		}
		
		for(UsuarioEsAmigo item : miAmigo.getUsuario_amigos()){
			
			if(item.getAmigo().getIdusuario() == miUsuario.getIdusuario()){
				System.out.println("Solicitud de amistad recibida");
				
			}else{
				System.out.println("Solicitud de amistad NO recibida");
				
			}
			
		
		}
	}
	
	@Test @Rollback @Transactional
	public void testEliminarAmigos(){
		
		Usuario miUsuario = new Usuario();
		
		miUsuario.setIdusuario(14444);
		miUsuario.setNombre("username");
		miUsuario.setPass("hola");
		miUsuario.setEmail("mail@user.com");
		miUsuario.setInstrumento("bajo");
		miUsuario.setLocalidad("San Justo");
		miUsuario.setPartido("La Matanza");
		miUsuario.setProvincia("Buenos Aires");
		miUsuario.setImagen("img");
		miUsuario.setInfluencias("banda");
		miUsuario.setBanda(null);
		
		Usuario miAmigo = new Usuario();
		
		miAmigo.setIdusuario(2234);
		miAmigo.setNombre("username2");
		miAmigo.setPass("holaasdasd");
		miAmigo.setEmail("mailadasd@user.com");
		miAmigo.setInstrumento("contrabajo");
		miAmigo.setLocalidad("San Justo");
		miAmigo.setPartido("La Matanza");
		miAmigo.setProvincia("Buenos Aires");
		miAmigo.setImagen("img2");
		miAmigo.setInfluencias("banda3");
		miAmigo.setBanda(null);

		
		Usuario miOtroAmigo = new Usuario();
		
		miOtroAmigo.setIdusuario(103333);
		miOtroAmigo.setNombre("username4");
		miOtroAmigo.setPass("chauuu");
		miOtroAmigo.setEmail("mailotro@user.com");
		miOtroAmigo.setInstrumento("violin");
		miOtroAmigo.setLocalidad("Mercedes");
		miOtroAmigo.setPartido("La Matanza");
		miOtroAmigo.setProvincia("Buenos Aires");
		miOtroAmigo.setImagen("img101");
		miOtroAmigo.setInfluencias("banda8");
		miOtroAmigo.setBanda(null);
	
		getSession().save(miUsuario);
		getSession().save(miOtroAmigo);
		getSession().save(miAmigo);

		amigoDaoService.agregarAListaDeAmigos(miUsuario.getIdusuario(),miAmigo.getIdusuario());
		amigoDaoService.agregarAListaDeAmigos(miUsuario.getIdusuario(),miOtroAmigo.getIdusuario());

		for(UsuarioEsAmigo item : miUsuario.getUsuario_amigos()){
			
			if(item.getAmigo().getIdusuario() == miAmigo.getIdusuario()){
				System.out.println("amigo encontrado con exito");
			}else{
				System.out.println("amigo no encontrado");

			}
			
		}
		
		
		amigoDaoService.eliminarAmigos(miUsuario, miAmigo);
		System.out.println("buscar amigo eliminado");

		for(UsuarioEsAmigo item : miUsuario.getUsuario_amigos()){
			
			if(item.getAmigo().getIdusuario() == miAmigo.getIdusuario()){
				System.out.println("amigo encontrado con exito");
			}else{
				System.out.println("amigo no encontrado");

			}
			
		}
		

		

	}

}
