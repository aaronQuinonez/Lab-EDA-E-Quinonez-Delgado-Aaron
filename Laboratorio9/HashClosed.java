package Laboratorio9;

public class HashClosed<E> {
    private Element<E>[] table;
    private int size;
    private int capacity;

    public HashClosed(int capacity) {
        this.capacity = capacity;
        this.table = new Element[capacity];
        this.size = 0;

        for (int i = 0; i < capacity; i++) {
            table[i] = new Element<>();
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void add(Register<E> register) {
        int index = hash(register.getKey());
        int startIndex = index;

        // Verificar si la clave ya existe
        while (table[index].getRegister() != null) {
            if (!table[index].isDeleted() && table[index].getRegister().getKey() == register.getKey()) {
                System.out.println("Error: La clave " + register.getKey() + " ya está presente en la tabla.");
                return;
            }
            index = (index + 1) % capacity;
            if (index == startIndex) {
                // La tabla está llena, no se puede insertar más
                System.out.println("Error: La tabla hash está llena.");
                return;
            }
        }
        // Si encontramos una celda vacía o eliminada, insertamos el registro
        table[index].setRegister(register);
        table[index].setDeleted(false);
        size++;
        System.out.println("Elemento con clave " + register.getKey() + " agregado correctamente.");
    }

    // Buscar un registro por clave
    public Register<E> find(int key) {
        int index = hash(key);
        int startIndex = index;

        while (table[index].getRegister() != null) {
            if (!table[index].isDeleted() && table[index].getRegister().getKey() == key) {
                return table[index].getRegister();
            }
            index = (index + 1) % capacity;
            if (index == startIndex) {
                break;
            }
        }

        return null;
    }

    // Eliminar un registro por clave
    public void remove(int key) {
        int index = hash(key);
        int startIndex = index;

        while (table[index].getRegister() != null) {
            if (!table[index].isDeleted() && table[index].getRegister().getKey() == key) {
                table[index].setDeleted(true);
                table[index].setRegister(null);
                size--;
                System.out.println("Elemento con clave " + key + " eliminado.");
                return;
            }
            index = (index + 1) % capacity;
            if (index == startIndex) {
                break;
            }
        }

        System.out.println("Elemento con clave " + key + " no encontrado.");
    }

    // Mostrar todos los elementos de la tabla
    public void display() {
        System.out.println("Contenido de la tabla hash:");
        for (int i = 0; i < capacity; i++) {
            if (table[i].getRegister() != null && !table[i].isDeleted()) {
                System.out.println("Índice " + i + ": " + table[i].getRegister());
            }
        }
    }

    public int getSize() {
        return size;
    }
}
