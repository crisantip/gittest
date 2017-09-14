package hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logica.ClaseParaPruebaDeMockito;

public class HamcrestTest {

//	private final ClaseParaPruebaDeMockito claseParaPruebaDeMockito=null;
	private final ClaseParaPruebaDeMockito claseParaPruebaDeMockito = new ClaseParaPruebaDeMockito();
	
	
	@Test
	public void deberiaValidarNoNuloConJUnit() {
		assertNotNull(claseParaPruebaDeMockito);
	}
	
	@Test
	public void deberiaValidarNoNuloConHamcrest() {
		assertThat(claseParaPruebaDeMockito, is(not(nullValue())));
	}
	
	@Test
	public void validarColoresJUnit() {
		List<String> colores = new ArrayList<String>();
		colores.add("amarillo");
		colores.add("azul");
		colores.add("rojo");
		
		assertTrue("No contiene todos los colores esperados", colores.contains("amarillo") && colores.contains("azul") && colores.contains("rojo"));
	}
	
	@Test
	public void validarColoresHamcrest() {
		List<String> colores = new ArrayList<String>();
		colores.add("amarillo");
//		colores.add("azul");
		colores.add("rojo");
		
		assertThat("No contiene todos los colores esperados", colores, hasItems("amarillo", "azul", "rojo"));
	}
}
