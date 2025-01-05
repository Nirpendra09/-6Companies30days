class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        int[][] dist = new int[26][26];
        for(int[] node : dist) Arrays.fill(node, Integer.MAX_VALUE);

        for(int i = 0; i < 26; i++) dist[i][i] = 0;

        for(int i = 0 ; i < cost.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for(int k = 0; k < 26; k++) {
            for(int i = 0; i < 26; i++) {
                for(int j = 0; j < 26; j++) {
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int n = source.length();
        long total = 0;
        for(int i = 0; i < n; i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';
            if(s == t) continue;

            if(dist[s][t] == Integer.MAX_VALUE) return -1;
            total += dist[s][t];
        }

        return total;
    }
}