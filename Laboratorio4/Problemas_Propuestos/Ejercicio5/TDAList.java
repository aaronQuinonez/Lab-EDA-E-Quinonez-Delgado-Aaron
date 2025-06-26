package Laboratorio4.Problemas_Propuestos.Ejercicio5;

public interface TDAList<E> {
	void insertFirst(E x);
	void insertLast(E x);
	boolean search(E x);
	void deleteByKey(E x);
	void deleteAtPosition(int x);
	int lenght();
	boolean isEmpty();
}
