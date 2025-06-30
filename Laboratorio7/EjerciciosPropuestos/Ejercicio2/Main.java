package Laboratorio7.EjerciciosPropuestos.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        try {
            AVLTree<Integer> tree = new AVLTree<>();
            // Insertar elementos
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);
            tree.insert(10);
            tree.insert(25);
            tree.insert(35);
            tree.insert(50);
            tree.insert(5);
            tree.insert(15);
            System.out.println("Árbol AVL después de insertar:");
            System.out.println(tree);
            // Buscar elementos
            System.out.println("\n¿Contiene 25? " + tree.search(25));
            System.out.println("¿Contiene 100? " + tree.search(100));
            // Mínimo y máximo
            System.out.println("\nMínimo: " + tree.min());
            System.out.println("Máximo: " + tree.max());
            // Predecesor y Sucesor
            System.out.println("\nPredecesor de 25: " + tree.predecesor(25));
            System.out.println("Sucesor de 25: " + tree.sucesor(25));
            // Eliminar nodo
            tree.remove(30);  // nodo con dos hijos
            System.out.println("\nÁrbol AVL después de eliminar 30:");
            System.out.println(tree);
            // Eliminar hoja
            tree.remove(5);
            System.out.println("\nÁrbol AVL después de eliminar 5:");
            System.out.println(tree);
            // Destruir el árbol
            tree.destroy();
            System.out.println("\n¿Árbol vacío? " + tree.isEmpty());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
