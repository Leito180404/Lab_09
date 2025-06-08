package Ejercicios;

import Ejercicios.graph.*;

public class Test7 {
    public static void main(String[] args) {
        // Creando el grafo dirigido
        GraphListEdge<String, Integer> graph = new GraphListEdge<>();
        
        // Creando vertices
        VertexObj<String, Integer> A = new VertexObj<>("A", 1);
        VertexObj<String, Integer> B = new VertexObj<>("B", 2);
        VertexObj<String, Integer> C = new VertexObj<>("C", 3);
        VertexObj<String, Integer> D = new VertexObj<>("D", 4);
        
        // Insertar vertices al grafo
        graph.insertVertex(A);
        graph.insertVertex(B);
        graph.insertVertex(C);
        graph.insertVertex(D);
        
        // Insertar aristas
        graph.insertEdge(A, B);
        graph.insertEdge(B, C);
        graph.insertEdge(C, D);
        graph.insertEdge(D, A);  // Ciclo para probar
        graph.insertEdge(A, C);  // Camino A->C
        
        // Imprimir grado de cada vértice
        System.out.println("Grado de los vértices:");
        System.out.println("Grado de A: " + graph.grado(A));
        System.out.println("Grado de B: " + graph.grado(B));
        System.out.println("Grado de C: " + graph.grado(C));
        System.out.println("Grado de D: " + graph.grado(D));
        
        // Verificar si existe camino entre A y C
        System.out.println("\nProbando si existe camino entre los vértices:");
        System.out.println("Camino entre A y C: " + graph.esCamino(A, C));
        
        // Verificar si es ciclo entre A y C
        System.out.println("\nProbando si es ciclo:");
        System.out.println("Es ciclo entre A y C: " + graph.esCiclo(A, C));
        
        // Verificar si el grafo es una rueda
        System.out.println("\nProbando si el grafo es una rueda:");
        System.out.println("El grafo es rueda: " + graph.esRueda());
        
        // Verificar si el grafo es completo
        System.out.println("\nProbando si el grafo es completo:");
        System.out.println("El grafo es completo: " + graph.esCompleto());
    }
}

