package Validations;

public class Validations {
	
	public static void isNull(Object o) {
		if(o == null) {
			throw new NullPointerException("El objeto no puede ser null.");
		}
	}
	
	public static void emptyString(String s) {
		if(s == "") {
			throw new IllegalArgumentException("El String no puede ser vacio.");
		}
	}
	
	public static void isHigher(int i) {
		if(i > 5) {
			throw new IllegalArgumentException("El entero no puede ser mayor a 5.");
		}
	}
	
	public static void isLower(int i) {
		if(i < 1) {
			throw new IllegalArgumentException("El entero no puede ser menor a 1.");
		}
	}
}
