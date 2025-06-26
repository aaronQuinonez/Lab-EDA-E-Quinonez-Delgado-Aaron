package Laboratorio4.Problemas_Propuestos.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        ListDoubleLinked<Integer> nums = new ListDoubleLinked<>();
        System.out.println(nums.isEmpty());
        nums.insertFirst(10);
        nums.insertFirst(9);
        nums.insertFirst(8);
        nums.insertFirst(7);
        nums.insertFirst(6);
        nums.insertFirst(5);
        nums.insertFirst(4);
        nums.insertFirst(3);
        nums.insertFirst(2);
        nums.insertFirst(1);
        System.out.println(nums);
        System.out.println("Longitud: " + nums.lengt());
    }
}
