package Laboratorio7.EjerciciosResueltos;

public class NodeAVL<E> extends Node<E> {
    private int fe;

    public NodeAVL(E data) {
        super(data);
        this.fe = 0;
    }

    public int getFE() {
        return fe;
    }

    public void setFE(int fe) {
        this.fe = fe;
    }

    @Override
    public String toString() {
        return getData().toString();
    }
}

