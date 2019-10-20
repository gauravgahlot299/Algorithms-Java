public class BSTConstruction {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String args[]) {
        int[] arr = new int[]{4, 14, 51, 36, 7, 2, 3};
        Node root = null;
        for (int a : arr) {
            root = constructBST(a, root);
        }
        System.out.println("DFS:");
        DFS(root);
        System.out.println("minValue:"+minValue(root).data);
    }

    static void DFS(Node root) {
        System.out.println(root.data);
        if (root.left != null) DFS(root.left);
        if (root.right != null) DFS(root.right);
    }

    static Node minValue(Node root) {
        if (root.left != null) {
            return minValue(root.left);
        }
        return root;
    }

    static Node constructBST(int a, Node root) {
        if (root == null) {
            root = new Node(a);
        } else {
            Node copy = root;
            while (copy != null) {
                if (a <= copy.data) {
                    if (copy.left != null)
                        copy = copy.left;
                    else {
                        copy.left = new Node(a);
                        break;
                    }
                } else {
                    if (a > copy.data) {
                        if (copy.right != null)
                            copy = copy.right;
                        else {
                            copy.right = new Node(a);
                            break;
                        }
                    }
                }
            }
        }
        return root;
    }
}
