package Ejercicios_Resueltos;

public interface Cola <E>{
    void enque(E x);
    void dequeue(E x);
    E back();
    E front();
    boolean isEmpty();
}
