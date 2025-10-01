import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int size = 100;
        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }

        int[] arr = generateRandomArray(size);

        PerformanceTracker tracker = new PerformanceTracker();
        SelectionSort sorter = new SelectionSort();

        tracker.start();
        sorter.sort(arr);
        tracker.stop();

        System.out.println("Sorted: " + Arrays.toString(arr));
        System.out.println("Comparisons: " + sorter.getComparisons());
        System.out.println("Swaps: " + sorter.getSwaps());
        System.out.println("Time (ns): " + tracker.getExecutionTime());

        tracker.exportToCSV("results.csv", "SelectionSort", size);
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }
}