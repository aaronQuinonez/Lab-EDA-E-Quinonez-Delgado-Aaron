/* 
 * Desarrolla un programa en Java que implemente un sistema de gestión de calificaciones de estudiantes. El
programa debe permitir al usuario ingresar las calificaciones de N estudiantes y calcular la mediana, moda
y desviación estándar
*/

import java.util.Scanner;

public class EjercicioPropuesto1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de estudiantes:");
        int n = sc.nextInt();
        //Array de longitud "n"
        int[] notas = new int[n];
        //Haciendo un bucle que se repetirá "n" veces
        for(int i=0; i<n; i++){
            //Ingreso de notas
            System.out.println("Ingrese la nota del estudiante " + (i+1) + ":");
            notas[i] = sc.nextInt();
        }
        //Ordenamos el array usando el método "OrdenarArray"
        OrdenarArray(notas);
        //Imprimimos el array
        ImprimirArray(notas);
        //Usamos el método "Mediana"
        System.out.println("La mediana es: " + Mediana(notas));

    }
    public static void OrdenarArray(int[] notas){
        //Metodo Bubble Sort
        for(int i=0; i<notas.length-1; i++){
            for(int j=0; j<notas.length-1-i; j++){
                //Si el numero actual es mayor que el siguiente, intercambian posiciones
                if(notas[j] > notas[j+1]){
                    int tmp = notas[j+1];
                    notas[j+1] = notas[j];
                    notas[j] = tmp;
                }
            }
        }
    }
    public static void ImprimirArray(int[] notas) {
        System.out.print("Notas: ");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i]);
            if (i < notas.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    public static double Mediana(int[] notas){
        //Devolvemos la posición media del array si la longitud es par
        if(notas.length % 2 == 0){
            return (notas[notas.length/2]+notas[(notas.length/2)-1])/2.0;
        }
        return notas[notas.length/2];
    }
}