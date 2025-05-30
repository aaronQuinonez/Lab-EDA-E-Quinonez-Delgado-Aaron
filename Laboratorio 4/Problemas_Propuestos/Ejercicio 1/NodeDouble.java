public class NodeDouble<E> {

    private E data;
    private NodeDouble<E> prev;
    private NodeDouble<E> next;

    public NodeDouble (E data){
        this.data = data;
        prev = null;
        next = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodeDouble<E> getPrev() {
        return prev;
    }

    public void setPrev(NodeDouble<E> prev) {
        this.prev = prev;
    }

    public NodeDouble<E> getNext() {
        return next;
    }

    public void setNext(NodeDouble<E> next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        return data.toString();
    }
}