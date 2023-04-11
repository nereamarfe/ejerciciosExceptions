package ejercicio5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {
    /*Clase Area: id, especialidad
     *Clase Trabajador: Persona persona, fecha incorporacion, Area area, cargo, salario
     *Clase Persona: dni, nombre, edad, direccion
     *Clase Paciente: Persona persona, fechaIngresoActual, patologiaActual, ingresos Hashmap<id, Ingreso ingreso>
     *Clase Ingreso: fechaIngreso, fechaSalida, Area area

     Interfaz Consumibles
     * calcularCostes{
     * Trabajador: sueldo*14 + plus 5% del total
     * Pacientes: numDias ingresados en cada area *700. if(area=trauma)+ total*2%
     */
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Trabajador> listaTrabajadores;

    public static void main(String[] args) {

        Area a1 = new Area(1,"Enfermeria");
        Area a2 = new Area(2,"Traumatologia");
        Area a3 = new Area(3,"Cardiologia");

        ArrayList<Area> listaAreas = new ArrayList<>();
        listaAreas.add(a1);
        listaAreas.add(a2);
        listaAreas.add(a3);

        String seguir = "";
        String opcion ="";
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Elija si quiere introducir un trabajador [t] o un paciente [p]");
            opcion = sc.nextLine();
            switch (opcion){
                case "t":
                    try{
                        String dni = leerDNI();
                    }catch(InputDNIfueraDeRango ex){
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("Introduzca el nombre");
                    String nombre = sc.nextLine();
                    try{
                        int edad = leerEdad();
                    }catch (EdadMenordeCeroException ex){
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("Introduzca la direccion");
                    String dir = sc.nextLine();
                    System.out.println("Introduzca la fecha de incorporacion");
                    


            }
            System.out.println("¿Quiere seguir introduciendo elementos? [SI/NO]");
            seguir = sc.nextLine();
        }while(seguir.equals("SI"));


        Trabajador t1 = new Trabajador("38841155L", "Sergio", 38,"Calle Castelao", LocalDate.of(2021,05,02),a2,"Cirujano",2200);
        Trabajador t5 = new Trabajador("111111111K","Amelia",46,"Calle Paraido",LocalDate.of(2002,5,6),a3,"Medico",2100);
        Trabajador t2 = new Trabajador("87745511H","Sarai",52,"Calle Pinar",LocalDate.of(2000,01,03),a1,"Auxiliar",1800);
        Trabajador t4 = new Trabajador("00000005G","Berto",59,"Calle walabi",LocalDate.of(1998,1,25),a1,"Jefe",1490);
        Trabajador t3 = new Trabajador("21544778J","Belen",32,"Calle Antonio Lozano",LocalDate.of(2016,06,5),a3,"MIR",2000);


        Ingreso i1 = new Ingreso(LocalDate.of(2023,1,03),LocalDate.of(2023,1,06),a2);
        Ingreso i2 = new Ingreso(LocalDate.of(2022,12,20),LocalDate.of(2022,12,21),a1);
        Ingreso i3 = new Ingreso(LocalDate.of(2023,01,01),LocalDate.of(2023,01,03),a3);

        HashMap<Integer,Ingreso> listado1 = new HashMap<>();
        listado1.put(1,i1);
        listado1.put(2,i2);
        listado1.put(3,i3);

        HashMap<Integer,Ingreso> listado2 = new HashMap<>();
        listado2.put(1,i3);
        listado2.put(2,i2);

        Paciente p1 = new Paciente("98546215K","Maria",56,"Calle Latina",LocalDate.of(2023,03,9),"neumonia",listado1);
        Paciente p2 = new Paciente("35578855V", "Nerea",29,"Calle desesperada",LocalDate.of(2023,2,15),"Covid",listado2);
        System.out.println("El paciente ha costado: " + p1.calcularCoste());
        //FALTAN LOS METODOS DEL MAIN

        ArrayList<Persona> miembrosHospi = new ArrayList<>();
        miembrosHospi.add(t1);
        miembrosHospi.add(t2);
        miembrosHospi.add(t3);
        miembrosHospi.add(t4);
        miembrosHospi.add(t5);
        miembrosHospi.add(p1);
        miembrosHospi.add(p2);

        calcularSalarioMedioEnfermeria(miembrosHospi);
        calcularSalarioMaximoCardiologia(miembrosHospi);
        calcularDiasTotalesPacientes(miembrosHospi);
        calcularAreaSanitariaMasCostosa(miembrosHospi, listaAreas);
    }

    private static int leerEdad() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introducir la edad");
        int edad = sc.nextInt();
        if(edad<0){
            throw new EdadMenordeCeroException("---EDAD INCORRECTA");
        }
        return edad;
    }

    private static String leerDNI() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el DNI");
        String dni = sc.nextLine();
        if(dni.length()<9){
            throw new InputDNIfueraDeRango("---DNI INCORRECTO");
        }
        return dni;
    }

    public static void calcularSalarioMedioEnfermeria( ArrayList<Persona> list){
        double salmedio=0;
        int cont=0;
        for (Persona p: list) {
            if(p instanceof Trabajador){
                if (((Trabajador) p).getArea().getEspecialidad().equals("Enfermeria")){
                    salmedio+=((Trabajador) p).getSalario();
                    cont++;
                }
            }
        }
        System.out.println("El salario medio de los enfermeros es de " + salmedio/cont + " €");
    }
    public static void calcularSalarioMaximoCardiologia(ArrayList<Persona> list){
        double salarioMax = 0;
        for (Persona p : list) {
            if(p instanceof Trabajador){
                if(((Trabajador) p).getArea().getEspecialidad().equals("Cardiologia")){
                    if(salarioMax<((Trabajador) p).getSalario()){
                        salarioMax= ((Trabajador) p).getSalario();
                    }
                }
            }
        }
        System.out.println("El salario máximo de Cardiología es: " + salarioMax + " €");
    }
    public static void calcularDiasTotalesPacientes(ArrayList<Persona> list){
        long diasTotales = 0;
        for (Persona p : list) {
            if(p instanceof Paciente){
                HashMap<Integer,Ingreso> listIngresos = ((Paciente) p).getListaIngresos();
                Iterator<Integer> claves = listIngresos.keySet().iterator();
                Ingreso ing;
                while(claves.hasNext()){
                    Integer key = claves.next();
                    ing = listIngresos.get(key);
                    long diasIngreso = DAYS.between(ing.getFechaIngreso(),ing.getFechaSalida());
                    diasTotales+=diasIngreso;
                }
            }
        }
        System.out.println("Entre todos los pacientes han pasado un total de: " + diasTotales + " dias en el hospi");
    }
    public static void calcularAreaSanitariaMasCostosa(ArrayList<Persona> list, ArrayList<Area> areas){
        double gastoMaximo = 0;
        Area areaMax= new Area();
        double gastoArea = 0;
        for (Area a: areas) {
            for (Persona p : list) {
                if(p instanceof Trabajador){
                    if(((Trabajador) p).getArea().getId()==a.getId()){
                        gastoArea+=((Trabajador) p).calcularCoste();
                    }
                }
                if(p instanceof Paciente){
                    HashMap<Integer,Ingreso> listingresos = ((Paciente) p).getListaIngresos();
                    Iterator<Integer> claves = listingresos.keySet().iterator();
                    Ingreso ing;
                    while(claves.hasNext()){
                        Integer key = claves.next();
                        ing = listingresos.get(key);
                        if(ing.getArea().getId()==a.getId()){
                            long difdias = DAYS.between(ing.getFechaIngreso(),ing.getFechaSalida());
                            gastoArea+=700*difdias;
                        }
                    }
                }
            }
            System.out.println("El gasto del area : " + a.getEspecialidad() + " es " + gastoArea);
            if(gastoArea>gastoMaximo){
                areaMax = a;
            }
        }
        System.out.println("El area que mas gasta es " + areaMax.getEspecialidad());
    }



}
