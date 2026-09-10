package texthack.dynamicprogramming;

import java.util.Scanner;

public class SmithWaterman {

    static void align(String a, String b) {

        int m = a.length();
        int n = b.length();

        int match = 2;
        int mismatch = -1;
        int gap = -2;

        int[][] dp = new int[m + 1][n + 1];

        int maxScore = 0;
        int maxI = 0;
        int maxJ = 0;

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                int diagonal = dp[i - 1][j - 1]
                        + (a.charAt(i - 1) == b.charAt(j - 1)
                        ? match : mismatch);

                int up = dp[i - 1][j] + gap;
                int left = dp[i][j - 1] + gap;

                // Local alignment can start anywhere
                dp[i][j] = Math.max(
                        0,
                        Math.max(diagonal, Math.max(up, left))
                );

                if (dp[i][j] > maxScore) {
                    maxScore = dp[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        // Traceback from highest-scoring cell
        StringBuilder alignedA = new StringBuilder();
        StringBuilder alignedB = new StringBuilder();

        int i = maxI;
        int j = maxJ;

        while (i > 0 && j > 0 && dp[i][j] > 0) {

            if (dp[i][j] == dp[i - 1][j - 1]
                    + (a.charAt(i - 1) == b.charAt(j - 1)
                    ? match : mismatch)) {

                alignedA.append(a.charAt(i - 1));
                alignedB.append(b.charAt(j - 1));

                i--;
                j--;

            } else if (dp[i][j] == dp[i - 1][j] + gap) {

                alignedA.append(a.charAt(i - 1));
                alignedB.append('-');

                i--;

            } else {

                alignedA.append('-');
                alignedB.append(b.charAt(j - 1));

                j--;
            }
        }

        System.out.println("\nBest Local Alignment:");
        System.out.println(alignedA.reverse());
        System.out.println(alignedB.reverse());

        System.out.println("\nAlignment Score: " + maxScore);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first sequence: ");
        String a = sc.nextLine();

        System.out.print("Enter second sequence: ");
        String b = sc.nextLine();

        align(a, b);

        sc.close();
    }
}