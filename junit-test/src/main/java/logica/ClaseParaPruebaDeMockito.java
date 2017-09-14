package logica;

import vo.PruebaVo;

public class ClaseParaPruebaDeMockito {

	private static final String CADENA_ESPACIO = " ";

	public String validaEdad(final PruebaVo pruebaVo) {
		String returnValue = "";

		if (pruebaVo.getNombre() != null && pruebaVo.getApellidoPaterno() != null) {
			final boolean flag = validaEdad(pruebaVo.getEdad());
			if (flag) {
				returnValue = imprimirDatos(pruebaVo);
			}
		}
		return returnValue;
	}

	private String imprimirDatos(final PruebaVo pruebaVo) {
		final StringBuilder builder = new StringBuilder();
		builder.append(pruebaVo.getNombre());
		builder.append(CADENA_ESPACIO);
		builder.append(pruebaVo.getApellidoPaterno());

		if (pruebaVo.getApellidoMaterno() != null) {
			builder.append(CADENA_ESPACIO);
			builder.append(pruebaVo.getApellidoMaterno());

		}
		builder.append(CADENA_ESPACIO);
		builder.append(pruebaVo.getEdad());

		return builder.toString();
	}

	private boolean validaEdad(final Integer edad) {

		if (edad >= 18) {
			return true;
		} else {
			return false;
		}

	}
}