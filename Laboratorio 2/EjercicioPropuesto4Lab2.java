/*
 * Triangulo recursivo 2. El método trianguloRecursivo2 calcula y muestra el resultado
 */

import java.util.Scanner;

public class EjercicioPropuesto4Lab2 {
    public static void trianguloRecursivo2(int base, int espacios){
        //Usamos i como el número de asteriscos por fila, j los espacios y k imprime los asteriscos correspondientes a i
        for (int i = 1; i <= base; i++) {
            // Imprimimos espacios a la izquierda
            for (int j = 0; j < base - i; j++) {
                System.out.print(" ");
            }
            // Imprimimos asteriscos
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Pedimos el valor de la base
        System.out.println("Ingrese el valor de la base del triángulo:");
        int base = sc.nextInt();
        //Creamos una variable espacios que determinará el numero de espacios que tendrá en cada fila del triángulo
        int espacios = 0;
        trianguloRecursivo2(base , espacios);
    }
}
