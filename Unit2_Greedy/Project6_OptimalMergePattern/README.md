# Project 6 - Optimal Merge Pattern

## Aim

To implement the Optimal Merge Pattern using the Greedy Method and find the minimum cost of merging files.

## Description

The Optimal Merge Pattern is used to merge several files into one file with minimum total cost.

At each step, we select the two smallest files and merge them. The merged file is added back and the process continues until only one file remains.

## Algorithm

1. Read the number of files.
2. Read the size of each file.
3. Insert all file sizes into a priority queue.
4. Remove the two smallest files.
5. Add their sizes to get the merge cost.
6. Add the merge cost to the total cost.
7. Insert the merged file back into the priority queue.
8. Repeat until only one file remains.
9. Display the minimum merge cost.

## Example Input

```text
Enter number of files: 4
Enter file sizes:
5 10 20 30
