package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistro;

@Controller
public class ControladorRegistro {
	
	//irAregistrarme con path variable
	@RequestMapping(method=RequestMethod.GET, path = "/irAregistrarme/{nombre}")
	public ModelAndView irRegistrarmeParametro(@PathVariable("nombre") String variable) {
		ModelMap model=new ModelMap();
		model.put("usuario", new DatosRegistro());
		model.put("parametro", variable.toUpperCase());
		return new ModelAndView("registroUsuario",model);
	}
	
	//ir a registrarme por request param
//	@RequestMapping(method=RequestMethod.GET, path = "/irAregistrarme/{nombre}")
//	public ModelAndView irRegistrarmeParametros(@RequestParam("nombre") String variable,
//									  @RequestParam("apellido") String apellido) {
//		ModelMap model=new ModelMap();
//		model.put("usuario", new DatosRegistro());
//		model.put("parametro", variable.toUpperCase()+" -- "+ apellido.toUpperCase());
//		return new ModelAndView("registroUsuario",model);
//	}
	
	@RequestMapping(method=RequestMethod.GET, path = "/irAregistrarme")
	public ModelAndView irRegistrarme() {
		ModelMap model=new ModelMap();
		DatosRegistro usuario =new DatosRegistro();
		usuario.setEmail("ingrese un email");
		model.put("usuario",usuario);
		return new ModelAndView("registroUsuario",model);
	}
	
	@RequestMapping(method=RequestMethod.POST ,path = "/registrarme")
	public ModelAndView registrar(@ModelAttribute DatosRegistro usuario) {
		ModelMap modelo = new  ModelMap();
		if(!usuario.getPassword().equals(usuario.getRepiteClave())) {
			modelo.put("msj", "pass y repass no coinciden");
			return new ModelAndView("registroUsuario",modelo);
		}
		if(usuario.getEmail().endsWith(".com") && usuario.getEmail().contains("@")) {
			modelo.put("email", usuario.getEmail());
			modelo.put("msj","usuario registrado con exito");
			return new ModelAndView("login",modelo);
		}
		modelo.put("msj", "formato e-mail incorrecto");
		return new ModelAndView("registroUsuario",modelo);	
	}
	
}
