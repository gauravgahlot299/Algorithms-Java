public class MergeSortedArrays_O1_Space {
    public static void main(String args[]) {
        int[] a = new int[]{1, 3, 5, 6};
        int[] b = new int[]{2, 4, 6, 8};
        merge(a, b);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

    static void merge(int[] a, int[] b) {
        for (int i = b.length - 1; i >= 0; i--) {
            int last = a[a.length - 1];
            int j = a.length - 2;
            while (j >= 0 && a[j] > b[i]) {
                a[j + 1] = a[j];
                j--;
            }
            if (j != a.length - 2 || last > b[i]) {
                a[j + 1] = b[i];
                b[i] = last;
            }
        }
    }
}
