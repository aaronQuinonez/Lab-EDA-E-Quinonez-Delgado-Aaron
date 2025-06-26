package Laboratorio2;
/*
 * Cuadrado recursivo. El método cuadradoRecursivo calcula y muestra el resultado.
 */

import java.util.Scanner;

public class EjercicioPropuesto6Lab2 {
    public static int fila = 0;
    public static void cuadradoRecursivo(int base){
        //Caso base
        if(fila > base-1){
            return;
        }
        for (int col = 0; col < base; col++) {
            if (fila == 0 || fila == base-1 || col == 0 || col == base-1) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        fila++;
        //Salto de línea después de cada fila
        System.out.println();
        cuadradoRecursivo(base);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de la base:");
        int base = sc.nextInt();
        cuadradoRecursivo(base);
    }
}
