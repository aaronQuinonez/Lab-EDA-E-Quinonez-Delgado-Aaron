package Laboratorio7.EjerciciosPropuestos.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        try {
            avl.insert(30);
            avl.insert(20);
            avl.insert(40);
            avl.insert(10);
            avl.insert(50);
            avl.insert(25);
            avl.insert(45);
            System.out.println("Recorrido del árbol AVL:");
            System.out.println(avl.toString());

            System.out.println("\nMétodo search():");
            System.out.println("¿25? " + avl.search(25));
            System.out.println("¿40? " + avl.search(40));
            System.out.println("¿99? " + avl.search(99));
            System.out.println("¿5?  " + avl.search(5));
        } catch (ExceptionItemDuplicate e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\nMínimo del árbol: " + avl.min());
            System.out.println("Máximo del árbol: " + avl.max());
            System.out.println("Predecesor de 25: " + avl.predecesor(25));
            System.out.println("Sucesor de 25: " + avl.sucesor(25));
        } catch (ExceptionItemNotFound e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
