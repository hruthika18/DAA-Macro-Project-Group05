# Project 6 : Optimal Merge Pattern using Greedy Method

## Overview

The Optimal Merge Pattern is a greedy algorithm used to merge multiple files into one file with minimum total cost.

When two files are merged, the cost of merging them is equal to the sum of their sizes. The main objective is to find the order of merging the files so that the total merging cost is minimum.

In this project, the Optimal Merge Pattern is implemented using the Greedy Method and a Priority Queue. The program does not use fixed input values. The user enters the required information at runtime.

The user can enter:

- Number of files
- Size of each file

The program then calculates the minimum total cost required to merge all the files.

## Objective

The main objectives of this project are:

1. Understand the Optimal Merge Pattern problem.
2. Implement the Optimal Merge Pattern using the Greedy Method.
3. Understand how the greedy approach works.
4. Use a Priority Queue to select the smallest files.
5. Calculate the minimum total merge cost.
6. Display the minimum merge cost.

## Algorithm

The solution uses the Greedy Method with a Priority Queue.

At every step, the two files with the smallest sizes are selected and merged.

The cost of merging the two files is added to the total cost. The newly merged file is then inserted back into the Priority Queue.

This process is repeated until only one file remains.

### 1. Problem Definition

Given `n` files with different sizes, the objective is to merge all the files into one file with minimum total merging cost.

If two files have sizes `a` and `b`, then:

```text
Merge Cost = a + b
```

### 2. Why Greedy Method is Used

At every step, the two smallest files are selected for merging.

Choosing the smallest files first helps reduce the total cost because smaller files are involved in fewer future merge operations.

Therefore, selecting the two smallest files at every step gives the minimum total merge cost.

### 3. Priority Queue

A Priority Queue is used to store the file sizes.

The smallest file size is automatically available at the front of the Priority Queue.

For example:

```text
Files:
5 10 20 30
```

The two smallest files are:

```text
5 and 10
```

They are merged first:

```text
5 + 10 = 15
```

The new file size `15` is added back to the Priority Queue.

The Priority Queue now contains:

```text
15 20 30
```

### 4. Algorithm Steps

1. Read the number of files.
2. Read the size of each file.
3. Insert all file sizes into a Priority Queue.
4. Remove the two smallest files.
5. Add their sizes to calculate the merge cost.
6. Add the merge cost to the total cost.
7. Insert the merged file back into the Priority Queue.
8. Repeat the process until only one file remains.
9. Display the minimum total merge cost.

### 5. Pseudocode

```text
OptimalMerge(files):

    totalCost = 0

    while more than one file exists:

        first = remove smallest file
        second = remove smallest file

        mergeCost = first + second

        totalCost = totalCost + mergeCost

        insert mergeCost back into Priority Queue

    return totalCost
```

## Input

The program reads all the required information at runtime.

### 1. Number of Files

```text
Enter number of files: 4
```

### 2. File Sizes

```text
Enter file sizes:
File 1: 5
File 2: 10
File 3: 20
File 4: 30
```

## Example

### Input

```text
Enter number of files: 4
Enter file sizes:
File 1: 5
File 2: 10
File 3: 20
File 4: 30
```

### Output

```text
-----------------------------
OPTIMAL MERGE PATTERN RESULT
-----------------------------
Minimum merge cost: 115
```

The minimum merge cost is `115`.

## Step-by-Step Example

Consider four files with sizes:

```text
5, 10, 20, 30
```

### Step 1

Select the two smallest files:

```text
5 and 10
```

Merge them:

```text
5 + 10 = 15
```

Cost:

```text
15
```

Remaining files:

```text
15, 20, 30
```

### Step 2

Select the two smallest files:

```text
15 and 20
```

Merge them:

```text
15 + 20 = 35
```

Cost:

```text
35
```

Remaining files:

```text
30, 35
```

### Step 3

Select the two remaining files:

```text
30 and 35
```

Merge them:

```text
30 + 35 = 65
```

Cost:

```text
65
```

### Total Cost

```text
15 + 35 + 65 = 115
```

Therefore:

```text
Minimum merge cost = 115
```

## Merge Table

| Step | Files Selected | Merge Cost | Total Cost |
|------|----------------|------------|------------|
| 1 | 5 + 10 | 15 | 15 |
| 2 | 15 + 20 | 35 | 50 |
| 3 | 30 + 35 | 65 | 115 |

The final minimum merge cost is:

```text
115
```

## Complexity

For `n` files:

### Time Complexity

```text
O(n log n)
```

A Priority Queue is used to repeatedly remove the two smallest elements and insert the merged file.

There are `n - 1` merge operations, and each insertion or removal from the Priority Queue takes `O(log n)` time.

### Space Complexity

```text
O(n)
```

The Priority Queue stores the file sizes and the merged file sizes.

## Technologies Used

- Programming Language: Java
- Algorithm: Greedy Method
- Data Structure: Priority Queue
- Input: Runtime input using `Scanner`
- Development Environment: Visual Studio Code

The program can also be compiled and executed using IntelliJ IDEA or Eclipse.

## Project Files

```text
Unit2_DivideAndConquer_Greedy/
|
|-- Project6_Optimal_Merge_Pattern.java
|-- README.md
|-- Prompt.txt
`-- Visualization.png
```

### File Description

| File | Description |
|------|-------------|
| `Project6_Optimal_Merge_Pattern.java` | Java implementation of Optimal Merge Pattern using the Greedy Method |
| `README.md` | Project documentation |
| `Prompt.txt` | Prompt used to generate the visualization |
| `Visualization.png` | Visualization of the Optimal Merge Pattern |

## Visualization

The `Visualization.png` file shows the process of merging files using the Optimal Merge Pattern.

The main flow is:

```text
Start
   |
   v
Read number of files
   |
   v
Read file sizes
   |
   v
Insert files into Priority Queue
   |
   v
Select two smallest files
   |
   v
Calculate merge cost
   |
   v
Add cost to total cost
   |
   v
Insert merged file
   |
   v
Repeat until one file remains
   |
   v
Display minimum merge cost
```

For the example:

```text
5 + 10 = 15
15 + 20 = 35
30 + 35 = 65
```

Total cost:

```text
15 + 35 + 65 = 115
```

Minimum cost:

```text
115
```

## Learning Outcome

After completing this project, we understand:

- How the Optimal Merge Pattern works.
- Why the Greedy Method is used.
- How a Priority Queue works.
- How to select the two smallest files efficiently.
- How the merge cost is calculated.
- How the minimum total merge cost is obtained.
- The time and space complexity of the algorithm.
- How Greedy Algorithms can be applied to optimization problems.

## Conclusion

This project implements the Optimal Merge Pattern using the Greedy Method and Priority Queue.

At each step, the two smallest files are selected and merged. The merged file is then inserted back into the Priority Queue. This process continues until all files are combined into one file.

For the example used in this project:

```text
Files: 5, 10, 20, 30

Merge 1: 5 + 10 = 15
Merge 2: 15 + 20 = 35
Merge 3: 30 + 35 = 65

Minimum Merge Cost: 115
```

This project helps us understand Greedy Algorithms, Priority Queues, and optimization through a practical implementation of the Optimal Merge Pattern.
