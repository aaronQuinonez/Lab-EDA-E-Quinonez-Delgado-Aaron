/*
 * Triangulo recursivo 1. El método trianguloRecursivo1 calcula y muestra el resultado.
 */

import java.util.Scanner;

public class EjercicioPropuesto3Lab2 {
    public static void trianguloRecursivo1(int base){
        /*String triangulo = "";
        for(int i=0; i<base; i++){
            for(int j=0; j<i+1; j++){
                triangulo += "*";
            }
            triangulo += "\n";
        }
        System.out.println(triangulo);*/
        //Caso base
        if(base == 0){
            return ;
        }
        trianguloRecursivo1(base-1);
        String str = "";
        for(int i=0; i<base; i++){
            str += "*";
        }
        System.out.println(str);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de la base del triángulo:");
        int base = sc.nextInt();
        trianguloRecursivo1(base);
    }
}
