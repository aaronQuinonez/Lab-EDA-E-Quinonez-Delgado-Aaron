public interface TDAList<E> {
	void insertFirst(E x);
	void insertLast(E x);
	boolean search(E x);
	void remove(E x);
	int lenght();
	boolean isEmpty();
}
