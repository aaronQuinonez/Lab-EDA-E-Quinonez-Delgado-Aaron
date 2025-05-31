package Problemas_Propuestos.Ejercicio7;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList<Integer> lista = new CircularLinkedList<>();
        for (int i = 1; i <= 6; i++) {
            lista.insertLast(i);
        }
        for (int i = 7; i <= 12; i++) {
            lista.insertFirst(i);
        }
        lista.printList();
    }
}
