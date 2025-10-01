public class PerformanceTracker {
    private long comparisons;
    private long swaps;
    private long timeNano;

    public void start() {
        comparisons = 0;
        swaps = 0;
        timeNano = System.nanoTime();
    }

    public void stop() {
        timeNano = System.nanoTime() - timeNano;
    }

    public void addComparisons(long c) {
        comparisons += c;
    }

    public void addSwaps(long s) {
        swaps += s;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getElapsedTime() {
        return timeNano;
    }
}