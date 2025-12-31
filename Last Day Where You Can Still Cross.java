// https://leetcode.com/problems/last-day-where-you-can-still-cross/
/*
Time Complexity: O(log (m * n) * (m * n)) where m = row and n = column. log(m * n) comes from performing a binary seach. (m * n) comes from breadth-first search.

Space Complexity: O((m + 1) * (n + 1)) where m = row and n = column. A grid is made during a traversal
*/

class Solution {

    private boolean traverseGraph(int maxRow, int maxCol, int midPtr, int[][] cells) {
        // Create a grid
        // Remember, the problem statement said it's a 1-based binary matrix
        int[][] grid = new int[maxRow + 1][maxCol + 1];

        // Create a list of possible directions
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Iterate cells until midPtr and populate parts of grid with water
        for (int i = 0; i < midPtr; i++) {
            int[] cell = cells[i];
            int x = cell[0];
            int y = cell[1];

            grid[x][y] = 1;
        }

        // Create a queue
        Queue<int[]> queue = new LinkedList<>();

        // Only iterate 1st row to see if traversal can even start
        // Remember, I added an extra column and row to the grid because it's a 1-based matrix
        for (int i = 1; i <= maxCol; i++) {

            // If cell is land, add it to queue and mark it as visited
            if (grid[1][i] == 0) {
                int[] curGridCell = new int[]{1, i};
                queue.add(curGridCell);
                grid[1][i] = -1;
            }
        }

        // Perform Breadth-First Search
        while (!queue.isEmpty()) {

            // Pop cell from queue
            int[] poppedCell = queue.poll();
            int cellRow = poppedCell[0], cellCol = poppedCell[1];

            // Perform all directions from popped cell
            for (int[] direction: directions) {
                int nextRow = cellRow + direction[0];
                int nextCol = cellCol + direction[1];

                // Check if next cell isn't out of bounds and if it's land
                if (nextRow > 0 && nextRow <= maxRow && nextCol > 0 && nextCol <= maxCol && grid[nextRow][nextCol] == 0) {

                    // Mark cell as visited
                    grid[nextRow][nextCol] = 1;

                    // If this is the last row, then a path does exist. Therefore, return true.
                    if (nextRow == maxRow) {
                        return true;
                    }

                    // Add neighboring cell to queue
                    int[] neighboringGridCell = new int[]{nextRow, nextCol};
                    queue.add(neighboringGridCell);
                }
            }
        }

        // If program is still running, then a path doesn't exist. Therefore, return false.
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        // Create left and right pointers
        int leftPtr = 0;
        int rightPtr = row * col;
        int latestPossibleDay = 0;

        // Perform binary search
        while (leftPtr < rightPtr - 1) {
            int midPtr = leftPtr + ((rightPtr - leftPtr) / 2);

            // Traverse graph and check if path exist
            boolean doesPathExist = traverseGraph(row, col, midPtr, cells);
            
            // If path exist, search 2nd half of grid
            // If not, search 1st half
            if (doesPathExist) {
                leftPtr = midPtr;
                latestPossibleDay = midPtr;
            } else {
                rightPtr = midPtr;
            }
        }

        return latestPossibleDay;
    }
}
