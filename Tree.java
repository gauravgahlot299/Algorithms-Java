class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class Tree {
    public static void main(String args[]) {
    }

    Node getTree(){
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }
}


