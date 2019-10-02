import java.util.*;

//Finding all the quadruplets from the given array named 'a' which sum up to a given number named 'b'.
public class FourNumberSum_Variation1 {
    static int[][] findQuadruplets(int[] a, int b) {
        Map<Integer, ArrayList<int[]>> map = new HashMap<Integer, ArrayList<int[]>>();
        List<int[]> resultList = new ArrayList<int[]>();
        for (int i = 1; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (map.containsKey(b - (a[i] + a[j]))) {
                    List<int[]> temp = map.get(b - (a[i] + a[j]));
                    for (int[] ele : temp) {
                        int[] quadruplet = new int[4];
                        quadruplet[0] = ele[0];
                        quadruplet[1] = ele[1];
                        quadruplet[2] = a[i];
                        quadruplet[3] = a[j];
                        resultList.add(quadruplet);
                    }
                }
            }
            for (int j = 0; j < i; j++) {
                int[] temp = new int[2];
                temp[0] = a[i];
                temp[1] = a[j];
                if (map.containsKey(a[j] + a[i])) {
                    map.get(a[j] + a[i]).add(temp);
                } else {
                    ArrayList<int[]> t = new ArrayList<int[]>();
                    t.add(temp);
                    map.put(a[j] + a[i], t);
                }
            }
        }
        int[][] resultArray = resultList.toArray(new int[resultList.size()][3]);
        return resultArray;
    }

    public static void main(String args[]) {
        int a[] = {12, 3, 1, 2, -6, 5, -8, 6, -2, -1};
        int b = 3;
        int[][] resultArray = findQuadruplets(a, b);
        if (resultArray.length == 0) System.out.println(-1);
        else {
            System.out.print("[");
            for (int i = 0; i < resultArray.length; i++) {
                System.out.print("[");
                for (int j = 0; j < resultArray[i].length; j++) {

                    if (j == 3) System.out.print(resultArray[i][j] + "]");
                    else System.out.print(resultArray[i][j] + ",");
                }
            }
            System.out.print("]");
        }
    }
}
