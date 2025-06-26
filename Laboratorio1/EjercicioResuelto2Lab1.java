package Laboratorio1;

import java.util.Scanner;

public class EjercicioResuelto2Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un número:");
        int n = scanner.nextInt();

        int suma = 0;
        int i = 1;

        while (i <= n) {
            suma += i;
            i++;
        }

        System.out.println("La suma de los primeros " + n + " números naturales es: " + suma);
        scanner.close();
    }
}
