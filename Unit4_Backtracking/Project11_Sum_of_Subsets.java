import java.util.*;

public class Main {

    static int[] set;
    static int target;
    static boolean found = false;

    static void sumOfSubsets(int index, int sum, List<Integer> subset) {

        if (sum == target) {
            System.out.println("Subset: " + subset + " | Sum = " + sum);
            found = true;
            return;
        }

        if (index == set.length || sum > target)
            return;

        // Include the current element
        subset.add(set[index]);
        sumOfSubsets(index + 1, sum + set[index], subset);

        // Exclude the current element
        subset.remove(subset.size() - 1);
        sumOfSubsets(index + 1, sum, subset);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        set = new int[n];

        for (int i = 0; i < n; i++)
            set[i] = sc.nextInt();

        target = sc.nextInt();

        System.out.println("Set: " + Arrays.toString(set));
        System.out.println("Target Sum: " + target);
        System.out.println("\nValid Subsets:");

        sumOfSubsets(0, 0, new ArrayList<>());

        if (!found)
            System.out.println("No subset found.");

        sc.close();
    }
}

/*
INPUT:
3
5 10 12
15

OUTPUT:
Set: [5, 10, 12]
Target Sum: 15

Valid Subsets:
Subset: [5, 10] | Sum = 15

Time Complexity: O(2^n)
Space Complexity: O(n)
*/
