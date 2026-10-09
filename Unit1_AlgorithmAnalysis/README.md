# Project 2 : Merge Sort Recursion Tree

## Overview

Merge Sort is a sorting algorithm based on the divide-and-conquer technique. It divides an array into smaller subarrays until each subarray contains only one element. These subarrays are then merged in sorted order until the entire array becomes sorted.

In this project, the Merge Sort algorithm is implemented in Java. The program displays the recursive calls, shows the merging process, and prints the final sorted array. The recursion tree helps us understand how the original problem is divided into smaller subproblems.

The user enters the array elements at runtime, and the program performs the sorting process.

## Objective

The main objectives of this project are:

1. Understand the Merge Sort algorithm.
2. Understand the divide-and-conquer technique.
3. Visualize the recursive calls made by Merge Sort.
4. Understand how an array is divided into smaller subarrays.
5. Observe how sorted subarrays are merged.
6. Analyze the time and space complexity of Merge Sort.

## Algorithm

The solution uses the divide-and-conquer approach. The array is repeatedly divided into two halves, and the smaller subarrays are merged after sorting.

### 1. Problem Definition

Given an array containing `n` elements, the objective is to arrange the elements in ascending order using Merge Sort.

The algorithm divides the array into smaller parts, sorts those parts recursively, and merges them to produce the final sorted array.

For example, the array:

```text
[8, 3, 6, 2, 7, 1, 5, 4]
```

must be sorted into:

```text
[1, 2, 3, 4, 5, 6, 7, 8]
```

### 2. Why Divide and Conquer Is Used

Sorting a large array can be easier when the problem is divided into smaller subproblems.

Merge Sort follows three main steps:

* **Divide:** Split the array into two halves.
* **Conquer:** Recursively sort each half.
* **Combine:** Merge the sorted halves into one sorted array.

The process continues until each subarray contains only one element. A single-element array is already sorted, so it becomes the base case of the recursion.

### 3. Recursion Tree

A recursion tree represents the recursive calls made by an algorithm. In Merge Sort, each internal node represents an array or subarray that is divided into two smaller parts.

Consider the input array:

```text
[8, 3, 6, 2, 7, 1, 5, 4]
```

The recursion tree for dividing the array is:

```text
                         [8, 3, 6, 2, 7, 1, 5, 4]
                              /             \
                   [8, 3, 6, 2]           [7, 1, 5, 4]
                    /       \              /       \
                [8, 3]     [6, 2]        [7, 1]    [5, 4]
                /   \      /   \         /   \     /   \
              [8]   [3]  [6]   [2]     [7]   [1] [5]   [4]
```

At the top, the original array contains eight elements.

* **Level 0:** The original array contains 8 elements.
* **Level 1:** The array is divided into two subarrays of 4 elements each.
* **Level 2:** Each subarray is divided into two subarrays of 2 elements each.
* **Level 3:** Each subarray is divided into single-element arrays.

At the last level, all subarrays contain one element. These are the base cases, and no further division is required.

For an array of 8 elements, the recursion tree has 4 levels when the root is counted as Level 0.

### 4. Merging Process

After the division phase, Merge Sort starts merging the smaller subarrays in sorted order.

Initially, the individual elements are:

```text
[8] [3] [6] [2] [7] [1] [5] [4]
```

**Level 1: Merge single-element arrays**

```text
[8] + [3] -> [3, 8]
[6] + [2] -> [2, 6]
[7] + [1] -> [1, 7]
[5] + [4] -> [4, 5]
```

**Level 2: Merge arrays of two elements**

```text
[3, 8] + [2, 6] -> [2, 3, 6, 8]

[1, 7] + [4, 5] -> [1, 4, 5, 7]
```

**Level 3: Merge arrays of four elements**

```text
[2, 3, 6, 8] + [1, 4, 5, 7]
                  |
                  v
[1, 2, 3, 4, 5, 6, 7, 8]
```

