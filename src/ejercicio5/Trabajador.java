package ejercicio5;

import java.time.LocalDate;

public class Trabajador extends Persona implements Coste{
    //*Clase Trabajador: Persona persona, fecha incorporacion, Area area, cargo, salario
    private LocalDate fechaIncorp;
    private Area area;
    private String cargo;
    private double salario;

    public Trabajador(String dni, String nombre, int edad, String direccion, LocalDate fechaIncorp, Area area, String cargo, double salario) {
        super(dni, nombre, edad, direccion);
        this.fechaIncorp = fechaIncorp;
        this.area = area;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Trabajador() {
        super();
        this.fechaIncorp = LocalDate.of(2015,01,01);
        this.area = area;
        this.cargo = "Cirujano";
        this.salario = 2000;
    }

    @Override
    public double calcularCoste() {
        double coste=0;
        coste =(getSalario()*14)*1.05;
        return coste;
    }

    public LocalDate getFechaIncorp() {
        return fechaIncorp;
    }

    public void setFechaIncorp(LocalDate fechaIncorp) {
        this.fechaIncorp = fechaIncorp;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
