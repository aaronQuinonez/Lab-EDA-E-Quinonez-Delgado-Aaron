package Laboratorio2;

//Invertir vector de enteros, permite ingresar tamaño y captura de valores del arreglo, el método 
//invertirArray calcula y muestra el resultado.

import java.util.Scanner;

public class EjercicioPropuesto1Lab2 {
    public static int[] invertirArray(int[] A){
        int[] Asalida = new int[A.length];
        int i = 0;
        //Creamos un loop que recorrerá desde la última posición del array original y será la primera posición del nuevo array "Asalida" 
        for(int j=A.length-1; i<A.length; j--){
            Asalida[i] = A[j];
            i++;
        }
        return Asalida;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        //Pedimos al usuario que ingrese el array con su respectiva longitud
        System.out.println("Ingrese la longitud del array");
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i=0; i<len; i++){
            System.out.println("Ingrese el valor para la posición " + i + ": ");
            arr[i] = sc.nextInt();
        }
        int[] arrInv = invertirArray(arr);
        //Imprimimos el array original
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
        //Imprimimos el array invertido
        for(int num : arrInv){
            System.out.print(num + " ");
        }
    }
}
