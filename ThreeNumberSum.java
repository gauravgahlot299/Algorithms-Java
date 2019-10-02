import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Finding all the triplets from the given array named 'a' which sum up to a given number named 'b'.
//The 3 numbers in a triplet should be sorted and also that the triplets need to be sorted.
public class ThreeNumberSum {
    static int[][] findTriplets(int[]a, int b){
        Arrays.sort(a);
        List<int[]> resultList = new ArrayList<int[]>();
        for (int i = 0; i < a.length - 2; i++) {
            int left = i + 1;
            int right = a.length - 1;
            int sumToFind = b - a[i];
            while (left < right) {
                if (a[left] + a[right] == sumToFind) {
                    int[] pair = {a[i], a[left], a[right]};
                    resultList.add(pair);
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
        int[][] resultArray = resultList.toArray(new int[resultList.size()][3]);
        return resultArray;
    }
    public static void main(String args[]) {
        int a[] = {12, 3, 1, 2, -6, 5, -8, 6, -2, -1};
        int b = 3;
        int[][] resultArray = findTriplets(a, b);
        if (resultArray.length == 0) System.out.println(-1);
        else {
            System.out.print("[");
            for (int i = 0; i < resultArray.length; i++) {
                System.out.print("[");
                for (int j = 0; j < resultArray[i].length; j++) {

                    if (j == 2) System.out.print(resultArray[i][j] + "]");
                    else System.out.print(resultArray[i][j] + ",");
                }
            }
            System.out.print("]");
        }
    }
}
