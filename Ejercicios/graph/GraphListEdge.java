package Ejercicios.graph;

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

}
