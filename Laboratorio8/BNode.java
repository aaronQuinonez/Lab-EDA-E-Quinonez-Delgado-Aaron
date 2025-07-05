package Laboratorio8;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;
    
    public BNode(int order) {
        this.keys = new ArrayList<>(order - 1);
        this.childs = new ArrayList<>(order);
        this.count = 0;
        for (int i = 0; i < order - 1; i++) {
            this.keys.add(null);
        }
        for (int i = 0; i < order; i++) {
            this.childs.add(null);
        }
    }
    
    // Check if the current node is full
    public boolean nodeFull(int maxKeys) {
        return this.count >= maxKeys;
    }
    
    // Check if the current node is empty
    public boolean nodeEmpty() {
        return this.count == 0;
    }
    
    public boolean searchNode(E key, int[] pos) {
        int i = 0;
        while (i < this.count && key.compareTo(this.keys.get(i)) > 0) i++;
        pos[0] = i;
        return (i < this.count && key.compareTo(this.keys.get(i)) == 0);
    }

    
    public boolean isLeaf() {
        return this.childs.get(0) == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.count; i++) {
            sb.append(this.keys.get(i));
            if (i < this.count - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}