# Project 11: Sum of Subsets using Backtracking

## Overview

The Sum of Subsets problem is a classic problem in Design and Analysis of Algorithms (DAA). It involves finding a subset of given numbers whose sum equals a specified target value.

This project uses the **Backtracking technique** to explore possible subsets by including or excluding each element.

## Objective

- Find subsets whose sum equals the target value.
- Understand the Backtracking technique.
- Represent the solution using a State Space Tree.
- Learn how to prune unnecessary branches.

## Algorithm

### Problem Definition

Given a set of positive integers `{5, 10, 12}` and a target sum of `15`, find a subset whose elements add up to the target.

**Input:**
- Set: `{5, 10, 12}`
- Target Sum: `15`

**Expected Solution:**
- Subset: `{5, 10}`
- Sum: `5 + 10 = 15`

### Backtracking Technique

Backtracking explores possible solutions by making decisions at each step.

For every element, there are two choices:

1. **Include:** Add the element to the current subset.
2. **Exclude:** Skip the element and continue with the remaining elements.

If the current sum exceeds the target, that branch is stopped because all elements are positive.

### Algorithm Steps

1. Start with an empty subset and sum `0`.
2. Select the next element.
3. Create an inclusion branch and add the element to the subset.
4. Create an exclusion branch without adding the element.
5. If the sum equals the target, display the subset.
6. If the sum exceeds the target, stop exploring that branch.
7. Continue until all possible subsets are explored.

### Pseudocode

SUM_OF_SUBSETS(index, sum, subset):
    If sum == target:
        Display subset
        Return

    If index == number of elements OR sum > target:
        Return

    Include the current element
    SUM_OF_SUBSETS(index + 1, new sum, subset)

    Remove the current element

    Exclude the current element
    SUM_OF_SUBSETS(index + 1, sum, subset)
Input
3
5 10 12
15

Input Explanation:

3 — Number of elements.
5 10 12 — Elements of the set.
15 — Target sum.
Output
Set: [5, 10, 12]
Target Sum: 15

Valid Subsets:
Subset: [5, 10] | Sum = 15
Step-by-Step Example

Given set: {5, 10, 12}
Target sum: 15

Step	Decision	Current Subset	Sum	Result
1	Include 5	{5}	5	Continue
2	Include 10	{5, 10}	15	Solution found
3	Explore remaining branches	Varies	Varies	Backtracking

The subset {5, 10} is a valid solution because its sum equals 15.

State Space Tree

The state space tree represents the inclusion and exclusion choices for each element.

Each node represents the current sum and selected subset.
The left branch represents including an element.
The right branch represents excluding an element.
A node with sum 15 represents a solution.
A branch with sum greater than 15 can be pruned.
Complexity Analysis

Time Complexity: O(2^n)

Each element has two choices: include or exclude. Therefore, the number of possible subsets can be up to 2^n.

Space Complexity: O(n)

The recursive call stack and current subset require space proportional to the number of elements.

Technologies Used
Programming Language: Java
Algorithm Technique: Backtracking
Concepts: Recursion, State Space Tree, Branch Pruning
Project Files
Unit4_Backtracking/
│
├── Project11_SumOfSubsets.java
├── Prompt.txt
├── README.md
└── Visualization.png
Visualization

The visualization illustrates the state space tree for finding a subset of {5, 10, 12} whose sum is 15.

It highlights:

Include and exclude branches.
The current sum at each node.
The valid subset {5, 10}.
Branches that are pruned or do not produce a solution.
Learning Outcomes
Understand the Backtracking algorithm.
Learn how to generate subsets using recursion.
Visualize inclusion and exclusion decisions using a state space tree.
Understand how pruning reduces unnecessary exploration.
Conclusion

The Sum of Subsets problem demonstrates how Backtracking can systematically explore possible combinations to find a target sum. For the given set {5, 10, 12} and target 15, the algorithm identifies {5, 10} as the valid subset.
