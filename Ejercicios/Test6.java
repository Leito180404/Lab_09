package Ejercicios;

import Ejercicios.graph.*;

public class Test6 {
    public static void main(String[] args) {
        // Crear un grafo de ejemplo
        GraphListEdge<String, Integer> graph = new GraphListEdge<>();

        // Crear los vertices
        VertexObj<String, Integer> vertexA = new VertexObj<>("A", 1);
        VertexObj<String, Integer> vertexB = new VertexObj<>("B", 2);
        VertexObj<String, Integer> vertexC = new VertexObj<>("C", 3);
        VertexObj<String, Integer> vertexD = new VertexObj<>("D", 4);

        // Insertar vertices en el grafo
        graph.insertVertex(vertexA);
        graph.insertVertex(vertexB);
        graph.insertVertex(vertexC);
        graph.insertVertex(vertexD);

        // Insertar aristas entre los vertices
        graph.insertEdge(vertexA, vertexB);
        graph.insertEdge(vertexA, vertexC);
        graph.insertEdge(vertexB, vertexD);
        graph.insertEdge(vertexC, vertexD);

        // Imprimir las representaciones del grafo
        System.out.println("Probando la Representacion Formal:");
        graph.printFormal();

        System.out.println("\nProbando la Lista de Adyacencia:");
        graph.printAdjacencyList();

        System.out.println("\nProbando la Matriz de Adyacencia:");
        graph.printAdjacencyMatrix();
    }
}

