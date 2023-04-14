package ejercicio4;

import java.util.InputMismatchException;

public class PosicionInvalidaException extends InputMismatchException {
    PosicionInvalidaException(String s){
        super(s);
        System.out.println("La posición introducida no existe en la cadena, caracter imposible de encontrar");
    }
}
