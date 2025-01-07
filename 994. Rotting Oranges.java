class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int orange_count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) q.add(new int[]{i, j});
                if(grid[i][j] != 0) orange_count++;
            }
        }

        if(orange_count == 0) return 0;
        int time = 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int count = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            count += size;

            for(int i = 0; i < size; i++) {
                int[] point = q.poll();

                for(int j = 0; j < dx.length; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.add(new int[]{x, y});
                    }
                }
            }
            time++;
        }

        return count == orange_count ? time - 1 : -1;
    }
}