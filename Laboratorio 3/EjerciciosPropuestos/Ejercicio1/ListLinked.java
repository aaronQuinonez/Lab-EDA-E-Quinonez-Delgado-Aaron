public class ListLinked <T> implements NodeList<T>{
    private Node<T> head;
    private int count;

    public ListLinked(){
        this.head = null;
        this.count = 0;
    }
    @Override
    public boolean isEmpty() {
		return this.head == null;
	}
    @Override
    public void insertarPrimero(T x){
        this.head = new Node<T>(x, this.head);
        this.count++;
    }
    @Override
    public void insertarUltimo(T x){
        if(isEmpty())
            insertarPrimero(x);
        else{
            Node<T> aux= this.head;
            while(aux.getNextNode() != null){
                aux = aux.getNextNode();
            }
            aux.setNextNode(new Node<T>(x));
            this.count++;
        }
    }
    @Override
    public String toString() {
        String list = "";
        for(Node<T> aux = this.head; aux != null; aux = aux.getNextNode()){
            list += aux.toString() + " ";
        }
        return list;
    }
}
