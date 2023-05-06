package mainPackage;

public class Exceptions extends Exception{

	public Exceptions(String mensaje) {
		// TODO Auto-generated constructor stub
	}
	//
}

class Starting_windows_exception extends Exception{
	private String mensaje;
	
	public Starting_windows_exception(String mensaje) {
		
		super(mensaje);

	}
	

}

class Unsupported_weapon extends Exceptions{
	private String mensaje;
	
	public Unsupported_weapon(String mensaje) {
		super(mensaje);

	}
	
	
}