package Laboratorio4.Problemas_Propuestos.Ejercicio6;

public class DoubleLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int count;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return count;
    }

    public void insertFirst(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        count++;
    }

    public void insertLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        count++;
    }

    public boolean search(E key) {
        Node<E> current = head;
        while (current != null) {
            if (current.getData().equals(key)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void deleteByKey(E key) {
        if (isEmpty()) 
            return;

        Node<E> current = head;
        while (current != null && !current.getData().equals(key)) {
            current = current.getNext();
        }
        if (current == null) 
            return;

        if (current == head) {
            removeFirst();
        } else if (current == tail) {
            removeLast();
        } else {
            Node<E> prevNode = current.getPrev();
            Node<E> nextNode = current.getNext();

            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
            count--;
        }
    }

    public void deleteAtPosition(int position) {
        if (position < 0 || position >= count || isEmpty()) 
            return;

        if (position == 0) {
            removeFirst();
            return;
        }
        if (position == count - 1) {
            removeLast();
            return;
        }
        Node<E> current = head;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }
        Node<E> prevNode = current.getPrev();
        Node<E> nextNode = current.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        count--;
    }

    public void removeFirst() {
        if (isEmpty()) 
            return;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        count--;
    }

    public void removeLast() {
        if (isEmpty()) 
            return;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        count--;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.toString());
            if (current.getNext() != null) {
                sb.append(" <-> ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }
}

