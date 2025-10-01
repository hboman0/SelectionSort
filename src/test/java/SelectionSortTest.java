import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SelectionSortTest {

    @Test
    public void testEmptyArray() {
        SelectionSort sorter = new SelectionSort();
        int[] arr = {};
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testSingleElement() {
        SelectionSort sorter = new SelectionSort();
        int[] arr = {5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    public void testSortedArray() {
        SelectionSort sorter = new SelectionSort();
        int[] arr = {1, 2, 3, 4};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4}, arr);
    }

    @Test
    public void testReverseArray() {
        SelectionSort sorter = new SelectionSort();
        int[] arr = {4, 3, 2, 1};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4}, arr);
    }

    @Test
    public void testDuplicates() {
        SelectionSort sorter = new SelectionSort();
        int[] arr = {3, 1, 2, 1, 3};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arr);
    }
}