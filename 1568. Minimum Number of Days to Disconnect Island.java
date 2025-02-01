class Solution {
    public int minDays(int[][] grid) {
        if(countIslands(grid) != 1) return 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if(countIslands(grid) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    int countIslands(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int islands = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && !seen[i][j]) {
                    islands++;
                    dfs(grid, i, j, seen);
                }
            }
        }

        return islands;
    }

    void dfs(int[][] grid, int row, int col, boolean[][] seen) {
        seen[row][col] = true;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !seen[x][y]) {
                dfs(grid, x, y, seen);
            }
        }
    }
}