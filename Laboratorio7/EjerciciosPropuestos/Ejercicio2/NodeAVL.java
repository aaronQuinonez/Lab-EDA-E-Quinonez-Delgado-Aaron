package Laboratorio7.EjerciciosPropuestos.Ejercicio2;

public class NodeAVL<E> {
    private E data;
    private NodeAVL<E> left;
    private NodeAVL<E> right;
    private int fe;
    
    public NodeAVL(E data){
        this.data = data;
        left = null;
        right = null;
        fe = 0;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodeAVL<E> getLeft() {
        return left;
    }

    public void setLeft(NodeAVL<E> left) {
        this.left = left;
    }

    public NodeAVL<E> getRight() {
        return right;
    }

    public void setRight(NodeAVL<E> right) {
        this.right = right;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    @Override
    public String toString(){
        return data.toString() + "(F.E.=" + fe + ")";
    }
}
