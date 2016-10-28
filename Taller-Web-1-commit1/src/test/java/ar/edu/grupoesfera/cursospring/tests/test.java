package ar.edu.grupoesfera.cursospring.tests;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.controladores.Controlador;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.servicios.UsuarioService;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

public class test {
	@Test
	public void registrarUsuarioConValidacionAfirmativaDebeRedirigirALaVistaDeProfile(){
		//preparacion
		//Creo Request trucho
		HttpServletRequest requestMock=mock(HttpServletRequest.class);
		when(requestMock.getSession()).thenReturn(mock(HttpSession.class));
		
		/* Creo una variable de tipo BindingResult y programo el comportamiento si no hay errores (false)
		entonces redirige a la vista profile =) */
		BindingResult result=mock(BindingResult.class);
		when(result.hasErrors()).thenReturn(false);
		
		/*Creo el usuario, no le mando datos porque en escencia el test corre por la programacion de bindring result
		  mas alla que los datos esten bien o mal, simulamos esto en la programacion de dicho objeto result */
		Usuario miUsuario=new Usuario();
		
		miUsuario.setNombre("Rodrigo");
		miUsuario.setInstrumento("bajista");
		miUsuario.setPass("191019901990");
		miUsuario.setLocalidad("moron");
		miUsuario.setLatitud("321321moron");
		miUsuario.setLongitud("3231321moron");
		
		//Creo servicio trucho y programo su funcionamiento ante el metodo registrarUsuario()
		UsuarioService serviceMock=mock(UsuarioService.class);		
		when(serviceMock.registrarUsuario(miUsuario)).thenReturn(null);
		
		//Creo el controlador
		Controlador miControlador=new Controlador();
		//Hago la pseudo dependecia
		miControlador.setUsuarioServiceMock(serviceMock);
		
		
		//ejecucion
		ModelAndView mav=miControlador.crearUsuario(miUsuario, result, requestMock);
		
		//contrastacion
		assertThat(mav.getViewName()).isEqualTo("profile");
	}
	
	@Test
	public void registrarUsuarioConValidacionNegativaDebeRedirigirALaVistaDeSignUp(){
		//preparacion
		HttpServletRequest requestMock=mock(HttpServletRequest.class);
		
		
		BindingResult result=mock(BindingResult.class);
		when(result.hasErrors()).thenReturn(true);
		
	
		Usuario miUsuario=new Usuario();
		
		
		UsuarioService serviceMock=mock(UsuarioService.class);		
		when(serviceMock.registrarUsuario(miUsuario)).thenReturn(null);
		
		
		Controlador miControlador=new Controlador();
		
		miControlador.setUsuarioServiceMock(serviceMock);
		
		
		//ejecucion
		ModelAndView mav=miControlador.crearUsuario(miUsuario, result, requestMock);
		
		//contrastacion
		assertThat(mav.getViewName()).isEqualTo("signup");
	}
}
