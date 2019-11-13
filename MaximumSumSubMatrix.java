public class MaximumSumSubMatrix {
    public static void main(String args[]) {
        int[][] matrix = {
                {2, 1, -3, -4, 5},
                {0, 6, 3, 4, 1},
                {2, -2, -1, 4, -5},
                {-3, 3, 1, 0, 3}
        };
        int[] output = getMaxSum(matrix);
        System.out.println(output[0]);
        for (int i = output[3]; i <= output[4]; i++) {
            System.out.println();
            for (int j = output[1]; j <= output[2]; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

    static int[] getKadaneResult(int[] temp) {
        int maxEndingHere = 0;
        int maxSoFar = temp[0];
        int start = 0;
        int end = 0;
        int s = 0;
        for (int i = 0; i < temp.length; i++) {
            maxEndingHere += temp[i];
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

    static int[] getMaxSum(int a[][]) {
        int currSum = 0;
        int maxSum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int maxUp = 0;
        int maxDown = 0;
        int cols = a[0].length;
        int rows = a.length;
        int[] temp = new int[rows];
        for (int i = 0; i < cols; i++) {
            int left = i;
            int right = i;
            for (int j = 0; j < rows; j++) {
                temp[j] = 0;
            }
            while (right < cols) {
                for (int j = 0; j < rows; j++) {
                    temp[j] += a[j][right];
                }
                int[] kadane = getKadaneResult(temp);
                currSum = kadane[0];
                if (maxSum < currSum) {
                    maxSum = currSum;
                    maxLeft = left;
                    maxRight = right;
                    maxUp = kadane[1];
                    maxDown = kadane[2];
                }
                right++;
            }
        }
        return new int[]{maxSum, maxLeft, maxRight, maxUp, maxDown};
    }
}
