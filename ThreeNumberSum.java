import java.util.ArrayList;
import java.util.Arrays;

public class ThreeNumberSum {
    public static void main(String args[]) {
        int a[] = {12, 3, 1, 2, -6, 5, -8, 6, -2, -1};
        int b = 3;
        Arrays.sort(a);
        ArrayList<int[]> result = new ArrayList<int[]>();
        for (int i = 0; i < a.length - 2; i++) {
            int left = i + 1;
            int right = a.length - 1;
            int sumToFind = b - a[i];
            while (left < right) {
                if (a[left] + a[right] == sumToFind) {
                    int[] pair = {a[i], a[left], a[right]};
                    result.add(pair);
                    left++;
                    right--;
                } else {
                    if (a[left] + a[right] > sumToFind) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        if (result.size() == 0) System.out.println(-1);
        else {
            int[][] resultArray = result.toArray(new int[result.size()][3]);
            for (int i = 0; i < resultArray.length; i++) {
                System.out.print("[");
                for (int j = 0; j < resultArray[i].length; j++) {
                    if (j == 2) System.out.print(resultArray[i][j] + "]");
                    else System.out.print(resultArray[i][j] + ",");
                }
            }
        }
    }
}
