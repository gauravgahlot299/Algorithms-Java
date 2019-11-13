public class MaximumSumNonAdjacentArray {
    public static void main(String args[]) {
        int[] a = {4, 1, 1, 4, 2, 1};
//        int[] a = {2, 5, 3, 1, 7};
        System.out.println(getMaxSum(a, 0));
        System.out.println(getMaxSum(a));
    }

    //    This is a Recursive Solution
    static int getMaxSum(int a[], int i) {
        while (i < a.length) {
            return Math.max(a[i] + getMaxSum(a, i + 2), getMaxSum(a, i + 1));
        }
        return 0;
    }

    //  This is a DP Solution
    static int getMaxSum(int a[]) {
        int incl = a[0];
        int excl = 0;
        for (int i = 1; i < a.length; i++) {
            int temp = incl;
            incl = Math.max(excl + a[i], incl);
            excl = temp;
        }
        return incl;
    }
}
