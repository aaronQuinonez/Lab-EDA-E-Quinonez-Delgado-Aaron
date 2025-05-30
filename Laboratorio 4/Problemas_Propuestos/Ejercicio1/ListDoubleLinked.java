package Problemas_Propuestos.Ejercicio1;

public class ListDoubleLinked <E> {
    private NodeDouble<E> head;
    private NodeDouble<E> tail;
    private int count;

    public ListDoubleLinked(){
        this.head = null;
        this.tail = null;
        count = 0;
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
    
}
