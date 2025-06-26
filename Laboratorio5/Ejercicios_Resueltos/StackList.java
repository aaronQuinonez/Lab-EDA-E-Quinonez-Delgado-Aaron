package Laboratorio5.Ejercicios_Resueltos;
public class StackList <E> {
    private Node<E> tope;
    private int count;

    public StackList() {
        tope = null;
        count = 0;
    }

    public boolean isEmpty(){
        return tope == null;
    }

    public void push(E x){
        Node<E> aux = new Node<>(x);
        if(isEmpty()){
            tope = aux;
        }else{
            aux.setNext(tope);
            tope = aux;
        }
        count++;
    }

    public void pop(){
        if(isEmpty())
            System.out.println("Pila vacía");
        else{
            System.out.println("Eliminando tope: " + tope.getData());
            tope = tope.getNext();
            count--;
        }
    }

    public String peek(){
        return tope.toString();
    }

    public int search(E x){
        Node<E> current = tope;
        int pos = 1;
        while (current != null) {
            if (current.getData().equals(x)) {
                return pos;
            }
            current = current.getNext();
            pos++;
        }
        return -1;
    }

    public int length(){
        return count;
    }

    @Override
    public String toString() {
        String str = "";
        Node<E> current = tope;
        while (current != null) {
            str += current.getData() + ", ";
            current = current.getNext();
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 2);
        }
        return str;
    }
}
