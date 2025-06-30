package Laboratorio7.EjerciciosPropuestos.Ejercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVLTree<Integer> tree = new AVLTree<>();
        AVLVisual<Integer> visualizer = new AVLVisual<>();

        int option;

        do {
            System.out.println("\n--- MENÚ ÁRBOL AVL ---");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Buscar elemento");
            System.out.println("4. Mínimo");
            System.out.println("5. Máximo");
            System.out.println("6. Predecesor");
            System.out.println("7. Sucesor");
            System.out.println("8. Mostrar recorridos");
            System.out.println("9. Destruir árbol");
            System.out.println("10. Verificar si está vacío");
            System.out.println("11. Graficar árbol");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.print("Ingrese el elemento a insertar: ");
                    int val = sc.nextInt();
                    try {
                        tree.insert(val);
                        System.out.println("Elemento insertado.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                case 2 -> {
                    System.out.print("Ingrese el elemento a eliminar: ");
                    int val = sc.nextInt();
                    try {
                        tree.remove(val);
                        System.out.println("Elemento eliminado.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                case 3 -> {
                    System.out.print("Ingrese el elemento a buscar: ");
                    int val = sc.nextInt();
                    boolean found = tree.search(val);
                    System.out.println("¿Encontrado? " + found);
                }

                case 4 -> {
                    try {
                        System.out.println("Mínimo: " + tree.min());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                case 5 -> {
                    try {
                        System.out.println("Máximo: " + tree.max());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                case 6 -> {
                    System.out.print("Valor para predecesor: ");
                    int val = sc.nextInt();
                    try {
                        System.out.println("Predecesor: " + tree.predecesor(val));
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                case 7 -> {
                    System.out.print("Valor para sucesor: ");
                    int val = sc.nextInt();
                    try {
                        System.out.println("Sucesor: " + tree.sucesor(val));
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                case 8 -> {
                    System.out.println("--- Recorridos ---");
                    System.out.println(tree);
                }

                case 9 -> {
                    tree.destroy();
                    System.out.println("Árbol destruido.");
                }

                case 10 -> {
                    System.out.println(tree.isEmpty() ? "Árbol vacío." : "Árbol NO vacío.");
                }

                case 11 -> {
                    System.out.println("Mostrando gráfico del árbol AVL...");
                    visualizer.visualize(tree.getRoot());
                }

                case 0 -> System.out.println("Saliendo del programa...");

                default -> System.out.println("Opción inválida.");
            }

        } while (option != 0);

        sc.close();
    }
}
