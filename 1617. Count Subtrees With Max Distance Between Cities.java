class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u][v] = graph[v][u] = 1;
        }

        int[] res = new int[n - 1];

        for (int state = 0; state < (1 << n); state++) {
            if (Integer.bitCount(state) < 2)
                continue;

            int diameter = getSubtreeDiameter(state, graph, n);
            if (diameter > 0) {
                res[diameter - 1]++;
            }
        }

        return res;
    }

    private int getSubtreeDiameter(int state, int[][] graph, int n) {
        int edges = 0;
        for (int i = 0; i < n; i++) {
            if ((state & (1 << i)) == 0)
                continue;
            for (int j = i + 1; j < n; j++) {
                if ((state & (1 << j)) != 0 && graph[i][j] == 1) {
                    edges++;
                }
            }
        }

        if (edges != Integer.bitCount(state) - 1)
            return 0;

        int maxDist = 0;
        for (int i = 0; i < n; i++) {
            if ((state & (1 << i)) != 0) {
                int dist = bfs(i, state, graph, n);
                maxDist = Math.max(maxDist, dist);
            }
        }

        return maxDist;
    }

    private int bfs(int start, int state, int[][] graph, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        dist[start] = 0;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next = 0; next < n; next++) {
                if (graph[curr][next] == 1 && (state & (1 << next)) != 0 && dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    maxDist = Math.max(maxDist, dist[next]);
                    queue.offer(next);
                }
            }
        }

        return maxDist;
    }
}