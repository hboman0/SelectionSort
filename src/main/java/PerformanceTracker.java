import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {
    private long comparisons;
    private long swaps;
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public void incrementComparisons() { comparisons++; }
    public void incrementSwaps() { swaps++; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getExecutionTime() { return endTime - startTime; }

    public void exportToCSV(String filename, String algorithm, int size) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.append(algorithm).append(",")
                  .append(String.valueOf(size)).append(",")
                  .append(String.valueOf(comparisons)).append(",")
                  .append(String.valueOf(swaps)).append(",")
                  .append(String.valueOf(getExecutionTime())).append("\n");
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        startTime = 0;
        endTime = 0;
    }
}
