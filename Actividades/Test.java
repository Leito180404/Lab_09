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
        
        //probando searchvertex
        System.out.println("\nBuscando el vertice 2: " + graph.searchVertex(2));
        System.out.println("Buscando el vertice 5: " + graph.searchVertex(5));

        //probando search edge
        System.out.println("\nBuscando arista entre 2 y 3:");
        System.out.println("Resultado: " + graph.searchEdge(2, 3));

        System.out.println("\nBuscando arista entre 1 y 4:");
        System.out.println("Resultado: " + graph.searchEdge(1, 4)); 

        System.out.println("\nBuscando arista entre 2 y 3:");
        System.out.println("Resultado: " + graph.searchEdge(2, 3));

        System.out.println("\nBuscando arista entre 1 y 4:");
        System.out.println("Resultado: " + graph.searchEdge(1, 4)); 

        //porbando remove edge
        System.out.println("\nEliminando la arista entre 2 y 3...");
        boolean edgeRemoved = graph.removeEdge(2, 3);
        System.out.println("Resultado de eliminar arista entre 2 y 3: " + edgeRemoved);
        System.out.println("grafo despues de eliminar la arista entre 2 y 3:");
        System.out.println(graph);

        System.out.println("\nBuscando la arista entre 2 y 3 despues de eliminarla:");
        System.out.println("Resultado: " + graph.searchEdge(2, 3));


        //probando remove vertex
        System.out.println("\nEliminando el vertice 2...");
        graph.removeVertex(2);
        System.out.println("grafo despues de eliminar el vertice 2:");
        System.out.println(graph);

        System.out.println("\nBuscando el vertice 2 despues de eliminarlo: " + graph.searchVertex(2));
    
        GraphLink<Integer> graph1 = new GraphLink<>();

        System.out.println("Insertando vertices...");
        graph1.insertVertex(1);
        graph1.insertVertex(2);
        graph1.insertVertex(3);
        graph1.insertVertex(4);

        graph1.insertEdge(1, 2);
        graph1.insertEdge(2, 3);
        graph1.insertEdge(3, 4);
        System.out.println("\nRealizando DFS a partir del vertice 1...");
        graph1.dfs(1);

        System.out.println("\nEliminando la arista entre 2 y 3...");
        graph1.removeEdge(2, 3);
        
        // Mostrar el grafo despues de la eliminacin
        System.out.println("grafo despues de eliminar la arista entre 2 y 3:");
        System.out.println(graph1);

        System.out.println("\nRealizando DFS a partir del vertice 1 depues de eliminar una arista");
        graph1.dfs(1);
    }
}

