# Project 7 : Travelling Salesperson Problem using Dynamic Programming

## Overview

The Travelling Salesperson Problem (TSP) is a well-known optimization problem in which a salesperson has to visit every city exactly once, return to the city they started from, and find the route with the minimum possible travel cost.

In this project, TSP is solved using Dynamic Programming and bitmasking. The program does not use fixed input values. The user enters the required information at runtime.

The user can enter:

- Number of cities
- City names
- Distance or cost matrix
- Starting city

The program then calculates the minimum tour cost and displays the optimal tour.

## Objective

The main objectives of this project are:

1. Understand the Travelling Salesperson Problem.
2. Implement TSP using Dynamic Programming.
3. Understand DP states and state transitions.
4. Use bitmasking to represent visited cities.
5. Find the minimum-cost tour.
6. Display the optimal route.

## Algorithm

The solution uses Dynamic Programming with bitmasking to keep track of the cities that have already been visited.

### 1. Problem Definition

Given `n` cities and a cost matrix `cost[i][j]`, the objective is to find a route that starts from a selected city, visits every other city exactly once, returns to the starting city, and has the minimum possible total cost.

The program assumes that:

- Every pair of cities has a travel cost.
- The travel costs are non-negative.
- The cost from a city to itself is 0.
- The cost matrix can also represent different costs in different directions.

### 2. Why Dynamic Programming is Used

A simple solution would be to generate every possible route and calculate its cost. The number of possible routes increases very quickly as the number of cities increases.

Many different routes can also contain the same smaller set of cities. Calculating the same part repeatedly is unnecessary.

Dynamic Programming avoids this repeated work by storing the result of each state and reusing it whenever the same state occurs again.

This implementation uses the top-down Dynamic Programming approach with memoization.

### 3. DP State

The main DP state used in the program is:

```text
dp[mask][current]
```

Here:

- `mask` represents the cities that have already been visited.
- `current` represents the city where the salesperson is currently located.
- `dp[mask][current]` stores the minimum cost for reaching the current city after visiting all the cities represented by the mask.

### 4. Bitmask Representation

Each city is represented by one bit.

For four cities:

```text
A = 0001
B = 0010
C = 0100
D = 1000
```

Some possible masks are:

```text
0001 -> A visited
0011 -> A and B visited
0101 -> A and C visited
1001 -> A and D visited
0111 -> A, B and C visited
1011 -> A, B and D visited
1111 -> A, B, C and D visited
```

For example:

```text
mask & (1 << j)
```

checks whether city `j` is already visited.

To mark city `j` as visited:

```text
mask | (1 << j)
```

When all cities have been visited:

```text
(1 << n) - 1
```

represents the full mask.

### 5. DP State Transition

Suppose the salesperson is currently at city `i` and wants to move to an unvisited city `j`.

The new cost is calculated as:

```text
newCost = dp[mask][i] + cost[i][j]
```

The new mask is:

```text
newMask = mask | (1 << j)
```

The DP table is then updated:

```text
dp[newMask][j] = min(dp[newMask][j], newCost)
```

In the recursive implementation, the program tries every unvisited city and calculates the minimum possible cost.

If the same state is reached again, its stored value is returned instead of calculating it again.

### 6. Base Case

The initial state contains only the starting city.

For example, if A is the starting city:

```text
dp[0001][A] = 0
```

When all cities have been visited, the salesperson has to return to the starting city.

The full mask is:

```text
mask = (1 << n) - 1
```

The program then adds the cost of travelling from the current city back to the starting city.

In the implementation, the selected starting city is placed at index 0, so the return cost is:

```text
cost[current][0]
```

### 7. Pseudocode

```text
TSP(mask, current):

    if all cities are visited:
        return cost[current][start]

    if dp[mask][current] is already calculated:
        return dp[mask][current]

    minimum = infinity
    nextCity = -1

    for every city j:

        if city j is not visited:

            newMask = mask | (1 << j)

            newCost = cost[current][j]
                       + TSP(newMask, j)

            if newCost is smaller than minimum:

                minimum = newCost
                nextCity = j

    dp[mask][current] = minimum
    parent[mask][current] = nextCity

    return minimum
```

After calculating the minimum cost, the `parent` table is used to reconstruct the optimal route.

## Input

The program reads all the required information at runtime.

### 1. Number of Cities

```text
Enter number of cities: 4
```

### 2. City Names

```text
City 1: A
City 2: B
City 3: C
City 4: D
```

### 3. Distance Matrix

```text
0 10 15 20
10 0 35 25
15 35 0 30
20 25 30 0
```

### 4. Starting City

```text
Enter starting city number (1-4): 1
```

## Example

### Input

