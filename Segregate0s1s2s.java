public class Segregate0s1s2s {
    public static void main(String args[]) {
        int[] arr = new int[]{2, 1, 0, 2, 1, 0};
        segregate(arr);
        for (int i = 0; i < arr.length; i++) System.out.println(arr[i]);
    }

    static void segregate(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }
}
