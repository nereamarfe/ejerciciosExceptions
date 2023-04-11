package ejercicio5;

public class Area {
    ///*Clase Area: id, especialidad
    private int id;
    private String especialidad;

    public Area(int id, String especialidad) {
        this.id = id;
        this.especialidad = especialidad;
    }

    public Area() {
        this.id = 1;
        this.especialidad = "Neurologia";
    }

    public int getId() {
        return id;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
