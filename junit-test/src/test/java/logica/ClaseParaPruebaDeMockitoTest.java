package logica;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import vo.PruebaVo;

//Tambien se peude utilizar esta anotacion para inicializar los mocks en caso de usar esta opcion quitar el before
//@RunWith(MockitoJUnitRunner.class)
public class ClaseParaPruebaDeMockitoTest {
	// Creamos nuestra clase que sera probada inyectando todos los objetos mock
	@InjectMocks
	private final ClaseParaPruebaDeMockito claseParaPruebaDeMockito = new ClaseParaPruebaDeMockito();
	// Agregamos el mock a la clase
	@Mock
	private PruebaVo pruebaVo;

	@Before
	public void init() {
		// Con esto inicializamos los mocks
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void deberiaValidarEdadEImprimirDatos() {

		// pruebaVo.setApellidoPaterno("a"); utilizamos when para hacer que al
		// ejecutarse nos devuelva un valor en concreto en este caso rosa
		when(pruebaVo.getNombre()).thenReturn("Rosa");
		when(pruebaVo.getApellidoPaterno()).thenReturn("Juarez");
		when(pruebaVo.getEdad()).thenReturn(19);

		final String saludo = claseParaPruebaDeMockito.validaEdad(pruebaVo);

		// verificamos que estamos ejecutando los get.
		// Nota: los verify solo se pueden ejecutar sobre objetos mock y no se
		// tiene acceso a metodos privados
		// times() sirve para saber cuantas veces es llamada una peticion u
		// objeto en este caso apellido materno es solo una vez por eso no
		// requiere en time
		verify(pruebaVo, times(2)).getNombre();
		verify(pruebaVo, times(2)).getApellidoPaterno();
		verify(pruebaVo).getApellidoMaterno();
		verify(pruebaVo, times(2)).getEdad();
		// Nos aseguramos que el metodo nos regrese los datos correctos
		assertEquals(saludo, "Rosa Juarez 19");

	}

	// creamos nuestro metodo para probar
	@Test
	public void deberiaValidarEdadEImprimirDatosConApellidoMaterno() {

		// pruebaVo.setApellidoPaterno("a"); utilizamos when para hacer que al
		// ejecutarse nos devuelva un valor en concreto en este caso rosa
		when(pruebaVo.getNombre()).thenReturn("Rosa");
		when(pruebaVo.getApellidoPaterno()).thenReturn("Juarez");
		when(pruebaVo.getApellidoMaterno()).thenReturn("Perez");
		when(pruebaVo.getEdad()).thenReturn(19);

		final String saludo = claseParaPruebaDeMockito.validaEdad(pruebaVo);

		// verificamos que estamos ejecutando los get.
		// Nota: los verify solo se pueden ejecutar sobre objetos mock y no se
		// tiene acceso a metodos privados
		// times() sirve para saber cuantas veces es llamada una peticion u
		// objeto a diferiencia del caso anterior getApellidoMaterno necesita el
		// times por que al entrar al if hace dos veces la peticion
		verify(pruebaVo, times(2)).getNombre();
		verify(pruebaVo, times(2)).getApellidoPaterno();
		verify(pruebaVo, times(2)).getApellidoMaterno();
		verify(pruebaVo, times(2)).getEdad();
		// Nos aseguramos que el metodo nos regrese los datos correctos
		assertEquals(saludo, "Rosa Juarez Perez 19");

	}

	// creamos nuestro metodo para probar
	@Test
	public void deberiaValidarEdadEImprimirDatosConEdadMenor() {

		// pruebaVo.setApellidoPaterno("a");
		// utilizamos when para hacer que al ejecutarse nos devuelva un valor
		// en concreto en este caso rosa
		when(pruebaVo.getNombre()).thenReturn("Rosa");
		when(pruebaVo.getApellidoPaterno()).thenReturn("Juarez");
		when(pruebaVo.getApellidoMaterno()).thenReturn("Perez");
		when(pruebaVo.getEdad()).thenReturn(17);

		final String saludo = claseParaPruebaDeMockito.validaEdad(pruebaVo);

		// verificamos que estamos ejecutando los get.

		verify(pruebaVo).getNombre();
		verify(pruebaVo).getApellidoPaterno();
		verify(pruebaVo).getEdad();
		// Nos aseguramos que el metodo nos regrese los datos correctos
		assertEquals(saludo, "");

	}

}
