import java.util.ArrayList;

public class LongestDecreasingSubsequence {
    static class Result {
        int[] dummy;
        int maxSoFar;

        public Result(int[] dummy, int maxSoFar) {
            this.dummy = dummy;
            this.maxSoFar = maxSoFar;
        }
    }

    public static void main(String args[]) {
//        int a[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int a[] = {1, 11, 2, 10, 4, 5, 2, 1};
        int b[] = printLDS(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

    static int[] printLDS(int a[]) {
        Result res = getLDS(a);
        int dummy[] = res.dummy;
        int maxSoFar = res.maxSoFar;
        return getLDSHelper(a, dummy, maxSoFar);
    }

    static Result getLDS(int a[]) {
        int dummy[] = new int[a.length];
        int maxSoFar = 1;
        for (int i = 0; i < dummy.length; i++) {
            dummy[i] = 1;
        }
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[i]) {
                    if (dummy[j] < dummy[i] + 1) {
                        dummy[j] = dummy[j] + 1;
                        maxSoFar = dummy[j] > maxSoFar ? dummy[j] : maxSoFar;
                    }
                }
            }
        }
        return new Result(dummy, maxSoFar);
    }

    static int[] getLDSHelper(int a[], int dummy[], int maxSoFar) {
        ArrayList<Integer> queue = new ArrayList<Integer>();
        int i = 0;
        int toPush = maxSoFar;
        while (i < dummy.length - 1) {
            while (i < dummy.length - 1 && (dummy[i] != toPush || dummy[i] == dummy[i + 1])) {
                i++;
            }
            if (i < dummy.length - 1) {
                queue.add(a[i]);
                toPush = toPush - 1;
                i++;
            } else break;
        }
        if (dummy[dummy.length - 1] == toPush) queue.add(a[dummy.length - 1]);
        int toReturn[] = new int[queue.size()];
        i = 0;
        for (int ele : queue) {
            toReturn[i++] = ele;
        }
        return toReturn;
    }
}
