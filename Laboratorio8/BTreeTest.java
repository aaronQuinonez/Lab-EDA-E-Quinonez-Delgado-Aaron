package Laboratorio8;

public class BTreeTest {
    public static void main(String[] args) {
        BTree<Integer> btree = new BTree<>(5);

        btree.insert(100);
        btree.insert(200);
        btree.insert(300);
        btree.insert(400);
        btree.insert(500);
        btree.insert(50);
        btree.insert(25);
        btree.insert(350);
        btree.insert(375);
        btree.insert(360);
        btree.insert(355);
        btree.insert(150);
        btree.insert(175);
        btree.insert(120);
        btree.insert(190);
        System.out.println(btree.toString());
        if (btree.search(200)) {
            System.out.println("Clave 200 encontrada.");
        } else {
            System.out.println("Clave 200 no está en el árbol.");
        }
        System.out.println("Mínimo: " + btree.min());
        System.out.println("Máximo: " + btree.max());
        System.out.println("Predecesor de 300: " + btree.predecesor(300));
        System.out.println("Sucesor de 300: " + btree.sucesor(300));

        btree.destroy();
        System.out.println(btree.toString());
    }
}