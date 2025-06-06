package Actividades;

import Actividades.graph.GraphLink;

public class Test {
    public static void main(String[] args) {
        GraphLink<Integer> graph = new GraphLink<>();

        System.out.println("Insertando vertices...");
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);

        graph.insertEdge(1, 2); // Arista entre 1 y 2
        graph.insertEdge(2, 3); // Arista entre 2 y 3
        graph.insertEdge(3, 4); // Arista entre 3 y 4

        System.out.println("\ngrafo despues de insertar vertices y aristas:");
        System.out.println(graph);

        System.out.println("\nBuscando el vertice 2: " + graph.searchVertex(2));
        System.out.println("Buscando el vertice 5: " + graph.searchVertex(5));

        System.out.println("\nBuscando arista entre 2 y 3:");
        System.out.println("Resultado: " + graph.searchEdge(2, 3));

        System.out.println("\nBuscando arista entre 1 y 4:");
        System.out.println("Resultado: " + graph.searchEdge(1, 4)); 
    }
}

