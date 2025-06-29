package Laboratorio7.EjerciciosResueltos;

public class Test {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();

        try {
            int[] values = {30, 20, 10, 40, 50, 25};

            for (int val : values) {
                System.out.println("Insertando: " + val);
                tree.insert(val);
                System.out.println(tree);
                System.out.println("------------------");
            }

        } catch (ExceptionItemDuplicate e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}