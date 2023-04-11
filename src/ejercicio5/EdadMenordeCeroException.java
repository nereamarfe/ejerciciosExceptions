package ejercicio5;

import java.util.InputMismatchException;

public class EdadMenordeCeroException extends InputMismatchException {
    EdadMenordeCeroException(String s){
        super(s);
        System.out.println("La edad introducida es menor que 0");


    }
}
