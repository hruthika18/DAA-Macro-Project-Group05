import java.util.*;

class Item {
    int weight, profit, id;
    double ratio;

    Item(int weight, int profit, int id) {
        this.weight = weight;
        this.profit = profit;
        this.id = id;
        this.ratio = (double) profit / weight;
    }
}

class Node {
    int level, weight, profit;
    double bound;
    boolean[] selected;

    Node(int level, int weight, int profit, boolean[] selected) {
        this.level = level;
        this.weight = weight;
        this.profit = profit;
        this.selected = selected;
    }
}

public class Project8_Knapsack_Branch_Bound {

    static double calculateBound(Node u, int n, int capacity, Item[] items) {
        if (u.weight > capacity)
            return 0;

        double result = u.profit;
        int totalWeight = u.weight;
        int j = u.level + 1;

        while (j < n && totalWeight + items[j].weight <= capacity) {
            totalWeight += items[j].weight;
            result += items[j].profit;
            j++;
        }

        if (j < n)
            result += (capacity - totalWeight) * items[j].ratio;

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter weight and profit of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            int weight = sc.nextInt();
            int profit = sc.nextInt();
            items[i] = new Item(weight, profit, i + 1);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        Queue<Node> queue = new LinkedList<>();

        Node root = new Node(-1, 0, 0, new boolean[n]);
        root.bound = calculateBound(root, n, capacity, items);
        queue.add(root);

        int maxProfit = 0;
        boolean[] bestSelection = new boolean[n];

        int nodesProcessed = 0;

        while (!queue.isEmpty()) {
            Node u = queue.poll();
            nodesProcessed++;

            if (u.level == n - 1 || u.bound <= maxProfit)
                continue;

            int i = u.level + 1;

            // Include current item
            Node include = new Node(
                i,
                u.weight + items[i].weight,
                u.profit + items[i].profit,
                u.selected.clone()
            );

            include.selected[i] = true;

            if (include.weight <= capacity && include.profit > maxProfit) {
                maxProfit = include.profit;
                bestSelection = include.selected.clone();
            }

            include.bound = calculateBound(include, n, capacity, items);

            if (include.weight <= capacity && include.bound > maxProfit)
                queue.add(include);

            // Exclude current item
            Node exclude = new Node(
                i, u.weight, u.profit, u.selected.clone()
            );

            exclude.bound = calculateBound(exclude, n, capacity, items);

            if (exclude.bound > maxProfit)
                queue.add(exclude);
        }

        int totalWeight = 0;

        System.out.println("\n-----------------------------");
        System.out.println("KNAPSACK BRANCH AND BOUND RESULT");
        System.out.println("-----------------------------");

        System.out.println("Selected Items:");

        for (int i = 0; i < n; i++) {
            if (bestSelection[i]) {
                System.out.println("Item " + items[i].id
                    + " - Weight: " + items[i].weight
                    + ", Profit: " + items[i].profit);

                totalWeight += items[i].weight;
            }
        }

        System.out.println("Maximum Profit: " + maxProfit);
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Nodes Processed: " + nodesProcessed);

        sc.close();
    }
}

/*
OUTPUT:

Enter number of items: 4
Enter weight and profit of each item:
Item 1: 2 40
Item 2: 3 50
Item 3: 4 65
Item 4: 5 70
Enter knapsack capacity: 7

-----------------------------
KNAPSACK BRANCH AND BOUND RESULT
-----------------------------
Selected Items:
Item 2 - Weight: 3, Profit: 50
Item 3 - Weight: 4, Profit: 65
Maximum Profit: 115
Total Weight: 7
Nodes Processed: 10

*/
