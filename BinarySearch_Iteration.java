public class BinarySearch_Iteration {
    public static void main(String args[]) {
        int a[] = {-12, -1, 4, 5, 6, 9};
        int b = 9;
        int startIndex = 0;
        int lastIndex = a.length - 1;
        while (startIndex <= lastIndex) {
            int mid = (startIndex + lastIndex) / 2;
            if (a[mid] == b) {
                System.out.println("Found at index:" + mid);
                return;
            } else {
                if (a[mid] > b) {
                    lastIndex = mid - 1;
                } else {
                    startIndex = mid + 1;
                }
            }
        }
        System.out.println("Not Found");
    }
}
