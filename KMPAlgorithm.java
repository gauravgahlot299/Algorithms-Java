public class KMPAlgorithm {
    public static void main(String args[]) {
        String a = "abcdeabcaaaba";
        String b = "aba";
        int[] prefixSuffixArray = getPrefixSuffixArray(b);
        System.out.println(getMatchingIndexPosition(a, b, prefixSuffixArray));
    }

    static int getMatchingIndexPosition(String a, String b, int[] arr) {
        int i = 0;
        int j = 0;
        while (i < a.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                if (j == b.length() - 1) return i - j;
                i++;
                j++;
            } else {
                if (j != 0)
                    j = arr[j - 1];
                else i++;
            }
        }
        return -1;
    }

    static int[] getPrefixSuffixArray(String b) {
        int l = b.length();
        int[] len = new int[l];
        int i = 1;
        int j = 0;
        len[0] = 0;
        while (i < l) {
            if (b.charAt(i) == b.charAt(j)) {
                len[i] = j + 1;
                i++;
                j++;
            } else {
                while (j > 0 && b.charAt(i) != b.charAt(j)) {
                    j = len[j - 1];
                }
                if (b.charAt(i) == b.charAt(j)) {
                    len[i] = j + 1;
                    i++;
                    j++;
                } else {
                    len[i] = 0;
                    i++;
                }
            }
        }
        return len;
    }
}
