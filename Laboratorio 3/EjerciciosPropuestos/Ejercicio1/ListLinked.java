public class ListLinked <T> implements NodeList<T>{
    private Node<T> head;
    private int count;

    public ListLinked(){
        this.head = null;
        this.count = 0;
    }
    public boolean isEmpty() {
		return this.head == null;
	}
}
