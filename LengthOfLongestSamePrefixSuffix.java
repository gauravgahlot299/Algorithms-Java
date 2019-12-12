public class LengthOfLongestSamePrefixSuffix {
    public static void main(String args[]) {
        String arr = new String("abcdabceabcd");
        System.out.println("Max:" + getLengthOfLongestPrefixSuffix(arr));

    }

    static int getLengthOfLongestPrefixSuffix(String string) {
        int l = string.length();
        int[] length = new int[l];
        length[0] = 0;
        int i = 1;
        int j = 0;
        int max = 0;
        while (i < l) {
            if (string.charAt(i) == (string.charAt(j))) {
                length[i] = j + 1;
                if (length[i] > max) max = length[i];
                i++;
                j++;
            } else {
                while (j > 0 && string.charAt(i) != (string.charAt(j))) {
                    j = length[j - 1];
                }
                if (string.charAt(i) == (string.charAt(j))) {
                    length[i] = j + 1;
                    if (length[i] > max) max = length[i];
                    i++;
                    j++;
                } else {
                    length[i] = 0;
                    if (length[i] > max) max = length[i];
                    i++;
                }
            }
        }
        for (i = 0; i < l; i++) System.out.println(length[i]);
        return max;
    }
}
