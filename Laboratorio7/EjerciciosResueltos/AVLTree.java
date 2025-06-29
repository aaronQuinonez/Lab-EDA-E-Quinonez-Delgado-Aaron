package Laboratorio7.EjerciciosResueltos;

public class AVLTree<E extends Comparable<E>> extends BST<E> {
    private boolean height;

    @Override
    public void insert(E x) throws ExceptionItemDuplicate {
        height = false;
        //Se castea ya que solo se inserta nodos de tipo NodeAVL<E>
        root = insertAVL((NodeAVL<E>) root, x);
    }

    private NodeAVL<E> insertAVL(NodeAVL<E> node, E x) throws ExceptionItemDuplicate {
        if (node == null) {
            height = true;
            return new NodeAVL<>(x);
        }

        int cmp = x.compareTo(node.getData());

        if (cmp == 0) {
            height = false;
            throw new ExceptionItemDuplicate("Elemento duplicado");
        }

        if (cmp < 0) {
            node.setLeft(insertAVL((NodeAVL<E>) node.getLeft(), x));
            if (height) {
                node.setFE(node.getFE() - 1);
            }
        } else {
            node.setRight(insertAVL((NodeAVL<E>) node.getRight(), x));
            if (height) {
                node.setFE(node.getFE() + 1);
            }
        }

        // Verifica si el nodo está balanceado
        if (node.getFE() == 0) {
            height = false;
        } else if (Math.abs(node.getFE()) > 1) {
            node = rebalance(node);
            height = false;
        }

        return node;
    }

    private NodeAVL<E> rebalance(NodeAVL<E> node) {
        if (node.getFE() == -2) {
            NodeAVL<E> left = (NodeAVL<E>) node.getLeft();
            if (left.getFE() <= 0) {
                return rotateRight(node); // Caso izquierda-izquierda
            } else {
                node.setLeft(rotateLeft(left)); // Caso izquierda-derecha
                return rotateRight(node);
            }
        } else if (node.getFE() == 2) {
            NodeAVL<E> right = (NodeAVL<E>) node.getRight();
            if (right.getFE() >= 0) {
                return rotateLeft(node); // Caso derecha-derecha
            } else {
                node.setRight(rotateRight(right)); // Caso derecha-izquierda
                return rotateLeft(node);
            }
        }
        return node;
    }

    private NodeAVL<E> rotateLeft(NodeAVL<E> x) {
        NodeAVL<E> y = (NodeAVL<E>) x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);

        // Actualizar FE
        x.setFE(x.getFE() - 1 - Math.max(y.getFE(), 0));
        y.setFE(y.getFE() - 1 + Math.min(x.getFE(), 0));

        return y;
    }

    private NodeAVL<E> rotateRight(NodeAVL<E> y) {
        NodeAVL<E> x = (NodeAVL<E>) y.getLeft();
        y.setLeft(x.getRight());
        x.setRight(y);

        // Actualizar FE
        y.setFE(y.getFE() + 1 - Math.min(x.getFE(), 0));
        x.setFE(x.getFE() + 1 + Math.max(y.getFE(), 0));

        return x;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Árbol AVL:\n");
        inorden((NodeAVL<E>) root, str);
        return str.toString();
    }

    private void inorden(NodeAVL<E> node, StringBuilder str) {
        if (node != null) {
            inorden((NodeAVL<E>) node.getLeft(), str);
            str.append(node.getData().toString() + " ");
            inorden((NodeAVL<E>) node.getRight(), str);
        }
    }
}
