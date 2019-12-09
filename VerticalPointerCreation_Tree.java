import java.util.ArrayDeque;
import java.util.TreeMap;

public class VerticalPointerCreation_Tree {
    static class Node {
        int data;
        int horizontal_distance;
        int level;
        Node left;
        Node right;
        Node vertical;

        public Node(int data) {
            this.data = data;
            this.horizontal_distance = 0;
            this.left = this.right = this.vertical = null;
            this.level = 0;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setVertical(Node vertical) {
            this.vertical = vertical;
        }
    }

    static class Tree {
        Node root;

        public Tree(Node root) {
            this.root = root;
        }

        void verticalPointerCreation() {
            TreeMap<Integer, Node> map = new TreeMap<>();
            ArrayDeque<Node> deque = new ArrayDeque<>();
            root.horizontal_distance = 0;
            root.level = 1;
            deque.add(root);
            while (deque.size() != 0) {
                Node temp = deque.pop();
                if (map.containsKey(temp.horizontal_distance)) {
                    if (map.get(temp.horizontal_distance).level != temp.level)
                        map.get(temp.horizontal_distance).setVertical(temp);
                }
                map.put(temp.horizontal_distance, temp);
                if (temp.left != null) {
                    temp.left.horizontal_distance = temp.horizontal_distance - 1;
                    temp.left.level = temp.level + 1;
                    deque.add(temp.left);
                }
                if (temp.right != null) {
                    temp.right.horizontal_distance = temp.horizontal_distance + 1;
                    temp.right.level = temp.level + 1;
                    deque.add(temp.right);
                }
            }
        }

        void BFS() {
            ArrayDeque<Node> deque = new ArrayDeque<>();
            deque.add(root);
            while (deque.size() != 0) {
                Node temp = deque.pop();
                System.out.print(temp.data + "->");
                if (temp.vertical == null) System.out.println("null");
                else {
                    System.out.println(temp.vertical.data);
                }
                if (temp.left != null) deque.add(temp.left);
                if (temp.right != null) deque.add(temp.right);
            }
        }
    }

    public static void main(String args[]) {
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        n2.setLeft(n4);
        n2.setRight(n5);
        Node n3 = new Node(3);
        n3.setLeft(n6);
        n3.setRight(n7);
        Node n1 = new Node(1);
        n1.setLeft(n2);
        n1.setRight(n3);
        Node n8 = new Node(8);
        n5.setLeft(n8);

        Tree tree = new Tree(n1);
        tree.verticalPointerCreation();

        tree.BFS();
    }

}
