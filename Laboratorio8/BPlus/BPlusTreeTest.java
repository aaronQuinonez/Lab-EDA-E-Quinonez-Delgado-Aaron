package Laboratorio8.BPlus;

import java.util.Scanner;

public class BPlusTreeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el grado del árbol B+: ");
        int grado = sc.nextInt();
        BPlusTree<Integer> tree = new BPlusTree<>(grado);

        // Insertar claves de prueba
        int[] datosIniciales = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};
        for (int dato : datosIniciales) {
            tree.insert(dato);
        }

        int op;
        do {
            System.out.println("\n--- MENÚ ÁRBOL B+ ---");
            System.out.println("1. Insertar clave");
            System.out.println("2. Eliminar clave");
            System.out.println("3. Buscar clave");
            System.out.println("4. Mostrar árbol (texto)");
            System.out.println("5. Mostrar writeTree() + Visualizar");
            System.out.println("6. Valor mínimo");
            System.out.println("7. Valor máximo");
            System.out.println("8. Predecesor");
            System.out.println("9. Sucesor");
            System.out.println("10. Destruir árbol");
            System.out.println("11. Verificar si está vacío");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Ingrese clave a insertar: ");
                    int ins = sc.nextInt();
                    tree.insert(ins);
                    System.out.println("Clave insertada.");
                    break;

                case 2:
                    System.out.print("Ingrese clave a eliminar: ");
                    int del = sc.nextInt();
                    boolean eliminado = tree.remove(del);
                    System.out.println(eliminado ? "Clave eliminada." : "Clave no encontrada.");
                    break;

                case 3:
                    System.out.print("Ingrese clave a buscar: ");
                    int srch = sc.nextInt();
                    System.out.println(tree.search(srch) ? "Clave encontrada." : "Clave no encontrada.");
                    break;

                case 4:
                    System.out.println("Árbol B+ actual:");
                    System.out.println(tree.toString());
                    break;

                case 5:
                    System.out.println("Detalles del árbol (writeTree):");
                    System.out.println(tree.writeTree());
                    System.out.println("Visualizando gráficamente el árbol...");
                    BPlusTreeVisualizador<Integer> visualizador = new BPlusTreeVisualizador<>(tree);
                    visualizador.visualizar();
                    break;

                case 6:
                    System.out.println("Valor mínimo: " + tree.min());
                    break;

                case 7:
                    System.out.println("Valor máximo: " + tree.max());
                    break;

                case 8:
                    System.out.print("Clave para hallar predecesor: ");
                    int pred = sc.nextInt();
                    System.out.println("Predecesor: " + tree.predecessor(pred));
                    break;

                case 9:
                    System.out.print("Clave para hallar sucesor: ");
                    int suc = sc.nextInt();
                    System.out.println("Sucesor: " + tree.successor(suc));
                    break;

                case 10:
                    tree.destroy();
                    System.out.println("Árbol destruido.");
                    break;

                case 11:
                    System.out.println(tree.isEmpty() ? "El árbol está vacío." : "El árbol NO está vacío.");
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (op != 0);

        sc.close();
    }
}
