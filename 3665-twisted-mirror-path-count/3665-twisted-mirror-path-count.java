
class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        final int MOD = 1_000_000_007;

        // Number of ways entering a cell from the left
        int[][] fromLeft = new int[m][n];

        // Number of ways entering a cell from above
        int[][] fromAbove = new int[m][n];

        // Starting position
        fromLeft[0][0] = 1;

        // Process cells row by row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Destination reached
                if (i == m - 1 && j == n - 1) {
                    return (int) (
                        ((long) fromLeft[i][j]
                        + fromAbove[i][j]) % MOD
                    );
                }

                if (grid[i][j] == 0) {

                    // Empty cell: both incoming directions
                    // can continue normally.
                    long ways = ((long) fromLeft[i][j]
                               + fromAbove[i][j]) % MOD;

                    // Move right
                    if (j + 1 < n) {
                        fromLeft[i][j + 1] = (int) (
                            (fromLeft[i][j + 1] + ways) % MOD
                        );
                    }

                    // Move down
                    if (i + 1 < m) {
                        fromAbove[i + 1][j] = (int) (
                            (fromAbove[i + 1][j] + ways) % MOD
                        );
                    }

                } else {

                    // Mirror cell

                    // Entered from left:
                    // Reflect down
                    if (i + 1 < m) {
                        fromAbove[i + 1][j] = (int) (
                            (fromAbove[i + 1][j]
                            + (long) fromLeft[i][j]) % MOD
                        );
                    }

                    // Entered from above:
                    // Reflect right
                    if (j + 1 < n) {
                        fromLeft[i][j + 1] = (int) (
                            (fromLeft[i][j + 1]
                            + (long) fromAbove[i][j]) % MOD
                        );
                    }
                }
            }
        }

        return 0;
    }
}
