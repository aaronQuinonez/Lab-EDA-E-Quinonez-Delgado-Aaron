package Laboratorio9;

public class Element<T> {
    private Register<T> register;
    private boolean isDeleted;

    public Element() {
        this.register = null;
        this.isDeleted = false;
    }

    public Element(Register<T> register) {
        this.register = register;
        this.isDeleted = false;
    }

    public Register<T> getRegister() {
        return register;
    }

    public void setRegister(Register<T> register) {
        this.register = register;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
