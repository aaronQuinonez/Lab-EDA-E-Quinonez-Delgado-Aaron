package Problemas_Propuestos.Ejercicio7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        CircularLinkedList<Integer> lista = new CircularLinkedList<>();
        for (int i = 1; i <= 6; i++) {
            lista.insertLast(i);
        }
        for (int i = 7; i <= 12; i++) {
            lista.insertFirst(i);
        }
        lista.printList();
        while (true) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Insertar al inicio (insertFirst)");
            System.out.println("2. Insertar al final (insertLast)");
            System.out.println("3. Eliminar por valor (deleteByKey)");
            System.out.println("4. Eliminar por posición (deleteAtPosition)");
            System.out.println("5. Eliminar primero (removeFirst)");
            System.out.println("6. Eliminar último (removeLast)");
            System.out.println("7. Mostrar lista");
            System.out.println("8. Tamaño de la lista (size)");
            System.out.println("9. ¿Lista vacía? (isEmpty)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            if (opcion == 0) {
                System.out.println("Saliendo del programa.");
                break;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Valor a insertar al inicio: ");
                    lista.insertFirst(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Valor a insertar al final: ");
                    lista.insertLast(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Valor a eliminar: ");
                    lista.deleteByKey(scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Posición a eliminar: ");
                    lista.deleteAtPosition(scanner.nextInt());
                    break;
                case 5:
                    lista.removeFirst();
                    break;
                case 6:
                    lista.removeLast();
                    break;
                case 7:
                    lista.printList();
                    break;
                case 8:
                    System.out.println("Tamaño de la lista: " + lista.size());
                    break;
                case 9:
                    System.out.println(lista.isEmpty() ? "La lista está vacía." : "La lista NO está vacía.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
