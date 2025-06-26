package Laboratorio4.Problemas_Propuestos.Ejercicio7;

public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public E getData() {
        return data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public String toString() {
        return data.toString();
    }
}
