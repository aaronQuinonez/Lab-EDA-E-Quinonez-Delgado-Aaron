package Laboratorio4.Problemas_Propuestos.Ejercicio6;

public class Node<E> {
    private E data;
    private Node<E> next;
    private Node<E> prev;

    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node(E data, Node<E> next, Node<E> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public String toString() {
        return data.toString();
    }
}
