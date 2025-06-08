package Ejercicios;

public class Edge1<E> {
    public Vertex1<E> refDest;
    public int weight;

    public Edge1(Vertex1<E> refDest) {
        this.refDest = refDest;
        this.weight = -1;
    }

    public Edge1(Vertex1<E> refDest, int weight) {
        this.refDest = refDest;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge1<?>) {
            Edge1<E> edge = (Edge1<E>) obj;
            return this.refDest.equals(edge.refDest);
        }
        return false;
    }

    @Override
    public String toString() {
        return refDest.getData() + " [" + weight + "]";
    }
}