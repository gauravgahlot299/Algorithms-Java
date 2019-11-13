public class MaxContiguousSumArray {
    public static void main(String args[]) {
//        int[] a = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        int[] a = {3, 5, -9, 1, 3, -2, 3, 4};
        int output = getMaxContinuousSum(a);
        System.out.println(output);
    }

    static int getMaxContinuousSum(int a[]) {
        int maxEndingHere = a[0];
        int maxSoFar = a[0];
        for (int i = 1; i < a.length; i++) {
            int sum = a[i] + maxEndingHere;
            maxEndingHere = Math.max(a[i], sum);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
