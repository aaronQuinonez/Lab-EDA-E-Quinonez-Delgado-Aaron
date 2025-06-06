package Ejercicios_Propuestos.Ejercicio1;
import java.util.Scanner;

import Ejercicios_Propuestos.StackGen;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackGen<Integer> pila = new StackGen<>();
        pila.push(10);
        pila.push(9);
        pila.push(8);
        pila.push(7);
        pila.push(6);
        pila.push(5);
        pila.push(4);
        pila.push(3);
        pila.push(2);
        pila.push(1);
        int opcion = -1;
        System.out.println("--- MENÚ ---");
        while (opcion != 0) {
            System.out.println("1. Insertar elemento (push)");
            System.out.println("2. Eliminar elemento (pop)");
            System.out.println("3. Ver elemento tope (top)");
            System.out.println("4. ¿Está vacía? (isEmpty)");
            System.out.println("5. Mostrar pila (printStack)");
            System.out.println("6. Vaciar pila (destroyStack)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número a insertar: ");
                    if (sc.hasNextInt()) {
                        int valor = sc.nextInt();
                        pila.push(valor);
                        System.out.println("Elemento insertado.");
                    } else {
                        System.out.println("Entrada inválida.");
                        sc.next();
                    }
                    break;
                case 2:
                    System.out.println("Elemento eliminado: " + pila.pop());
                    break;
                case 3:
                    System.out.println("Elemento en el tope: " + pila.top());
                    break;
                case 4:
                    System.out.println("¿Está vacía?: " + pila.isEmpty());
                    break;
                case 5:
                    System.out.println("Elementos en la pila:\n" + pila);
                    break;
                case 6:
                    pila.destroyStack();
                    System.out.println("Pila vaciada.");
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
