import java.util.Stack;

public class LongestIncreasingSubsequence {
    public static void main(String args[]) {
        int a[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int b[] = getLIS(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

    static int[] getLIS(int a[]) {
        int dummy[] = new int[a.length];
        int maxSoFar = -1;
        for (int i = 0; i < dummy.length; i++) {
            dummy[i] = -1;
        }
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[i]) {
                    if (dummy[j] < dummy[i] + 1) {
                        dummy[j] = dummy[j] + 1;
                        maxSoFar = dummy[j] > maxSoFar ? dummy[j] : maxSoFar;
                    }
                }
            }
        }
        Stack<Integer> stack = new Stack<Integer>();
        int i = dummy.length - 1;
        int toPush = maxSoFar;
        while (i > 0) {
            while (dummy[i] != toPush || dummy[i] == dummy[i - 1]) {
                i--;
            }
            stack.push(a[i]);
            toPush = toPush - 1;
            i--;
        }
        if (dummy[0] == toPush) stack.push(a[0]);
        int toReturn[] = new int[stack.size()];
        i = 0;
        while (!stack.empty()) {
            toReturn[i++] = stack.pop();
        }
        return toReturn;
    }
}
