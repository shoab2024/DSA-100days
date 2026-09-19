import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final long INF = Long.MAX_VALUE / 4;

    static long solve(int[] v, int[] w, int idx, int value, long[][] dp) {

        if (value == 0)
            return 0;

        if (idx == 0)
            return INF;

        if (dp[idx][value] != -1)
            return dp[idx][value];

        // Don't take the item
        long notTake = solve(v, w, idx - 1, value, dp);

        // Take the item
        long take = INF;

        if (value >= v[idx - 1]) {
            long previous =
                solve(v, w, idx - 1,
                      value - v[idx - 1], dp);

            if (previous != INF) {
                take = w[idx - 1] + previous;
            }
        }

        return dp[idx][value] = Math.min(take, notTake);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long W = sc.nextLong();

        int[] v = new int[n];
        int[] w = new int[n];

        int totalValue = 0;

        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();

            totalValue += v[i];
        }

        long[][] dp = new long[n + 1][totalValue + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int answer = 0;

        for (int value = 0; value <= totalValue; value++) {
            if (solve(v, w, n, value, dp) <= W) {
                answer = value;
            }
        }

        System.out.println(answer);
    }
}
