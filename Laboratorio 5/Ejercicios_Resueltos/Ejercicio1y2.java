package Ejercicios_Resueltos;
public class Ejercicio1y2{
    public static void main(String[] args) {
        StackList <Integer> nums = new StackList<>();
        nums.push(5);
        nums.push(4);
        nums.push(3);
        nums.push(2);
        nums.push(1);
        System.out.println(nums);
        System.out.println("Longitud: " + nums.length());
        System.out.println("Tope: " + nums.peek());
        System.out.println("Buscar pos de 5:" + nums.search(5));
        nums.pop();
        nums.pop();
        nums.pop();
        System.out.println(nums);
        System.out.println("Longitud: " + nums.length());
        System.out.println("Tope: " + nums.peek());

        System.out.println("\n-----COLAS--------");
        QueueLink<Integer> numColas = new QueueLink<>();
        numColas.enque(1);
        numColas.enque(2);
        numColas.enque(3);
        numColas.enque(4);
        numColas.enque(5);
        System.out.println(numColas);
        System.out.println("Primero: " + numColas.front());
        System.out.println("Último: " + numColas.back());
        numColas.dequeue();
        numColas.dequeue();
        System.out.println(numColas);
        System.out.println("Primero: " + numColas.front());
        System.out.println("Último: " + numColas.back());
    }
}