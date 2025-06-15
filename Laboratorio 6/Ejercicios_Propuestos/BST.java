package Ejercicios_Propuestos;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class BST<E extends Comparable<E>> implements BSTInterface<E>{
    private Node<E> root;

    public BST(){
        this.root = null;
    }

    @Override
    public boolean isEmpty(){
        return root == null;
    }

    @Override
    public void destroy(){
        root = null;
    }

    @Override
    public void insert(E x) throws ExceptionItemDuplicate{
        //Si está vacío
        if(isEmpty())
            root = new Node<>(x);
        else{
            //Nodo actual
            Node<E> cur = root;
            //Nodo padre
            Node<E> par = null;
            while(cur != null){
                int com = x.compareTo(cur.getData());
                //Si es igual
                if(com == 0){
                    throw new ExceptionItemDuplicate("Elemento ya encontrado");
                }
                //Guardamos nodo padre
                par = cur;
                //Si es menor
                if(com < 0){
                    cur = cur.getLeft();
                }
                //Si es mayor
                else{
                    cur = cur.getRight();
                }
            }
            int com = x.compareTo(par.getData());
            //Insertamos el nodo
            if(com > 0){
                par.setRight(new Node<>(x));
            }else{
                par.setLeft(new Node<>(x));
            }
        }
    }

    @Override
    public void remove(E x) throws ExceptionItemNotFound{
        root = remove(x, root);
    }

    private Node<E> remove (E x, Node<E> node) throws ExceptionItemNotFound{
        if(node == null){
            throw new ExceptionItemNotFound("Elemento no encontrado");
        }else{
            int com = x.compareTo(node.getData());
            if(com < 0 ){
                node.setLeft(remove(x, node.getLeft()));
            }
            else if(com > 0){
                node.setRight(remove(x, node.getRight()));
            }else{
                //Caso 1 si el nodo no tiene hijos
                if(node.getLeft() == null && node.getRight() == null){
                    return null;
                }
                //Caso 2 solo tiene un hijo
                if(node.getLeft() == null){
                    return node.getRight();
                }else if(node.getRight() == null){
                    return node.getLeft();
                }
                //Caso 3 tiene 2 hijos, lo reemplazamos por su sucesor
                Node<E> suc = node.getRight();
                while (suc.getLeft() != null) {
                    suc = suc.getLeft();
                }
                node.setData(suc.getData());
                node.setRight(remove(suc.getData(), node.getRight()));
            }
            return node;
        }
    }

    @Override
    public boolean search(E x) throws ExceptionItemNotFound{
        if(isEmpty()){
            return false;
        }else{
            Node<E> cur = root;
            while(cur != null){
                int com = x.compareTo(cur.getData());
                if(com == 0){
                    return true;
                }
                if(com < 0){
                    cur = cur.getLeft();
                }
                else{
                    cur = cur.getRight();
                }
            }
            return false;
        }
    }

    @Override
    public E min() throws ExceptionItemNotFound{
        if(isEmpty()){
            throw new ExceptionItemNotFound("Lista vacía");
        }else{
            Node<E> cur = root;
            Node<E> par = null;
            while(cur != null){
                par = cur;
                cur = cur.getLeft();
            }
            return par.getData();
        }
    }

    @Override
    public E max() throws ExceptionItemNotFound{
        if(isEmpty()){
            throw new ExceptionItemNotFound("Lista vacía");
        }else{
            Node<E> cur = root;
            Node<E> par = null;
            while(cur != null){
                par = cur;
                cur = cur.getRight();
            }
            return par.getData();
        }
    }

    @Override
    public E predecesor(E x) throws ExceptionItemNotFound{
        if(isEmpty()) {
            throw new ExceptionItemNotFound("Arbol vacío");
        }else{
            Node<E> cur = root;
            Node<E> pre = null;
            while(cur != null){
                int com = x.compareTo(cur.getData());
                if(com == 0){
                    //Caso 1 si tiene subárbol izquierdo
                    if(cur.getLeft() != null){
                        Node<E> tmp = cur.getLeft();
                        while(tmp.getRight() != null){
                            tmp = tmp.getRight();
                        }
                        return tmp.getData();
                    }
                    //Caso 2 no tiene subárbol izquierdo
                    if (pre != null) {
                        return pre.getData();
                    } else {
                        throw new ExceptionItemNotFound("No hay predecesor");
                    }
                }
                if(com < 0){
                    cur = cur.getLeft();
                }
                else{
                    //Guardamos posible predecesor
                    pre = cur;
                    cur = cur.getRight();
                }
            }
            throw new ExceptionItemNotFound("Elemento no encontrado");
        }
    }

    @Override
    public E sucesor(E x) throws ExceptionItemNotFound{
        if(isEmpty()){
            throw new ExceptionItemNotFound("Arbol vacío");
        }else{
            Node<E> cur = root;
            Node<E> suc = null;
            while(cur != null){
                int com = x.compareTo(cur.getData());
                if(com == 0){
                    //Caso 1 si tiene subárbol derecho
                    if(cur.getRight() != null){
                        Node<E> tmp = cur.getRight();
                        while(tmp.getLeft() != null){
                            tmp = tmp.getLeft();
                        }
                        return tmp.getData();
                    }
                    //Caso 2 no tiene subárbol derecho
                    if (suc != null) {
                        return suc.getData();
                    } else {
                        throw new ExceptionItemNotFound("No hay sucesor");
                    }
                }
                if(com < 0){
                    //Guardamos posible sucesor
                    suc = cur;
                    cur = cur.getLeft();
                }
                else{
                    cur = cur.getRight();
                }
            }
            throw new ExceptionItemNotFound("Elemento no encontrado");
        }
    }

    private void inorden(Node<E> node, StringBuilder str){
        if(node != null){
            inorden(node.getLeft(), str);
            str.append(node.getData()).append(" ");
            inorden(node.getRight(), str);
        }
    }

    private void preorden(Node<E> node, StringBuilder str){
        if(node != null){
            str.append(node.getData()).append(" ");
            preorden(node.getLeft(), str);
            preorden(node.getRight(), str);
        }
    }

    private void postorden(Node<E> node, StringBuilder str){
        if(node != null){
            postorden(node.getLeft(), str);
            postorden(node.getRight(), str);
            str.append(node.getData()).append(" ");
        }
    }
       
    // Número de nodos en el árbol
    public int size() {
        return size(root);
    }
    
    // Número de nodos en el subárbol
    private int size(Node<E> node) {
        if (node == null) 
            return 0;
        return 1 + size(node.getLeft()) + size(node.getRight());
    }
    
    // Número de claves en el árbol menores que la clave proporcionada
    public int rank(E key) {
        return rank(key, root);
    }
    
    // Número de claves en el subárbol menores que la clave proporcionada
    private int rank(E key, Node<E> node) {
        if (node == null) {
            return 0;
        }
        int cmp = key.compareTo(node.getData());
        if (cmp < 0) {
            return rank(key, node.getLeft());
        }
        else if (cmp > 0) {
            return 1 + size(node.getLeft()) + rank(key, node.getRight());
        }
        else {
            return size(node.getLeft());
        }
    }
    
    public int depth(E key) {
        return depth(key, root, 1);
    }
    
    private int depth(E key, Node<E> node, int level) {
        if (node == null) 
            return 0;
        if (node.getData().compareTo(key) == 0) 
            return level;
        int leftLevel = depth(key, node.getLeft(), level+1);
        if (leftLevel > 0) {
            return leftLevel;
        }
        else {
            return depth(key, node.getRight(), level+1);
        }
    }

    public void printTreeGraph() {
        String styleSheet =
            "node {" +
            "	text-alignment: right;" +
            "	text-offset: 10px, 0px;" +
            "   size: 15px, 15px;" +
            "}" +
            "node.marked {" +
            "	fill-color: red;" +
            "}";
    
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Binary Search Tree");
        graph.setAttribute("ui.stylesheet", styleSheet);

        print(root, graph);

        Viewer viewer = graph.display();
        viewer.disableAutoLayout();
    }
    
    private void print(Node<E> x, Graph graph) {
        if (x == null) return;

        org.graphstream.graph.Node n = graph.addNode(x.getData().toString());

        if (size() <= 50) {
            n.setAttribute("ui.label", n.getId());
        }

        n.setAttribute("x", rank(x.getData()));
        n.setAttribute("y", depth(x.getData())*-1);

        print(x.getLeft(), graph);
        print(x.getRight(), graph);

        if (x.getLeft() != null) {
            String keyStr = x.getData().toString();
            String leftKey = x.getLeft().getData().toString();
            graph.addEdge(keyStr + leftKey, keyStr, leftKey);
        }

        if (x.getRight() != null) {
            String keyStr = x.getData().toString();
            String rightKey = x.getRight().getData().toString();
            graph.addEdge(keyStr + rightKey, keyStr, rightKey);
        }
    }

    @Override
    public String toString() {
        StringBuilder strIn = new StringBuilder();
        StringBuilder strPre = new StringBuilder();
        StringBuilder strPos = new StringBuilder();
        inorden(root, strIn);
        preorden(root, strPre);
        postorden(root, strPos);
        return "Recorrido inorden: " + strIn.toString()
        + "\n Recorrido preorden: " + strPre.toString()
        + "\n Recorrido postorden: " + strPos.toString();
    }
}