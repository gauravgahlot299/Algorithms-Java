public class NumberOfBSTs_CatalanNumber {
    int getCatalanNumber_DP(int n) {
        int output[] = new int[n + 1];
        output[0] = 1;
        output[1] = 1;
        for (int i = 2; i <= n; i++) {
            output[i] = 0;
            for (int j = 0; j < i; j++) {
                output[i] += output[j] * output[i - j - 1];
            }
        }
        return output[n];
    }

    int getCatalanNumber_Recursive(int n) {
        if (n == 0 || n == 1) return 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += getCatalanNumber_Recursive(i) * getCatalanNumber_Recursive(n - i - 1);
        }
        return result;
    }

    public static void main(String args[]) {
        NumberOfBSTs_CatalanNumber catalanNumber = new NumberOfBSTs_CatalanNumber();
        System.out.println(catalanNumber.getCatalanNumber_DP(4));
        System.out.println(catalanNumber.getCatalanNumber_Recursive(4));
    }
}
