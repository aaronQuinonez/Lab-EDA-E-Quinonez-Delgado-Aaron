package Laboratorio9.HashClosed;

import java.util.Scanner;

public class TestHashClosed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashClosed<Integer> hashTable = new HashClosed<>(10);

        int opcion;
        do {
            System.out.println("\n--- MENÚ: HASH CERRADO ---");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Buscar elemento");
            System.out.println("4. Mostrar tabla hash");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave: ");
                    int claveInsertar = scanner.nextInt();
                    System.out.print("Ingrese el valor: ");
                    int valor = scanner.nextInt();
                    hashTable.add(new Register<>(claveInsertar, valor));
                    break;

                case 2:
                    System.out.print("Ingrese la clave a eliminar: ");
                    int claveEliminar = scanner.nextInt();
                    hashTable.remove(claveEliminar);
                    break;

                case 3:
                    System.out.print("Ingrese la clave a buscar: ");
                    int claveBuscar = scanner.nextInt();
                    Register<Integer> encontrado = hashTable.find(claveBuscar);
                    if (encontrado != null) {
                        System.out.println("Elemento encontrado: " + encontrado);
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    break;

                case 4:
                    hashTable.display();
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 5);
        scanner.close();
    }
}
