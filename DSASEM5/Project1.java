import java.util.Arrays;
import java.util.Scanner;

public class Project1 {
    public static class Project {
        long start, end, reward;
        Project(long start, long end, long reward) {
            this.start = start;
            this.end = end;
            this.reward = reward;
        }
    }
    public static int binarySearch(Project[] projects, int right, long start) {
        int low = 0;
        int high = right - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (projects[mid].end < start) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
    static long solve(Project[] projects, int i,long dp[]) {
        if (i < 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        long notTake = solve(projects, i - 1,dp);
        int j = binarySearch(projects, i, projects[i].start);
        long take = projects[i].reward + solve(projects, j,dp);
        return dp[i] =Math.max(take, notTake);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Project[] projects = new Project[n];
        long dp[]=new long[n];
        Arrays.fill(dp,-1);
        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long p = sc.nextLong();

            projects[i] = new Project(a, b, p);
        }
        Arrays.sort(projects, (x, y) -> Long.compare(x.end, y.end));
        System.out.println(solve(projects,n-1,dp));
    }
}