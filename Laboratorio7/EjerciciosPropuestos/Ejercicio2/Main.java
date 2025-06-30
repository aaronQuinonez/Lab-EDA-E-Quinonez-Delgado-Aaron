package Laboratorio7.EjerciciosPropuestos.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        try {
            // Caso: sin necesidad de rotación
            avl.insert(30);
            avl.insert(20);
            avl.insert(40);
            // Caso: rotación simple a la derecha
            avl.insert(10);
            // Caso: rotación simple a la izquierda
            avl.insert(50);
            // Caso: rotación doble izquierda-derecha (LR)
            avl.insert(25);
            // Caso: rotación doble derecha-izquierda (RL)
            avl.insert(45);
            System.out.println("Recorrido del árbol AVL:");
            System.out.println(avl.toString());

        } catch (ExceptionItemDuplicate e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
