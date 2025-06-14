package Ejercicios_Resueltos;

public class Main {
    public static void main(String[] args) {
        BST<Integer> arbol = new BST<>();
        System.out.println(arbol.isEmpty());
        try {
            arbol.insert(15);
            arbol.insert(10);
            arbol.insert(7);
            arbol.insert(13);
            arbol.insert(20);
            arbol.insert(17);
            arbol.insert(25);
            System.out.println("Árbol completo: " + arbol);
            System.out.println("Buscar 10: " + arbol.search(10));
            System.out.println("Buscar 25: " + arbol.search(25));
            System.out.println("El valor mínimo del árbol es: " + arbol.min());
            System.out.println("El valor máximo del árbol es: " + arbol.max());
            //Sucesor
            System.out.println("Sucesor de 10: " + arbol.sucesor(10));
            System.out.println("Sucesor de 15: " + arbol.sucesor(15));
            //Predecesor
            System.out.println("Predecesor de 10: " + arbol.predecesor(10));
            System.out.println("Predecesor de 15: " + arbol.predecesor(15)); 
            //Imprimiendo árbol
            System.out.println("Árbol completo: " + arbol);
            // Eliminaciones
            arbol.remove(7);
            System.out.println("Después de eliminar 7 (hoja): " + arbol);
            arbol.remove(20);
            System.out.println("Después de eliminar 20 (dos hijos): " + arbol);
            arbol.remove(10);
            System.out.println("Después de eliminar 10 (un hijo): " + arbol);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
