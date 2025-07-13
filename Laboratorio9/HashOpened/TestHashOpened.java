package Laboratorio9.HashOpened;

import java.util.Scanner;

public class TestHashOpened {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashOpened<String> hashTable = new HashOpened<>(8);
        int opcion;
        do {
            System.out.println("\n--- MENÚ: HASH ABIERTO ---");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Buscar elemento");
            System.out.println("4. Mostrar tabla hash");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave (entero): ");
                    int claveInsertar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el valor (String): ");
                    String valor = scanner.nextLine();
                    hashTable.insert(new Register<>(claveInsertar, valor));
                    break;

                case 2:
                    System.out.print("Ingrese la clave a eliminar: ");
                    int claveEliminar = scanner.nextInt();
                    hashTable.delete(claveEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese la clave a buscar: ");
                    int claveBuscar = scanner.nextInt();
                    Register<String> resultado = hashTable.search(claveBuscar);
                    if (resultado != null) {
                        System.out.println("Elemento encontrado: " + resultado);
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    break;
                case 4:
                    hashTable.showTable();
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