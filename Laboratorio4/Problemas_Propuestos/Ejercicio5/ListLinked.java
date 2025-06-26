package Laboratorio4.Problemas_Propuestos.Ejercicio5;
 
public class ListLinked<E> implements TDAList<E>{
	private Node<E> head;
	private int count;
	
	public ListLinked() {
		this.head = null;
		this.count = 0;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public int lenght() {
		return this.count;
	}
	
	public void insertFirst(E x) {
		this.head = new Node<E>(x, this.head);
		this.count ++;
	}
	
	public void insertLast(E x) {
		if (isEmpty())
			insertFirst(x);
		else {
			Node<E> aux = this.head;
			while (!aux.getData().equals(x) && aux.getNext() != null)
				aux = aux.getNext();
			if(!aux.getData().equals(x)) {
				aux.setNext(new Node<E>(x));
				this.count ++;
			}
		}
	}
	
	public boolean search(E x) { 
		Node<E> aux = this.head;
		for(; aux != null && !aux.getData().equals(x); aux = aux.getNext());
		return aux != null;
	}
	
	public void deleteByKey(E x) {
		if (isEmpty())
			return;

		if (head.getData().equals(x)) {
			head = head.getNext();
			count--;
			return;
		}

		Node<E> prev = head;
		Node<E> curr = head.getNext();
		while (curr != null && !curr.getData().equals(x)) {
			prev = curr;
			curr = curr.getNext();
		}
		if (curr != null) {
			prev.setNext(curr.getNext());
			count--;
		}
	}

	public void deleteAtPosition(int x) {
		if (x < 0 || x >= count || isEmpty()) 
			return;

		if (x == 0) {
			head = head.getNext();
			count--;
			return;
		}
		Node<E> prev = head;
		for (int i = 0; i < x - 1; i++) {
			prev = prev.getNext();
		}
		Node<E> toDelete = prev.getNext();
		if (toDelete != null) {
			prev.setNext(toDelete.getNext());
			count--;
		}
	}

	public void removeFirst() {
		if (!isEmpty()) {
			head = head.getNext();
			count--;
		}
	}

    public void removeLast() {
        if (isEmpty()) return;
        if (head.getNext() == null) {
            head = null;
        } else {
            Node<E> aux = head;
            while (aux.getNext().getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(null);
        }
        count--;
    }
	
	public String toString() {
		String str = "";
		for(Node<E> aux = this.head; aux != null; aux = aux.getNext())
			str += aux.toString() + ", ";
		return str;
	}
}