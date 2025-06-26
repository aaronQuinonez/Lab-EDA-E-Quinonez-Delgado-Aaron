package Laboratorio2;
/*
 * Triangulo recursivo 2. El método trianguloRecursivo2 calcula y muestra el resultado
 */

import java.util.Scanner;

public class EjercicioPropuesto4Lab2 {
    public static void trianguloRecursivo2(int base, int espacios){
        /* 
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
        }*/
        //Caso base
        if(base == 0)
            return;
        trianguloRecursivo2(base-1, espacios+1);
        //Creamos 2 string uno para la cantidad de espacios y otro que almacena los *
        String strEsp = "";
        String str = "";
        //Guarda en la variable asteriscos
        for(int i=0; i<base; i++){
            str += "*";
        }
        //Guarda en la variable espacios
        for(int i=0; i<espacios; i++){
            strEsp += " ";
        }
        System.out.println(strEsp + str);
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
