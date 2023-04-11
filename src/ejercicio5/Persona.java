package ejercicio5;

public class Persona {
    //  *Clase Persona: dni, nombre, edad, direccion
    private String dni;
    private String nombre;
    private int edad;
    private String direccion;

    public Persona(String dni, String nombre, int edad, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }
    public Persona() {
        this.dni = "35587755V";
        this.nombre = "Sara";
        this.edad = 32;
        this.direccion = "Avenida de Galica 9";
    }


    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
