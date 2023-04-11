package ejercicio5;

public class InputDNIfueraDeRango extends StringIndexOutOfBoundsException {
    InputDNIfueraDeRango(String s){
        super(s);
        System.out.println("El DNI debe contener al menos 9 caracteres");
    }
}
