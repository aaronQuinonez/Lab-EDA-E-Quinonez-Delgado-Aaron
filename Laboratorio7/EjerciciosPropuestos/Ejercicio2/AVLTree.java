package Laboratorio7.EjerciciosPropuestos.Ejercicio2;

public class AVLTree<E extends Comparable<E>> {
    private NodeAVL<E> root;
    private boolean height;
    
    public AVLTree(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void destroy(){
        root = null;
    }

    public void insert(E data) throws ExceptionItemDuplicate{
        height = false;
        root = insertAVL(root, data);
    }

    private NodeAVL<E> insertAVL(NodeAVL<E> node, E x) throws ExceptionItemDuplicate{
        if(isEmpty()) return new NodeAVL<>(x);
        int cmp = x.compareTo(node.getData());
        if(cmp == 0) throw new ExceptionItemDuplicate("Elemento duplicado: " + x);
        else if(cmp > 0) node.setRight(insertAVL(node.getRight(), x));
        else node.setLeft(insertAVL(node.getLeft(), x));
        return node;
    }
    
    private NodeAVL<E> rotacionSimpleIzquierda(NodeAVL<E> x){
        NodeAVL<E> y = x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);
        //Factores de equilibrio
        x.setFe(x.getFe() - 1 - Math.max(y.getFe(), 0));
        y.setFe(y.getFe() - 1 + Math.min(x.getFe(), 0));
        return y;
    }
}
