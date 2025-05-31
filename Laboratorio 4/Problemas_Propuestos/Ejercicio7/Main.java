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
        System.out.println("\nEliminando el valor 10 con deleteByKey:");
        lista.deleteByKey(10);
        lista.printList();

        System.out.println("\nEliminando el valor 1 con deleteByKey:");
        lista.deleteByKey(1);
        lista.printList();

        System.out.println("\nEliminando el valor 7 con deleteByKey:");
        lista.deleteByKey(7);
        lista.printList();

        System.out.println("\nEliminando elemento en la posición 0 con deleteAtPosition:");
        lista.deleteAtPosition(0);
        lista.printList();

        System.out.println("Tamaño actual de la lista: " + lista.size());

        System.out.println("\nEliminando primer elemento (removeFirst):");
        lista.removeFirst();
        lista.printList();

        System.out.println("\nEliminando último elemento (removeLast):");
        lista.removeLast();
        lista.printList();
    }
}
