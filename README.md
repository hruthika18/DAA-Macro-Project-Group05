# DAA Macro Project – Group 05

A collection of Design and Analysis of Algorithms (DAA) macro projects implemented as part of our Computer Science and Engineering coursework. This repository brings together five algorithmic problems, organized by unit, with source code and project-specific documentation.

## About the Project

The purpose of this repository is to understand how different algorithm design techniques work by applying them to practical problems. Each project focuses on an algorithm, its step-by-step execution, and analysis of its time and space complexity.

## Projects Included

| Unit | Project | Algorithmic Technique | Folder |
|---|---|---|---|
| Unit I | **Project 2 – Merge Sort Recursion Tree** | Divide and Conquer / Recursion | [`Unit1_AlgorithmAnalysis`](Unit1_AlgorithmAnalysis/) |
| Unit II | **Project 6 – Optimal Merge Pattern Tree** | Greedy Algorithm | [`Unit2_DivideAndConquer_Greedy`](Unit2_DivideAndConquer_Greedy/) |
| Unit III | **Project 7 – Travelling Salesperson Problem using Dynamic Programming** | Dynamic Programming and Bitmasking | [`Unit3_DynamicProgramming`](Unit3_DynamicProgramming/) |
| Unit IV | **Project 11 – Sum of Subsets Tree** | Backtracking | [`Unit4_Backtracking`](Unit4_Backtracking/) |
| Unit V | **Project 13 – 0/1 Knapsack using Branch and Bound** | Branch and Bound | [`Unit5_BranchAndBound`](Unit5_BranchAndBound/) |

Open each unit folder for the corresponding source code and project documentation.

## Project Summaries

### Unit I – Merge Sort Recursion Tree

Merge Sort uses the divide-and-conquer technique. It repeatedly divides an array into smaller subarrays, sorts them recursively, and merges the sorted subarrays. The recursion tree helps illustrate how the problem is divided and how the recursive calls are organized.

### Unit II – Optimal Merge Pattern Tree

The Optimal Merge Pattern combines multiple sorted files or lists with the minimum total merge cost. A greedy strategy repeatedly merges the two smallest files first. The merge tree represents the order of merging and the cost at each step.

### Unit III – Travelling Salesperson Problem using Dynamic Programming

The Travelling Salesperson Problem seeks a minimum-cost tour that visits every city once and returns to the starting city. The project uses dynamic programming with bitmasking to represent visited cities, calculate subproblem costs, and determine an optimal tour.

### Unit IV – Sum of Subsets Tree

The Sum of Subsets problem finds subsets of a given set whose elements add up to a specified target. Backtracking explores choices to include or exclude elements and prunes branches that cannot lead to a valid solution. The state-space tree shows these decisions.

### Unit V – 0/1 Knapsack using Branch and Bound

The 0/1 Knapsack problem selects items with given weights and profits without exceeding a capacity limit. Branch and Bound explores promising choices and uses an upper-bound estimate to avoid exploring branches that cannot improve the best solution found.

## Repository Structure

```text
DAA-Macro-Project-Group05/
├── Unit1_AlgorithmAnalysis/
│   ├── README.md
│   └── Merge Sort project files
├── Unit2_DivideAndConquer_Greedy/
│   ├── README.md
│   └── Optimal Merge Pattern project files
├── Unit3_DynamicProgramming/
│   ├── README.md
│   └── Travelling Salesperson Problem project files
├── Unit4_Backtracking/
│   ├── README.md
│   └── Sum of Subsets project files
├── Unit5_BranchAndBound/
│   ├── README.md
│   └── Knapsack project files
└── README.md
```

*The names shown as “project files” above describe the contents; consult each folder for the exact filenames.*

## Technologies Used

- **Java** for algorithm implementation
- **Git and GitHub** for version control and collaboration
- **Markdown** for project documentation

## How to Use This Repository

1. Open the folder for the unit or algorithm you want to study.
2. Read that folder's `README.md` for the problem statement, algorithm explanation, pseudocode, examples, and complexity analysis.
3. Open the Java source file in the same folder.
4. Compile and run the program using a JDK, following any input instructions in the project documentation.

For a Java source file whose public class name matches its filename, a typical command sequence is:

```bash
javac FileName.java
java ClassName
```

Replace `FileName.java` and `ClassName` with the actual names used by the project.

## Learning Objectives

Through these projects, we aim to:

- Understand divide-and-conquer, greedy, dynamic programming, backtracking, and branch-and-bound techniques.
- Translate algorithmic ideas into working Java programs.
- Trace recursive calls, dynamic programming states, decision trees, and search spaces.
- Analyze time and space complexity.
- Document algorithms using explanations, pseudocode, and sample inputs and outputs.
- Collaborate using Git and GitHub.

## Team

**Group 05 (G5)**

This repository is maintained collaboratively by the project group. Each unit contains its own documentation and implementation files.

## Conclusion

These five projects demonstrate how different algorithm design techniques can be used to solve computational problems. Studying their execution, decision structures, and complexity helps connect theoretical concepts from DAA with practical implementation.
