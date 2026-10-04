import java.util.*;

public class Main {

    static int n;
    static int[][] cost;
    static int[][] dp;
    static int[][] parent;

    static int tsp(int mask, int current) {

        if (mask == (1 << n) - 1) {
            return cost[current][0];
        }

        if (dp[mask][current] != -1) {
            return dp[mask][current];
        }

        int min = Integer.MAX_VALUE;
        int nextCity = -1;

        for (int city = 0; city < n; city++) {

            if ((mask & (1 << city)) == 0) {

                int newCost = cost[current][city]
                        + tsp(mask | (1 << city), city);

                if (newCost < min) {
                    min = newCost;
                    nextCity = city;
                }
            }
        }

        dp[mask][current] = min;
        parent[mask][current] = nextCity;

        return min;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of cities
        System.out.print("Enter number of cities: ");
        n = sc.nextInt();

        // City names
        String[] city = new String[n];

        System.out.println("Enter city names:");

        for (int i = 0; i < n; i++) {
            System.out.print("City " + (i + 1) + ": ");
            city[i] = sc.next();
        }

        // Cost matrix
        cost = new int[n][n];

        System.out.println("\nEnter the cost/distance matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        // Starting city
        System.out.print("\nEnter starting city number (1-" + n + "): ");
        int start = sc.nextInt() - 1;

        // DP tables
        int totalMasks = 1 << n;

        dp = new int[totalMasks][n];
        parent = new int[totalMasks][n];

        for (int i = 0; i < totalMasks; i++) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(parent[i], -1);
        }

        /*
         * If starting city is not city 0,
         * swap it with city 0 so that the DP
         * can always start from index 0.
         */
        if (start != 0) {

            String temp = city[0];
            city[0] = city[start];
            city[start] = temp;

            for (int i = 0; i < n; i++) {
                int tempCost = cost[i][0];
                cost[i][0] = cost[i][start];
                cost[i][start] = tempCost;
            }

            for (int i = 0; i < n; i++) {
                int tempCost = cost[0][i];
                cost[0][i] = cost[start][i];
                cost[start][i] = tempCost;
            }
        }

        // Solve TSP
        int answer = tsp(1, 0);

        System.out.println("\n-----------------------------");
        System.out.println("TSP RESULT");
        System.out.println("-----------------------------");

        System.out.println("Minimum tour cost: " + answer);

        // Print optimal path
        System.out.print("Optimal tour: ");

        int mask = 1;
        int current = 0;

        System.out.print(city[current]);

        while (true) {

            int next = parent[mask][current];

            if (next == -1) {
                break;
            }

            System.out.print(" -> " + city[next]);

            mask = mask | (1 << next);
            current = next;
        }

        System.out.println(" -> " + city[0]);

        sc.close();
    }
}


/*

OUPTUT:

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
-----------------------------
TSP RESULT
-----------------------------
Minimum tour cost: 80
Optimal tour: A -> B -> D -> C -> A

*/  