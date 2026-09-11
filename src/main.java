import java.util.Scanner;
import texthack.patternmatching.Naive;
import texthack.patternmatching.KMP;
import texthack.patternmatching.RabinKarp;
import texthack.patternmatching.ZFunction;
import texthack.patternmatching.MultiPatternMatching;
import texthack.patternmatching.SuffixArrayLCP;
import texthack.dynamicprogramming.EditDistance;
import texthack.dynamicprogramming.NeedlemanWunsch;
import texthack.dynamicprogramming.SmithWaterman;
import texthack.dynamicprogramming.IntervalDP;
import texthack.dynamicprogramming.TSP;
import texthack.networkflow.FordFulkerson;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== DSA ALGORITHMS =====");
        System.out.println("1. Naive String Matching");
        System.out.println("2. KMP Algorithm");
        System.out.println("3. Rabin-Karp Algorithm");
        System.out.println("4. Z-Function");
        System.out.println("5. Multi-Pattern Matching");
        System.out.println("6. Suffix Array + LCP");
        System.out.println("7. Edit Distance");
        System.out.println("8. Needleman-Wunsch");
        System.out.println("9. Smith-Waterman");
        System.out.println("10. Interval DP");
        System.out.println("11. Bitmask DP - TSP");
        System.out.println("12. Ford-Fulkerson");

        System.out.print("\nEnter Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                System.out.print("Enter Text: ");
                String text1 = sc.nextLine();

                System.out.print("Enter Pattern: ");
                String pattern1 = sc.nextLine();

                Naive.search(text1, pattern1);
                break;

            case 2:
                System.out.print("Enter Text: ");
                String text2 = sc.nextLine();

                System.out.print("Enter Pattern: ");
                String pattern2 = sc.nextLine();

                KMP.search(text2, pattern2);
                break;

            case 3:
                System.out.print("Enter Text: ");
                String text3 = sc.nextLine();

                System.out.print("Enter Pattern: ");
                String pattern3 = sc.nextLine();

                RabinKarp.search(text3, pattern3);
                break;

            case 4:
                System.out.print("Enter Text: ");
                String text4 = sc.nextLine();

                System.out.print("Enter Pattern: ");
                String pattern4 = sc.nextLine();

                ZFunction.search(text4, pattern4);
                break;

            case 5:
                System.out.print("Enter Text: ");
                String text5 = sc.nextLine();

                System.out.print("Enter Number of Patterns: ");
                int n1 = sc.nextInt();
                sc.nextLine();

                String[] patterns = new String[n1];

                for (int i = 0; i < n1; i++) {
                    System.out.print("Enter Pattern " + (i + 1) + ": ");
                    patterns[i] = sc.nextLine();
                }

                MultiPatternMatching.search(text5, patterns);
                break;

            case 6:
                System.out.print("Enter Text: ");
                String text6 = sc.nextLine();

                SuffixArrayLCP.search(text6);
                break;

            case 7:
                System.out.print("Enter First String: ");
                String a1 = sc.nextLine();

                System.out.print("Enter Second String: ");
                String b1 = sc.nextLine();

                System.out.println("Edit Distance: " +
                        EditDistance.editDistance(a1, b1));
                break;

            case 8:
                System.out.print("Enter First Sequence: ");
                String a2 = sc.nextLine();

                System.out.print("Enter Second Sequence: ");
                String b2 = sc.nextLine();

                NeedlemanWunsch.align(a2, b2);
                break;

            case 9:
                System.out.print("Enter First Sequence: ");
                String a3 = sc.nextLine();

                System.out.print("Enter Second Sequence: ");
                String b3 = sc.nextLine();

                SmithWaterman.align(a3, b3);
                break;

            case 10:
                System.out.print("Enter Number of Matrices: ");
                int n2 = sc.nextInt();

                int[] p = new int[n2 + 1];

                System.out.println("Enter Matrix Dimensions:");

                for (int i = 0; i <= n2; i++) {
                    p[i] = sc.nextInt();
                }

                System.out.println("Minimum Multiplication Cost: " +
                        IntervalDP.matrixChain(p));
                break;

            case 11:
                System.out.print("Enter Number of Cities: ");
                int n3 = sc.nextInt();

                int[][] cost = new int[n3][n3];

                System.out.println("Enter Cost Matrix:");

                for (int i = 0; i < n3; i++) {
                    for (int j = 0; j < n3; j++) {
                        cost[i][j] = sc.nextInt();
                    }
                }

                System.out.println("Minimum TSP Cost: " +
                        TSP.solve(cost));
                break;

            case 12:
                System.out.print("Enter Number of Vertices: ");
                int v = sc.nextInt();

                int[][] graph = new int[v][v];

                System.out.print("Enter Number of Edges: ");
                int e = sc.nextInt();

                System.out.println("Enter Source Destination Capacity:");

                for (int i = 0; i < e; i++) {
                    int u = sc.nextInt();
                    int w = sc.nextInt();
                    int capacity = sc.nextInt();

                    graph[u][w] = capacity;
                }

                System.out.print("Enter Source: ");
                int source = sc.nextInt();

                System.out.print("Enter Sink: ");
                int sink = sc.nextInt();

                FordFulkerson.findMaxFlow(graph, source, sink);
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}