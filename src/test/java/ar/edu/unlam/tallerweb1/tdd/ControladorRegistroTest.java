package ar.edu.unlam.tallerweb1.tdd;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;
import ar.edu.unlam.tallerweb1.controladores.ControladorRegistro;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistro;

public class ControladorRegistroTest {
	
	private ControladorRegistro controladorRegistro= new ControladorRegistro();
	private DatosRegistro usuario= new DatosRegistro("erickummax@gmail.com","2236","2236");
	private DatosRegistro usuarioIncorrecto= new DatosRegistro("erickummaxgmail.com","2236","2236");
	private DatosRegistro usuarioClaveIncorrecta= new DatosRegistro("erickummax@gmail.com","2236","2232");

	@Test
	public void registrarUsuario() {
		givenSiElUsuarioNoExiste(usuario);
		ModelAndView model=whenSeRegistraElUsuario(usuario);
		thenUsuarioRegistradoConExito(model);
	}
	
	@Test
	public void errorFormatoDeEmail() {
		ModelAndView model=whenSeRegistraElUsuarioIncorrecto(usuarioIncorrecto);
		thenUsuarioFallaPorMailIncorrecto(model);
	}
	
	@Test
	public void errorContrasenasIncorrectas() {
		ModelAndView model=whenSeRegistraElUsuarioClavesDistintas(usuarioClaveIncorrecta);
		thenUsuarioFallaPorPassNoCoinciden(model);
	}
	
	private void givenSiElUsuarioNoExiste(DatosRegistro usuario) {
		
	}
	
	private ModelAndView whenSeRegistraElUsuario(DatosRegistro usuario) {
		return controladorRegistro.registrar(usuario);
	}
	
	private ModelAndView whenSeRegistraElUsuarioIncorrecto(DatosRegistro usuarioIncorrecto) {
		return controladorRegistro.registrar(usuarioIncorrecto);
	}
	
	private ModelAndView whenSeRegistraElUsuarioClavesDistintas(DatosRegistro usuarioClaveIncorrecta) {
		return controladorRegistro.registrar(usuarioClaveIncorrecta);
	}
	
	
	private void thenUsuarioRegistradoConExito(ModelAndView model) {
		assertThat(model.getViewName()).isEqualTo("login");
		assertThat(model.getModel().get("msj").equals("usuario registrado con exito"));
		assertThat(model.getModel().get("email")).isEqualTo(this.usuario.getEmail());	
	}
	
	private void thenUsuarioFallaPorMailIncorrecto(ModelAndView model) {
		assertThat(model.getViewName()).isEqualTo("registroUsuario");
		assertThat(model.getModel().get("msj")).isEqualTo("formato e-mail incorrecto");
	}
	
	private void thenUsuarioFallaPorPassNoCoinciden(ModelAndView model) {
		assertThat(model.getViewName()).isEqualTo("registroUsuario");
		assertThat(model.getModel().get("msj")).isEqualTo("pass y repass no coinciden");
	}
}
