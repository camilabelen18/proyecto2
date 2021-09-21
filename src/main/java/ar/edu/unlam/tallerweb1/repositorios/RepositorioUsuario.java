package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.DatosRegistro;

import java.util.List;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	DatosRegistro buscarUsuario(String email, String password);
	void guardar(DatosRegistro usuario);
    DatosRegistro buscar(String email);
	void modificar(DatosRegistro usuario);
}
