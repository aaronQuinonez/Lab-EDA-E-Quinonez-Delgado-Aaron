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

    public void destroy() {
        this.root = null;
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
            boolean fl = current.searchNode(cl, pos);
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
        int medianIndex = (orden - 1) / 2;
        nDes = new BNode<E>(this.orden);

        for (int i = medianIndex + 1; i < current.count; i++) {
            nDes.keys.set(i - (medianIndex + 1), current.keys.get(i));
        }
        for (int i = medianIndex + 1; i <= current.count; i++) {
            nDes.childs.set(i - (medianIndex + 1), current.childs.get(i));
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
        if (current == null) return false;
        int[] pos = new int[1];
        boolean found = current.searchNode(key, pos);
        if (found) return true;
        return search(current.childs.get(pos[0]), key);
    }

    public E min() {
        if (isEmpty()) return null;
        BNode<E> temp = this.root;
        while (!temp.isLeaf()) temp = temp.childs.get(0);
        return temp.keys.get(0);
    }

    public E max() {
        if (isEmpty()) return null;
        BNode<E> temp = this.root;
        while (!temp.isLeaf()) temp = temp.childs.get(temp.count);
        return temp.keys.get(temp.count - 1);
    }

    public E predecesor(E key) {
        return predecesor(this.root, key, null);
    }

    private E predecesor(BNode<E> node, E key, E lastLeft) {
        if (node == null) return lastLeft;
        int[] pos = new int[1];
        if (node.searchNode(key, pos)) {
            if (!node.isLeaf()) {
                BNode<E> temp = node.childs.get(pos[0]);
                while (!temp.isLeaf()) temp = temp.childs.get(temp.count);
                return temp.keys.get(temp.count - 1);
            } else if (pos[0] > 0) {
                return node.keys.get(pos[0] - 1);
            } else {
                return lastLeft;
            }
        } else {
            return predecesor(node.childs.get(pos[0]), key, pos[0] > 0 ? node.keys.get(pos[0] - 1) : lastLeft);
        }
    }

    public E sucesor(E key) {
        return sucesor(this.root, key, null);
    }

    private E sucesor(BNode<E> node, E key, E lastRight) {
        if (node == null) return lastRight;
        int[] pos = new int[1];
        if (node.searchNode(key, pos)) {
            if (!node.isLeaf()) {
                BNode<E> temp = node.childs.get(pos[0] + 1);
                while (!temp.isLeaf()) temp = temp.childs.get(0);
                return temp.keys.get(0);
            } else if (pos[0] < node.count - 1) {
                return node.keys.get(pos[0] + 1);
            } else {
                return lastRight;
            }
        } else {
            return sucesor(node.childs.get(pos[0]), key, pos[0] < node.count ? node.keys.get(pos[0]) : lastRight);
        }
    }

    public void remove(E key) {
        root = remove(root, key);
        if (root != null && root.count == 0 && !root.isLeaf()) {
            root = root.childs.get(0);
        }
    }

    private BNode<E> remove(BNode<E> node, E key) {
        if (node == null) return null;
        int[] pos = new int[1];
        boolean found = node.searchNode(key, pos);
        if (found) {
            if (node.isLeaf()) {
                for (int i = pos[0]; i < node.count - 1; i++) {
                    node.keys.set(i, node.keys.get(i + 1));
                }
                node.keys.set(node.count - 1, null);
                node.count--;
            } else {
                BNode<E> predNode = node.childs.get(pos[0]);
                while (!predNode.isLeaf()) {
                    predNode = predNode.childs.get(predNode.count);
                }
                E pred = predNode.keys.get(predNode.count - 1);
                node.keys.set(pos[0], pred);
                node.childs.set(pos[0], remove(node.childs.get(pos[0]), pred));
            }
        } else {
            BNode<E> temp = node.childs.get(pos[0]);
            node.childs.set(pos[0], remove(temp, key));
        }
        return node;
    }

    public String toString() {
        String s = "";
        if (isEmpty()) s += "BTree is empty...";
        else s = writeTree(this.root);
        return s;
    }

    private String writeTree(BNode<E> current) {
        StringBuilder sb = new StringBuilder();
        if (current != null) writeTreeHelper(current, sb, 0);
        return sb.toString();
    }

    private void writeTreeHelper(BNode<E> current, StringBuilder sb, int level) {
        if (current != null) {
            for (int i = 0; i < level; i++) sb.append("  ");
            sb.append("Nivel ").append(level).append(": ").append(current.toString()).append("\n");
            if (!current.isLeaf()) {
                for (int i = 0; i <= current.count; i++) {
                    writeTreeHelper(current.childs.get(i), sb, level + 1);
                }
            }
        }
    }

    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        inOrderHelper(this.root, sb);
        return sb.toString().trim();
    }

    private void inOrderHelper(BNode<E> current, StringBuilder sb) {
        if (current != null) {
            int i;
            for (i = 0; i < current.count; i++) {
                inOrderHelper(current.childs.get(i), sb);
                sb.append(current.keys.get(i)).append(" ");
            }
            inOrderHelper(current.childs.get(i), sb);
        }
    }

    public int height() {
        return height(this.root);
    }

    private int height(BNode<E> current) {
        if (current == null) return 0;
        if (current.isLeaf()) return 1;
        return 1 + height(current.childs.get(0));
    }

    public int countNodes() {
        return countNodes(this.root);
    }

    private int countNodes(BNode<E> current) {
        if (current == null) return 0;
        int count = 1;
        if (!current.isLeaf()) {
            for (int i = 0; i <= current.count; i++) {
                count += countNodes(current.childs.get(i));
            }
        }
        return count;
    }

    public int countKeys() {
        return countKeys(this.root);
    }

    private int countKeys(BNode<E> current) {
        if (current == null) return 0;
        int count = current.count;
        if (!current.isLeaf()) {
            for (int i = 0; i <= current.count; i++) {
                count += countKeys(current.childs.get(i));
            }
        }
        return count;
    }
} 
