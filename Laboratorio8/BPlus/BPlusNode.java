package Laboratorio8.BPlus;

import java.util.ArrayList;
import java.util.List;

public class BPlusNode<T extends Comparable<T>> {
    private List<T> keys;
    private List<BPlusNode<T>> children;
    private BPlusNode<T> next; // Para enlaces entre hojas
    private boolean isLeaf;
    private int degree;
    
    public BPlusNode(int degree, boolean isLeaf) {
        this.degree = degree;
        this.isLeaf = isLeaf;
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
        this.next = null;
    }
    
    // Getters y Setters
    public List<T> getKeys() {
        return keys;
    }
    
    public void setKeys(List<T> keys) {
        this.keys = keys;
    }
    
    public List<BPlusNode<T>> getChildren() {
        return children;
    }
    
    public void setChildren(List<BPlusNode<T>> children) {
        this.children = children;
    }
    
    public BPlusNode<T> getNext() {
        return next;
    }
    
    public void setNext(BPlusNode<T> next) {
        this.next = next;
    }
    
    public boolean isLeaf() {
        return isLeaf;
    }
    
    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
    
    public int getDegree() {
        return degree;
    }
    
    public void setDegree(int degree) {
        this.degree = degree;
    }
    
    public boolean isFull() {
        return keys.size() > degree - 1;
    }
    
    public boolean hasMinimumKeys() {
        return keys.size() >= Math.ceil((double)(degree - 1) / 2);
    }
    
    public int findInsertPosition(T key) {
        int pos = 0;
        while (pos < keys.size() && keys.get(pos).compareTo(key) < 0) {
            pos++;
        }
        return pos;
    }
    
    public int findKey(T key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }
    
    public void insertKey(T key) {
        int pos = findInsertPosition(key);
        keys.add(pos, key);
    }
    
    public void insertChild(BPlusNode<T> child, int pos) {
        children.add(pos, child);
    }
    
    public boolean removeKey(T key) {
        int index = findKey(key);
        if (index != -1) {
            keys.remove(index);
            return true;
        }
        return false;
    }
    
    public void removeChild(int index) {
        if (index >= 0 && index < children.size()) {
            children.remove(index);
        }
    }
    
    public T getMinKey() {
        if (keys.isEmpty()) {
            return null;
        }
        return keys.get(0);
    }
    
    public T getMaxKey() {
        if (keys.isEmpty()) {
            return null;
        }
        return keys.get(keys.size() - 1);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < keys.size(); i++) {
            sb.append(keys.get(i));
            if (i < keys.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        if (isLeaf) {
            sb.append(" (hoja)");
        }
        return sb.toString();
    }
}