The merging process compares the elements from the two sorted halves and copies the smaller element into a temporary array. Any remaining elements are then copied, and the merged result is placed back into the original array.

### 5. Base Case

The base case occurs when a subarray contains only one element.

In the Java implementation, the condition is:

```java
if (left == right) {
    return;
}
```

When `left` and `right` are equal, there is only one element in the subarray. It is already sorted, so the recursive call returns without dividing it further.

The program also returns when `left > right`, which represents an empty subarray.

### 6. Merge Operation

The merge operation combines two sorted subarrays into one sorted subarray.

Suppose the two halves are:

```text
Left half:  [2, 6]
Right half: [3, 8]
```

The algorithm compares the first elements of both halves.

1. Compare 2 and 3. Copy 2.
2. Compare 6 and 3. Copy 3.
3. Compare 6 and 8. Copy 6.
4. Copy the remaining element 8.

The result is:

```text
[2, 3, 6, 8]
```

This process is repeated until the complete array is sorted.

### 7. Pseudocode

```text
MERGE_SORT(arr, left, right):

    if left >= right:
        return

    mid = (left + right) / 2

    MERGE_SORT(arr, left, mid)

    MERGE_SORT(arr, mid + 1, right)

    MERGE(arr, left, mid, right)


MERGE(arr, left, mid, right):

    Create a temporary array

    Compare elements from both sorted halves

    Copy the smaller element into the temporary array

    Copy any remaining elements

    Copy the temporary array back into arr
```

The program prints the recursive calls before processing each subarray and prints the merged elements after each merge operation. This output helps demonstrate the recursion tree and the merging sequence.

## Input

The program reads the array size and its elements at runtime.

### 1. Number of Elements

The user first enters the number of elements in the array.

```text
Enter number of elements: 8
```

### 2. Array Elements

The user enters the elements to be sorted.

```text
Enter array elements:
8 3 6 2 7 1 5 4
```

The program then displays the recursive calls, the merging process, and the final sorted array.

## Example

### Input

```text
Enter number of elements: 8
Enter array elements:
8 3 6 2 7 1 5 4
```

### Output

```text
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
```

The recursive calls show how the original array is divided into smaller subarrays. The `Merged` lines show how those subarrays are combined in sorted order.

The final sorted array is:

```text
[1, 2, 3, 4, 5, 6, 7, 8]
```

## Step-by-Step Example

Consider the array:

```text
[8, 3, 6, 2, 7, 1, 5, 4]
```

### Step 1: Divide the Original Array

The original array is split into two halves:

```text
Left:  [8, 3, 6, 2]
Right: [7, 1, 5, 4]
```

### Step 2: Divide Each Half

The left half is divided into:

```text
[8, 3] and [6, 2]
```

The right half is divided into:

```text
[7, 1] and [5, 4]
```

### Step 3: Continue Until Single Elements

The subarrays are divided further:

```text
[8] [3] [6] [2] [7] [1] [5] [4]
```

Each subarray contains one element and is already sorted.

### Step 4: Merge the Small Subarrays

```text
[8] + [3] -> [3, 8]
[6] + [2] -> [2, 6]
[7] + [1] -> [1, 7]
[5] + [4] -> [4, 5]
```

### Step 5: Merge the Larger Subarrays

```text
[3, 8] + [2, 6] -> [2, 3, 6, 8]

[1, 7] + [4, 5] -> [1, 4, 5, 7]
```

### Step 6: Final Merge

The two sorted halves are merged:

```text
[2, 3, 6, 8] + [1, 4, 5, 7]
```

The final result is:

```text
[1, 2, 3, 4, 5, 6, 7, 8]
```

Therefore, the input array is successfully sorted using Merge Sort.

## Complexity

For an array containing `n` elements, Merge Sort has the following complexity.

### Time Complexity

```text
O(n log n)
```

