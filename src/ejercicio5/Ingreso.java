package ejercicio5;

import java.time.LocalDate;

public class Ingreso {
      // *Clase Ingreso: fechaIngreso, fechaSalida, Area area
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Area area;

    public Ingreso(LocalDate fechaIngreso, LocalDate fechaSalida, Area area) {
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.area = area;
    }

    public Ingreso() {
        this.fechaIngreso = LocalDate.of(2020,03,12);
        this.fechaSalida = LocalDate.of(2020,03,14);
        this.area = area;
    }


    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public Area getArea() {
        return area;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
