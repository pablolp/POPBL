package Main;

public class Paciente extends Usuario {
	TablaEjercicios ejercicios;

	public Paciente(String userName, String nombre, String apellido1, String apellido2, String centro,
			TablaEjercicios ejercicios) {
		super(userName, nombre, apellido1, apellido2, centro);
		this.ejercicios = ejercicios;
	}
	
	public void setPaciente(Paciente paciente){
		super.setUserName(paciente.getUserName());
		super.setNombre(paciente.getNombre());
		super.setApellido1(paciente.getApellido1());
		super.setApellido2(paciente.getApellido2());
		super.setCentro(paciente.getCentro());
	}

	public Paciente(String userName) {
		super(userName);
		this.ejercicios = getEjercicios();
	}

	public TablaEjercicios getEjercicios() {
		if (ejercicios == null)
			ejercicios = cargarEjercicios();

		return ejercicios;
	}

	private TablaEjercicios cargarEjercicios() {
		// Leer desde fichero aqui
		return new TablaEjercicios();
	}

	public void setEjercicios(TablaEjercicios ejercicios) {
		 this.ejercicios = ejercicios;
	}

}