package Ejercicios_Propuestos.Ejercicio1;
import Ejercicios_Propuestos.StackGen;

public class Main {
    public static void main(String[] args) {
        StackGen<Integer> pilaNums = new StackGen<>();
        //Usando isEmpty
        System.out.println("¿Está vacío? " + pilaNums.isEmpty());
        //Agregando elementos
        pilaNums.push(1);
        pilaNums.push(2);
        pilaNums.push(3);
        pilaNums.push(4);
        pilaNums.push(5);
        pilaNums.push(6);
        pilaNums.push(7);
        pilaNums.push(8);
        pilaNums.push(9);
        pilaNums.push(10);
        System.out.println("¿Está vacío? " + pilaNums.isEmpty());
        System.out.println("Pila:\n" + pilaNums);
        System.out.println("Tope: " + pilaNums.top());
        //Eliminando elementos
        pilaNums.pop();
        pilaNums.pop();
        System.out.println("¿Está vacío? " + pilaNums.isEmpty());
        System.out.println("Pila:\n" + pilaNums);
        System.out.println("Tope: " + pilaNums.top());
        //Usando destroyStack
        pilaNums.destroyStack();
        System.out.println("¿Está vacío? " + pilaNums.isEmpty());
    }
}
