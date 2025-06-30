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
        if(node == null){
            height = true;
            return new NodeAVL<>(x);
        }
        int cmp = x.compareTo(node.getData());
        if(cmp == 0) {
            height = false;
            throw new ExceptionItemDuplicate("Elemento duplicado: " + x);
        }
        else if(cmp > 0) {
            node.setRight(insertAVL(node.getRight(), x));
            if (height) {
                switch (node.getFe()) {
                    case -1 -> {
                        node.setFe(0);
                        height = false;
                    }
                    case 0 -> node.setFe(1);
                    case 1 -> {
                        node = balancearDerecha(node);
                        height = false;
                    }
                }
            }
        }
        else {
            node.setLeft(insertAVL(node.getLeft(), x));
            if (height) {
                switch (node.getFe()) {
                    case 1 -> {
                        node.setFe(0);
                        height = false;
                    }
                    case 0 -> node.setFe(-1);
                    case -1 -> {
                        node = balancearIzquierda(node);
                        height = false;
                    }
                }
            }
        }
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

    private NodeAVL<E> rotacionSimpleDerecha(NodeAVL<E> y){
        NodeAVL<E> x = y.getLeft();
        y.setLeft(x.getRight());
        x.setRight(y);
        //Factores de equilibrio
        y.setFe(y.getFe() + 1 - Math.min(x.getFe(), 0));
        x.setFe(x.getFe() + 1 + Math.max(y.getFe(), 0));
        return x;
    }

    private NodeAVL<E> balancearIzquierda(NodeAVL<E> node){
        NodeAVL<E> left = node.getLeft();
        if(left.getFe() > 0) node.setLeft(rotacionSimpleIzquierda(left));
        return rotacionSimpleDerecha(node);
    }

    private NodeAVL<E> balancearDerecha(NodeAVL<E> node){
        NodeAVL<E> right = node.getRight();
        if(right.getFe() > 0) node.setRight(rotacionSimpleDerecha(right));
        return rotacionSimpleIzquierda(node);
    }

    public boolean search(E data) {
        NodeAVL<E> current = root;
        while (current != null) {
            int cmp = data.compareTo(current.getData());
            
            if (cmp == 0) return true;
            else if (cmp < 0) current = current.getLeft();
            else current = current.getRight();
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString().trim();
    }

    private void inOrder(NodeAVL<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.getLeft(), sb);
            sb.append(node.getData()).append(" ");
            inOrder(node.getRight(), sb);
        }
    }
}
