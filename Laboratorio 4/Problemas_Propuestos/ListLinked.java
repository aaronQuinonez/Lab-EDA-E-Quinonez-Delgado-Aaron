package Problemas_Propuestos;
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
	
	public void remove(E x) {
		if(isEmpty()){
			return;
		}
		Node<E> dato = this.head;
		Node<E> apuntador = this.head.getNext();
		while(apuntador != null && !apuntador.getData().equals(x)){
			dato = dato.getNext();
			apuntador = apuntador.getNext();
		}
		if(apuntador.getData().equals(x)){
			dato.setNext(apuntador.getNext());
		}
	}
	
	public String toString() {
		String str = "";
		for(Node<E> aux = this.head; aux != null; aux = aux.getNext())
			str += aux.toString() + ", ";
		return str;
	}
	
}
