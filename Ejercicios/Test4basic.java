package Ejercicios;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.Graph;

public class Test4basic {
    public static void main(String[] args) {
        Graph<String, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");

        System.out.println("Grafo: " + graph);

        DijkstraShortestPath<String, DefaultEdge> dijkstra = new DijkstraShortestPath<>(graph);
        System.out.println("Camino más corto de A a D: " + dijkstra.getPath("A", "D"));

        ConnectivityInspector<String, DefaultEdge> inspector = new ConnectivityInspector<>(graph);
        System.out.println("¿Es el grafo conexo? " + inspector.isGraphConnected());
    }
}
