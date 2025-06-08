package Ejercicios.graph;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class GraphListEdge<V, E> {
    public ArrayList<VertexObj<V, E>> secVertex;
    public ArrayList<EdgeObj<V, E>> secEdge;
    
    public GraphListEdge() {
        this.secVertex = new ArrayList<VertexObj<V, E>>();
        this.secEdge = new ArrayList<EdgeObj<V, E>>(); 
    }

    public void insertVertex(VertexObj<V, E> v) {
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.info.equals(v.info)) {
                return;
            }
        }
        secVertex.add(v);
    }

    public void insertEdge(VertexObj<V, E> v, VertexObj<V, E> z) {
        for (EdgeObj<V, E> edge : secEdge) {
            if (edge.endVertex1.equals(v) && edge.endVertex2.equals(z) || edge.endVertex1.equals(z) && edge.endVertex2.equals(v)) {
                return;
            }
        }
        EdgeObj<V, E> newEdge = new EdgeObj<>(v, z, null, 0);
        secEdge.add(newEdge);
        ((ArrayList<EdgeObj<V, E>>) v.secEdge).add(newEdge);
        ((ArrayList<EdgeObj<V, E>>) z.secEdge).add(newEdge);
    }

    public boolean searchVertex(VertexObj<V, E> v) {
    for (VertexObj<V, E> vertex : secVertex) {
        if (vertex.equals(v)) {
            return true;
        }
    }
    return false;
    }

    public boolean searchEdge(VertexObj<V, E> v, VertexObj<V, E> z) {
        for (EdgeObj<V, E> edge : v.secEdge) {
            if (edge.endVertex1.equals(z) || edge.endVertex2.equals(z)) {
                return true;
            }
        }
        return false;
    }

    public void bfs(VertexObj<V, E> v) {
        for (VertexObj<V, E> vertex : secVertex) {
            vertex.visited = false;
        }

        Queue<VertexObj<V, E>> queue = new LinkedList<>();
        queue.add(v);
        v.visited = true;
        
        System.out.println("Recorrido BFS a partir del vértice: " + v.info);

        while (!queue.isEmpty()) {
            VertexObj<V, E> currentVertex = queue.poll();
            System.out.println("Visitando vértice: " + currentVertex.info);

            for (EdgeObj<V, E> edge : currentVertex.secEdge) {
                VertexObj<V, E> adjacentVertex = (edge.endVertex1.equals(currentVertex)) ? edge.endVertex2 : edge.endVertex1;
                if (!adjacentVertex.visited) {
                    adjacentVertex.visited = true;
                    queue.add(adjacentVertex);
                }
            }
        }
    }

    //ejercicio 5.a
    public int grado(VertexObj<V, E> v) {
        return v.secEdge.size();
    }
    //ejercicio5.b
    public boolean esCamino(VertexObj<V, E> inicio, VertexObj<V, E> fin) {
        for (EdgeObj<V, E> edge : inicio.secEdge) {
            if (edge.endVertex1.equals(fin) || edge.endVertex2.equals(fin)) {
                return false; // Estan directamente conectados, no es un camino
            }
        }
        return true;
    }
    //ejercicio 5.c
    public boolean esCiclo(VertexObj<V, E> inicio, VertexObj<V, E> fin) {
        for (EdgeObj<V, E> edge : inicio.secEdge) {
            if (edge.endVertex1.equals(fin) || edge.endVertex2.equals(fin)) {
                return true; // Existe una arista entre el inicio y el fin, es un ciclo
            }
        }
        return false;
    }

    //ejercicio 5.d
    public boolean esRueda() {
        int nodoSueltoCount = 0;
        for (VertexObj<V, E> vertex : secVertex) {
            if (grado(vertex) == 1) {
                nodoSueltoCount++;
            }
        }
        return nodoSueltoCount == 1; // Solo un nodo debe estar desconectado
    }
    //ejercicio 5.e
    public boolean esCompleto() {
        for (VertexObj<V, E> v1 : secVertex) {
            for (VertexObj<V, E> v2 : secVertex) {
                if (!v1.equals(v2) && !searchEdge(v1, v2)) {
                    return false; // Si algan par de vertices no esta conectado, no es completo
                }
            }
        }
        return true;
    }

    //ejercicio 6.a
    public void printFormal() {
        System.out.println("Representacion Formal:");
        for (VertexObj<V, E> vertex : secVertex) {
            System.out.print(vertex.info + ": ");
            for (EdgeObj<V, E> edge : vertex.secEdge) {
                if (edge.endVertex1.equals(vertex)) {
                    System.out.print(edge.endVertex2.info + " ");
                } else {
                    System.out.print(edge.endVertex1.info + " ");
                }
            }
            System.out.println();
        }
    }

    //ejercicio 6.b
    public void printAdjacencyList() {
        System.out.println("\nLista de Adyacencia:");
        for (VertexObj<V, E> vertex : secVertex) {
            System.out.print(vertex.info + " --> ");
            for (EdgeObj<V, E> edge : vertex.secEdge) {
                if (edge.endVertex1.equals(vertex)) {
                    System.out.print(edge.endVertex2.info + " ");
                } else {
                    System.out.print(edge.endVertex1.info + " ");
                }
            }
            System.out.println();
        }
    }

    //ejercicio 6.c
    public void printAdjacencyMatrix() {
        System.out.println("\nMatriz de Adyacencia:");
        int size = secVertex.size();
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (EdgeObj<V, E> edge : secVertex.get(i).secEdge) {
                int startIdx = secVertex.indexOf(edge.endVertex1);
                int endIdx = secVertex.indexOf(edge.endVertex2);
                matrix[startIdx][endIdx] = 1;
                matrix[endIdx][startIdx] = 1; // Para un grafo no dirigido
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //ejercicio 9.a
    public boolean isIsomorphic(GraphListEdge<V, E> otherGraph) {
        if (this.secVertex.size() != otherGraph.secVertex.size()) {
            return false;
        }

        for (VertexObj<V, E> vertex : this.secVertex) {
            boolean matchFound = false;
            for (VertexObj<V, E> otherVertex : otherGraph.secVertex) {
                if (compareEdges(vertex, otherVertex)) {
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                return false;
            }
        }
        return true;
    }

    private boolean compareEdges(VertexObj<V, E> vertex1, VertexObj<V, E> vertex2) {
        if (vertex1.secEdge.size() != vertex2.secEdge.size()) {
            return false;
        }
        for (EdgeObj<V, E> edge1 : vertex1.secEdge) {
            boolean edgeMatch = false;
            for (EdgeObj<V, E> edge2 : vertex2.secEdge) {
                if (edge1.equals(edge2)) {
                    edgeMatch = true;
                    break;
                }
            }
            if (!edgeMatch) {
                return false;
            }
        }
        return true;
    }

    //ejercicio 9.b
    public boolean isPlanar() {
        for (EdgeObj<V, E> edge : secEdge) {
            if (hasCrossingEdge(edge)) {
                return false;
            }
        }
        return true;
    }
        private boolean hasCrossingEdge(EdgeObj<V, E> edge) {
            return false;
    }

    //ejercicio 9.c
    public boolean isConnected() {
        VertexObj<V, E> startVertex = secVertex.get(0);
        dfs(startVertex);

        for (VertexObj<V, E> vertex : secVertex) {
            if (!vertex.visited) {
                return false;
            }
        }
        return true;
    }

    private void dfs(VertexObj<V, E> vertex) {
        vertex.visited = true;
        for (EdgeObj<V, E> edge : vertex.secEdge) {
            VertexObj<V, E> adjacent = (edge.endVertex1.equals(vertex)) ? edge.endVertex2 : edge.endVertex1;
            if (!adjacent.visited) {
                dfs(adjacent);
            }
        }
    }

    //ejercicio 9.d
    public boolean isAutocomplementary() {
        GraphListEdge<V, E> complementGraph = generateComplementGraph();

        return this.isIsomorphic(complementGraph);
    }

    private GraphListEdge<V, E> generateComplementGraph() {
        GraphListEdge<V, E> complementGraph = new GraphListEdge<>();

        for (VertexObj<V, E> vertex : secVertex) {
            complementGraph.insertVertex(new VertexObj<>(vertex.info, vertex.position));
        }

        for (VertexObj<V, E> vertex : secVertex) {
            for (VertexObj<V, E> adj : secVertex) {
                if (!vertex.equals(adj) && !searchEdge(vertex, adj)) {
                    complementGraph.insertEdge(vertex, adj);
                }
            }
        }
        return complementGraph;
    }
}
