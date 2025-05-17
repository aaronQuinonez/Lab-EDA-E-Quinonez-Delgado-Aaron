/* Rotar a la Izquierda, permite ingresar tamaño y captura de valores del arreglo, el método 
 * rotarIzquierdaArray calcula y muestra el resultado.
 */

import java.util.Scanner;

public class EjercicioPropuesto2Lab2 {
    public int[] rotarIzquierdaArray(int[] A, int d) { 
        int[] Ainvertido = new int[A.length];
        return Ainvertido; 
    } 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Pedimos la longitud y valores del array
        System.out.println("Ingrese la longitud del array");
        int len = sc.nextInt();
        int[] A = new int[len];
        for(int i=0; i<len; i++){
            System.out.println("Ingrese el valor para la posición " + i + ": ");
            A[i] = sc.nextInt();
        }
        //Pedimos la cantidad de veces que rotará hacia la izquierda
        System.out.println("Ingrese la cantidad de veces que rotará hacia la izquierda");
        int d = sc.nextInt();
        
    }
}
