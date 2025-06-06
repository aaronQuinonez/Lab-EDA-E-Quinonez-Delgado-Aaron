package Ejercicios_Propuestos.Ejercicio2;

import java.util.Scanner;

import Ejercicios_Propuestos.QueueGen;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueGen<Integer> cola = new QueueGen<>();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        cola.enqueue(5);
        cola.enqueue(6);
        cola.enqueue(7);
        cola.enqueue(8);
        cola.enqueue(9);
        cola.enqueue(10);
        int opcion = -1;
        System.out.println("Cola inicializada. Lista para recibir datos.");
        while (opcion != 0) {
            System.out.println("\n--- MENÚ DE COLA ---");
            System.out.println("1. Encolar (enqueue)");
            System.out.println("2. Desencolar (dequeue)");
            System.out.println("3. Ver frente (front)");
            System.out.println("4. Ver final (back)");
            System.out.println("5. ¿Está vacía?");
            System.out.println("6. Vaciar cola (destroyQueue)");
            System.out.println("7. Mostrar cola");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número a encolar: ");
                    int num = sc.nextInt();
                    cola.enqueue(num);
                    System.out.println("Elemento encolado.");
                    break;

                case 2:
                    System.out.println("Elemento desencolado: " + cola.dequeue());
                    break;
                case 3:
                    System.out.println("Frente de la cola: " + cola.front());
                    break;

                case 4:
                    System.out.println("Final de la cola: " + cola.back());
                    break;

                case 5:
                    System.out.println("¿Cola vacía? " + cola.isEmpty());
                    break;

                case 6:
                    cola.destroyQueue();
                    System.out.println("Cola vaciada.");
                    break;

                case 7:
                    System.out.println(cola);
                    break;

                case 0:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
        sc.close();
    }
}
