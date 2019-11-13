public class MaxSumCircularArrayNonAdjacent {
    public static void main(String args[]) {
        int[] a = {4, 1, 1, 4, 2, 1};
//        int[] a = {2, 5, 3, 1, 7};
        System.out.println(getMaxSum(a));
    }

    static int getMaxSum(int a[]) {
        int incl = a[0];
        int excl = 0;
        for (int i = 1; i < a.length - 1; i++) {
            int temp = incl;
            incl = Math.max(incl, a[i] + excl);
            excl = temp;
        }
        int consideringFirstElement = incl;

        incl = a[a.length - 1];
        excl = 0;
        for (int i = a.length - 2; i >= 1; i--) {
            int temp = incl;
            incl = Math.max(incl, a[i] + excl);
            excl = temp;
        }
        int consideringLastElement = incl;
        return Math.max(consideringFirstElement, consideringLastElement);
    }
}
