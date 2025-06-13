package Ejercicios_Resueltos;

public class Main {
    public static void main(String[] args) {
        BST<Integer> arbol = new BST<>();
        System.out.println(arbol.isEmpty());
        try {
            arbol.insert(15);
            arbol.insert(10);
            arbol.insert(7);
            System.out.println("Buscar 10: " + arbol.search(10));
            System.out.println("Buscar 25: " + arbol.search(25));
            System.out.println("El valor mínimo del árbol es: " + arbol.min());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
