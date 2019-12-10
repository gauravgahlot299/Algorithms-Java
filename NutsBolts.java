public class NutsBolts {
    public static void main(String args[]) {
        char nuts[] = new char[]{'d', 'b', 'a', 'e', 'f', 'c'};
        char bolts[] = new char[]{'e', 'a', 'f', 'b', 'c', 'd'};
        quickSort(nuts, bolts, 0, nuts.length - 1);
        for (int i = 0; i < nuts.length; i++) {
            System.out.println(nuts[i] + "-" + bolts[i]);
        }
    }

    static void quickSort(char[] nuts, char[] bolts, int low, int high) {
        if (low < high) {
            int partition = getPartition(nuts, bolts[high], low, high);
            getPartition(bolts, nuts[partition], low, high);
            quickSort(nuts, bolts, low, partition - 1);
            quickSort(nuts, bolts, partition + 1, high);
        }
    }

    static int getPartition(char[] considered, char pivot, int low, int high) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (considered[j] < pivot) {
                char temp = considered[i];
                considered[i] = considered[j];
                considered[j] = temp;
                i++;
            } else if (considered[j] == pivot) {
                char temp = considered[high];
                considered[high] = considered[j];
                considered[j] = temp;
                j--;
            }
        }
        char temp = considered[i];
        considered[i] = considered[high];
        considered[high] = temp;
        return i;
    }
}
