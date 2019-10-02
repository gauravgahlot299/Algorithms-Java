import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Finding all the pairs of the numbers from the given array named 'a' which sum up to a given number named 'b'.
//The 2 numbers in a pair should be sorted and also that the pairs need to be sorted.
public class TwoNumberSum {
    static int[][] findPairs(int[] a, int b) {
        Arrays.sort(a);
        List<int[]> resultList = new ArrayList<int[]>();
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            if (a[left] + a[right] == b) {
                int temp[] = {a[left], a[right]};
                resultList.add(temp);
                left++;
                right--;
            } else {
                if (a[left] + a[right] < b) {
                    left++;
                } else right--;
            }
        }
        int[][] resultArray = resultList.toArray(new int[resultList.size()][2]);
        return resultArray;
    }

    public static void main(String args[]) {
        int a[] = {12, 3, 1, 2, -6, 5, -8, 6, -2, -1};
        int b = 3;
        int[][] resultArray = findPairs(a, b);
        if (resultArray.length == 0) System.out.println(-1);
        else {
            System.out.print("[");
            for (int i = 0; i < resultArray.length; i++) {
                System.out.print("[");
                for (int j = 0; j < resultArray[i].length; j++) {
                    if (j == 1) System.out.print(resultArray[i][j] + "]");
                    else System.out.print(resultArray[i][j] + ",");
                }
            }
            System.out.print("]");
        }
    }
}