The array is divided into halves, resulting in approximately `log n` levels. At each level, merging the subarrays requires a total of `O(n)` work.

Therefore, the overall time complexity is `O(n log n)` in the best, average, and worst cases.

### Space Complexity

```text
O(n)
```

The merge operation uses a temporary array to combine the elements. The recursive calls also require stack space, which is `O(log n)`.

The temporary array requires `O(n)` space, so the overall auxiliary space complexity is `O(n)`.

## Technologies Used

* Programming Language: Java
* Algorithm: Merge Sort
* Technique: Divide and Conquer
* Concept: Recursion
* Input: Runtime input using `Scanner`
* Development Environment: Visual Studio Code

The program can also be compiled and executed using other Java IDEs such as IntelliJ IDEA or Eclipse.

## Project Files

```text
Unit1_AlgorithmAnalysis/
|
|-- Project2_MergeSortRecursionTree.java
|-- README.md
|-- Pseudocode.txt
|-- Prompt.txt
`-- Visualization.png
```

### File Description

| File                                   | Description                                                            |
| -------------------------------------- | ---------------------------------------------------------------------- |
| `Project2_MergeSortRecursionTree.java` | Java implementation of Merge Sort with recursive-call and merge output |
| `README.md`                            | Project documentation                                                  |
| `Pseudocode.txt`                       | Algorithm and pseudocode                                               |
| `Prompt.txt`                           | Prompt used to generate the recursion-tree visualization               |
| `Visualization.png`                    | Diagram of the Merge Sort recursion tree                               |

## Visualization

The `Visualization.png` file represents the division and merging stages of Merge Sort for an array of eight elements.

The visualization should include:

* The original array at the root.
* Recursive division into two halves at each level.
* Single-element subarrays at the leaf level.
* Arrows connecting parent arrays to their left and right subarrays.
* The merging process in bottom-up order.
* The final sorted array.
* The time and space complexity.

The main flow of the algorithm is:

```text
Start with the original array
          |
          v
Divide the array into two halves
          |
          v
Recursively divide each half
          |
          v
Reach single-element subarrays
          |
          v
Merge adjacent sorted subarrays
          |
          v
Merge larger sorted subarrays
          |
          v
Obtain the final sorted array
```

The recursion tree explains the division of the problem, while the merging stages show how the solution is constructed.

## Learning Outcome

After completing this project, we understand:

* How Merge Sort works.
* How the divide-and-conquer technique is applied.
* How recursive calls form a recursion tree.
* How an array is divided into smaller subarrays.
* Why a single-element array is the base case.
* How two sorted subarrays are merged.
* How to trace recursive calls in a Java program.
* How the recursion tree relates to the time complexity.
* Why Merge Sort requires additional memory for merging.

## Conclusion

This project demonstrates the Merge Sort algorithm using a recursion tree and a Java implementation.

The array is repeatedly divided into smaller subarrays until each subarray contains one element. The subarrays are then merged in sorted order to produce the final result.

For the example used in this project:

```text
Input:  [8, 3, 6, 2, 7, 1, 5, 4]

Output: [1, 2, 3, 4, 5, 6, 7, 8]
```

The project helps explain recursion, divide and conquer, merging, and algorithm complexity through a practical example.
=======
\# Unit 1: Algorithm Analysis — Merge Sort Recursion Tree



\## Overview

This project demonstrates divide-and-conquer using \*\*Merge Sort\*\* on an 8-element array: `\[38, 27, 43, 3, 9, 82, 10, 19]`.



\## Visualization

!\[Merge Sort Recursion Tree](Visualization.png)



\## Algorithm Logic \& Pseudocode

```text

Algorithm MergeSort(arr, left, right):

&#x20;   if left < right:

&#x20;       mid = left + (right - left) / 2

&#x20;       MergeSort(arr, left, mid)

&#x20;       MergeSort(arr, mid + 1, right)

&#x20;       Merge(arr, left, mid, right)
