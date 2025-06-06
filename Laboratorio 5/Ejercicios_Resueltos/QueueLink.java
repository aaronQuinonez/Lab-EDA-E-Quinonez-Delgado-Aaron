package Ejercicios_Resueltos;
public class QueueLink<E> implements Cola<E>{
	private Node<E> last;
	private Node<E> first;
	
	public QueueLink() {
		last = first = null;
	}
	public void enque(E x) {
		Node<E> newNode = new Node<>(x);
		if (isEmpty()) 
			first = newNode;
		else 
			last.setNext(newNode);
		last = newNode;
	}
	
	public void dequeue(){
		if (isEmpty())
			System.out.println("Cola vacía");
		first = first.getNext();
		if (first == null)
			last = null;
	}
	public E back(){
		if (isEmpty())
			System.out.println("Cola vacía");
		return last.getData();
	}
	public E front(){
		if (isEmpty())
			System.out.println("Cola vacía");
		return first.getData();
	}
	public boolean isEmpty () {
		return last == null;
	}
	public String toString() {
		String str = "";
		for (Node<E> i = first; i != null; i = i.getNext())
			str += i + ", ";
		return str;
	}
}