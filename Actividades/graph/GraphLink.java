package Actividades.graph;
import Actividades.ListLinked;
public class GraphLink<E> {

    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<Vertex<E>>();
    }

    public void insertVertex(E data) {
        Vertex<E> v = new Vertex<E>(data);
        if (listVertex.indexOf(v) < 0) {
            listVertex.addLast(v);
        }
    }

    public void insertEdge(E verOri, E verDes) {
        // implementar este método
    }

    public String toString() {
        return this.listVertex.toString();
    }
}
