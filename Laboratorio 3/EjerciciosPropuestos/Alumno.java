public class Alumno {
    String nombre;
    int edad;
    int cui;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getCui() {
        return cui;
    }
    public void setCui(int cui) {
        this.cui = cui;
    }
    @Override
    public String toString() {
        return "Nombre:" + nombre + "\nEdad: " + edad + "\nCUI:" + cui;
    }
}