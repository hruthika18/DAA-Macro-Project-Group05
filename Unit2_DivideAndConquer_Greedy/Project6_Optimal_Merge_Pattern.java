import java.util.*;

public class Project6_Optimal_Merge_Pattern {

    static int n;
    static PriorityQueue<Integer> files;

    static int optimalMerge() {

        int totalCost = 0;

        while (files.size() > 1) {

            int first = files.remove();
            int second = files.remove();

            int mergeCost = first + second;

            totalCost = totalCost + mergeCost;

            files.add(mergeCost);
        }

        return totalCost;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of files: ");
        n = sc.nextInt();

        files = new PriorityQueue<>();

        System.out.println("Enter file sizes:");

        for (int i = 0; i < n; i++) {

            System.out.print("File " + (i + 1) + ": ");

            files.add(sc.nextInt());
        }

        int answer = optimalMerge();

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("OPTIMAL MERGE PATTERN RESULT");
        System.out.println("-----------------------------");
        System.out.println("Minimum merge cost: " + answer);

        sc.close();
    }
}

/*
OUTPUT:

Enter number of files: 4
Enter file sizes:
File 1: 5
File 2: 10
File 3: 20
File 4: 30

-----------------------------
OPTIMAL MERGE PATTERN RESULT
-----------------------------

Minimum merge cost: 115

*/