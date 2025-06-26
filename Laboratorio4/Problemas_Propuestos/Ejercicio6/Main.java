package Laboratorio4.Problemas_Propuestos.Ejercicio6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> lista = new DoubleLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (true) {
            System.out.println("\nMENÚ");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Buscar un elemento");
            System.out.println("5. Eliminar por clave");
            System.out.println("6. Eliminar por posición");
            System.out.println("7. Eliminar el primer elemento");
            System.out.println("8. Eliminar el último elemento");
            System.out.println("9. Tamaño de la lista");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            if (opcion == 0) {
                System.out.println("Programa finalizado.");
                break;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el valor a insertar al inicio: ");
                    int valInicio = scanner.nextInt();
                    lista.insertFirst(valInicio);
                    break;
                case 2:
                    System.out.print("Ingresa el valor a insertar al final: ");
                    int valFinal = scanner.nextInt();
                    lista.insertLast(valFinal);
                    break;
                case 3:
                    System.out.println("Lista actual: " + lista);
                    break;
                case 4:
                    System.out.print("Ingrese el valor a buscar: ");
                    int buscar = scanner.nextInt();
                    boolean encontrado = lista.search(buscar);
                    System.out.println(encontrado ? "Elemento encontrado." : "Elemento no encontrado.");
                    break;
                case 5:
                    System.out.print("Ingrese el valor a eliminar: ");
                    int key = scanner.nextInt();
                    lista.deleteByKey(key);
                    break;
                case 6:
                    System.out.print("Ingrese la posición a eliminar: ");
                    int pos = scanner.nextInt();
                    lista.deleteAtPosition(pos);
                    break;
                case 7:
                    lista.removeFirst();
                    System.out.println("Primer elemento eliminado.");
                    break;
                case 8:
                    lista.removeLast();
                    System.out.println("Último elemento eliminado.");
                    break;
                case 9:
                    System.out.println("Tamaño de la lista: " + lista.size());
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
