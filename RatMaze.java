import java.util.ArrayList;

public class RatMaze {
    static class Node {
        boolean result;
        String direction;

        public Node(boolean result, String direction) {
            this.result = result;
            this.direction = direction;
        }
    }

    public static void main(String args[]) {
        int mat[][] = new int[][]{{1, 1, 0, 0},
                {0, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        String path = "";
        String direction = "";
        Node n = getPath(mat, 0, 0, direction);
        System.out.println(n.result);
        System.out.println(n.direction);
    }

    static Node getPath(int[][] mat, int i, int j, String direction) {
        if (i < mat.length && j < mat[0].length) {
            if (mat[i][j] == 1) {
                if (i == mat.length - 1 && j == mat[0].length - 1) {
                    return new Node(true, direction);
                }
                Node down = getPath(mat, i + 1, j, direction + "Down");
                if (down.result == true) {
                    return down;
                }
                Node right = getPath(mat, i, j + 1, direction + "Right");
                if (right.result == true) {
                    return right;
                }
            }
            return new Node(false, null);
        }
        return new Node(false, null);
    }
}
