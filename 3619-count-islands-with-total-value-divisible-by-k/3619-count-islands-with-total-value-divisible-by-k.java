class Solution {
    public int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // We found a new piece of land!
                if (grid[r][c] > 0) {
                    
                    // Traverse the entire island. Our DFS returns the sum % k
                    int islandSumModulo = dfs(grid, r, c, k);
                    
                    // If the remaining modulo is 0, the total sum is perfectly divisible by k
                    if (islandSumModulo == 0) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    private int dfs(int[][] grid, int r, int c, int k) {
        // Base case: out of bounds, or we hit water/already visited land
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        
        // Capture the cell's value and immediately apply modulo
        int val = grid[r][c] % k;
        
        // Sink the land (set to 0) so we don't visit it again in an infinite loop
        grid[r][c] = 0; 
        
        // Add the sums from all 4 directions, applying modulo at EVERY step to prevent overflow
        val = (val + dfs(grid, r - 1, c, k)) % k; // Up
        val = (val + dfs(grid, r + 1, c, k)) % k; // Down
        val = (val + dfs(grid, r, c - 1, k)) % k; // Left
        val = (val + dfs(grid, r, c + 1, k)) % k; // Right
        
        return val;
    }
}