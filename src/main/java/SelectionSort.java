public class SelectionSort {
    private long comparisons;
    private long swaps;

    public SelectionSort() {
        this.comparisons = 0;
        this.swaps = 0;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            boolean sorted = true;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                    sorted = false;
                }
            }

            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                sorted = false;
            }

            if (sorted) break;
        }
    }

    private void swap(int[] array, int i, int j) {
        swaps++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}