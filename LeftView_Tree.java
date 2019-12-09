import java.util.ArrayDeque;

public class LeftView_Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
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

        void leftView() {
            ArrayDeque<Node> deque = new ArrayDeque<>();
            deque.add(root);
            deque.add(new Node(-1));
            System.out.print(root.data);
            while (deque.size() != 0) {
                Node temp = deque.pop();
                if (temp.data != -1) {
                    if (temp.left != null) {
                        deque.add(temp.left);
                    }
                    if (temp.right != null) {
                        deque.add(temp.right);
                    }
                    if (deque.peek().data == -1) {
                        deque.add(new Node(-1));
                    }
                } else {
                    if (deque.peek() != null && deque.peek().data != -1)
                        System.out.print(deque.peek().data);
                }
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
        tree.leftView();
    }

}
