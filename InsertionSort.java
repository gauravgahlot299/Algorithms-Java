public class InsertionSort {
    public static void main(String args[]) {
        int[] arr = new int[]{2, 4, 1, 5, 3, 2};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int item = arr[i];
            while (j >= 0 && arr[j] > item) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = item;
        }
    }
}
