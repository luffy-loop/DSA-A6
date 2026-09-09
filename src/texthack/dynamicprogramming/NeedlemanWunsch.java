package texthack.dynamicprogramming;

import java.util.Scanner;

public class NeedlemanWunsch {

    static void align(String a, String b) {

        int m = a.length();
        int n = b.length();

        int match = 1;
        int mismatch = -1;
        int gap = -2;

        int[][] dp = new int[m + 1][n + 1];

        // Initialize first row and first column
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i * gap;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j * gap;
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                int diagonal = dp[i - 1][j - 1]
                        + (a.charAt(i - 1) == b.charAt(j - 1)
                        ? match : mismatch);

                int up = dp[i - 1][j] + gap;
                int left = dp[i][j - 1] + gap;

                dp[i][j] = Math.max(diagonal, Math.max(up, left));
            }
        }

        // Traceback
        StringBuilder alignedA = new StringBuilder();
        StringBuilder alignedB = new StringBuilder();

        int i = m;
        int j = n;

        while (i > 0 || j > 0) {

            if (i > 0 && j > 0 &&
                    dp[i][j] == dp[i - 1][j - 1]
                            + (a.charAt(i - 1) == b.charAt(j - 1)
                            ? match : mismatch)) {

                alignedA.append(a.charAt(i - 1));
                alignedB.append(b.charAt(j - 1));

                i--;
                j--;

            } else if (i > 0 && dp[i][j] == dp[i - 1][j] + gap) {

                alignedA.append(a.charAt(i - 1));
                alignedB.append('-');

                i--;

            } else {

                alignedA.append('-');
                alignedB.append(b.charAt(j - 1));

                j--;
            }
        }

        System.out.println("\nOptimal Alignment:");
        System.out.println(alignedA.reverse());
        System.out.println(alignedB.reverse());

        System.out.println("\nAlignment Score: " + dp[m][n]);
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