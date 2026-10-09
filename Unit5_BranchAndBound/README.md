# 0/1 Knapsack Problem Using Branch and Bound

## Overview

The 0/1 Knapsack Problem is an optimization problem that aims to maximize total profit without exceeding the given knapsack capacity.

Each item has a weight and a profit. An item can either be selected completely or not selected.

In this project, the problem is implemented using the Branch and Bound technique in Java. The algorithm uses upper bounds to identify promising solutions and prunes branches that cannot improve the current maximum profit.

The program accepts the number of items, their weights and profits, and the knapsack capacity at runtime.

## Objective

The main objectives of this project are:

1. Understand the 0/1 Knapsack Problem.
2. Implement Branch and Bound using Java.
3. Understand state-space trees, upper bounds, and pruning.
4. Find the maximum profit without exceeding the capacity.
5. Analyze the time and space complexity.

## Algorithm

The algorithm uses Branch and Bound to explore possible item selections.

### 1. Problem Definition

Given `n` items with different weights and profits, find the selection that maximizes profit without exceeding the knapsack capacity.

Total Weight <= Knapsack Capacity

Maximum Profit = Sum of selected item profits

### 2. Branch and Bound

Each item creates two possible choices:

- **Include:** Select the item.
- **Exclude:** Do not select the item.

The algorithm calculates an upper bound for each node. If the bound cannot improve the current maximum profit, that branch is pruned.

### 3. Algorithm Steps

1. Read the number of items, weights, profits, and capacity.
2. Sort items by descending profit-to-weight ratio.
3. Create the root node of the state-space tree.
4. Generate include and exclude branches.
5. Calculate the upper bound for each node.
6. Prune branches that cannot improve the current maximum profit.
7. Continue until no promising nodes remain.
8. Display the selected items and maximum profit.

### 4. Pseudocode

KnapsackBranchAndBound(items, capacity):

    Sort items by profit-to-weight ratio
    Create root node
    Insert root into queue
    maxProfit = 0

    while queue is not empty:

        Remove a node

        if its bound cannot improve maxProfit:
            continue

        Generate include and exclude branches

        Update maxProfit when a better
        feasible solution is found

        Calculate bounds for both branches
        Add promising branches to queue

    Display optimal solution

## Input

The program accepts input at runtime.

Enter number of items: 4
Enter weight and profit of each item:
Item 1: 2 40
Item 2: 3 50
Item 3: 4 65
Item 4: 5 70
Enter knapsack capacity: 7

## Output
-----------------------------
KNAPSACK BRANCH AND BOUND RESULT
-----------------------------
Selected Items:
Item 2 - Weight: 3, Profit: 50
Item 3 - Weight: 4, Profit: 65
Maximum Profit: 115
Total Weight: 7
Nodes Processed: 10

The maximum profit is `115`, with a total weight of `7`.

## Step-by-Step Example

Given:

Capacity = 7

Item 1: Weight = 2, Profit = 40
Item 2: Weight = 3, Profit = 50
Item 3: Weight = 4, Profit = 65
Item 4: Weight = 5, Profit = 70

The optimal selection is Items 2 and 3.

Total Weight = 3 + 4 = 7

Total Profit = 50 + 65 = 115

Other branches are explored or pruned based on their upper bounds.

## Complexity

### Time Complexity

Worst case: O(n * 2^n)

In the worst case, the algorithm may explore an exponential number of nodes, with up to `O(n)` work for bound calculation per node.

### Space Complexity

O(n * 2^n)

In the worst case, the queue may store exponentially many nodes, each containing a selection array of size `n`.

## Technologies Used

- Programming Language: Java
- Algorithm: Branch and Bound
- Data Structure: Queue
- Input: Scanner
- Development Environment: Visual Studio Code

## Project Files

Unit5_BranchAndBound/
|
|-- Project8_Knapsack_Branch_Bound.java
|-- README.md
|-- Prompt.txt
`-- Visualization.png

| File | Description |
|---|---|
| `Project8_Knapsack_Branch_Bound.java` | Java implementation of Knapsack using Branch and Bound |
| `README.md` | Project documentation |
| `Prompt.txt` | Visualization generation prompt |
| `Visualization.png` | Algorithm visualization |

## Learning Outcome

After completing this project, we understand:

- The 0/1 Knapsack Problem.
- Branching and pruning.
- State-space trees and upper bounds.
- Finding optimal solutions using Branch and Bound.
- Time and space complexity analysis.

## Conclusion

This project implements the 0/1 Knapsack Problem using Branch and Bound in Java. The algorithm explores promising item selections and prunes branches that cannot improve the current best solution.

For the given example, the algorithm selects Items 2 and 3, achieving a maximum profit of `115` without exceeding the knapsack capacity of `7`.
