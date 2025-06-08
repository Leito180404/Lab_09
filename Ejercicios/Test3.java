package Ejercicios;

import Ejercicios.graph.*;

public class Test3 {
    public static void main(String[] args) {
        GraphListEdge<String, Integer> graph = new GraphListEdge<>();

        VertexObj<String, Integer> vertex1 = new VertexObj<>("A", 1);
        VertexObj<String, Integer> vertex2 = new VertexObj<>("B", 2);
        VertexObj<String, Integer> vertex3 = new VertexObj<>("C", 3);
        VertexObj<String, Integer> vertex4 = new VertexObj<>("D", 4);

        graph.insertVertex(vertex1);
        graph.insertVertex(vertex2);
        graph.insertVertex(vertex3);
        graph.insertVertex(vertex4);

        graph.insertVertex(vertex1);  // Este deberia ignorarse

        System.out.println("Vértices en el grafo:");
        for (VertexObj<String, Integer> v : graph.secVertex) {
            System.out.println(v.info);
        }
    }
}

