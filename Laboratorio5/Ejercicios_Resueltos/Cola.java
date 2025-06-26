package Laboratorio5.Ejercicios_Resueltos;

public interface Cola <E>{
    void enque(E x);
    void dequeue();
    E back();
    E front();
    boolean isEmpty();
}
