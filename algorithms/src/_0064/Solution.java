package _0064;

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        final int R = grid.length;
        final int C = grid[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (r == 0 && c == 0) {
                    grid[r][c] = grid[r][c];
                } else if (r == 0) {
                    grid[r][c] = grid[r][c - 1] + grid[r][c];
                } else if (c == 0) {
                    grid[r][c] = grid[r - 1][c] + grid[r][c];
                } else {
                    grid[r][c] = Math.min(grid[r][c - 1], grid[r - 1][c]) + grid[r][c];
                }
            }
        }
        return grid[R - 1][C - 1];
    }

    public static void main(String[] args) {
        final int[][] grid = {{5, 0, 1}, {1, 3, 2}, {1, 3, 1}};
        final Solution solution = new Solution();
        final int ret = solution.minPathSum(grid);
        System.out.println(ret);
    }
}
