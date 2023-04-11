package ejercicio5;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;

import static java.time.temporal.ChronoUnit.DAYS;

public class Paciente extends Persona implements Coste{
    // *Clase Paciente: Persona persona, fechaIngresoActual, patologiaActual, ingresos Hashmap<id, Ingreso ingreso>
    private LocalDate fechaIngresoActual;
    private String patologia;
    private HashMap<Integer, Ingreso> listaIngresos;

    public Paciente(String dni, String nombre, int edad, String direccion, LocalDate fechaIngresoActual, String patologia, HashMap<Integer, Ingreso> listaIngresos) {
        super(dni, nombre, edad, direccion);
        this.fechaIngresoActual = fechaIngresoActual;
        this.patologia = patologia;
        this.listaIngresos = listaIngresos;
    }

    public Paciente() {
        super();
        this.fechaIngresoActual = LocalDate.of(2020,01,01);
        this.patologia = "Neumonia";
        this.listaIngresos = listaIngresos;
    }

    @Override
    public double calcularCoste() {
        double coste = 0;
        Iterator claves = listaIngresos.keySet().iterator();
        Ingreso ing;
        while(claves.hasNext()){
            Integer cod = (Integer) claves.next();
            ing = listaIngresos.get(cod);
            long difdias = DAYS.between(ing.getFechaIngreso(),ing.getFechaSalida());
            System.out.println(difdias + " dias ingresado");
            coste+=700*difdias;
            if(ing.getArea().getEspecialidad().equals("Traumatologia")){
                coste+=(700*difdias)*0.02;
            }
        }
        return coste;
    }

    /*
        @Override
        public double calcularCoste() {
            double coste =0;
            Iterator claves = listaIngresos.keySet().iterator();

            while(claves.hasNext()){
                //long day = DAYS.between(listaIngresos.get(claves.next()).getFechaSalida(),listaIngresos.get(claves.next()).getFechaIngreso());
                Period difdias = listaIngresos.get(claves.next()).getFechaSalida().until(listaIngresos.get(claves.next()).getFechaIngreso());
                int dias = difdias.getDays();
                //ver el metodo .daysBetween
                System.out.println(dias);
                coste+=700*dias;
                if(listaIngresos.get(claves.next()).getArea().getEspecialidad().equals("Traumatologia")){
                    coste+=(700*dias)*0.02;
                }
            }
            return coste;
        }
    */
    public LocalDate getFechaIngresoActual() {
        return fechaIngresoActual;
    }

    public void setFechaIngresoActual(LocalDate fechaIngresoActual) {
        this.fechaIngresoActual = fechaIngresoActual;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public HashMap<Integer, Ingreso> getListaIngresos() {
        return listaIngresos;
    }

    public void setListaIngresos(HashMap<Integer, Ingreso> listaIngresos) {
        this.listaIngresos = listaIngresos;
    }
}
