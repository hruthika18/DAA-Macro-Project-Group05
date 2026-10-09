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

