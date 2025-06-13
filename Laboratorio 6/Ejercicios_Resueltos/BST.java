package Ejercicios_Resueltos;

public class BST<E extends Comparable<E>> implements BSTInterface<E>{
    private Node<E> root;

    public BST(){
        this.root = null;
    }

    @Override
    public boolean isEmpty(){
        return root == null;
    }

    @Override
    public void destroy() {}

    @Override
    public void insert(E x) {}

    @Override
    public void remove(E x) {}

    @Override
    public boolean search(E x) {
        return false;
    }

    @Override
    public E min() {
        return null;
    }

    @Override
    public E max() {
        return null;
    }

    @Override
    public E predecesor(E x) {
        return null;
    }

    @Override
    public E sucesor(E x) {
        return null;
    }

    
}
