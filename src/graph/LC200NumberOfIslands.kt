package graph

/**
 * 200. Number of Islands
 *
 * Medium
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */

class LC200NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        return useDirections1(grid)
        // return useDirections2(grid)
        // return usingHashMap(grid)
    }

    //------------- Approach 1 - Directions -------------
    // We can directly go through 4 directions of the current node and visit the neighbors to perform the DFS
    private fun useDirections1(grid: Array<CharArray>): Int {

        // Intuition:
        // We have a graph represented by a grid
        // We can iterate over all the cells
        // At each step, do a DFS using a direction helper to check four sides
        // When we check all the connected nodes (1s), we have found one island

        var ans = 0
        val n = grid.size
        val m = grid[0].size
        val directions = arrayOf(
            arrayOf(0, 1), // Right
            arrayOf(0, -1), // Left
            arrayOf(-1, 0), // Up
            arrayOf(1, 0) // Down
        )

        val seen = Array(n) { BooleanArray(m) }

        // Check if the requested node is in bounds and is land (1)
        fun isValid(row: Int, col: Int): Boolean {
            return row in 0..<n && col in 0..<m && grid[row][col] == '1'
        }

        // DFS on the requested node
        fun dfs(row: Int, col: Int) {
            // For each direction, do the DFS, which recurses the DFS for the next cells
            for (dir in directions) {
                val nextRow = row + dir[0]
                val nextCol = col + dir[1]

                // If the next neighbor is a valid neighbor, do the DFS on it
                if (isValid(nextRow, nextCol) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true
                    dfs(nextRow, nextCol)
                }
            }
        }

        // Iterate over the grid
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                // If the current node is land (1) and we haven't visited it yet, check it and do the DFS on all the neighbors
                if (grid[row][col] == '1' && !seen[row][col]) {
                    seen[row][col] = true
                    dfs(row, col)
                    ans++
                }
            }
        }

        return ans
    }


    //-------------Approach 2 - Direction------------------
    // This is the same as approach 1, but we can modify the cells to prevent using the seen array
    private fun useDirections2(grid: Array<CharArray>): Int {

        var ans = 0
        val n = grid.size
        val m = grid[0].size
        val directions = arrayOf(
            arrayOf(0, 1),
            arrayOf(0, -1),
            arrayOf(-1, 0),
            arrayOf(1, 0)
        )

        fun isValid(row: Int, col: Int): Boolean {
            return row in 0..<n && col in 0..<m && grid[row][col] == '1'
        }

        fun dfs(row: Int, col: Int) {
            for (dir in directions) {
                val nextRow = row + dir[0]
                val nextCol = col + dir[1]

                if (isValid(nextRow, nextCol)) {
                    grid[nextRow][nextCol] = '0'
                    dfs(nextRow, nextCol)
                }
            }
        }

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == '1') {
                    grid[row][col] = '0'
                    dfs(row, col)
                    ans++
                }
            }
        }

        return ans
    }


    //-------------Approach 3 - HashMap------------------
    // We can use a hash map to form the graph and neighbors then perform the DFS
    private fun usingHashMap(grid: Array<CharArray>): Int {
        var ans = 0
        val graph = mutableMapOf<String, MutableList<String>>()
        val seen = mutableSetOf<String>()

        fun isLand(i: Int, j: Int): Boolean {
            return grid[i][j] == '1'
        }

        for (i in grid.indices) {
            for (j in grid[i].indices) {

                if (isLand(i, j)) {

                    val node = key(i, j)

                    if (!graph.contains(node)) graph[node] = mutableListOf()

                    // Check the left
                    if (j > 0 && isLand(i, j - 1)) graph[node]!!.add(key(i, j - 1))
                    // Check the right
                    if (j < grid[i].size - 1 && isLand(i, j + 1)) graph[node]!!.add(key(i, j + 1))
                    // Check the top
                    if (i > 0 && isLand(i - 1, j)) graph[node]!!.add(key(i - 1, j))
                    // Check the bottom
                    if (i < grid.size - 1 && isLand(i + 1, j)) graph[node]!!.add(key(i + 1, j))
                }
            }
        }

        fun notSeen(node: String): Boolean {
            return !seen.contains(node)
        }

        fun dfs(node: String) {
            for (neighbor in graph[node]!!) {
                if (notSeen(neighbor)) {
                    seen.add(neighbor)
                    dfs(neighbor)
                }
            }
        }

        for (node in graph.keys) {
            if (notSeen(node)) {
                seen.add(node)
                dfs(node)
                ans++
            }
        }

        return ans
    }

    private fun key(i: Int, j: Int): String {
        return "$i,$j"
    }
}