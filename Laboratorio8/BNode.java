package Laboratorio8;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;
    public BNode(int n){
        this.keys = new ArrayList<E>(n);
        this.childs = new ArrayList<BNode<E>>(n+1);
        this.count = 0;
        for (int i = 0; i < n; i++){
            this.keys.add(null);
            this.childs.add(null);
        }
    }
    // Devuelve true si el nodo está lleno (tiene el máximo de claves)
    public boolean nodeFull(int maxKeys) {
        return count == maxKeys;
    }

    // Devuelve true si el nodo está vacío (sin claves)
    public boolean isEmpty() {
        return count == 0;
    }
    public boolean searchNode(E key, int[] pos) {
        int i = 0;
        while (i < count && key.compareTo(keys.get(i)) > 0) {
            i++;
        }
        pos[0] = i;
        return (i < count && key.compareTo(keys.get(i)) == 0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < count; i++) {
            sb.append(keys.get(i));
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}