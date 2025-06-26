package Laboratorio3.EjerciciosResueltos;

import java.util.ArrayList;

public class EjercicioResuelto1Lab3 {
    public static void main(String[] args) {
        ArrayList<String> alumnos = new ArrayList<String>(); 
        ArrayList<Integer> notas = new ArrayList<Integer>(); 
        alumnos.add("MARIA"); 
        alumnos.add("DIEGO"); 
        alumnos.add("RENE"); 
        alumnos.add("ALONSO");
        //Codigo hash del arrayList
        System.out.println(alumnos.hashCode());
        //Boolean si está vacío el arrayList
        System.out.println(alumnos.isEmpty());
        //Longitud del arrayList 
        System.out.println(alumnos.size());
    }
}