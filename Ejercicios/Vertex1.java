package Ejercicios;

import Actividades.graph.Edge;

public class Vertex1<E> {
    private E data;
    public ListLinked1<Edge<E>> listAdj;
    public boolean visited;

    public Vertex1(E data) {
        this.data = data;
        this.listAdj = new ListLinked1<Edge<E>>();
        this.visited = false;
    }

    public E getData() {
        return data;
    }

    public boolean equals(Object o) {
        if (o instanceof Vertex1<?>) {
            Vertex1<E> v = (Vertex1<E>) o;
            return this.data.equals(v.data);
        }
        return false;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.data);
        if (this.listAdj.size() > 0) {
            result.append(" --> ");
            for (Edge<E> edge : this.listAdj) {
                result.append(edge.refDest.getData())
                      .append("[").append(edge.weight).append("], ");
            }
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }
}


