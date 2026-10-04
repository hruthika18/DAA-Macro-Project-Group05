# Unit 2 - Divide and Conquer and Greedy

## Project 6 - Optimal Merge Pattern

### Aim

To implement the Optimal Merge Pattern using the Greedy Method and find the minimum cost of merging multiple files.

### Description

Optimal Merge Pattern is a greedy algorithm used to merge several files into one file with minimum total cost.

At each step, the two smallest files are selected and merged. The merged file is then added back. This process continues until only one file remains.

### Algorithm

1. Read the number of files.
2. Read the size of each file.
3. Store all file sizes in a priority queue.
4. Select the two smallest file sizes.
5. Add them to calculate the merge cost.
6. Add the merge cost to the total cost.
7. Insert the merged file back into the priority queue.
8. Repeat until only one file remains.
9. Display the minimum total merge cost.

### Example Input

```text
Enter number of files: 4
Enter file sizes:
5 10 20 30