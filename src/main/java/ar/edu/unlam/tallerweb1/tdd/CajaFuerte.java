package ar.edu.unlam.tallerweb1.tdd;

public class CajaFuerte {
	
	private Boolean abierta=true;

	public Boolean estaAbierta() {
		return abierta;
	}

	public void cerrar() {
		this.abierta=false;
	}

	public Boolean estaCerrada() {
		return !estaAbierta();
	}

}
