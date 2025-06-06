package Ejercicios_Propuestos;

public interface StackIn <E>{
    void push(E item);
    E pop();
    E top();
    void destroyStack();
    boolean isEmpty();
    boolean isFull();
}
