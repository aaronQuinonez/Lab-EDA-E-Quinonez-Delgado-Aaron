package Laboratorio7.EjerciciosPropuestos.Ejercicio3;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class AVLVisual<E> {
    private Graph graph;
    private int nodeCounter = 0;

    public void visualize(NodeAVL<E> root) {
        if (root == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        System.setProperty("org.graphstream.ui", "swing");
        
        graph = new SingleGraph("AVL Tree");
        graph.setStrict(false);
        graph.setAutoCreate(true);
        
        // Configurar el estilo del grafo
        graph.setAttribute("ui.stylesheet", getStyleSheet());
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");
        
        nodeCounter = 0;
        
        // Construir el grafo desde la raíz
        buildGraphHierarchical(root, null, 0, 0, calculateInitialOffset(root));
        
        // Crear el viewer y configurarlo
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        
        // Desactivar el layout automático para mantener posiciones manuales
        viewer.disableAutoLayout();
        
        System.out.println("Árbol AVL visualizado. Cierra la ventana para continuar.");
    }
    
    private void buildGraphHierarchical(NodeAVL<E> node, String parentId, double x, double y, double horizontalSpacing) {
        if (node == null) return;
        
        // Crear ID único para evitar conflictos
        String nodeId = "node_" + nodeCounter++;
        
        // Agregar el nodo al grafo
        Node graphNode = graph.addNode(nodeId);
        
        // Configurar etiqueta y posición
        graphNode.setAttribute("ui.label", node.getData().toString() + " (FE:" + node.getFe() + ")");
        graphNode.setAttribute("x", x);
        graphNode.setAttribute("y", y);
        
        // Marcar posición como fija
        graphNode.setAttribute("layout.frozen");
        
        // Conectar con el padre si existe
        if (parentId != null) {
            String edgeId = parentId + "_to_" + nodeId;
            graph.addEdge(edgeId, parentId, nodeId, true);
        }
        
        // Recursivamente agregar hijos con espaciado apropiado
        double nextY = y - 80; // Distancia vertical entre niveles
        double nextSpacing = horizontalSpacing * 0.6; // Reducir espaciado horizontal
        
        if (node.getLeft() != null) {
            buildGraphHierarchical(node.getLeft(), nodeId, x - horizontalSpacing, nextY, nextSpacing);
        }
        
        if (node.getRight() != null) {
            buildGraphHierarchical(node.getRight(), nodeId, x + horizontalSpacing, nextY, nextSpacing);
        }
    }
    
    private double calculateInitialOffset(NodeAVL<E> root) {
        int height = getTreeHeight(root);
        // Calcular el espaciado inicial basado en la altura del árbol
        return Math.max(100, 50 * Math.pow(2, height - 1));
    }
    
    private int getTreeHeight(NodeAVL<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(getTreeHeight(node.getLeft()), getTreeHeight(node.getRight()));
    }
    
    private String getStyleSheet() {
        return """
            graph {
                padding: 50px;
            }
            
            node {
                shape: box;
                size: 60px, 40px;
                fill-color: #87CEEB;
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
                text-size: 10px;
                text-color: #696969;
            }
            
            edge:selected {
                fill-color: #FF6347;
            }
        """;
    }
}