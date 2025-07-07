package Laboratorio8.BPlus;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class BPlusTreeVisualizador<T extends Comparable<T>> {
    private Graph graph;
    private int nodeCounter = 0;
    private BPlusTree<T> arbol;

    public BPlusTreeVisualizador(BPlusTree<T> arbol) {
        this.arbol = arbol;
    }

    public void visualizar() {
        BPlusNode<T> root = arbol.getRoot();
        if (root == null) {
            System.out.println("El árbol B+ está vacío.");
            return;
        }

        System.setProperty("org.graphstream.ui", "swing");
        graph = new SingleGraph("Árbol B+");
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

        System.out.println("Árbol B+ visualizado. Cierra la ventana para continuar.");
    }

    private void buildGraph(BPlusNode<T> node, String parentId, double x, double y, double offset) {
        if (node == null) return;

        String nodeId = "node_" + (nodeCounter++);
        String label = node.toString(); // Mostrar claves como [x, y, z]

        Node graphNode = graph.addNode(nodeId);
        graphNode.setAttribute("ui.label", label);
        graphNode.setAttribute("x", x);
        graphNode.setAttribute("y", y);
        graphNode.setAttribute("layout.frozen");

        if (parentId != null) {
            String edgeId = parentId + "_to_" + nodeId;
            graph.addEdge(edgeId, parentId, nodeId, true);
        }

        if (!node.isLeaf()) {
            double childY = y - 80;
            double childOffset = offset * 0.6;

            for (int i = 0; i < node.getChildren().size(); i++) {
                BPlusNode<T> child = node.getChildren().get(i);
                double childX = x + (i - node.getChildren().size() / 2.0) * offset;
                buildGraph(child, nodeId, childX, childY, childOffset);
            }
        }
    }

    private double calculateInitialOffset(BPlusNode<T> root) {
        int height = treeHeight(root);
        return Math.max(100, 50 * Math.pow(2, height - 1));
    }

    private int treeHeight(BPlusNode<T> node) {
        if (node == null) return 0;
        if (node.isLeaf()) return 1;
        return 1 + treeHeight(node.getChildren().get(0));
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
                fill-color: #98FB98;
                stroke-mode: plain;
                stroke-color: #2E8B57;
                stroke-width: 2px;
                text-color: #004d00;
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
                fill-color: #2E8B57;
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
