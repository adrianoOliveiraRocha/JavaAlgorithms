package searchalgorithms.binarySearch;

import java.util.Arrays;

public class BuiltInBinarySearch {
    public static void main(String[] args) {
        int[] numbers = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        int target = 38;

        // Built-in method
        int result = Arrays.binarySearch(numbers, target);

        if (result >= 0) {
            System.out.println("Found at index: " + result);
        } else {
            // The negative result tells you where it *would* be inserted
            System.out.println("Not found. Insertion point: " + (-result - 1));
        }
    }
}