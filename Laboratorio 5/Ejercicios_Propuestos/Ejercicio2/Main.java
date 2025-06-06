package Ejercicios_Propuestos.Ejercicio2;

import Ejercicios_Propuestos.QueueGen;

public class Main {
    public static void main(String[] args) {
        QueueGen<Integer> nums = new QueueGen<>();
        nums.enqueue(1);
        nums.enqueue(2);
        nums.enqueue(3);
        nums.enqueue(4);
        nums.enqueue(5);
        nums.enqueue(6);
        nums.enqueue(7);
        nums.enqueue(8);
        nums.enqueue(9);
        nums.enqueue(10);
        System.out.println(nums);
        System.out.println(nums.back());
        System.out.println(nums.front());
        System.out.println(nums.dequeue());
        System.out.println(nums);
        System.out.println(nums.front());
        nums.destroyQueue();
        System.out.println(nums);
    }
}
