public class ElementsLarger {
    public static void main(String args[]) {
        int[] arr = new int[]{1, 3, 5, 7, 9};
        int ele = 4;
        System.out.print(getLargerCount(arr, ele));
    }

    static int getLargerCount(int[] arr, int ele) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == ele) {
                return arr.length - mid;
            }
            if (low == high - 1 || low == high) {
                if (ele < arr[low]) {
                    return arr.length - low;
                }
                if (ele > arr[high])
                    return arr.length - high - 1;
                else return arr.length - high;
            }
            if (ele < arr[mid]) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return 0;
    }
}
