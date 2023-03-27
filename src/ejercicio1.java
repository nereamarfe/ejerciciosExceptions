import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio1 {
    //EJERCICIO 1 PAGINA 199
    /*
    Escribe un programa calculadora que reciba como parámetros dos enteros (num1 y num2) desde
    su llamada y que los muestre por pantalla. A continuacion, se deberá solicitar al usuario que
    seleccione la operacion matematica a realizar entre los dos numeros.
    Las operaciones que implementará serán suma, resta, multiplicacion, division y potencia.
     */
    public static void main(String[] args) {
        calculadora();
    }
    public static void calculadora(){
        int num1 =0;
        int num2 =0;
        boolean numValidos;
        do{
            Scanner sc = new Scanner(System.in);
            try{
                System.out.println("Introduce un número");
                num1 = sc.nextInt();
                System.out.println("Introduce otro número");
                num2 = sc.nextInt();
                numValidos=true;
            }catch (InputMismatchException e){
                System.out.println("El operando introducido no es válido");
                numValidos=false;
            }
        }while(!numValidos);


        int opcion = 0;
        double res = 0;
        do{
            Scanner sn = new Scanner(System.in);
            System.out.println("Elige la operación que desea realizar, pulsa 0 para salir");
            System.out.println("[1] Sumar");
            System.out.println("[2] Restar");
            System.out.println("[3] Multiplicar");
            System.out.println("[4] Dividir");
            System.out.println("[5] Potencia");
            opcion = sn.nextInt();
            switch (opcion){
                case 1:
                    res = num1+num2;
                    System.out.println("La suma es " + res);
                    break;
                case 2:
                   res = num1-num2;
                    System.out.println("La resta es " + res);
                    break;
                case 3:
                    res = num1*num2;
                    System.out.println("El producto es " + res);
                    break;
                case 4:
                    try{
                        res = num1/num2;
                        System.out.println("La division es " + res);
                    }catch (ArithmeticException e){
                        System.out.println("No es posible la división entre 0");
                    }

                    break;
                case 5:
                    res = Math.pow(num1,num2);
                    System.out.println("La potencia es " + res);
                    break;
            }
        }while(opcion!=0);

    }
}
