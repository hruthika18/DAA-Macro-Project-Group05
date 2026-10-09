<<<<<<< HEAD
# Project 13 - 0/1 Knapsack Problem Using Branch and Bound

## Overview

The 0/1 Knapsack Problem is a well-known optimization problem in which we need to select items to obtain the maximum possible profit without exceeding the given knapsack capacity.

Each item has a weight and a profit. An item can either be selected completely or left out. It cannot be divided into smaller parts.

In this project, the 0/1 Knapsack Problem is implemented in Java using the Branch and Bound technique. The algorithm explores different combinations of items and uses upper bounds to identify promising solutions. Branches that cannot improve the current maximum profit are pruned to reduce unnecessary exploration.

The program accepts the number of items, their weights and profits, and the knapsack capacity at runtime.

## Objective

The main objectives of this project are:

1. Understand the 0/1 Knapsack Problem.
2. Implement the Branch and Bound technique using Java.
3. Understand branching, bounding, and pruning.
4. Represent possible item selections using a state-space tree.
5. Find the maximum profit without exceeding the capacity.
6. Analyze the time and space complexity of the algorithm.

## Algorithm

The solution uses Branch and Bound to explore possible item selections while avoiding branches that cannot lead to a better solution.

### 1. Problem Definition

Given `n` items, each with a weight and profit, and a knapsack with a fixed capacity, the objective is to select items that maximize the total profit without exceeding the capacity.

The constraints are:

```text
Total Weight <= Knapsack Capacity

Maximum Profit = Sum of the profits of selected items
```

Each item has two possible choices:

* Include the item in the knapsack.
* Exclude the item from the knapsack.

This is called the 0/1 Knapsack Problem because an item is either selected or not selected.

### 2. Why Branch and Bound Is Used

A simple solution would examine every possible combination of items. For `n` items, there are `2^n` possible selections.

As the number of items increases, examining every combination becomes expensive.

Branch and Bound improves the search by calculating an upper bound on the profit that can be obtained from a node. If this bound cannot exceed the best profit found so far, that branch does not need to be explored further.

This helps reduce unnecessary calculations while still finding the optimal solution.

### 3. State-Space Tree

A state-space tree represents the possible choices made for each item.

At each level, the algorithm considers two branches:

* **Include branch:** Select the current item.
* **Exclude branch:** Skip the current item.

For example, with four items, the first decision creates two branches. Each branch can then create two more branches for the next item.

```text
                         Root
                       /      \
                  Include 1   Exclude 1
                   /    \       /    \
             Include 2 Exclude 2 Include 2 Exclude 2
                  ... Continue for remaining items ...
```

Each node represents a partial selection of items.

A node stores information such as:

* The level or item currently being considered.
* The total weight of selected items.
* The total profit of selected items.
* The upper bound on the possible profit.

The algorithm uses this information to decide whether a node should be explored or pruned.

### 4. Branching

Branching means creating new possibilities from the current node.

Suppose the current item has weight `w` and profit `p`, and the current node has weight `currentWeight` and profit `currentProfit`.

**Include the item:**

```text
newWeight = currentWeight + w

newProfit = currentProfit + p
```

The include branch is feasible only if:

```text
newWeight <= capacity
```

If the new weight exceeds the capacity, the selection cannot be used as a valid solution.

**Exclude the item:**

The item is skipped, so the weight and profit remain unchanged.

```text
newWeight = currentWeight

newProfit = currentProfit
```

Both choices are considered when they can contribute to finding a better solution.

### 5. Upper Bound

The upper bound estimates the maximum profit that a node could potentially achieve if the remaining capacity were filled as advantageously as possible.

Items are sorted in descending order of their profit-to-weight ratio:

```text
Profit-to-Weight Ratio = Profit / Weight
```

Items with higher ratios are considered first when calculating the bound.

For the upper-bound calculation, a fractional part of an item may be used to estimate the maximum possible profit. This is only a relaxation used for bounding; the actual 0/1 solution still selects each item completely or excludes it.

The upper bound helps identify nodes that may lead to a better solution.

### 6. Pruning

Pruning means removing a branch from further consideration when it cannot produce a better solution.

Suppose the best feasible profit found so far is `maxProfit`.

If a node's upper bound is less than or equal to `maxProfit`, the branch can be pruned because it cannot improve the current result.

