import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Generic_DFS {
    static class Node {
        int data;
        List<Node> children = new ArrayList<Node>();

        Node(int data) {
            this.data = data;
            children = null;
        }

        Node(int data, ArrayList<Node> children) {
            this.data = data;
            this.children = children;
        }

        static void printDFS(Node root) {
            System.out.println(root.data);
            if (root.children != null) {
                for (Node child : root.children) {
                    printDFS(child);
                }
            }
        }
    }

    public static void main(String args[]) {
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n2 = new Node(2, new ArrayList<Node>() {{
            add(n5);
            add(n6);
        }});
        Node n3 = new Node(3, new ArrayList<Node>() {{
            add(n7);
        }});
        Node n4 = new Node(4);
        Node n1 = new Node(1, new ArrayList<Node>() {{
            add(n2);
            add(n3);
            add(n4);
        }});
        Node.printDFS(n1);
    }
}
