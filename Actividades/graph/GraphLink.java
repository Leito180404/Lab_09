package Actividades.graph;
import Actividades.ListLinked;
public class GraphLink<E> {

    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<Vertex<E>>();
    }

    public void insertVertex(E data) {
        // implementar este método
    }

    public void insertEdge(E verOri, E verDes) {
        // implementar este método
    }

    public String toString() {
        return this.listVertex.toString();
    }
}
