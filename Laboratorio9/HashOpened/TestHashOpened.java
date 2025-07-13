package Laboratorio9.HashOpened;

public class TestHashOpened {
    public static void main(String[] args) {
        // TAMAÑO DE LA TABLA: 8
        HashOpened<String> hashTable = new HashOpened<>(8);

        // AGREGACIÓN DE ELEMENTOS
        hashTable.insert(new Register<>(5, "Pepe"));
        hashTable.insert(new Register<>(21, "Jesús"));
        hashTable.insert(new Register<>(19, "Juan"));
        hashTable.insert(new Register<>(16, "María"));

        // INTENTAR AGREGAR CLAVE DUPLICADA
        hashTable.insert(new Register<>(21, "DUPLICADO"));

        // MOSTRAR LA TABLA HASH
        hashTable.showTable();

        // BÚSQUEDA DE CLAVES
        System.out.println("\n--- BÚSQUEDA ---");
        Register<String> r5 = hashTable.search(5);
        System.out.println(r5 != null ? "Encontrado: " + r5 : "Clave 5 no encontrada.");

        Register<String> r21 = hashTable.search(21);
        System.out.println(r21 != null ? "Encontrado: " + r21 : "Clave 21 no encontrada.");

        // ELIMINACIÓN LÓGICA
        System.out.println("\n--- ELIMINACIÓN ---");
        hashTable.delete(21);
        hashTable.delete(100); // no existe

        // MOSTRAR TABLA TRAS ELIMINACIÓN
        hashTable.showTable();
    }
}