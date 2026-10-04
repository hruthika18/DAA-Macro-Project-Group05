# Project 6 - Optimal Merge Pattern using Greedy Method

## Overview

The Optimal Merge Pattern is a greedy algorithm used to merge multiple files into one file with minimum total cost.

When two files are merged, the cost of merging them is equal to the sum of their sizes. The main objective is to find the order of merging the files so that the total merging cost is minimum.

In this project, the Optimal Merge Pattern is implemented using the Greedy Method and a Priority Queue.

The program does not use fixed input values. The user enters the required information at runtime.

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



