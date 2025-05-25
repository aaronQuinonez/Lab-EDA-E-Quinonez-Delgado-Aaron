public class Alumno {
    String nombre;
    int edad;
    int cui;

    public Alumno(String nombre, int edad, int cui){
        this.nombre = nombre;
        this.edad = edad;
        this.cui = cui;
    }

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
    public boolean equals(Object obj) {
        //Si obj no es de tipo Alumno
        if(obj == null || getClass() != obj.getClass())
            return false;
        Alumno alum = (Alumno) obj;
        return this.nombre.equals(alum.nombre) && this.cui == alum.cui;
    }
    @Override
    public String toString() {
    return "Nombre:" + nombre + "\nEdad: " + edad + "\nCUI:" + cui + "\n";
    }
}