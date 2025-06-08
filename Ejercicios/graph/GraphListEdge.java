package Ejercicios.graph;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class GraphListEdge<V, E> {
    ArrayList<VertexObj<V, E>> secVertex;
    ArrayList<EdgeObj<V, E>> secEdge;
    
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

}