```text
Enter number of cities: 4

Enter city names:
City 1: A
City 2: B
City 3: C
City 4: D

Enter the cost/distance matrix:
0 10 15 20
10 0 35 25
15 35 0 30
20 25 30 0

Enter starting city number (1-4): 1
```

### Output

```text
-----------------------------
TSP RESULT
-----------------------------
Minimum tour cost: 80
Optimal tour: A -> B -> D -> C -> A
```

The total cost is:

```text
10 + 25 + 30 + 15 = 80
```

## Step-by-Step DP Example

Consider the starting city as A.

Initially:

```text
dp[0001][A] = 0
```

Visit B:

```text
A -> B = 10

dp[0011][B] = 10
```

From B, visit C:

```text
B -> C = 35

dp[0111][C] = 10 + 35
            = 45
```

The algorithm continues for the other possible combinations.

For the example matrix, some important DP states are:

| Mask | Visited Cities | Current City | DP Value |
|------|----------------|--------------|----------|
| 0001 | A | A | 0 |
| 0011 | A, B | B | 10 |
| 0101 | A, C | C | 15 |
| 1001 | A, D | D | 20 |
| 0111 | A, B, C | B | 50 |
| 0111 | A, B, C | C | 45 |
| 1011 | A, B, D | B | 45 |
| 1011 | A, B, D | D | 35 |
| 1101 | A, C, D | C | 50 |
| 1101 | A, C, D | D | 45 |

When all cities have been visited:

```text
1111
```

The final possible states are:

| Last City | DP Value | Cost Back to A | Total |
|-----------|----------|----------------|-------|
| B | 70 | 10 | 80 |
| C | 65 | 15 | 80 |
| D | 75 | 20 | 95 |

The minimum cost is 80.

One optimal route is:

```text
A -> B -> D -> C -> A
```

Another route with the same cost is:

```text
A -> C -> D -> B -> A
```

The program reports:

```text
Optimal Tour: A -> B -> D -> C -> A
Cost: 80
```

## Complexity

For `n` cities:

### Time Complexity

```text
O(n^2 * 2^n)
```

There are up to `2^n` possible subsets and up to `n` possible current cities. Each state can check up to `n` next cities.

### Space Complexity

```text
O(n * 2^n)
```

The DP table stores values for different combinations of visited cities and current cities. The parent table used to reconstruct the route has the same size.

The number of states grows exponentially, so this method is mainly suitable for a relatively small number of cities.

## Technologies Used

- Programming Language: Java
- Algorithm: Dynamic Programming
- Technique: Bitmasking
- Input: Runtime input using `Scanner`
- Development Environment: Visual Studio Code

The program can also be compiled and executed using IntelliJ IDEA or Eclipse.

## Project Files

```text
Unit3_DynamicProgramming/
|
|-- Project7_TSP_DP.java
|-- README.md
|-- Pseudocode.txt
|-- Prompt.txt
`-- Visualization.png
```

### File Description

| File | Description |
|------|-------------|
| `Project7_TSP_DP.java` | Java implementation of TSP using Dynamic Programming |
| `README.md` | Project documentation |
| `Pseudocode.txt` | Algorithm and pseudocode |
| `Prompt.txt` | Prompt used to generate the visualization |
| `Visualization.png` | Visualization of DP states and transitions |

## Visualization

The `Visualization.png` file shows how the DP states change as different cities are visited.

The main flow is:

```text
Start at the selected city
        |
        v
Create the initial DP state
        |
        v
Choose an unvisited city
        |
        v
Calculate the new cost
        |
        v
Update the DP state
        |
        v
Repeat for different combinations
        |
        v
All cities visited
        |
        v
Return to the starting city
        |
        v
Find the minimum cost
        |
        v
Display the optimal tour
```

The visualization focuses on the DP state transitions for the four-city example.

## Learning Outcome

After completing this project, we understand:

- How the Travelling Salesperson Problem works.
- Why a brute-force solution becomes expensive as the number of cities increases.
- How Dynamic Programming avoids repeated calculations.
- How bitmasking can represent visited cities.
- How DP states are formed and updated.
- How the optimal route can be reconstructed using a parent table.
- The time and space complexity of the Dynamic Programming solution.
- The limitations of the approach when the number of cities becomes large.

## Conclusion

This project solves the Travelling Salesperson Problem using Dynamic Programming and bitmasking.

Instead of calculating the same states repeatedly, the program stores the results of already calculated states and uses them when required. The parent table is used to find the actual route after the minimum cost has been calculated.

For the example used in this project:

```text
Optimal Tour: A -> B -> D -> C -> A
Minimum Cost: 80
```

This project helped us understand Dynamic Programming, bitmasking, DP state transitions, and route reconstruction through a practical implementation of TSP.
