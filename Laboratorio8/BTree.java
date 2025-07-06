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

    public void destroy() {
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

    public void remove(E x) {
        if (isEmpty()) return;
        remove(this.root, x);
        // Si la raíz quedó vacía pero tiene un hijo, bajamos un nivel
        if (root != null && root.count == 0 && root.childs.get(0) != null) {
            root = root.childs.get(0);
        }
    }

    private void remove(BNode<E> node, E x) {
        if (node == null) return;

        int i = 0;
        while (i < node.count && x.compareTo(node.keys.get(i)) > 0) {
            i++;
        }

        if (i < node.count && x.compareTo(node.keys.get(i)) == 0) {
            if (node.childs.get(i) == null) { // Es nodo hoja
                // Eliminar la clave desplazando las demás
                for (int j = i; j < node.count - 1; j++) {
                    node.keys.set(j, node.keys.get(j + 1));
                }
                node.keys.set(node.count - 1, null);
                node.count--;
            } else { // Es nodo interno
                // Encontrar predecesor inmediato
                BNode<E> predNode = node.childs.get(i);
                while (predNode.childs.get(predNode.count) != null) {
                    predNode = predNode.childs.get(predNode.count);
                }
                E pred = predNode.keys.get(predNode.count - 1);
                node.keys.set(i, pred);
                remove(node.childs.get(i), pred);
                
                // Verificar underflow después de eliminar
                if (node.childs.get(i).count < (orden + 1) / 2 - 1) {
                    fixChildBeforeRemove(node, i);
                }
            }
        } else {
            if (node.childs.get(i) == null) {
                System.out.println("Clave no encontrada: " + x);
                return;
            }

            // Verificar underflow antes de descender
            int minKeys = (int) Math.ceil((double) orden / 2) - 1;
            if (node.childs.get(i).count <= minKeys) {
                fixChildBeforeRemove(node, i);
                // Ajustar índice si hubo fusión con hermano izquierdo
                if (i > 0 && node.childs.get(i - 1) != null && 
                    node.childs.get(i - 1).count > minKeys) {
                    i--;
                }
            }

            remove(node.childs.get(i), x);
        }
    }

    private void fixChildBeforeRemove(BNode<E> parent, int pos) {
        int minKeys = (int) Math.ceil((double) orden / 2) - 1;
        BNode<E> child = parent.childs.get(pos);

        // 1. Intentar préstamo del hermano izquierdo
        if (pos > 0 && parent.childs.get(pos - 1) != null && 
            parent.childs.get(pos - 1).count > minKeys) {
            BNode<E> left = parent.childs.get(pos - 1);

            // Desplazar claves e hijos del child a la derecha
            for (int j = Math.min(child.count, child.keys.size() - 1); j > 0; j--) {
                child.keys.set(j, child.keys.get(j - 1));
            }
            for (int j = Math.min(child.count + 1, child.childs.size() - 1); j > 0; j--) {
                child.childs.set(j, child.childs.get(j - 1));
            }

            // Mover clave del padre y del hermano izquierdo
            if (child.count < child.keys.size()) {
                child.keys.set(0, parent.keys.get(pos - 1));
                child.count++;
            }
            if (child.count + 1 < child.childs.size()) {
                child.childs.set(0, left.childs.get(left.count));
            }

            parent.keys.set(pos - 1, left.keys.get(left.count - 1));
            
            // Limpiar en hermano izquierdo
            left.keys.set(left.count - 1, null);
            left.childs.set(left.count, null);
            left.count--;
            return;
        }

        // 2. Intentar préstamo del hermano derecho
        if (pos < parent.count && parent.childs.get(pos + 1) != null && 
            parent.childs.get(pos + 1).count > minKeys) {
            BNode<E> right = parent.childs.get(pos + 1);

            // Mover clave del padre al child
            if (child.count < child.keys.size()) {
                child.keys.set(child.count, parent.keys.get(pos));
                child.count++;
            }
            if (child.count + 1 < child.childs.size()) {
                child.childs.set(child.count, right.childs.get(0));
            }

            parent.keys.set(pos, right.keys.get(0));

            // Ajustar hermano derecho
            for (int j = 0; j < right.count - 1; j++) {
                right.keys.set(j, right.keys.get(j + 1));
                right.childs.set(j, right.childs.get(j + 1));
            }
            right.childs.set(right.count - 1, right.childs.get(right.count));
            right.keys.set(right.count - 1, null);
            right.childs.set(right.count, null);
            right.count--;
            return;
        }

        // 3. Fusión necesaria
        if (pos > 0) {
            fuzeNode(parent, pos - 1);
        } else if (pos < parent.count) {
            fuzeNode(parent, pos);
        }
    }

    private void fuzeNode(BNode<E> parent, int pos) {
        // Verificar índices válidos
        if (pos < 0 || pos >= parent.count) return;
        
        BNode<E> left = parent.childs.get(pos);
        BNode<E> right = parent.childs.get(pos + 1);

        // CORRECCIÓN: La verificación debe ser más permisiva
        // En la fusión, combinamos: left.count + 1 (clave del padre) + right.count
        // Esto debe ser <= orden - 1 (máximo de claves por nodo)
        if (left.count + right.count + 1 > orden - 1) {
            // Si no podemos fusionar, intentamos redistribuir
            redistributeKeys(parent, pos);
            return;
        }

        // Mover clave del padre al nodo izquierdo
        if (left.count < left.keys.size()) {
            left.keys.set(left.count, parent.keys.get(pos));
            left.count++;
        }

        // Copiar claves del nodo derecho
        for (int i = 0; i < right.count && left.count + i < left.keys.size(); i++) {
            left.keys.set(left.count + i, right.keys.get(i));
        }

        // Copiar hijos del nodo derecho
        for (int i = 0; i <= right.count && left.count + i < left.childs.size(); i++) {
            left.childs.set(left.count + i, right.childs.get(i));
        }

        left.count += right.count;

        // Eliminar clave del padre y ajustar
        for (int i = pos; i < parent.count - 1; i++) {
            parent.keys.set(i, parent.keys.get(i + 1));
            parent.childs.set(i + 1, parent.childs.get(i + 2));
        }

        // Limpiar última posición
        parent.keys.set(parent.count - 1, null);
        parent.childs.set(parent.count, null);
        parent.count--;

        // Si el padre es la raíz y queda vacío
        if (parent == root && parent.count == 0) {
            root = left;
        }
    }

    // Nuevo método para redistribuir claves cuando no se puede fusionar
    private void redistributeKeys(BNode<E> parent, int pos) {
        BNode<E> left = parent.childs.get(pos);
        BNode<E> right = parent.childs.get(pos + 1);
        
        // Calcular total de claves disponibles
        int totalKeys = left.count + right.count + 1; // +1 por la clave del padre
        int leftNewCount = totalKeys / 2;
        int rightNewCount = totalKeys - leftNewCount - 1; // -1 por la clave que sube al padre
        
        // Crear array temporal con todas las claves ordenadas
        ArrayList<E> tempKeys = new ArrayList<>();
        ArrayList<BNode<E>> tempChilds = new ArrayList<>();
        
        // Agregar claves del nodo izquierdo
        for (int i = 0; i < left.count; i++) {
            tempKeys.add(left.keys.get(i));
            tempChilds.add(left.childs.get(i));
        }
        tempChilds.add(left.childs.get(left.count));
        
        // Agregar clave del padre
        tempKeys.add(parent.keys.get(pos));
        
        // Agregar claves del nodo derecho
        for (int i = 0; i < right.count; i++) {
            tempKeys.add(right.keys.get(i));
            tempChilds.add(right.childs.get(i));
        }
        tempChilds.add(right.childs.get(right.count));
        
        // Limpiar nodos
        for (int i = 0; i < orden - 1; i++) {
            left.keys.set(i, null);
            right.keys.set(i, null);
        }
        for (int i = 0; i < orden; i++) {
            left.childs.set(i, null);
            right.childs.set(i, null);
        }
        
        // Redistribuir al nodo izquierdo
        left.count = leftNewCount;
        for (int i = 0; i < leftNewCount; i++) {
            left.keys.set(i, tempKeys.get(i));
            left.childs.set(i, tempChilds.get(i));
        }
        left.childs.set(leftNewCount, tempChilds.get(leftNewCount));
        
        // La clave que sube al padre
        parent.keys.set(pos, tempKeys.get(leftNewCount));
        
        // Redistribuir al nodo derecho
        right.count = rightNewCount;
        for (int i = 0; i < rightNewCount; i++) {
            right.keys.set(i, tempKeys.get(leftNewCount + 1 + i));
            right.childs.set(i, tempChilds.get(leftNewCount + 1 + i));
        }
        right.childs.set(rightNewCount, tempChilds.get(tempKeys.size()));
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


    public E predecesor(E x) {
    return predecesor(this.root, x, null);
}

    private E predecesor(BNode<E> node, E x, E candidate) {
        if (node == null) return candidate;

        int i = 0;
        while (i < node.count && x.compareTo(node.keys.get(i)) > 0) {
            candidate = node.keys.get(i); // posible predecesor
            i++;
        }

        // Si lo encuentra, busca el máximo en su subárbol izquierdo
        if (i < node.count && x.compareTo(node.keys.get(i)) == 0) {
            if (node.childs.get(i) != null) {
                return max(node.childs.get(i));
            } else {
                return candidate;
            }
        }

        return predecesor(node.childs.get(i), x, candidate);
    }

    public E sucesor(E x) {
        return sucesor(this.root, x, null);
    }

    private E sucesor(BNode<E> node, E x, E candidate) {
        if (node == null) return candidate;

        int i = 0;
        while (i < node.count && x.compareTo(node.keys.get(i)) > 0) {
            i++;
        }

        // Si lo encuentra, busca el mínimo en su subárbol derecho
        if (i < node.count && x.compareTo(node.keys.get(i)) == 0) {
            if (node.childs.get(i + 1) != null) {
                return min(node.childs.get(i + 1));
            } else {
                return candidate;
            }
        }

        if (i < node.count) {
            candidate = node.keys.get(i); // posible sucesor
        }

        return sucesor(node.childs.get(i), x, candidate);
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