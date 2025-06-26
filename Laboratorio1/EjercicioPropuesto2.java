package Laboratorio1;

/*
 * Implementa un programa en Java que encuentre todos los números primos en un rango definido por el
 * usuario utilizando el algoritmo de la Criba de Eratóstenes
 */
import java.util.Scanner;

public class EjercicioPropuesto2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Pedimos al usuario que ingrese los límites
        System.out.println("Ingrese el rango inferior");
        int rangoInf = sc.nextInt();
        System.out.println("Ingrese el rango superior");
        int rangoSup = sc.nextInt();
        //Comprobamos que los rangos son válidos y mayores que 1 para ver cuáles son primos
        if(rangoInf < 2 && rangoInf < rangoSup){
            System.out.println("Ingrese un rango válido");
            return;
        }
        //Creamos un array de tipo boolean que empezará desde 0 hasta "rangoSup"
        //A partir del número 2 serán True, con la criba de Eratóstenes se irán descartando los números no primos
        boolean[] numPrimo = new boolean[rangoSup + 1];
        for (int i=2; i<=rangoSup; i++){
            numPrimo[i] = true;
        }
        // Criba de Eratóstenes
        //Evaluamos con i*i porque no es necesario evaluar más allá de la raíz cuadrada del rangoSup
        for (int i=2; i*i <= rangoSup; i++){
            if (numPrimo[i]){
                for (int j = i * i; j <= rangoSup; j += i){
                    numPrimo[j] = false;
                }
            }
        }
        //Finalmente presentamos los números primos
        System.out.println("Los números primos solicitados son:");
        for (int i=rangoInf; i<=rangoSup; i++){
            if (numPrimo[i]){
                System.out.print(i + " ");
            }
        }
    }
}
