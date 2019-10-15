import java.util.*;

public class BreadthFirstSearch {
    public static void main(String args[]) {
        Node root = new Tree().getTree();
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        queue.add(root);
        printBFS(queue);
    }

    static void printBFS(ArrayDeque<Node> queue) {
        Node curr = queue.peek();
        if (curr != null) {
            curr = queue.pop();
            System.out.println(curr.data);
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
            printBFS(queue);
        }
    }
}
