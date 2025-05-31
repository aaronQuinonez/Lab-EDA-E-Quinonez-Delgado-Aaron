package Problemas_Propuestos.Ejercicio7;

public class CircularLinkedList<E> {
    private Node<E> tail;
    private int size;

    public CircularLinkedList() {
        this.tail = null;
        this.size = 0;
    }

    public void insertLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (tail == null) {
            tail = newNode;
            tail.setNext(tail);
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void insertFirst(E data) {
        Node<E> newNode = new Node<>(data);
        if (tail == null) {
            tail = newNode;
            tail.setNext(tail);
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    public void printList() {
        if (tail == null) {
            System.out.println("Lista vacía");
            return;
        }

        Node<E> current = tail.getNext();
        Node<E> start = current;

        while (current != null) {
            System.out.print(current + " -> ");
            current = current.getNext();
            if (current == start) 
                break;
        }
        System.out.println("Inicio");
    }
}