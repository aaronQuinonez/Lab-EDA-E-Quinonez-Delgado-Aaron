package Ejercicios_Propuestos.Ejercicio3;
import Ejercicios_Propuestos.BST;

public class Test {
    public static void main(String[] args) {
        BST<Integer> arbol = new BST<>();
        try {
            // Insertamos algunos valores
            arbol.insert(50);
            arbol.insert(30);
            arbol.insert(70);
            arbol.insert(20);
            arbol.insert(40);
            arbol.insert(60);
            arbol.insert(80);

            arbol.printTreeGraph();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}