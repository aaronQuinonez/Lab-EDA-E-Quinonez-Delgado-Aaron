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
}