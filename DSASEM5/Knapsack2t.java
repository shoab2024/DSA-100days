import java.util.Arrays;
import java.util.Scanner;

public class Knapsack2t{

    static final long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long W = sc.nextLong();

        int[] value = new int[n];
        int[] weight = new int[n];

        int totalValue = 0;

        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
            weight[i] = sc.nextInt();
            totalValue += value[i];
        }

        // dp[v] = minimum weight required to get value v
        long[] dp = new long[totalValue + 1];

        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            // Go backwards because this is 0/1 Knapsack
            for (int v = totalValue; v >= value[i]; v--) {

                dp[v] = Math.min(
                    dp[v],
                    dp[v - value[i]] + weight[i]
                );
            }
        }

        int answer = 0;

        for (int v = 0; v <= totalValue; v++) {
            if (dp[v] <= W) {
                answer = v;
            }
        }

        System.out.println(answer);
    }
}
