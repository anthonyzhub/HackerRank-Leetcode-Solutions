/*
https://leetcode.com/problems/number-of-islands/
Time Complexity: O(m * n) where m & n represents the size of the matrix. We're traversing the matrix using a nested for-loop and while using dfs

Space Complexity: O(m * n) where m & n represents the size of the matrix. Multiple recursive calls are made with traverseMatrix().
    In worst case scenario, the entire grid is an island.

Thought process:
- Iterate matrix until you see land
- From that point, perform dfs on matrix
- For every cell visited, 
    - Check that it wasn't previously visited. If so, exit
    - If a cell is water, exit
    - If a cell is land, continue exploring
    - Set every new cell to 2 to mark as visited
- Visit right, bottom, left, and top cell
- Once done exploring, backtrack to start point and update island counter
- Don't remove 2 from visited cells to prevent from counting the same land twice
*/

class Solution {

    private void traverseMatrix(char[][] grid, int m, int n, int i, int j) {
        // OBJECTIVE: Simply turn every neighboring land into -1 for visited

        // Exit if iterator goes out of bounds
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        // Exit if iterator reaches a visited cell or water
        if (grid[i][j] == '2' || grid[i][j] == '0') {
            return;
        }

        // Mark cell as visited
        grid[i][j] = '2'; // NOTE: If I set it to '-1', Java will interpret it as a String instead of char and throw an error

        // Check right, bottom, left, and top side
        traverseMatrix(grid, m, n, i, j + 1);
        traverseMatrix(grid, m, n, i + 1, j);
        traverseMatrix(grid, m, n, i, j - 1);
        traverseMatrix(grid, m, n, i - 1, j);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islandCounter = 0;

        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // IMPORTANT: The problem is simply asking how many islands are there.
                //  We don't care how big the island is. The fact we found land means
                //  we can increment the counter by 1.
                if (grid[i][j] == '1') {
                    traverseMatrix(grid, m, n, i, j);
                    islandCounter++;
                }
            }
        }

        return islandCounter;
    }
}
