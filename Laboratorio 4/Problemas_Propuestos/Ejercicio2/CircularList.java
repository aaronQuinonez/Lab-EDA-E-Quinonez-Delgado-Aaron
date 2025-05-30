package Problemas_Propuestos.Ejercicio2;

public class CircularList <E> {
    private Node<E> tail;
    private int count;

    public CircularList() {
        this.tail = null;
        this.count = 0;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public int lenght(){
        return count;
    }

    public void insertLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            newNode.setNext(newNode);
            tail = newNode;
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
            tail = newNode;
        }
        count++;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        String result = "[";
        Node<E> current = tail.getNext();
        Node<E> start = current;
        while (current != null) {
            result += current.getData();
            current = current.getNext();
            if (current == start) break;
            result += ", ";
        }
        result += "]";
        return result;
    }
}
