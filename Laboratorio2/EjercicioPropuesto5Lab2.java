package Laboratorio2;
/*
 * Triangulo recursivo 3. El método trianguloRecursivo3 calcula y muestra el resultado.
 */

import java.util.Scanner;

public class EjercicioPropuesto5Lab2 {
    public static int fila = 1;
    public static void trianguloRecursivo3(int base, int fila){
        //Caso base
        if(fila > base)
            return;
        //Imprimimos los espacios iniciales por fila: base-fila
        for(int i=0; i<base-fila; i++)
            System.out.print(" ");
        //Imprimimos el número de * segun la fila
        for(int i=0; i<fila; i++)
            System.out.print("* ");
        System.out.println();
        trianguloRecursivo3(base, fila+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor para la base");
        int base = sc.nextInt();
        trianguloRecursivo3(base, fila);
    }
}
