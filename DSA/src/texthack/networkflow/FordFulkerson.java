package texthack.networkflow;

import java.util.*;

public class FordFulkerson {

    static boolean bfs(int[][] r, int s, int t, int[] p) {

        int n = r.length;
        boolean[] v = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        v[s] = true;
        p[s] = -1;

        while (!q.isEmpty()) {

            int u = q.poll();

            for (int x = 0; x < n; x++) {

                if (!v[x] && r[u][x] > 0) {
                    q.add(x);
                    p[x] = u;
                    v[x] = true;
                }
            }
        }

        return v[t];
    }

    public static void findMaxFlow(int[][] graph, int s, int t) {

        int n = graph.length;
        int[][] r = new int[n][n];

        for (int i = 0; i < n; i++) {
            r[i] = graph[i].clone();
        }

        int[] p = new int[n];
        int maxFlow = 0;

        while (bfs(r, s, t, p)) {

            int flow = Integer.MAX_VALUE;

            for (int v = t; v != s; v = p[v]) {
                int u = p[v];
                flow = Math.min(flow, r[u][v]);
            }

            for (int v = t; v != s; v = p[v]) {
                int u = p[v];

                r[u][v] -= flow;
                r[v][u] += flow;
            }

            maxFlow += flow;
        }

        System.out.println("Maximum Flow: " + maxFlow);
    }
}