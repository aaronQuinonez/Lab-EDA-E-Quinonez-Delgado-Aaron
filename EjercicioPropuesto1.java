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
            System.out.println("Ingrese la nota del estudante " + (i+1) + ":");
            notas[i] = sc.nextInt();
        }
        //Ordenamos el array usando el método "OrdenarArray"
        OrdenarArray(notas);
        //Usamos el método "Mediana"
        System.out.println("La mediana es: " + Mediana(notas));

    }
    public static void OrdenarArray(int[] notas){
        //Metodo Bubble Sort
        for(int i=0; i<notas.length-1; i++){
            for(int j=0; j<notas.length-1-i; i++){
                //Si el numero actual es mayor que el siguiente, intercambian posiciones
                if(notas[j] > notas[j+1]){
                    int tmp = notas[j+1];
                    notas[j+1] = notas[j];
                    notas[j] = tmp;
                }
            }
        }
    }
    public static int Mediana(int[] notas){
        //Devolvemos la posición media del array
        return notas[notas.length/2];
    }
}