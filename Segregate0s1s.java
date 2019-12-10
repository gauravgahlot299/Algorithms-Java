public class Segregate0s1s {
    public static void main(String args[]) {
        int[] arr = new int[]{0, 1, 1, 0, 1, 0};
        segregate(arr);
        for (int i = 0; i < arr.length; i++) System.out.println(arr[i]);
    }

    static void segregate(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int pivot = 0;
        while (i < j) {
            while (arr[i] <= arr[pivot]) i++;
            while (arr[j] > arr[pivot]) j--;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = temp;
    }
}
