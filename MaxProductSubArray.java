public class MaxProductSubArray {
    int getMaxProduct(int[] a) {
        int neg = 1;
        int pos = 1;
        int maxProduct = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                neg = 1;
                pos = 1;
                maxProduct = Math.max(maxProduct, a[i]);
            } else {
                if (a[i] < 0) {
                    int temp = pos;
                    if (neg < 0) {
                        pos = neg * a[i];
                        maxProduct = Math.max(maxProduct, pos);
                    } else {
                        pos = 1;
                    }
                    neg = temp * a[i];
                } else {
                    pos *= a[i];
                    if (neg < 0) {
                        neg *= a[i];
                    }
                    maxProduct = Math.max(maxProduct, pos);
                }
            }
        }
        return maxProduct;
    }

    public static void main(String args[]) {
        MaxProductSubArray mps = new MaxProductSubArray();
//        int input[] = {-6, -3, 8, -9, -1, -1, 3, 6, 9, 0, 3, -1};
        int input[] = {-1, -4, 0, -2};
        System.out.println(mps.getMaxProduct(input));
    }
}
