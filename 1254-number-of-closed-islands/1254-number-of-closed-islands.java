class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Phase 1: Sink all islands connected to the top and bottom borders
        for (int c = 0; c < cols; c++) {
            if (grid[0][c] == 0) dfs(grid, 0, c);
            if (grid[rows - 1][c] == 0) dfs(grid, rows - 1, c);
        }
        
        // Phase 1 (cont): Sink all islands connected to the left and right borders
        for (int r = 0; r < rows; r++) {
            if (grid[r][0] == 0) dfs(grid, r, 0);
            if (grid[r][cols - 1] == 0) dfs(grid, r, cols - 1);
        }
        
        // Phase 2: Count the remaining closed islands in the inner grid
        int count = 0;
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (grid[r][c] == 0) {
                    count++;
                    dfs(grid, r, c); // Sink it so we don't count it again
                }
            }
        }
        
        return count;
    }
    
    // Standard DFS to flood-fill an island (turn 0s into 1s)
    private void dfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Base cases: Stop if we go out of bounds OR if we hit water (1)
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 1) {
            return;
        }
        
        // Sink the current piece of land
        grid[r][c] = 1;
        
        // Recursively sink the connected land in all 4 directions
        dfs(grid, r - 1, c); // Up
        dfs(grid, r + 1, c); // Down
        dfs(grid, r, c - 1); // Left
        dfs(grid, r, c + 1); // Right
    }
}