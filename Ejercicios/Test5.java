package Ejercicios;

import Ejercicios.graph.*;

public class Test5 {
    public static void main(String[] args) {
        // Caso 1: Grafo con ciclo
        System.out.println("Caso 1: Grafo con ciclo");
        GraphListEdge<String, Integer> graph1 = new GraphListEdge<>();
        
        VertexObj<String, Integer> vertex1 = new VertexObj<>("A", 1);
        VertexObj<String, Integer> vertex2 = new VertexObj<>("B", 2);
        VertexObj<String, Integer> vertex3 = new VertexObj<>("C", 3);

        graph1.insertVertex(vertex1);
        graph1.insertVertex(vertex2);
        graph1.insertVertex(vertex3);

        graph1.insertEdge(vertex1, vertex2); // A-B
        graph1.insertEdge(vertex2, vertex3); // B-C
        graph1.insertEdge(vertex3, vertex1); // C-A (Ciclo)

        System.out.println("Grado de A: " + graph1.grado(vertex1));
        System.out.println("Grado de B: " + graph1.grado(vertex2));
        System.out.println("Grado de C: " + graph1.grado(vertex3));
        
        System.out.println("Es ciclo entre A y C: " + graph1.esCiclo(vertex1, vertex3)); // Debe ser true
        System.out.println("Es ciclo entre B y C: " + graph1.esCiclo(vertex2, vertex3)); // Debe ser false

        // Caso 2: Grafo que no es una rueda
        System.out.println("\nCaso 2: Grafo que no es una rueda");
        GraphListEdge<String, Integer> graph2 = new GraphListEdge<>();
        
        VertexObj<String, Integer> vertex4 = new VertexObj<>("D", 4);
        VertexObj<String, Integer> vertex5 = new VertexObj<>("E", 5);

        graph2.insertVertex(vertex1);
        graph2.insertVertex(vertex2);
        graph2.insertVertex(vertex4);
        graph2.insertVertex(vertex5);

        graph2.insertEdge(vertex1, vertex2); // A-B
        graph2.insertEdge(vertex2, vertex4); // B-D
        graph2.insertEdge(vertex4, vertex5); // D-E
        
        System.out.println("Es rueda: " + graph2.esRueda()); // No debe ser rueda, ya que tiene más de un nodo suelto

        // Caso 3: Grafo completo
        System.out.println("\nCaso 3: Grafo completo");
        GraphListEdge<String, Integer> graph3 = new GraphListEdge<>();
        
        VertexObj<String, Integer> vertex6 = new VertexObj<>("F", 6);
        VertexObj<String, Integer> vertex7 = new VertexObj<>("G", 7);

        graph3.insertVertex(vertex1);
        graph3.insertVertex(vertex2);
        graph3.insertVertex(vertex6);
        graph3.insertVertex(vertex7);

        graph3.insertEdge(vertex1, vertex2); // A-B
        graph3.insertEdge(vertex1, vertex6); // A-F
        graph3.insertEdge(vertex1, vertex7); // A-G
        graph3.insertEdge(vertex2, vertex6); // B-F
        graph3.insertEdge(vertex2, vertex7); // B-G
        graph3.insertEdge(vertex6, vertex7); // F-G

        System.out.println("Es completo: " + graph3.esCompleto()); // Debe ser verdadero, ya que todos los vértices están conectados entre sí

        // Caso 4: Grafo no es ciclo
        System.out.println("\nCaso 4: Grafo no es ciclo");
        GraphListEdge<String, Integer> graph4 = new GraphListEdge<>();
        
        VertexObj<String, Integer> vertex8 = new VertexObj<>("H", 8);
        VertexObj<String, Integer> vertex9 = new VertexObj<>("I", 9);

        graph4.insertVertex(vertex8);
        graph4.insertVertex(vertex9);

        graph4.insertEdge(vertex8, vertex9); // H-I
        
        System.out.println("Es ciclo entre H e I: " + graph4.esCiclo(vertex8, vertex9)); // Debe ser false

        // Caso 5: Grafo con nodo suelto, pero no es rueda
        System.out.println("\nCaso 5: Grafo con nodo suelto, pero no es rueda");
        GraphListEdge<String, Integer> graph5 = new GraphListEdge<>();
        
        VertexObj<String, Integer> vertex10 = new VertexObj<>("J", 10);
        VertexObj<String, Integer> vertex11 = new VertexObj<>("K", 11);
        VertexObj<String, Integer> vertex12 = new VertexObj<>("L", 12);

        graph5.insertVertex(vertex10);
        graph5.insertVertex(vertex11);
        graph5.insertVertex(vertex12);

        graph5.insertEdge(vertex10, vertex11); // J-K
        
        System.out.println("Es rueda: " + graph5.esRueda()); // Debe ser false

        // Caso 6: Grafo con más de un nodo conectado entre sí
        System.out.println("\nCaso 6: Grafo con múltiples vértices");
        GraphListEdge<String, Integer> graph6 = new GraphListEdge<>();
        
        VertexObj<String, Integer> vertex13 = new VertexObj<>("M", 13);
        VertexObj<String, Integer> vertex14 = new VertexObj<>("N", 14);
        VertexObj<String, Integer> vertex15 = new VertexObj<>("O", 15);

        graph6.insertVertex(vertex13);
        graph6.insertVertex(vertex14);
        graph6.insertVertex(vertex15);

        graph6.insertEdge(vertex13, vertex14); // M-N
        graph6.insertEdge(vertex14, vertex15); // N-O
        graph6.insertEdge(vertex15, vertex13); // O-M
        
        System.out.println("Es ciclo entre M y N: " + graph6.esCiclo(vertex13, vertex14)); // Debe ser true
    }
}