The pruning condition is:

```text
if upperBound <= maxProfit:
    prune the node
```

Branches that exceed the knapsack capacity are also rejected as infeasible selections.

Pruning reduces the number of nodes explored, although the algorithm may still take exponential time in the worst case.

### 7. Algorithm Steps

1. Read the number of items.
2. Read the weight and profit of every item.
3. Read the knapsack capacity.
4. Sort the items by descending profit-to-weight ratio.
5. Create the root node of the state-space tree.
6. Calculate the upper bound of the root node.
7. Generate include and exclude branches for promising nodes.
8. Update the maximum profit whenever a better feasible solution is found.
9. Calculate the upper bounds of the new nodes.
10. Prune nodes that cannot improve the current maximum profit.
11. Continue until no promising nodes remain.
12. Display the selected items, total weight, and maximum profit.

### 8. Pseudocode

```text
KNAPSACK_BRANCH_AND_BOUND(items, capacity):

    Sort items by descending profit-to-weight ratio

    Create the root node
    maxProfit = 0

    Insert root into the queue

    while queue is not empty:

        Remove a promising node

        if upperBound(node) <= maxProfit:
            continue

        Generate the include branch

        if include branch is within capacity:

            Update maxProfit if the profit is better

            Calculate its upper bound

            if its bound can improve maxProfit:
                Insert it into the queue

        Generate the exclude branch

        Calculate its upper bound

        if its bound can improve maxProfit:
            Insert it into the queue

    Display the best feasible selection
    Display maximum profit and total weight
```

The exact queue operations and bound calculations depend on the Java implementation.

## Input

The program accepts the required values at runtime.

### 1. Number of Items

The user enters the total number of items.

```text
Enter number of items: 4
```

### 2. Weights and Profits

For each item, the user enters its weight followed by its profit.

```text
Enter weight and profit of each item:

Item 1: 2 40
Item 2: 3 50
Item 3: 4 65
Item 4: 5 70
```

### 3. Knapsack Capacity

The user enters the maximum weight the knapsack can hold.

```text
Enter knapsack capacity: 7
```

The program then explores possible selections and identifies the maximum profit.

## Example

### Input

```text
Enter number of items: 4

Enter weight and profit of each item:
Item 1: 2 40
Item 2: 3 50
Item 3: 4 65
Item 4: 5 70

Enter knapsack capacity: 7
```

### Output

The expected optimal selection for these values is:

```text
-----------------------------
KNAPSACK BRANCH AND BOUND RESULT
-----------------------------

Selected Items:
Item 2 - Weight: 3, Profit: 50
Item 3 - Weight: 4, Profit: 65

Maximum Profit: 115
Total Weight: 7
```

If your Java implementation also prints the number of nodes processed, that value should be taken from the actual program output because it depends on the node-expansion and pruning strategy used.

The selected items have a combined weight of `7`, which equals the capacity, and a combined profit of `115`.

## Step-by-Step Example

Consider the following items and a knapsack capacity of `7`.

| Item   | Weight | Profit | Profit-to-Weight Ratio |
| ------ | -----: | -----: | ---------------------: |
| Item 1 |      2 |     40 |                  20.00 |
| Item 2 |      3 |     50 |                  16.67 |
| Item 3 |      4 |     65 |                  16.25 |
| Item 4 |      5 |     70 |                  14.00 |

### Step 1: Start from the Root

Initially, no items have been selected.

```text
Selected Items: None
Total Weight: 0
Total Profit: 0
```

The root represents the starting point of the search.

### Step 2: Consider Item Selections

The algorithm explores include and exclude decisions for each item.

For example, selecting Item 1 gives:

```text
Weight = 2
Profit = 40
```

Selecting Items 1 and 2 gives:

```text
Total Weight = 2 + 3 = 5
Total Profit = 40 + 50 = 90
```

This is a feasible selection because the total weight does not exceed `7`.

### Step 3: Explore Other Combinations

Selecting Items 2 and 3 gives:

```text
Total Weight = 3 + 4 = 7
Total Profit = 50 + 65 = 115
```

This selection uses the full capacity and achieves a profit of `115`.

Selecting Items 1 and 3 gives:

```text
Total Weight = 2 + 4 = 6
Total Profit = 40 + 65 = 105
```

