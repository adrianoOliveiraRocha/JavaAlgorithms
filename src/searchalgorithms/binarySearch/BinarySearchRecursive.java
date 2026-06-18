package searchalgorithms.binarySearch;

public class BinarySearchRecursive {

    public static int binarySearchRecursive(int[] arr, int left, int right, int target) {
        // Base case: if left index exceeds right, target is not present
        if (left > right) {
            return -1;
        }

        // Calculate middle index
        int mid = left + (right - left) / 2;

        // If element is present at the middle itself
        if (arr[mid] == target) {
            return mid;
        }

        // If element is smaller than mid, search in the left subarray
        if (arr[mid] > target) {
            return binarySearchRecursive(arr, left, mid - 1, target);
        }

        // Else, search in the right subarray
        return binarySearchRecursive(arr, mid + 1, right, target);
    }

    public static void main(String[] args) {
        int[] numbers = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        int target = 45;

        int result = binarySearchRecursive(numbers, 0, numbers.length - 1, target);

        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}

