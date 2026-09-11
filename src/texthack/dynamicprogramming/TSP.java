package texthack.dynamicprogramming;

public class TSP {

    public static int solve(int[][] cost) {

        int n = cost.length;
        int size = 1 << n;
        int[][] dp = new int[size][n];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[1][0] = 0;

        for (int mask = 1; mask < size; mask++) {

            for (int u = 0; u < n; u++) {

                if ((mask & (1 << u)) == 0 ||
                        dp[mask][u] == Integer.MAX_VALUE) {
                    continue;
                }

                for (int v = 0; v < n; v++) {

                    if ((mask & (1 << v)) == 0) {

                        int next = mask | (1 << v);

                        dp[next][v] = Math.min(
                                dp[next][v],
                                dp[mask][u] + cost[u][v]
                        );
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        int full = size - 1;

        for (int i = 1; i < n; i++) {
            ans = Math.min(
                    ans,
                    dp[full][i] + cost[i][0]
            );
        }

        return ans;
    }
}