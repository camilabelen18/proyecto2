package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.DatosRegistro;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	DatosRegistro consultarUsuario(String email, String password);
}
