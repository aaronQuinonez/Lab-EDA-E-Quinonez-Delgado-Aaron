package Problemas_Propuestos.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        ListDoubleLinked<Integer> nums = new ListDoubleLinked<>();
        System.out.println(nums.isEmpty());
        nums.insertFirst(4);
        nums.insertFirst(5);
        nums.insertFirst(6);
        nums.insertFirst(7);
        nums.insertFirst(8);
        System.out.println(nums);
        System.out.println("Longitud: " + nums.lengt());
    }
}
