package exception;

public class ExceptionNoFound extends Exception {

	public ExceptionNoFound(String arg0) {
		super("No se ha encontrado "+arg0);
	}

	
}
