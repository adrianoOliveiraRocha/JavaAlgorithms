package searchalgorithms.binarySearch;

public class BinarySearchExample {

    // Iterative Binary Search
    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // Calculate mid to avoid integer overflow (instead of (left + right)/2)
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid; // Target found! Return its index
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            } 
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // Target not found in the array
        return -1;
    }

    public static void main(String[] args) {
        // The array MUST be sorted for binary search to work
        int[] numbers = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        
        // Using Java's built-in sort if you have unsorted data
        // Arrays.sort(numbers); 

        int target = 23;
        int result = binarySearchIterative(numbers, target);

        if (result == -1) {
            System.out.println("Element " + target + " not found.");
        } else {
            System.out.println("Element " + target + " found at index: " + result);
        }

        // Test a value that doesn't exist
        int missing = 99;
        int resultMissing = binarySearchIterative(numbers, missing);
        System.out.println("Search for " + missing + " returned: " + resultMissing);
    }
}

