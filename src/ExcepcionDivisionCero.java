public class ExcepcionDivisionCero extends ArithmeticException {
    ExcepcionDivisionCero(String mensaje){
        super(mensaje);
        System.out.println("Se ha producido un error en la division");
    }
}
