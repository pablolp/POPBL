package Main;

public class Fisio extends Usuario {
	private final String SEPARADOR = "$";
	public Fisio(String userName,String nombre, String apellido1, String apellido2,String centro) {
		super(userName, nombre, apellido1, apellido2,centro);
		// TODO Auto-generated constructor stub
	}
	public Fisio(String userName) {
		super(userName);
		// TODO Auto-generated constructor stub
	}
	
	public String guardar() {		
		return super.guardar()+SEPARADOR+"Fisio";
	}
	

}
