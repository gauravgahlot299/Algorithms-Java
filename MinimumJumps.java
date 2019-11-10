import java.util.Stack;

public class MinimumJumps {
    public static void main(String args[]) {
        int a[] = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        Stack<Integer> stack = new java.util.Stack<Integer>();
        int minJumps = Integer.MAX_VALUE;
        minJumps = getMinJumps(a, stack, minJumps);
        System.out.println("Min jumps required to go from 1st element to last are: " + minJumps);
        System.out.println("Indices to traverse are: ");
        while (!stack.empty())
            System.out.println(stack.pop());
    }

    static int getMinJumps(int a[], Stack<Integer> stack, int minJumps) {
        int numOfJumps[] = new int[a.length];
        int parentIndex[] = new int[a.length];
        numOfJumps[0] = 0;
        for (int i = 1; i < a.length; i++) {
            numOfJumps[i] = Integer.MAX_VALUE;
        }
        parentIndex[0] = -1;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + a[j] >= i) {
                    if (1 + numOfJumps[j] < numOfJumps[i]) {
                        numOfJumps[i] = 1 + numOfJumps[j];
                        parentIndex[i] = j;
                    }
                }
            }
        }
        int i = a.length - 1;
        stack.push(i);
        while (i > 0) {
            stack.push(parentIndex[i]);
            i = parentIndex[i];
        }
        return numOfJumps[a.length - 1];
    }
}
