import java.util.Arrays;

public class Project1_SortingComplexity {
    public static void merge(int[] arr, int left, int mid, int right, int depth) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++) rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];

        String indent = "    ".repeat(depth);
        int[] mergedSlice = Arrays.copyOfRange(arr, left, right + 1);
        System.out.println(indent + "↰ Merged: " + Arrays.toString(mergedSlice));
    }

    public static void mergeSort(int[] arr, int left, int right, int depth, String side) {
        String indent = "    ".repeat(depth);
        int[] currentSlice = Arrays.copyOfRange(arr, left, right + 1);
        System.out.println(indent + "↳ [" + side + "] Split: " + Arrays.toString(currentSlice));

        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, depth + 1, "Left");
            mergeSort(arr, mid + 1, right, depth + 1, "Right");
            merge(arr, left, mid, right, depth);
        }
    }

    public static void main(String[] args) {
        int[] sampleArray = {38, 27, 43, 3, 9, 82, 10, 19};
        System.out.println("Initial Array: " + Arrays.toString(sampleArray));
        System.out.println("\n--- Recursive Execution Trace ---");
        mergeSort(sampleArray, 0, sampleArray.length - 1, 0, "Root");
        System.out.println("\nSorted Output: " + Arrays.toString(sampleArray));
    }
}