package Laboratorio4.Problemas_Propuestos.Ejercicio3;

import java.util.Iterator;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        //INsetando elementos
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(7);
        lista.add(8);
        lista.add(9);
        lista.add(10);
        System.out.println(lista);
        //Obtener primer y último elemento
        System.out.println("Primer elemento (head): " + lista.getFirst());
        System.out.println("Último elemento (tail): " + lista.getLast());
        // Eliminar desde ambos extremos (requiere conexiones bidireccionales)
        System.out.println("Eliminando primer elemento: " + lista.removeFirst());
        System.out.println("Eliminando último elemento: " + lista.removeLast());
        System.out.println("Nueva lista " + lista);
        //Utilizando descendingIterator
        System.out.print("Iteración hacia atrás: ");
        Iterator<Integer> it = lista.descendingIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
