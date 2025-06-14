package Ejercicios_Propuestos.Ejercicio1;
import Ejercicios_Propuestos.BST;

public class Test {
    public static void main(String[] args) {
        BST<Integer> arbol = new BST<>();
        try {
            System.out.println("¿Árbol vacío?: " + arbol.isEmpty());

            // Insertar elementos
            System.out.println("\n--- Insertando elementos ---");
            arbol.insert(15);
            arbol.insert(10);
            arbol.insert(20);
            arbol.insert(8);
            arbol.insert(12);
            arbol.insert(17);
            arbol.insert(25);
            System.out.println("¿Árbol vacío?: " + arbol.isEmpty());

            // Mostrar recorridos
            System.out.println("\n--- Recorridos del árbol ---");
            System.out.println(arbol);

            // Buscar elementos
            System.out.println("\n--- Búsqueda ---");
            System.out.println("¿Contiene 10?: " + arbol.search(10));
            System.out.println("¿Contiene 30?: " + arbol.search(30));

            // Mínimo y máximo
            System.out.println("\n--- Mínimo y máximo ---");
            System.out.println("Mínimo: " + arbol.min());
            System.out.println("Máximo: " + arbol.max());

            // Sucesor y predecesor
            System.out.println("\n--- Sucesores y predecesores ---");
            System.out.println("Sucesor de 10: " + arbol.sucesor(10));
            System.out.println("Predecesor de 10: " + arbol.predecesor(10));
            System.out.println("Sucesor de 15: " + arbol.sucesor(15));
            System.out.println("Predecesor de 15: " + arbol.predecesor(15));

            // Eliminar nodos
            System.out.println("\n--- Eliminación de nodos ---");
            System.out.println("Árbol antes de eliminar 20:");
            System.out.println(arbol);
            arbol.remove(20);
            System.out.println("Árbol tras eliminar 20:");
            System.out.println(arbol);

            arbol.remove(25);
            arbol.remove(17);
            System.out.println("Árbol tras eliminar 25 y 17:");
            System.out.println(arbol);

            // Destruir árbol
            System.out.println("\n--- Destruyendo el árbol ---");
            arbol.destroy();
            System.out.println("¿Árbol vacío?: " + arbol.isEmpty());
            System.out.println("Árbol tras destruir: " + arbol);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}