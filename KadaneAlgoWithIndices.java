public class KadaneAlgoWithIndices {
    public static void main(String args[]) {
//        int[] a = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        int[] a = {3, 5, -9, 1, 3, -2, 3, 4};
        int start = 0;
        int end = 0;
        int output[] = getMaxContinuousSum(a, start, end);
        start = output[1];
        end = output[2];
        System.out.println(output[0]);
        for (int i = start; i <= end; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static int[] getMaxContinuousSum(int a[], int start, int end) {
        int maxEndingHere = 0;
        int maxSoFar = a[0];
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            maxEndingHere = maxEndingHere + a[i];
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            } else {
                if (maxEndingHere < 0) {
                    maxEndingHere = 0;
                    s = i + 1;
                }
            }
        }
        return new int[]{maxSoFar, start, end};
    }
}
