package ar.edu.unlam.tallerweb1.tdd;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class CerraduraTest {
	
	@Test
	public void cuandoSeCreaLaCajaFuerteDebeEstarAbierta() {
		//given
		
		//when
		CajaFuerte caja= whenCreoUnaCajaFuerte();
		
		//then
		thenLaCajaFuerteEstaAbierta(caja);
	}
	
	@Test
	public void cuandoSeCierraLaCajaFuerteDebeEstarCerrada() {
		CajaFuerte caja=givenCreoUnaCajaFuerte();
		caja.cerrar();
		thenLaCajaFuerteEstaCerrada(caja);
	}
	
	private void thenLaCajaFuerteEstaCerrada(CajaFuerte caja) {
		assertThat(caja.estaCerrada()).isTrue();
		
	}

	private CajaFuerte givenCreoUnaCajaFuerte(){
		return whenCreoUnaCajaFuerte();
	}
	
	private void thenLaCajaFuerteEstaAbierta(CajaFuerte cajaFuerte) {
		assertThat(cajaFuerte.estaAbierta()).isTrue();
	}
	
	private CajaFuerte whenCreoUnaCajaFuerte() {
		return new CajaFuerte();
	}
}
