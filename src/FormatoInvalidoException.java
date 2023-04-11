import java.util.InputMismatchException;

public class FormatoInvalidoException extends InputMismatchException {
    FormatoInvalidoException(String s){
        super(s);
        System.out.println("Se ha introducido un tipo de valor incorrecto");
    }
}
