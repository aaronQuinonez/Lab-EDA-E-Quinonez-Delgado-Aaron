package Problemas_Propuestos.Ejercicio4;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
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
        lista.add(11);
        lista.add(12);
        System.out.println("Lista original:");
        System.out.println(lista);
        System.out.println("\nRecorrido circular:");
        int index = 0;
        for (int i = 0; i < lista.size()*2; i++) {
            System.out.print(lista.get(index) + " ");
            index = (index + 1) % lista.size();
        }
    }
}
