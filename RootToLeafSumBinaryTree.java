import java.util.Stack;

public class RootToLeafSumBinaryTree {
    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(16);
        root.right = new Node(5);
        root.left.right = new Node(-3);
        root.right.left = new Node(6);
        root.right.right = new Node(11);
        int sum = 26;
        Stack<Integer> result = new Stack<Integer>();
        boolean res = getPath(root, sum, result);
        if (res) {
            while (!result.empty())
                System.out.print(result.pop() + " ");
        }
    }

    static boolean getPath(Node root, int sum, Stack<Integer> result) {
        if (root == null) return false;
        if (root.data == sum && root.left == null && root.right == null) {
            result.push(root.data);
            return true;
        }
        if (getPath(root.left, sum - root.data, result) == true) {
            result.push(root.data);
            return true;
        }
        if (getPath(root.right, sum - root.data, result) == true) {
            result.push(root.data);
            return true;
        }
        return false;
    }
}
