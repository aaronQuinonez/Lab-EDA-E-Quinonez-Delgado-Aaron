package Laboratorio3.EjerciciosResueltos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EjercicioResuelto3Lab3 {
    public static void main(String[] args) {
        ArrayList<Animal> mascotas = new ArrayList<Animal>();
        Animal anm1 = new Animal("Rex", true);
        mascotas.add(anm1);
        Iterator<Animal> itA = mascotas.iterator();
        while(itA.hasNext()){
            System.out.println(itA.next());
        }
        List<Animal> mascotas2 = new ArrayList<Animal>();
    }
}

class Animal {
    String nombre;
    boolean genero;

    public Animal(String nombre, boolean genero) {
        super();
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nGenero: " + genero;
    }
}