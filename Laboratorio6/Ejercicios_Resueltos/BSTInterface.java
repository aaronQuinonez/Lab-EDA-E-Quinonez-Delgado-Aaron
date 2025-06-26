package Laboratorio6.Ejercicios_Resueltos;

public interface BSTInterface<E extends Comparable<E>> {
    void destroy();
    boolean isEmpty();
    void insert(E x) throws ExceptionItemDuplicate;
    void remove(E x) throws ExceptionItemNotFound;
    boolean search(E x) throws ExceptionItemNotFound;
    E min() throws ExceptionItemNotFound;
    E max() throws ExceptionItemNotFound;
    E predecesor(E x) throws ExceptionItemNotFound;
    E sucesor(E x) throws ExceptionItemNotFound;
}
