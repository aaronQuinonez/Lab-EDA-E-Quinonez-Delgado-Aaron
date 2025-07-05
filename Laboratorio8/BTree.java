package Laboratorio8;

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
                if (current.nodeFull(this.orden - 1)) {
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
        int medianIndex = (orden-1)/2;
        nDes = new BNode<E>(this.orden);
        
        for (int i = medianIndex+1; i < current.count; i++) {
            nDes.keys.set(i - (medianIndex+1), current.keys.get(i));
        }
        for (int i = medianIndex+1; i <= current.count; i++) {
            nDes.childs.set(i - (medianIndex+1), current.childs.get(i));
        }
        nDes.count = current.count - medianIndex - 1;
        current.count = medianIndex;
        if (k <= medianIndex) {
            putNode(current, cl, rd, k);
        } else {
            putNode(nDes, cl, rd, k - medianIndex - 1);
        }
        
        return current.keys.get(medianIndex);
    }
    
    public boolean search(E key) {
        return search(this.root, key);
    }
    
    private boolean search(BNode<E> current, E key) {
        if (current == null) {
            return false;
        }
        
        int[] pos = new int[1];
        boolean found = current.searchNode(key, pos);
        
        if (found) {
            return true;
        } else {
            return search(current.childs.get(pos[0]), key);
        }
    }
    
    public String toString() {
        String s = "";
        if (isEmpty()) {
            s += "BTree is empty...";
        } else {
            s = writeTree(this.root);
        }
        return s;
    }
    
    private String writeTree(BNode<E> current) {
        StringBuilder sb = new StringBuilder();
        if (current != null) {
            writeTreeHelper(current, sb, 0);
        }
        return sb.toString();
    }
    
    private void writeTreeHelper(BNode<E> current, StringBuilder sb, int level) {
        if (current != null) {
            for (int i = 0; i < level; i++) {
                sb.append("  ");
            }
            sb.append("Nivel ").append(level).append(": ");
            sb.append(current.toString()).append("\n");         
            if (!current.isLeaf()) {
                for (int i = 0; i <= current.count; i++) {
                    writeTreeHelper(current.childs.get(i), sb, level + 1);
                }
            }
        }
    }
}