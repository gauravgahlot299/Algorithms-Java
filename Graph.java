import java.util.*;

class Vertex {
    String id;
    ArrayList<Vertex> descendants;

    Vertex(String id) {
        this.id = id;
        this.descendants = new ArrayList<Vertex>();
    }

    void addDescendant(Vertex vertex) {
        this.descendants.add(vertex);
    }
}

public class Graph {
    HashMap<String, Vertex> getGraph() {
        HashMap<String, Vertex> graph = new HashMap<String, Vertex>();
        Vertex v1 = new Vertex("A");
        graph.put(v1.id, v1);
        Vertex v2 = new Vertex("B");
        graph.put(v2.id, v2);
        Vertex v3 = new Vertex("C");
        graph.put(v3.id, v3);
        Vertex v4 = new Vertex("D");
        graph.put(v4.id, v4);
        Vertex v5 = new Vertex("E");
        graph.put(v5.id, v5);
        Vertex v6 = new Vertex("F");
        graph.put(v6.id, v6);
        Vertex v7 = new Vertex("G");
        graph.put(v7.id, v7);
        v1.addDescendant(v3);
        v2.addDescendant(v3);
        v3.addDescendant(v4);
        v2.addDescendant(v5);
        v4.addDescendant(v6);
        v5.addDescendant(v6);
        v6.addDescendant(v7);
        return graph;
    }

    public static void main(String args[]) {
        HashMap<String, Vertex> graph = new HashMap<String, Vertex>();
        Vertex v1 = new Vertex("A");
        graph.put(v1.id, v1);
        Vertex v2 = new Vertex("B");
        graph.put(v2.id, v2);
        Vertex v3 = new Vertex("C");
        graph.put(v3.id, v3);
        Vertex v4 = new Vertex("D");
        graph.put(v4.id, v4);
        Vertex v5 = new Vertex("E");
        graph.put(v5.id, v5);
        Vertex v6 = new Vertex("F");
        graph.put(v6.id, v6);
        Vertex v7 = new Vertex("G");
        graph.put(v7.id, v7);
        v1.addDescendant(v3);
        v2.addDescendant(v3);
        v3.addDescendant(v4);
        v2.addDescendant(v5);
        v4.addDescendant(v6);
        v5.addDescendant(v6);
        v6.addDescendant(v7);
        for (String key : graph.keySet()) {
            System.out.print(key + " : ");
            for (Vertex descendant : graph.get(key).descendants) {
                System.out.print(descendant.id + " ");
            }
            System.out.println();
        }
    }
}
