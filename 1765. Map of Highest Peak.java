class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] matrix = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isWater[i][j] == 1) {
                    q.add(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }


        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int[] d : dirs) {
                int x = r + d[0];
                int y = c + d[1];

                if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] == -1) {
                    matrix[x][y] = matrix[r][c] + 1;

                    q.add(new int[] {x, y});
                }
            }
        }

        return matrix;
    }
}