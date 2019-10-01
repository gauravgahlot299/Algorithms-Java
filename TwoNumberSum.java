import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoNumberSum {
    public static void main(String args[]) {
        int a[] = {12, 3, 1, 2, -6, 5, -8, 6, -2, -1};
        int b = 3;
        Arrays.sort(a);
        List<int[]> result = new ArrayList<int[]>();
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            if (a[left] + a[right] == b) {
                int temp[] = {a[left], a[right]};
                result.add(temp);
                left++;
                right--;
            } else {
                if (a[left] + a[right] < b) {
                    left++;
                } else right--;
            }
        }
        if (result.size() == 0) System.out.println(-1);
        else {
            int[][] result1 = result.toArray(new int[result.size()][2]);
            for (int i = 0; i < result1.length; i++) {
                System.out.print("[");
                for (int j = 0; j < result1[i].length; j++) {
                    if (j == 1) System.out.print(result1[i][j] + "]");
                    else System.out.print(result1[i][j] + ",");
                }
            }
        }
    }
}
