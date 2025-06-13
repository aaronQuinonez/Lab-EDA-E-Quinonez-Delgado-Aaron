package Ejercicios_Resueltos;

public interface BSTInterface<E extends Comparable<E>> {
    void destroy();
    boolean isEmpty();
    void insert(E x) throws ExceptionItemDuplicate;
    void remove(E x);
    boolean search(E x);
    E min();
    E max();
    E predecesor(E x);
    E sucesor(E x);
}
