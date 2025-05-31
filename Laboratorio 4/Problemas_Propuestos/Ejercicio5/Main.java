package Problemas_Propuestos.Ejercicio5;

public class Main {
    public static void main(String[] args) {
        TDAList<Integer> l = new ListLinked<Integer>();
		l.insertLast(7);
		System.out.println(l);
		l.insertLast(8);
		System.out.println(l);
		l.insertFirst(3);
		System.out.println(l);
		l.insertFirst(2);
		System.out.println(l);
		l.insertLast(9);
		System.out.println(l);
		l.insertFirst(1);
		System.out.println(l);
		
		System.out.println("50 ? "+ l.search(50));
		System.out.println("9 ? "+ l.search(9));
		
		l.remove(12);
		System.out.println(l);
		l.remove(38);
		System.out.println(l);
		l.remove(50);
		System.out.println(l);
		l.remove(1332);
		System.out.println(l);
		System.out.println("long ? "+ l.lenght());
		
		
	}
}
