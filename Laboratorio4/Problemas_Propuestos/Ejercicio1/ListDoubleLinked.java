package Laboratorio4.Problemas_Propuestos.Ejercicio1;

public class ListDoubleLinked <E> {
    private NodeDouble<E> head;
    private NodeDouble<E> tail;
    private int count;

    public ListDoubleLinked(){
        this.head = null;
        this.tail = null;
        count = 0;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public int lengt(){
        return count;
    }

    public void insertFirst(E x){
        NodeDouble<E> aux = new NodeDouble<E>(x);
        //Si es el primer nodo será head y tail
        if(isEmpty()){
            this.head = aux;
            this.tail = aux;
        }else{
            aux.setNext(head);
            this.head.setPrev(aux);
            this.head = aux;
        }
        count++;
    }

    public NodeDouble<E> getHead() {
        return head;
    }

    public void setHead(NodeDouble<E> head) {
        this.head = head;
    }

    public NodeDouble<E> getTail() {
        return tail;
    }

    public void setTail(NodeDouble<E> tail) {
        this.tail = tail;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        String result = "[";
        NodeDouble<E> aux = head;
        while (aux != null) {
            result += aux.getData();
            if (aux.getNext() != null) {
                result += ", ";
            }
            aux = aux.getNext();
        }
        result += "]";
        return result;
    }
}
