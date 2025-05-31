package Problemas_Propuestos.Ejercicio5;

public class Main {
    public static void main(String[] args) {
		ListLinked<Integer> lista = new ListLinked<>();
		for (int i = 1; i <= 5; i++) {
            lista.insertLast(i);
        }
        System.out.println("Lista después de insertar:");
        System.out.println(lista);
		lista.insertFirst(40);
        System.out.println("Lista después de usar insertFirst:");
		System.out.println(lista);
		lista.deleteByKey(10);
        System.out.println("Después de intentar eliminar 10 (no está):");
		System.out.println(lista);
		lista.deleteByKey(40);
        System.out.println("Después de eliminar 40:");
        System.out.println(lista);
		lista.deleteAtPosition(1);
        System.out.println("Después de eliminar el segundo elemento:");
        System.out.println(lista);
        lista.deleteAtPosition(10);
        System.out.println("Después de intentar eliminar en posición 10 (fuera de rango):");
        System.out.println(lista);
        lista.removeFirst();
        System.out.println("Después de removeFirst():");
        System.out.println(lista);
        lista.removeLast();
        System.out.println("Después de removeLast():");
        System.out.println(lista);
	}
}
