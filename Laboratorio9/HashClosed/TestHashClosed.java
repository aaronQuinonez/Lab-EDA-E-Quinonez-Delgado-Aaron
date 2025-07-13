package Laboratorio9.HashClosed;

public class TestHashClosed {
    public static void main(String[] args) {
        HashClosed<Integer> hashTable = new HashClosed<>(10);

        // Agregar los elementos
        hashTable.add(new Register<>(100, 100));
        hashTable.add(new Register<>(5, 5));
        hashTable.add(new Register<>(14, 14));
        hashTable.add(new Register<>(15, 15));
        hashTable.add(new Register<>(22, 22));
        hashTable.add(new Register<>(16, 16));
        hashTable.add(new Register<>(17, 17));
        hashTable.add(new Register<>(32, 32));
        hashTable.add(new Register<>(13, 13));
        hashTable.add(new Register<>(32, 32));
        hashTable.add(new Register<>(100, 100));

        // Mostrar la tabla hash resultante
        System.out.println("\nTabla hash después de agregar los elementos:");
        hashTable.display();

        // Buscar los elementos
        System.out.println("\nBuscando elementos...");
        Register<Integer> found32 = hashTable.find(32);
        if (found32 != null) {
            System.out.println("Encontrado el valor 32: " + found32);
        } else {
            System.out.println("Elemento 32 no encontrado.");
        }

        Register<Integer> found200 = hashTable.find(200);
        if (found200 != null) {
            System.out.println("Encontrado el valor 200: " + found200);
        } else {
            System.out.println("Elemento 200 no encontrado.");
        }

        // Eliminar los elementos 17 y 100
        System.out.println("\nEliminando los elementos 17 y 100...");
        hashTable.remove(17);
        hashTable.remove(100);

        // Mostrar la tabla hash resultante después de las eliminaciones
        System.out.println("\nTabla hash después de eliminar los elementos 17 y 100:");
        hashTable.display();
    }
}
