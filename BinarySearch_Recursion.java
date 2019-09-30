public class BinarySearch_Recursion {
    public static void main(String args[]) {
        int a[] = {-1, 0, 3, 6, 7, 8};
        int b = 4;
        int left = 0;
        int right = a.length - 1;
        int idx = BinarySearch(a, left, right, b);
        if (idx != -1) {
            System.out.println("Found at index:" + idx);
        } else {
            System.out.println("Not Found");
        }
    }

    static int BinarySearch(int a[], int left, int right, int b) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == b) {
                return mid;
            } else {
                if (a[mid] > b) {
                    return BinarySearch(a, left, mid - 1, b);
                } else {
                    return BinarySearch(a, mid + 1, right, b);
                }
            }
        }
        return -1;
    }
}
