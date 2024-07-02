package graph

/**
 * 695. Max Area of Island
 *
 * Medium
 *
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */

class LC695MaxAreaOfIsland {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {

        // Intuition:
        // We have a graph represented by a grid.
        // We can iterate over the grid cells; at each cell, if it's 1, perform DFS to visit the neighbors.
        // We use a direction helper to simplify the DFS in 4 directions (up, down, left, right).

        var maxArea = 0
        var currArea = 0
        val m = grid.size
        val n = grid[0].size

        val seen = Array(m) { BooleanArray(n) }

        // Direction vectors for moving in the grid (up, down, left, right)
        val directions = arrayOf(
            intArrayOf(-1, 0), // Up
            intArrayOf(1, 0), // Down
            intArrayOf(0, -1), // Left
            intArrayOf(0, 1) // Right
        )

        // Check if the cell (x, y) is within bounds and is land (1)
        fun isValid(x: Int, y: Int): Boolean {
            return (x in 0..<m) && (y in 0..<n) && (grid[x][y] == 1)
        }

        // Perform DFS to explore the island and calculate its area
        fun dfs(x: Int, y: Int) {
            for (direction in directions) {
                val newX = x + direction[0]
                val newY = y + direction[1]
                if (isValid(newX, newY) && !seen[newX][newY]) {
                    seen[newX][newY] = true
                    currArea++
                    dfs(newX, newY)
                }
            }
        }

        // Iterate over the grid to find all islands and calculate the maximum area
        for (x in grid.indices) {
            for (y in grid[0].indices) {
                if (!seen[x][y] && grid[x][y] == 1) {
                    seen[x][y] = true
                    currArea = 1
                    dfs(x, y)
                    maxArea = maxOf(maxArea, currArea)
                }
            }
        }

        return maxArea
    }
}