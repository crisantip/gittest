package vo;

public class PruebaVo {
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Integer edad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(final String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(final String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(final Integer edad) {
		this.edad = edad;
	}
}