package Laboratorio7.EjerciciosPropuestos.Ejercicio3;

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
        if (left == null) return node;
        if(left.getFe() > 0) node.setLeft(rotacionSimpleIzquierda(left));
        return rotacionSimpleDerecha(node);
    }

    private NodeAVL<E> balancearDerecha(NodeAVL<E> node){
        NodeAVL<E> right = node.getRight();
        if (right == null) return node;
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

    public E min() throws ExceptionItemNotFound {
        if (isEmpty()) throw new ExceptionItemNotFound("El árbol está vacío.");
        NodeAVL<E> current = root;
        while (current.getLeft() != null) current = current.getLeft();
        return current.getData();
    }

    public E max() throws ExceptionItemNotFound {
        if (isEmpty()) throw new ExceptionItemNotFound("El árbol está vacío.");
        NodeAVL<E> current = root;
        while (current.getRight() != null) current = current.getRight();
        return current.getData();
    }

    public E predecesor(E x) throws ExceptionItemNotFound {
        NodeAVL<E> current = root;
        NodeAVL<E> pre = null;
        while (current != null) {
            int cmp = x.compareTo(current.getData());
            if (cmp == 0) {
                // Si tiene subárbol izquierdo, se busca el más grande de dicho subárbol
                if (current.getLeft() != null) {
                    NodeAVL<E> temp = current.getLeft();
                    while (temp.getRight() != null) temp = temp.getRight();
                    return temp.getData();
                }
                break;
            }
            else if (cmp < 0) current = current.getLeft();
            else {
                pre = current;
                current = current.getRight();
            }
        }
        if (pre == null) throw new ExceptionItemNotFound("No hay predecesor");
        return pre.getData();
    }

    public E sucesor(E x) throws ExceptionItemNotFound {
        NodeAVL<E> current = root;
        NodeAVL<E> suc = null;
        while (current != null) {
            int cmp = x.compareTo(current.getData());
            if (cmp == 0) {
                // Si tiene subárbol derecho, se busca el más pequeño de dicho subárbol
                if (current.getRight() != null) {
                    NodeAVL<E> temp = current.getRight();
                    while (temp.getLeft() != null) temp = temp.getLeft();
                    return temp.getData();
                }
                break;
            }
            else if (cmp < 0) {
                suc = current;
                current = current.getLeft();
            } else current = current.getRight();
        }
        if (suc == null) throw new ExceptionItemNotFound("No hay sucesor");
        return suc.getData();
    }

    public void remove(E x) throws ExceptionItemNotFound {
        height = false;
        root = removeAVL(root, x);
    }

    private NodeAVL<E> removeAVL(NodeAVL<E> node, E x) throws ExceptionItemNotFound {
        if (node == null) {
            throw new ExceptionItemNotFound("Elemento no encontrado: " + x);
        }

        int cmp = x.compareTo(node.getData());

        if (cmp < 0) {
            node.setLeft(removeAVL(node.getLeft(), x));
            if (height) {
                node = rebalanceRight(node);
            }
        } else if (cmp > 0) {
            node.setRight(removeAVL(node.getRight(), x));
            if (height) {
                node = rebalanceLeft(node);
            }
        } else {
            // Nodo encontrado
            if (node.getLeft() == null || node.getRight() == null) {
                node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
                height = true;
            } else {
                // Buscar sucesor
                NodeAVL<E> suc = getMin(node.getRight());
                node.setData(suc.getData());
                node.setRight(removeAVL(node.getRight(), suc.getData()));
                if (height) node = rebalanceLeft(node);
            }
        }
        return node;
    }

    private NodeAVL<E> getMin(NodeAVL<E> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private NodeAVL<E> rebalanceLeft(NodeAVL<E> node) {
        int fe = node.getFe();
        if (fe == 1) node.setFe(0);
        else if (fe == 0) {
            node.setFe(-1);
            height = false;
        } else if (fe == -1) {
            NodeAVL<E> left = node.getLeft();
            if (left.getFe() <= 0) {
                node = rotacionSimpleDerecha(node);
                if (left.getFe() == 0) {
                    node.setFe(1);
                    node.getRight().setFe(-1);
                    height = false;
                }
            } else node = balancearIzquierda(node);
        }
        return node;
    }

    private NodeAVL<E> rebalanceRight(NodeAVL<E> node) {
        int fe = node.getFe();
        if (fe == -1) node.setFe(0);
        else if (fe == 0) {
            node.setFe(1);
            height = false;
        } else if (fe == 1) {
            NodeAVL<E> right = node.getRight();
            if (right.getFe() >= 0) {
                node = rotacionSimpleIzquierda(node);
                if (right.getFe() == 0) {
                    node.setFe(-1);
                    node.getLeft().setFe(1);
                    height = false;
                }
            } else node = balancearDerecha(node);
        }

        return node;
    }

    @Override
    public String toString() {
        StringBuilder strIn = new StringBuilder();
        StringBuilder strPre = new StringBuilder();
        StringBuilder strPost = new StringBuilder();

        inOrder(root, strIn);
        preOrder(root, strPre);
        postOrder(root, strPost);

        return "Recorrido Inorden: " + strIn.toString().trim()
            + "\nRecorrido Preorden: " + strPre.toString().trim()
            + "\nRecorrido Postorden: " + strPost.toString().trim();
    }

    private void inOrder(NodeAVL<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.getLeft(), sb);
            sb.append(node.getData()).append(" ");
            inOrder(node.getRight(), sb);
        }
    }

    private void preOrder(NodeAVL<E> node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.getData()).append(" ");
            preOrder(node.getLeft(), sb);
            preOrder(node.getRight(), sb);
        }
    }

    private void postOrder(NodeAVL<E> node, StringBuilder sb) {
        if (node != null) {
            postOrder(node.getLeft(), sb);
            postOrder(node.getRight(), sb);
            sb.append(node.getData()).append(" ");
        }
    }
}
