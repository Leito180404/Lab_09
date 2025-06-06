package Actividades.graph;

import Actividades.ListLinked;

public class Vertex<E> {
    private E data;
    protected ListLinked<Edge<E>> listAdj;
    public boolean visited;
    public Vertex(E data) {
        this.data = data;
        listAdj = new ListLinked<Edge<E>>();
        this.visited = false;
    }

    public E getData() {
        return data;
    }

    public boolean equals(Object o) {
        if (o instanceof Vertex<?>) {
            Vertex<E> v = (Vertex<E>) o;
            return this.data.equals(v.data);
        }
        return false;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.data);
        if (this.listAdj.size() > 0) {
            result.append(" --> ");
            result.append(this.listAdj.toString());
        }
        return result.toString();
    }

}
