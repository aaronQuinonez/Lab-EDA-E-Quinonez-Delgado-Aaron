/*
 * Cuadrado recursivo. El método cuadradoRecursivo calcula y muestra el resultado.
 */

import java.util.Scanner;

public class EjercicioPropuesto6Lab2 {
    public static void cuadradoRecursivo(int base){
        for (int i = 0; i < base; i++) {
            for (int col = 0; col < base; col++) {
                if (i == 0 || i == base-1 || col == 0 || col == base-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(); // Salto de línea después de cada fila
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de la base:");
        int base = sc.nextInt();
        cuadradoRecursivo(base);
    }
}
