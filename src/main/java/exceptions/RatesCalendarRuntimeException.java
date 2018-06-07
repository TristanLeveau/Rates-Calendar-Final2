package exceptions;


// Gestion des erreurs

public class RatesCalendarRuntimeException extends RuntimeException {


	public RatesCalendarRuntimeException() {
		super();
	}

	public RatesCalendarRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RatesCalendarRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public RatesCalendarRuntimeException(String message) {
		super(message);
	}

	public RatesCalendarRuntimeException(Throwable cause) {
		super(cause);
	}
	
	

}