Selecting Items 1 and 4 gives:

```text
Total Weight = 2 + 5 = 7
Total Profit = 40 + 70 = 110
```

Both are feasible, but neither gives a profit greater than `115`.

### Step 4: Apply Bounding and Pruning

The algorithm calculates upper bounds for promising nodes.

If a node cannot produce a profit greater than the best feasible profit found so far, its branch is pruned.

Selections whose total weight exceeds `7` are also rejected as infeasible.

This avoids exploring branches that cannot improve the result.

### Step 5: Obtain the Final Result

The best selection is:

```text
Selected Items: Item 2 and Item 3

Total Weight = 3 + 4 = 7

Total Profit = 50 + 65 = 115
```

Therefore, the maximum profit is `115` for the given example.

## Complexity

For `n` items, the Branch and Bound solution has the following complexity.

### Time Complexity

```text
Worst Case: O(n * 2^n)
```

There can be up to `2^n` possible combinations of items. If calculating the bound requires examining up to `n` items, the worst-case time complexity can be `O(n * 2^n)`.

The actual execution time depends on how many branches are pruned.

### Space Complexity

```text
O(n * 2^n)
```

In a straightforward implementation where the queue may store exponentially many nodes and each node contains an item-selection array of size `n`, the worst-case space complexity can be `O(n * 2^n)`.

Implementations that store only compact node information may use a different amount of memory.

## Technologies Used

* Programming Language: Java
* Algorithm: Branch and Bound
* Problem: 0/1 Knapsack
* Data Structure: Priority Queue or Queue, depending on the implementation
* Input: Runtime input using `Scanner`
* Development Environment: Visual Studio Code

The program can also be compiled and executed using other Java IDEs such as IntelliJ IDEA or Eclipse.

## Project Files

```text
Unit5_BranchAndBound/
|
|-- Project13_Knapsack_Branch_Bound.java
|-- README.md
|-- Prompt.txt
`-- Visualization.png
```

### File Description

| File                                   | Description                                                            |
| -------------------------------------- | ---------------------------------------------------------------------- |
| `Project13_Knapsack_Branch_Bound.java` | Java implementation of the 0/1 Knapsack Problem using Branch and Bound |
| `README.md`                            | Project documentation                                                  |
| `Prompt.txt`                           | Prompt used to generate the visualization                              |
| `Visualization.png`                    | State-space tree showing branching, bounds, and pruning                |

Make sure the Java filename matches the public class name in your actual code.

## Visualization

The `Visualization.png` file illustrates how Branch and Bound explores possible item selections.

The visualization should include:

* The root node representing an empty selection.
* Include and exclude branches for each item.
* The weight and profit of promising nodes.
* Upper bounds for selected nodes.
* Pruned branches that cannot improve the current best profit.
* The final optimal selection.

The overall flow is:

```text
Start with an empty selection
             |
             v
      Calculate upper bound
             |
             v
     Generate two branches
        /           \
       v             v
    Include        Exclude
       \             /
        v           v
      Check weight and bound
             |
             v
    Prune unpromising branches
             |
             v
     Update maximum profit
             |
             v
      Display best solution
```

The visualization helps explain how the algorithm searches the state-space tree and uses upper bounds to reduce unnecessary exploration.

## Learning Outcome

After completing this project, we understand:

* How the 0/1 Knapsack Problem works.
* How Branch and Bound explores possible selections.
* How include and exclude branches are generated.
* How upper bounds estimate the best possible result from a node.
* How pruning reduces unnecessary exploration.
* How a state-space tree represents the search process.
* How to determine the maximum feasible profit.
* The time and space complexity of Branch and Bound.

## Conclusion

This project implements the 0/1 Knapsack Problem using Branch and Bound in Java.

The algorithm explores possible item selections, calculates upper bounds, and prunes branches that cannot improve the best feasible solution. This can reduce the amount of work compared with examining every possible selection.

For the example used in this project:

```text
Knapsack Capacity: 7

Selected Items: Item 2 and Item 3

Total Weight: 7

Maximum Profit: 115
```

The project demonstrates how branching, bounding, and pruning can be used to solve an optimization problem while maintaining the optimal result.
=======
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
>>>>>>> 92f5d3b7052d670ef7423baddd4f2723409cb994
