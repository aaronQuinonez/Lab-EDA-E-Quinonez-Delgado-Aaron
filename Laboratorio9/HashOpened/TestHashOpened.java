package Laboratorio9.HashOpened;

public class TestHashOpened {
    public static void main(String[] args) {
        HashOpened<Integer> hashTable = new HashOpened<>(10);

        // Insertar elementos
        hashTable.insert(new Register<>(100, 100));
        hashTable.insert(new Register<>(5, 5));
        hashTable.insert(new Register<>(14, 14));
        hashTable.insert(new Register<>(15, 15));
        hashTable.insert(new Register<>(22, 22));
        hashTable.insert(new Register<>(16, 16));
        hashTable.insert(new Register<>(17, 17));
        hashTable.insert(new Register<>(32, 32));
        hashTable.insert(new Register<>(13, 13));
        hashTable.insert(new Register<>(32, 32));
        hashTable.insert(new Register<>(100, 100));

        // Mostrar tabla
        hashTable.showTable();

        // Buscar claves
        System.out.println("\nBuscando elementos...");
        Register<Integer> found32 = hashTable.search(32);
        System.out.println(found32 != null ? "Encontrado: " + found32 : "Elemento 32 no encontrado.");

        Register<Integer> found200 = hashTable.search(200);
        System.out.println(found200 != null ? "Encontrado: " + found200 : "Elemento 200 no encontrado.");

        // Eliminar claves
        System.out.println("\nEliminando claves 17 y 100...");
        hashTable.delete(17);
        hashTable.delete(100);

        // Mostrar tabla después de eliminar
        hashTable.showTable();
    }
}
