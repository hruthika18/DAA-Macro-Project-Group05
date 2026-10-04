import java.util.*;

public class OptimalMergePattern {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of files: ");
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        System.out.println("Enter file sizes:");

        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }

        int totalCost = 0;

        while (pq.size() > 1) {
            int a = pq.remove();
            int b = pq.remove();

            int cost = a + b;
            totalCost = totalCost + cost;

            pq.add(cost);
        }

        System.out.println("Minimum merge cost = " + totalCost);

        sc.close();
    }
}