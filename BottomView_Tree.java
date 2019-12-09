import java.util.ArrayDeque;
import java.util.TreeMap;

public class BottomView_Tree {
    static class Node {
        int data;
        int horizontal_distance;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.horizontal_distance = 0;
            this.left = this.right = null;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    static class Tree {
        Node root;

        public Tree(Node root) {
            this.root = root;
        }

        void bottomView() {
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            ArrayDeque<Node> deque = new ArrayDeque<>();
            root.horizontal_distance = 0;
            deque.add(root);
            while (deque.size() != 0) {
                Node temp = deque.pop();
                map.put(temp.horizontal_distance, temp.data);
                if (temp.left != null) {
                    temp.left.horizontal_distance = temp.horizontal_distance - 1;
                    deque.add(temp.left);
                }
                if (temp.right != null) {
                    temp.right.horizontal_distance = temp.horizontal_distance + 1;
                    deque.add(temp.right);
                }
            }
            for (Integer key:map.keySet()) {
                System.out.print(map.get(key));
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
        tree.bottomView();
    }

}
