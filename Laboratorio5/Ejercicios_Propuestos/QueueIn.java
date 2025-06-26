package Laboratorio5.Ejercicios_Propuestos;

public interface QueueIn<E> {
    void enqueue(E item);
    E dequeue();
    void destroyQueue();
    boolean isEmpty();
    E front();
    E back();
}