public class HeapSort {
    public void sort(int arr[], boolean ascending) {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i, ascending);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0, ascending);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int N, int i, boolean ascending) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // Compare child nodes based on ascending or descending order
        if (ascending) {
            if (l < N && arr[l] > arr[largest])
                largest = l;

            if (r < N && arr[r] > arr[largest])
                largest = r;
        } else {
            if (l < N && arr[l] < arr[largest])
                largest = l;

            if (r < N && arr[r] < arr[largest])
                largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest, ascending);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int N = arr.length;

        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver's code
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int N = arr.length;

        // Sort in ascending order
        HeapSort ob = new HeapSort();
        ob.sort(arr, true);

        System.out.println("Sorted array in ascending order:");
        printArray(arr);

        // Sort in descending order
        ob.sort(arr, false);

        System.out.println("Sorted array in descending order:");
        printArray(arr);
    }
}