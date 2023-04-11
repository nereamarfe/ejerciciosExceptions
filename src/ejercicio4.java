import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio4 {
    //EJERCICIO 4 PÁGINA 199
    /*
    Programa que pide una cadena de texto y solicita una posicion para imprimir.
    Controlar las posibles excepciones producidas al acceder a posiciones invalidas de la cadena
     */

    //VER SOLUCION DE NURIA COMO ORGANIZA LAS EXCEPCIONES

    public static void main(String[] args) {
        accederCharacter();
    }
    public static void accederCharacter(){
        Scanner sc = new Scanner(System.in);
        String cadena="";
        System.out.println("Introduzca una cadena de texto");
        cadena = sc.nextLine();
        String character = "";
        int pos = 0;
        boolean posValida = true;
        do{
            Scanner sr = new Scanner(System.in);
           try{
               try{
                   System.out.println("Introduzca la posicion del caracter de la cadena que desea ver");
                   pos = sr.nextInt();
                   posValida= true;
               }catch (InputMismatchException ex){
                   throw new FormatoInvalidoException("----ERROR DE FORMATO");
               }
           }catch (FormatoInvalidoException ex){
               System.out.println(ex.getMessage());
               posValida=false;
           }
        }while(!posValida);


        try{
            character = sacarCaracter(cadena,pos);
            System.out.println("El caracter en posición " + pos + " es: " + character);

        }catch (PosicionInvalidaException ex ){
            System.out.println(ex.getMessage());
        }


    }
    public static String sacarCaracter(String s, int pos){
        if(pos<0 || pos>s.length()-1){
            throw new PosicionInvalidaException("----POSICIÓN INVALIDA");
        }
        String car = s.substring(pos, pos+1);
        return car;
    }
}
