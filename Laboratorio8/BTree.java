package Laboratorio8;

import java.util.ArrayList;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int orden;
    private boolean up;
    private BNode<E> nDes;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E cl) {
        up = false;
        E mediana;
        BNode<E> pnew;
        mediana = push(this.root, cl);
        if (up) {
            pnew = new BNode<E>(this.orden);
            pnew.count = 1;
            pnew.keys.set(0, mediana);
            pnew.childs.set(0, this.root);
            pnew.childs.set(1, nDes);
            this.root = pnew;
        }
    }

    private E push(BNode<E> current, E cl) {
        int pos[] = new int[1];
        E mediana;
        if (current == null) {
            up = true;
            nDes = null;
            return cl;
        } else {
            boolean fl;
            fl = current.searchNode(cl, pos);
            if (fl) {
                System.out.println("Item duplicado\n");
                up = false;
                return null;
            }

            mediana = push(current.childs.get(pos[0]), cl);
            if (up) {
                if (current.nodeFull(orden - 1)) {
                    mediana = dividedNode(current, mediana, pos[0]);
                } else {
                    putNode(current, mediana, nDes, pos[0]);
                    up = false;
                }
            }
            return mediana;
        }
    }

    private void putNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        int i;
        for (i = current.count - 1; i >= k; i--) {
            current.keys.set(i + 1, current.keys.get(i));
            current.childs.set(i + 2, current.childs.get(i + 1));
        }
        current.keys.set(k, cl);
        current.childs.set(k + 1, rd);
        current.count++;
    }

    private E dividedNode(BNode<E> current, E cl, int k) {
        BNode<E> rd = nDes;
        nDes = new BNode<E>(orden);

        // Crear arrays temporales para insertar claves/hijos de manera ordenada
        ArrayList<E> tempKeys = new ArrayList<>(orden);
        ArrayList<BNode<E>> tempChilds = new ArrayList<>(orden + 1);

        // Copiar claves existentes
        for (int i = 0; i < current.count; i++) {
            tempKeys.add(current.keys.get(i));
        }
        // Insertar clave nueva en la posición correcta
        tempKeys.add(null); // para agrandar
        for (int i = tempKeys.size() - 1; i > k; i--) {
            tempKeys.set(i, tempKeys.get(i - 1));
        }
        tempKeys.set(k, cl);

        // Copiar hijos existentes
        for (int i = 0; i <= current.count; i++) {
            tempChilds.add(current.childs.get(i));
        }
        tempChilds.add(null); // agrandar lista
        for (int i = tempChilds.size() - 1; i > k + 1; i--) {
            tempChilds.set(i, tempChilds.get(i - 1));
        }
        tempChilds.set(k + 1, rd);

        int med = (orden - 1) / 2;
        E median = tempKeys.get(med);

        // Limpiar nodos actuales
        for (int i = 0; i < orden - 1; i++) {
            current.keys.set(i, null);
            nDes.keys.set(i, null);
        }
        for (int i = 0; i < orden; i++) {
            current.childs.set(i, null);
            nDes.childs.set(i, null);
        }

        current.count = 0;
        nDes.count = 0;

        // Llenar current con claves e hijos de la izquierda
        for (int i = 0; i < med; i++) {
            current.keys.set(i, tempKeys.get(i));
            current.childs.set(i, tempChilds.get(i));
            current.count++;
        }
        current.childs.set(med, tempChilds.get(med));

        // Llenar nDes con claves e hijos de la derecha
        for (int i = med + 1, j = 0; i < tempKeys.size(); i++, j++) {
            nDes.keys.set(j, tempKeys.get(i));
            nDes.childs.set(j, tempChilds.get(i));
            nDes.count++;
        }
        nDes.childs.set(nDes.count, tempChilds.get(tempKeys.size()));

        return median;
    }


    public String toString() {
        String s = "";
        if (isEmpty())
            s += "BTree is empty...";
        else
            s = writeTree(this.root);
        return s;
    }

    private String writeTree(BNode<E> current) {
        return writeTree(current, 0);
    }

    public boolean search(E x) {
        return search(this.root, x);
    }

    private boolean search(BNode<E> current, E x) {
        if (current == null) {
            return false;
        }
        int i = 0;
        while (i < current.count && x.compareTo(current.keys.get(i)) > 0) {
            i++;
        }
        // Si encontramos la clave
        if (i < current.count && x.compareTo(current.keys.get(i)) == 0) {
            return true;
        }
        // Si llegamos a un nodo hoja sin encontrarla
        if (current.childs.get(i) == null) {
            return false;
        }
        // Buscar recursivamente en el hijo adecuado
        return search(current.childs.get(i), x);
    }

    public E min() {
        if (isEmpty()) return null;
        return min(this.root);
    }

    private E min(BNode<E> node) {
        while (node.childs.get(0) != null) {
            node = node.childs.get(0);
        }
        return node.keys.get(0); // Primera clave es la menor
    }

    public E max() {
        if (isEmpty()) return null;
        return max(this.root);
    }

    private E max(BNode<E> node) {
        while (node.childs.get(node.count) != null) {
            node = node.childs.get(node.count);
        }
        return node.keys.get(node.count - 1); // Última clave es la mayor
    }

    private String writeTree(BNode<E> current, int level) {
        StringBuilder sb = new StringBuilder();
        if (current != null) {
            // Agregar espacios según el nivel
            for (int i = 0; i < level; i++) {
                sb.append(" ");
            }
            sb.append("Nivel ").append(level).append(": ").append(current.toString()).append("\n");

            // Llamar recursivamente a los hijos
            for (int i = 0; i <= current.count; i++) {
                BNode<E> child = current.childs.get(i);
                if (child != null) {
                    sb.append(writeTree(child, level + 1));
                }
            }
        }
        return sb.toString();
    }
}