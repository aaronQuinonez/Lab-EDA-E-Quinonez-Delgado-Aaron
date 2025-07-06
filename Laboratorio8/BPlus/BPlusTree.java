package Laboratorio8.BPlus;

import java.util.ArrayList;
import java.util.List;

public class BPlusTree<T extends Comparable<T>> {
    private BPlusNode<T> root;
    private int degree;
    
    public BPlusTree(int degree) {
        if (degree < 3) {
            throw new IllegalArgumentException("El grado debe ser al menos 3");
        }
        this.degree = degree;
        this.root = null;
    }
    
    public void destroy() {
        root = null;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public void insert(T key) {
        if (root == null) {
            root = new BPlusNode<>(degree, true);
            root.getKeys().add(key);
        } else {
            BPlusNode<T> newRoot = insertHelper(root, key);
            if (newRoot != null) {
                root = newRoot;
            }
        }
    }
    
    private BPlusNode<T> insertHelper(BPlusNode<T> node, T key) {
        if (node.isLeaf()) {
            node.insertKey(key);
            if (node.isFull()) {
                return splitNode(node);
            }
        } else {
            int pos = 0;
            while (pos < node.getKeys().size() && key.compareTo(node.getKeys().get(pos)) > 0) {
                pos++;
            }
            if (pos >= node.getChildren().size()) {
                System.err.println("Error: acceso inválido a hijo en posición " + pos);
                return null;
            }
            BPlusNode<T> child = node.getChildren().get(pos);
            BPlusNode<T> newChild = insertHelper(child, key);
            
            if (newChild != null) {
                T promoteKey = newChild.getKeys().get(0);
                node.getKeys().add(pos, promoteKey);
                node.getChildren().add(pos + 1, newChild);
                
                if (node.isFull()) {
                    return splitNode(node);
                }
            }
        }
        return null;
    }

    private BPlusNode<T> splitNode(BPlusNode<T> node) {
        int mid = node.getKeys().size() / 2;
        BPlusNode<T> newNode = new BPlusNode<>(degree, node.isLeaf());

        // Mover la mitad derecha de las claves al nuevo nodo
        for (int i = mid; i < node.getKeys().size(); i++) {
            newNode.getKeys().add(node.getKeys().get(i));
        }
        // Eliminar las claves movidas del nodo original
        for (int i = node.getKeys().size() - 1; i >= mid; i--) {
            node.getKeys().remove(i);
        }

        if (!node.isLeaf()) {
            // Mover los hijos correspondientes
            for (int i = mid + 1; i < node.getChildren().size(); i++) {
                newNode.getChildren().add(node.getChildren().get(i));
            }
            // Eliminar los hijos movidos del nodo original
            while (node.getChildren().size() > mid + 1) {
                node.getChildren().remove(node.getChildren().size() - 1);
            }
        } else {
            // Enlazar hojas si el nodo es hoja
            newNode.setNext(node.getNext());
            node.setNext(newNode);
        }

        // Si el nodo actual era la raíz, crear una nueva raíz
        if (node == root) {
            BPlusNode<T> newRoot = new BPlusNode<>(degree, false);
            newRoot.getKeys().add(newNode.getKeys().get(0)); // Promueve primera clave del nuevo nodo
            newRoot.getChildren().add(node);
            newRoot.getChildren().add(newNode);
            return newRoot;
        }

        return newNode;
    }
    
    public boolean search(T key) {
        return searchHelper(root, key);
    }
    
    private boolean searchHelper(BPlusNode<T> node, T key) {
        if (node == null) {
            return false;
        }
        
        if (node.isLeaf()) {
            return node.findKey(key) != -1;
        } else {
            int pos = 0;
            while (pos < node.getKeys().size() && key.compareTo(node.getKeys().get(pos)) >= 0) {
                pos++;
            }
            return searchHelper(node.getChildren().get(pos), key);
        }
    }
    
    public boolean remove(T key) {
        if (root == null) {
            return false;
        }
        
        boolean removed = removeHelper(root, key);
        
        // Si la raíz se queda sin claves pero tiene hijos, promover hijo
        if (root.getKeys().isEmpty() && !root.getChildren().isEmpty()) {
            root = root.getChildren().get(0);
        }
        
        return removed;
    }

    private boolean removeHelper(BPlusNode<T> node, T key) {
        if (node.isLeaf()) {
            boolean removed = node.removeKey(key);
            if (removed && node.getKeys().size() < Math.ceil((degree - 1) / 2.0)) {
                rebalanceLeaf(node);
            }
            return removed;
        } else {
            int pos = 0;
            while (pos < node.getKeys().size() && key.compareTo(node.getKeys().get(pos)) >= 0) {
                pos++;
            }
            boolean removed = removeHelper(node.getChildren().get(pos), key);
            
            // Rebalancear nodos internos si es necesario (opcional)
            if (removed && node.getChildren().get(pos).getKeys().size() < Math.ceil((degree - 1) / 2.0)) {
                rebalanceInternal(node, pos);
            }
            return removed;
        }
    }

    private void rebalanceInternal(BPlusNode<T> parent, int childIndex) {
        BPlusNode<T> node = parent.getChildren().get(childIndex);

        // Intenta redistribución con hermano izquierdo
        if (childIndex > 0) {
            BPlusNode<T> leftSibling = parent.getChildren().get(childIndex - 1);
            if (leftSibling.getKeys().size() > Math.ceil((degree - 1) / 2.0)) {
                // Mover clave del padre al nodo actual
                T parentKey = parent.getKeys().remove(childIndex - 1);
                node.getKeys().add(0, parentKey);
                
                // Mover última clave del hermano izquierdo al padre
                T borrowedKey = leftSibling.getKeys().remove(leftSibling.getKeys().size() - 1);
                parent.getKeys().add(childIndex - 1, borrowedKey);
                
                // Mover último hijo del hermano izquierdo (si existe)
                if (!leftSibling.isLeaf()) {
                    BPlusNode<T> borrowedChild = leftSibling.getChildren().remove(leftSibling.getChildren().size() - 1);
                    node.getChildren().add(0, borrowedChild);
                }
                return;
            }
        }

        // Intenta redistribución con hermano derecho
        if (childIndex < parent.getChildren().size() - 1) {
            BPlusNode<T> rightSibling = parent.getChildren().get(childIndex + 1);
            if (rightSibling.getKeys().size() > Math.ceil((degree - 1) / 2.0)) {
                // Mover clave del padre al nodo actual
                T parentKey = parent.getKeys().remove(childIndex);
                node.getKeys().add(parentKey);
                
                // Mover primera clave del hermano derecho al padre
                T borrowedKey = rightSibling.getKeys().remove(0);
                parent.getKeys().add(childIndex, borrowedKey);
                
                // Mover primer hijo del hermano derecho (si existe)
                if (!rightSibling.isLeaf()) {
                    BPlusNode<T> borrowedChild = rightSibling.getChildren().remove(0);
                    node.getChildren().add(borrowedChild);
                }
                return;
            }
        }

        // Fusión (si no se pudo redistribuir)
        if (childIndex > 0) {
            mergeInternalNodes(parent, childIndex - 1, childIndex); // Fusión con izquierdo
        } else {
            mergeInternalNodes(parent, childIndex, childIndex + 1); // Fusión con derecho
        }
    }

    private void mergeInternalNodes(BPlusNode<T> parent, int leftIndex, int rightIndex) {
        BPlusNode<T> leftNode = parent.getChildren().get(leftIndex);
        BPlusNode<T> rightNode = parent.getChildren().get(rightIndex);

        // Mover clave del padre al hermano izquierdo
        T parentKey = parent.getKeys().remove(leftIndex);
        leftNode.getKeys().add(parentKey);

        // Mover claves e hijos del hermano derecho
        leftNode.getKeys().addAll(rightNode.getKeys());
        leftNode.getChildren().addAll(rightNode.getChildren());

        // Eliminar el hermano derecho
        parent.getChildren().remove(rightIndex);
    }

    private void rebalanceLeaf(BPlusNode<T> node) {
        BPlusNode<T> parent = findParent(root, node);
        if (parent == null) return; // Es la raíz (caso especial)

        int nodeIndex = parent.getChildren().indexOf(node);
        if (nodeIndex == -1) return; // No debería ocurrir

        // --- Intenta redistribución con hermano izquierdo ---
        if (nodeIndex > 0) {
            BPlusNode<T> leftSibling = parent.getChildren().get(nodeIndex - 1);
            if (leftSibling.getKeys().size() > Math.ceil((degree - 1) / 2.0)) {
                // Mover la última clave del hermano izquierdo al nodo actual
                T borrowedKey = leftSibling.getKeys().remove(leftSibling.getKeys().size() - 1);
                node.getKeys().add(0, borrowedKey);
                // Actualizar clave del padre
                parent.getKeys().set(nodeIndex - 1, node.getKeys().get(0));
                return;
            }
        }

        // Intenta redistribución con hermano derecho
        if (nodeIndex < parent.getChildren().size() - 1) {
            BPlusNode<T> rightSibling = parent.getChildren().get(nodeIndex + 1);
            if (rightSibling.getKeys().size() > Math.ceil((degree - 1) / 2.0)) {
                // Mover la primera clave del hermano derecho al nodo actual
                T borrowedKey = rightSibling.getKeys().remove(0);
                node.getKeys().add(borrowedKey);
                // Actualizar clave del padre
                parent.getKeys().set(nodeIndex, rightSibling.getKeys().get(0));
                return;
            }
        }

        // Fusión (si no se pudo redistribuir)
        if (nodeIndex > 0) {
            // Fusionar con hermano izquierdo
            mergeWithLeftSibling(parent, nodeIndex);
        } else {
            // Fusionar con hermano derecho
            mergeWithRightSibling(parent, nodeIndex);
        }
    }

    private void mergeWithLeftSibling(BPlusNode<T> parent, int nodeIndex) {
        BPlusNode<T> leftSibling = parent.getChildren().get(nodeIndex - 1);
        BPlusNode<T> node = parent.getChildren().get(nodeIndex);

        // Mover todas las claves al hermano izquierdo
        leftSibling.getKeys().addAll(node.getKeys());

        // Actualizar enlaces si son hojas
        if (node.isLeaf()) {
            leftSibling.setNext(node.getNext());
        }

        // Eliminar clave del padre y el nodo fusionado
        parent.getKeys().remove(nodeIndex - 1);
        parent.getChildren().remove(nodeIndex);
    }

    private void mergeWithRightSibling(BPlusNode<T> parent, int nodeIndex) {
        BPlusNode<T> node = parent.getChildren().get(nodeIndex);
        BPlusNode<T> rightSibling = parent.getChildren().get(nodeIndex + 1);

        // Mover todas las claves al nodo actual
        node.getKeys().addAll(rightSibling.getKeys());

        // Actualizar enlaces si son hojas
        if (rightSibling.isLeaf()) {
            node.setNext(rightSibling.getNext());
        }

        // Eliminar clave del padre y el nodo fusionado
        parent.getKeys().remove(nodeIndex);
        parent.getChildren().remove(nodeIndex + 1);
    }

    private BPlusNode<T> findParent(BPlusNode<T> current, BPlusNode<T> child) {
        // Caso base: si es null o es hoja, no hay padre
        if (current == null || current.isLeaf()) {
            return null;
        }

        // Verificar si el hijo está entre los hijos del nodo actual
        for (int i = 0; i < current.getChildren().size(); i++) {
            if (current.getChildren().get(i) == child) {
                return current;
            }
        }

        // Búsqueda recursiva en los hijos
        for (int i = 0; i < current.getChildren().size(); i++) {
            BPlusNode<T> parent = findParent(current.getChildren().get(i), child);
            if (parent != null) {
                return parent;
            }
        }

        return null;
    }
    
    public T min() {
        if (root == null) {
            return null;
        }
        
        BPlusNode<T> current = root;
        while (!current.isLeaf()) {
            current = current.getChildren().get(0);
        }
        
        return current.getKeys().isEmpty() ? null : current.getKeys().get(0);
    }
    
    public T max() {
        if (root == null) {
            return null;
        }
        
        BPlusNode<T> current = root;
        while (!current.isLeaf()) {
            current = current.getChildren().get(current.getChildren().size() - 1);
        }
        
        return current.getKeys().isEmpty() ? null : current.getMaxKey();
    }
    
    public T predecessor(T key) {
        List<T> allKeys = getAllKeys();
        T predecessor = null;
        
        for (T k : allKeys) {
            if (k.compareTo(key) < 0) {
                if (predecessor == null || k.compareTo(predecessor) > 0) {
                    predecessor = k;
                }
            }
        }
        
        return predecessor;
    }
    
    public T successor(T key) {
        List<T> allKeys = getAllKeys();
        T successor = null;
        
        for (T k : allKeys) {
            if (k.compareTo(key) > 0) {
                if (successor == null || k.compareTo(successor) < 0) {
                    successor = k;
                }
            }
        }
        
        return successor;
    }
    
    private List<T> getAllKeys() {
        List<T> keys = new ArrayList<>();
        if (root != null) {
            collectLeafKeys(root, keys);
        }
        return keys;
    }
    
    private void collectLeafKeys(BPlusNode<T> node, List<T> keys) {
        if (node.isLeaf()) {
            keys.addAll(node.getKeys());
        } else {
            for (BPlusNode<T> child : node.getChildren()) {
                collectLeafKeys(child, keys);
            }
        }
    }
    
    public BPlusNode<T> fuzeNode(BPlusNode<T> left, BPlusNode<T> right) {
        if (left == null) return right;
        if (right == null) return left;
        
        // Agregar todas las claves del nodo derecho al izquierdo
        left.getKeys().addAll(right.getKeys());
        
        if (!left.isLeaf()) {
            left.getChildren().addAll(right.getChildren());
        } else {
            left.setNext(right.getNext());
        }
        
        return left;
    }
    
    public BPlusNode<T> dividedNode(BPlusNode<T> node) {
        if (node == null || !node.isFull()) {
            return null;
        }
        
        return splitNode(node);
    }
    
    @Override
    public String toString() {
        if (root == null) {
            return "Árbol vacío";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Árbol B+ (grado ").append(degree).append("):\n");
        toStringHelper(root, sb, 0);
        return sb.toString();
    }
    
    private void toStringHelper(BPlusNode<T> node, StringBuilder sb, int level) {
        if (node == null) {
            return;
        }
        
        // Indentación por nivel
        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }
        
        sb.append(node.toString()).append("\n");
        
        // Recursión para hijos
        for (BPlusNode<T> child : node.getChildren()) {
            toStringHelper(child, sb, level + 1);
        }
    }
    
    public String writeTree() {
        if (root == null) {
            return "Árbol B+ vacío (grado " + degree + ")";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("=== ÁRBOL B+ ===\n");
        sb.append("Grado: ").append(degree).append("\n");
        sb.append("Claves totales: ").append(getAllKeys().size()).append("\n");
        sb.append("Altura: ").append(getHeight()).append("\n");
        sb.append("\nEstructura:\n");
        
        writeTreeHelper(root, sb, 0);
        
        sb.append("\nRecorrido de hojas: ");
        List<T> leafKeys = getAllKeys();
        for (int i = 0; i < leafKeys.size(); i++) {
            sb.append(leafKeys.get(i));
            if (i < leafKeys.size() - 1) {
                sb.append(" -> ");
            }
        }
        sb.append("\n");
        
        return sb.toString();
    }
    
    private void writeTreeHelper(BPlusNode<T> node, StringBuilder sb, int level) {
        if (node == null) {
            return;
        }
        
        // Indentación por nivel
        for (int i = 0; i < level; i++) {
            sb.append("    ");
        }
        
        sb.append("Nivel ").append(level).append(": ");
        sb.append(node.toString()).append("\n");
        
        // Recursión para hijos
        for (BPlusNode<T> child : node.getChildren()) {
            writeTreeHelper(child, sb, level + 1);
        }
    }
    
    public int getHeight() {
        if (root == null) {
            return 0;
        }
        
        int height = 1;
        BPlusNode<T> current = root;
        
        while (!current.isLeaf()) {
            height++;
            current = current.getChildren().get(0);
        }
        
        return height;
    }
    
    public BPlusNode<T> getRoot() {
        return root;
    }
    
    public int getDegree() {
        return degree;
    }
}