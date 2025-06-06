package Ejercicios_Propuestos;

public interface QueueIn<E> {
    void enqueue(E item);
    E dequeue();
    void destroyQueue();
    boolean isEmpty();
    boolean isFull();
    E front();
    E back();
}