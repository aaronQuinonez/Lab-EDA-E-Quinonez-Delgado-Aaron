package Laboratorio8;

import java.util.Scanner;

public class BTreeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el orden del árbol B: ");
        int orden = sc.nextInt();
        BTree<Integer> tree = new BTree<>(orden);
        BTreeVisualizador<Integer> visualizador = new BTreeVisualizador<>(tree);
        
        // Insertar datos iniciales
        tree.insert(100);
        tree.insert(200);
        tree.insert(300);
        tree.insert(400);
        tree.insert(500);
        tree.insert(50);
        tree.insert(25);
        tree.insert(350);
        tree.insert(375);
        tree.insert(360);
        tree.insert(355);
        tree.insert(150);
        tree.insert(175);
        tree.insert(120);
        tree.insert(190);

        int op;
        do {
            System.out.println("\n--- MENÚ ÁRBOL B CON VISUALIZACIÓN ---");
            System.out.println("1. Insertar clave");
            System.out.println("2. Eliminar clave");
            System.out.println("3. Buscar clave");
            System.out.println("4. Mostrar árbol (texto)");
            System.out.println("5. Visualizar árbol (gráfico)");
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
                    System.out.println("Clave insertada. Use opción 5 para ver el árbol gráficamente.");
                    break;

                case 2:
                    System.out.print("Ingrese clave a eliminar: ");
                    int del = sc.nextInt();
                    tree.remove(del);
                    System.out.println("Operación completada. Use opción 5 para ver el árbol gráficamente.");
                    break;

                case 3:
                    System.out.print("Ingrese clave a buscar: ");
                    int srch = sc.nextInt();
                    System.out.println(tree.search(srch) ? "Clave encontrada." : "Clave no encontrada.");
                    break;

                case 4:
                    System.out.println("Árbol B actual (representación textual):");
                    System.out.println(tree);
                    break;

                case 5:
                    System.out.println("Abriendo visualización gráfica del árbol...");
                    visualizador.visualizar();
                    System.out.println("Ventana de visualización abierta. Puede cerrarla cuando termine de verla.");
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
                    System.out.println("Predecesor: " + tree.predecesor(pred));
                    break;

                case 9:
                    System.out.print("Clave para hallar sucesor: ");
                    int suc = sc.nextInt();
                    System.out.println("Sucesor: " + tree.sucesor(suc));
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
                    visualizador.cerrarVisualizacion();
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (op != 0);

        sc.close();
    }
}