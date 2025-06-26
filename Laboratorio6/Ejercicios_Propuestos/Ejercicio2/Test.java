package Laboratorio6.Ejercicios_Propuestos.Ejercicio2;
import Laboratorio6.Ejercicios_Propuestos.BST;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST<Integer> arbol = new BST<>();
        System.out.print("Ingresa una palabra: ");
        String palabra = scanner.nextLine();
        try {
            for (char letra : palabra.toCharArray()) {
                int ascii = (int) letra;
                if (!arbol.search(ascii)) {
                    arbol.insert(ascii);
                    System.out.println("Insertando letra '" + letra + "' en ASCII: " + ascii);
                } else {
                    System.out.println("Letra repetida '" + letra + "', no insertada.");
                }
            }
            System.out.println("\n--- Árbol ---");
            System.out.println(arbol);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
