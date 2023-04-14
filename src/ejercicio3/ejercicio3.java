package ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio3 {
    //EJERCICIO 2 PAGINA 199
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
                //ver la SOLUCION de Nuria para personalizar las Excepciones
                //Aqui no podria hacer un throw pq tiene sus propias Excepciones
                //Enmascaro las InputMismatch y RELANZO UNA Excepcion PROPIA
                //Doble try catch
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
                        res = dividir(num1,num2);
                        System.out.println("La division es " + res);
                    }catch (ExcepcionDivisionCero ex){
                        System.out.println(ex.getMessage());
                    }

                    break;
                case 5:
                    res = Math.pow(num1,num2);
                    System.out.println("La potencia es " + res);
                    break;
            }
        }while(opcion!=0);

    }
    public static double dividir(int n1, int n2){
        double res;
        if(n2==0){
            throw new ExcepcionDivisionCero("No se puede dividir entre 0");
        }
        res = n1/n2;

        return res;
    }
}
