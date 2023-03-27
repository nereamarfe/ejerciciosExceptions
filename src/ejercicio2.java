import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class ejercicio2 {
    //EJERCICIO 3 PAGINA 199
    public static void main(String[] args) {
        try{
            int anhoNacimiento = preguntarAnhoNacimiento();
            System.out.println("Año de nacimiento: " + anhoNacimiento);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
    public static int preguntarAnhoNacimiento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el año de nacimiento");
        int anho = 0;
        anho = sc.nextInt();
        if(anho<=0){
            throw new IllegalArgumentException("La edad debe ser mayor que 0");
        }
        return anho;
    }
}
