package Problemas_Propuestos.Ejercicio7;

public class CircularLinkedList<E> {
    private Node<E> tail;
    private int size;

    public CircularLinkedList() {
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public int size() {
        return size;
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

    public void deleteByKey(E key) {
        if (tail == null) 
            return;

        Node<E> current = tail.getNext();
        Node<E> prev = tail;
        boolean found = false;
        while (true) {
            if (current.getData().equals(key)) {
                found = true;
                break;
            }
            if (current == tail) break;
            prev = current;
            current = current.getNext();
        }

        if (!found) 
            return;

        if (current == tail && current == tail.getNext()) {
            tail = null;
        } else if (current == tail) {
            prev.setNext(current.getNext());
            tail = prev;
        } else {
            prev.setNext(current.getNext());
        }
        size--;
    }

    public void deleteAtPosition(int pos) {
        if (isEmpty() || pos < 0 || pos >= size) {
            System.out.println("Posición inválida o lista vacía.");
            return;
        }
        Node<E> current = tail.getNext();
        Node<E> prev = tail;
        if (pos == 0) {
            if (size == 1) {
                tail = null;
            } else {
                prev.setNext(current.getNext());
                tail = prev;
            }
        } else {
            for (int i = 0; i < pos; i++) {
                prev = current;
                current = current.getNext();
            }
            prev.setNext(current.getNext());
            if (current == tail) {
                tail = prev;
            }
        }
        size--;
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