package Laboratorio7.EjerciciosPropuestos.Ejercicio2;

public class AVLTree<E> {
    private NodeAVL<E> root;
    
    public AVLTree(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }
}
