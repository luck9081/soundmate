package ar.edu.grupoesfera.cursospring.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.BandaService;
import ar.edu.grupoesfera.cursospring.interfaces.PerfilService;
import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;



public class TestBanda {
	//TEST DEL CONTROLLER MISBANDAS
	@Test
	public void testQueAlPresionarEnMisBandasElControladorLoLLeveAMisBandas(){
		
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		when(requestMock.getSession()).thenReturn(mock(HttpSession.class));
		
		Banda banda = new Banda ();
		
		 banda.setNombre("Black Sabbath");
		 banda.setGenero("Rock");
		 banda.setId(1);
		 
		 String nombreBanda = banda.getNombre();
		
		BandaService bandaServiceMock=mock(BandaService.class);
		when(bandaServiceMock.consultarBandas(nombreBanda)).thenReturn(banda);
		
		BandaController miBandaController = new BandaController();
		
		miBandaController.setBandaServiceMock(bandaServiceMock);
		
		ModelAndView mav = new ModelAndView();
		
		mav=miBandaController.misbandas(requestMock);
		
		assertThat(mav.getViewName()).isEqualTo("misBandas");

		
		
		
		
	}
	//TEST DEL CONTROLLER CREAR BANDA 
	@Test
	public void testDeQueAlCrearUnaBandaElControllerMeLLevaAlLanding(){
		
		
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		when(requestMock.getSession()).thenReturn(mock(HttpSession.class));
		 
		
		
		
		Banda banda = new Banda ();
		
		 banda.setNombre("Black Sabbath");
		 banda.setGenero("Rock");
		
		 
		 Usuario usuario = new Usuario ();
		 
		 usuario.setNombre("rodrigo1990");
		 usuario.setEmail("mcd77.1990@gmail.com");
		 usuario.setBanda(banda);
		 usuario.setImagen("rodri.jpg");
		 usuario.setIdusuario(1);
		 usuario.setInfluencias("rock");
		 usuario.setInstrumento("bajista");
		 usuario.setPartido("moron");
		 usuario.setLocalidad("moron");
		 usuario.setPass("1990");
		 usuario.setProvincia("Buenos Aires");
		 
		 String nombreUsuario=usuario.getNombre();
		
		PerfilService perfilServiceMock=mock(PerfilService.class);
		when(perfilServiceMock.buscarPerfilUsuario(nombreUsuario)).thenReturn(usuario);
		
		
		 
		BandaService bandaServiceMock=mock(BandaService.class);
		doNothing().when(bandaServiceMock).registrarBanda(banda, nombreUsuario);

		
		BandaController miBandaController = new BandaController();
		
		miBandaController.setPerfilService(perfilServiceMock);
		
		ModelAndView mav = new ModelAndView();
		
		
		
		mav=miBandaController.crearBanda(banda, requestMock);
		
	
		
		assertThat(mav.getViewName()).isEqualTo("landing");

		
		
		
		
	}



	
	
	
}
