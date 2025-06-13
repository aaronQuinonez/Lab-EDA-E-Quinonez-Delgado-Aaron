package Ejercicios_Resueltos;

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
    public void destroy(){}

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
    public void remove(E x) {}

    @Override
    public boolean search(E x) throws ExceptionItemNotFound{
        if(isEmpty()){
            throw new ExceptionItemNotFound("Lista vacía");
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
    public E min() {
        return null;
    }

    @Override
    public E max() {
        return null;
    }

    @Override
    public E predecesor(E x) {
        return null;
    }

    @Override
    public E sucesor(E x) {
        return null;
    }

    
}
