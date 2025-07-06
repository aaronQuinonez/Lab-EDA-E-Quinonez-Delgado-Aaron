package Laboratorio8;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class BTreeVisualizador<E extends Comparable<E>> {
    private Graph graph;
    private int nodeCounter = 0;
    private BTree<E> arbol;

    public BTreeVisualizador(BTree<E> arbol) {
        this.arbol = arbol;
    }

    public void visualizar() {
        BNode<E> root = arbol.getRoot();
        if (root == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        System.setProperty("org.graphstream.ui", "swing");
        graph = new SingleGraph("Árbol B");
        graph.setStrict(false);
        graph.setAutoCreate(true);

        graph.setAttribute("ui.stylesheet", getStyleSheet());
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");

        nodeCounter = 0;

        buildGraph(root, null, 0, 0, calculateInitialOffset(root));

        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        viewer.disableAutoLayout();

        System.out.println("Árbol B visualizado. Cierra la ventana para continuar.");
    }

    private void buildGraph(BNode<E> node, String parentId, double x, double y, double offset) {
        if (node == null) return;

        String nodeId = "node_" + (nodeCounter++);
        String label = node.toString(); // ya muestra claves [x, y, z]

        Node graphNode = graph.addNode(nodeId);
        graphNode.setAttribute("ui.label", label);
        graphNode.setAttribute("x", x);
        graphNode.setAttribute("y", y);
        graphNode.setAttribute("layout.frozen");

        if (parentId != null) {
            String edgeId = parentId + "_to_" + nodeId;
            graph.addEdge(edgeId, parentId, nodeId, true);
        }

        double childY = y - 80;
        double childOffset = offset * 0.6;

        for (int i = 0; i <= node.count; i++) {
            BNode<E> child = node.childs.get(i);
            if (child != null) {
                double childX = x + (i - node.count / 2.0) * offset;
                buildGraph(child, nodeId, childX, childY, childOffset);
            }
        }
    }

    private double calculateInitialOffset(BNode<E> root) {
        int height = treeHeight(root);
        return Math.max(100, 50 * Math.pow(2, height - 1));
    }

    private int treeHeight(BNode<E> node) {
        if (node == null) return 0;
        if (node.childs.get(0) == null) return 1; // hoja
        return 1 + treeHeight(node.childs.get(0));
    }

    private String getStyleSheet() {
        return """
            graph {
                padding: 50px;
            }

            node {
                shape: box;
                size-mode: fit;
                padding: 5px, 3px;
                fill-color: #B0E0E6;
                stroke-mode: plain;
                stroke-color: #4682B4;
                stroke-width: 2px;
                text-color: #000080;
                text-size: 12px;
                text-alignment: center;
                text-style: bold;
                shadow-mode: plain;
                shadow-width: 2px;
                shadow-color: #D3D3D3;
                shadow-offset: 2px, 2px;
            }

            node:selected {
                fill-color: #FFD700;
                stroke-color: #FF8C00;
            }

            edge {
                shape: line;
                size: 2px;
                fill-color: #4682B4;
                arrow-shape: arrow;
                arrow-size: 8px, 6px;
            }

            edge:selected {
                fill-color: #FF6347;
            }
        """;
    }

    public void cerrarVisualizacion() {
        if (graph != null) {
            graph.clear();
        }
    }
}
