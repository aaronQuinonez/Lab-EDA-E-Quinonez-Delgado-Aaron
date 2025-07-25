package Laboratorio3.EjerciciosPropuestos.Ejercicio1;

public class Node <T>{
    private T data;
    private Node<T> nextNode;
    
    public Node(T data, Node<T> nextNode){
        this.data = data;
        this.nextNode = nextNode;
    }

    public Node(T data){
        this.data = data;
        this.nextNode = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public String toString() {
        return this.data.toString();
    }
    
}
