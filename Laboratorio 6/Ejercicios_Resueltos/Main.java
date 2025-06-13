package Ejercicios_Resueltos;

public class Main {
    public static void main(String[] args) {
        BST<Integer> arbol = new BST<>();
        System.out.println(arbol.isEmpty());
        try {
            arbol.insert(15);
            arbol.insert(10);
            arbol.insert(7);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
