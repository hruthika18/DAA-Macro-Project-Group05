```java
import java.util.Scanner;

public class Project2_MergeSortRecursionTree {

    static void mergeSort(int[] arr, int left, int right, int level) {
        if (left > right) {
            return;
        }

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        System.out.print("mergeSort(" + left + ", " + right + ") -> ");

        for (int i = left; i <= right; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid, level + 1);
        mergeSort(arr, mid + 1, right, level + 1);

        merge(arr, left, mid, right);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        System.out.print("Merged: ");

        for (int i = left; i <= right; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nMerge Sort Recursion Tree:");
        mergeSort(arr, 0, n - 1, 0);

        System.out.print("\nSorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}


/*

INPUT:
Enter number of elements: 8
Enter array elements:
8 3 6 2 7 1 5 4

OUTPUT:
Merge Sort Recursion Tree:
mergeSort(0, 7) -> 8 3 6 2 7 1 5 4
    mergeSort(0, 3) -> 8 3 6 2
        mergeSort(0, 1) -> 8 3
            mergeSort(0, 0) -> 8
            mergeSort(1, 1) -> 3
        Merged: 3 8
        mergeSort(2, 3) -> 6 2
            mergeSort(2, 2) -> 6
            mergeSort(3, 3) -> 2
        Merged: 2 6
    Merged: 2 3 6 8
    mergeSort(4, 7) -> 7 1 5 4
        mergeSort(4, 5) -> 7 1
            mergeSort(4, 4) -> 7
            mergeSort(5, 5) -> 1
        Merged: 1 7
        mergeSort(6, 7) -> 5 4
            mergeSort(6, 6) -> 5
            mergeSort(7, 7) -> 4
        Merged: 4 5
    Merged: 1 4 5 7
Merged: 1 2 3 4 5 6 7 8

Sorted array: 1 2 3 4 5 6 7 8

*/