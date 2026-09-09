import java.io.*;
import java.util.*;

public class Projects {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) {
                    return -1;
                }
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int res = 0;

            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }

            return res * sign;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();

        int n = fs.nextInt();

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = fs.nextInt(); // start
            arr[i][1] = fs.nextInt(); // end
            arr[i][2] = fs.nextInt(); // reward
        }

        // Sort by ending time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {

            // Skip current project
            long skip = (i == 0) ? 0 : dp[i - 1];

            // Select current project
            long select = arr[i][2];

            // Binary search for last project with
            // end < current project's start
            int low = 0;
            int high = i - 1;
            int ans = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (arr[mid][1] < arr[i][0]) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (ans != -1) {
                select += dp[ans];
            }

            dp[i] = Math.max(skip, select);
        }

        System.out.println(dp[n - 1]);
    }
}