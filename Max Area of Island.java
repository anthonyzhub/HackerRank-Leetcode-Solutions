/*
https://leetcode.com/problems/max-area-of-island/

Time Complexity: O(m * n) where m * n is the dimension of the grid. We're traversing the entire graph to find land

Space Complexity: O(m * n) where m * n is the dimension of the grid. A recursive call is made for every new piece of land we find. Worst case,
    the entire grid is land.
*/

class Solution {

    private int traverseGraph(int[][] grid, int i, int j, int m, int n, int curArea) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        int north = traverseGraph(grid, i - 1, j, m, n, curArea + 1);
        int east = traverseGraph(grid, i, j + 1, m, n, curArea + 1);
        int south = traverseGraph(grid, i + 1, j, m, n, curArea + 1);
        int west = traverseGraph(grid, i, j - 1, m, n, curArea + 1);

        return north + south + east + west + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curCell = grid[i][j];

                if (curCell == 1) {
                    int curArea = traverseGraph(grid, i, j, m, n, 0);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }

        return maxArea;
    }
}
