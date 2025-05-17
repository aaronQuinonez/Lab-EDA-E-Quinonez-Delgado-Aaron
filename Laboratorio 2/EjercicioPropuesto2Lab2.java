/* Rotar a la Izquierda, permite ingresar tamaño y captura de valores del arreglo, el método 
 * rotarIzquierdaArray calcula y muestra el resultado.
 */

import java.util.Scanner;

public class EjercicioPropuesto2Lab2 {
    public static int[] rotarIzquierdaArray(int[] A, int d) { 
        int[] Ainvertido = A.clone();
        for(int i=0; i<d; i++){
            //Guardamos el primer valor del array el cual será movido hacia la última posición del array
            int tmp = Ainvertido[0];
            //Rotamos los valores del array un espacio hacia la izquierda
            for(int j=1; j<Ainvertido.length; j++){
                Ainvertido[j-1] = Ainvertido[j];
            }
            Ainvertido[A.length-1] =tmp;
        }
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
        int[] ArrayInv = rotarIzquierdaArray(A, d);
        //Imprimimos el array original
        for(int num : A){
            System.out.print(num + " ");
        }
        System.out.println();
        //Imprimimos el array invertido
        for(int num : ArrayInv){
            System.out.print(num + " ");
        }
    }
}
