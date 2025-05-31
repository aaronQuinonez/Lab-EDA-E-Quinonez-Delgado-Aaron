package Problemas_Propuestos.Ejercicio5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		ListLinked<Integer> lista = new ListLinked<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (true) {
            System.out.println("\nMENÚ");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Mostrar lista");
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
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
	}
}
