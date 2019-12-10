public class QuickSort {
    static int[] arr = new int[]{2, 54, 31, 12, 8, 0};

    public static void main(String args[]) {
        int low = 0;
        int high = arr.length - 1;
        quickSort(low, high);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void quickSort(int low, int high) {
        if (low < high) {
            int partition = getPartition(low, high);
            quickSort(low, partition - 1);
            quickSort(partition + 1, high);
        }
    }

    static int getPartition(int i, int j) {
        int pivot = i;
        while (i < j) {
            while (arr[i] <= arr[pivot]) {
                i++;
            }
            while (arr[j] > arr[pivot]) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = temp;
        return j;
    }
}
