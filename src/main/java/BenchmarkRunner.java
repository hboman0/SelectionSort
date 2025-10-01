import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 5000, 10000};
        String fileName = "results.csv";

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);

            PerformanceTracker tracker = new PerformanceTracker();
            SelectionSort sorter = new SelectionSort(tracker);

            tracker.start();
            sorter.sort(arr);
            tracker.stop();

            System.out.println("n = " + size);
            System.out.println("Comparisons: " + tracker.getComparisons());
            System.out.println("Swaps: " + tracker.getSwaps());
            System.out.println("Time (ns): " + tracker.getExecutionTime());
            System.out.println("---------------------------------");

            tracker.exportToCSV(fileName, "SelectionSort", size);
        }

        System.out.println("Results saved to " + fileName);
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