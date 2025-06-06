package Ejercicios_Propuestos;

public class StackGen<E> implements StackIn<E>{
    private Node<E> tope;
    private int count;

    public StackGen() {
        tope = null;
        count = 0;
    }

    public void push(E item){
        tope = new Node<>(item, tope);
        count++;
    }
    public E pop(){
        if(isEmpty()){
            System.out.println("Pila vacía");
            return null;
        }else{
            E aux = tope.getData();
            tope = tope.getNext();
            count--;
            return aux;
        }
    }
    public E top(){
        if(isEmpty()){
            System.out.println("Pila vacía");
            return null;
        }else{
            return tope.getData();
        }
    }
    public void destroyStack(){
        tope = null;
        count = 0;
    }
    public boolean isEmpty(){
        return tope == null;
    }

    @Override
    public String toString() {
        String str = "";
        Node<E> aux = tope;
        while(aux != null){
            str += aux.getData().toString() + "\n";
            aux = aux.getNext();
        }
        return str;
    }
}
