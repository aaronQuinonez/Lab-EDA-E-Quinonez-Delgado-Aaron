package Laboratorio5.Ejercicios_Propuestos;

public class QueueGen<E> implements QueueIn<E> {
    private Node<E> first;
    private Node<E> last;
    private int count;

    public QueueGen(){
        first = null;
        last = null;
    }
    
    public void enqueue(E item){
        Node<E> aux = new Node<>(item);
        if(isEmpty()){
            first = aux;
            last = aux;
        }else{
            last.setNext(aux);
            last = aux;
        }
        count++;
    }
    public E dequeue(){
        if(isEmpty()){
            System.out.println("Cola vacía");
            return null;
        }else{
            E aux = first.getData();
            first = first.getNext();
            count--;
            if(first == null){
                last = null;
            }
            return aux;
        }
    }
    public void destroyQueue(){
        first = null;
        last = null;
        count = 0;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public E front(){
        if(isEmpty()){
            return null;
        }
        return first.getData();
    }
    public E back(){
        if(isEmpty())
            return null;
        return last.getData();
    }

    @Override
    public String toString() {
        if(isEmpty())
            return "Cola vacía";
        String str = "";
        Node<E> aux = first;
        while(aux != null){
            str += aux.getData() + ", ";
            aux = aux.getNext();
        }
        return str;
    }
}
