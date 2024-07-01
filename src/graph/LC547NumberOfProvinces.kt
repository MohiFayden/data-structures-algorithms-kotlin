package graph

/**
 * 547. Number of Provinces
 *
 * Medium
 *
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */

class LC547NumberOfProvinces {
    fun findCircleNum(isConnected: Array<IntArray>): Int {

        // Intuition:
        // We are given a graph represented as an adjacency matrix.
        // We can use Depth-First Search (DFS) to explore each component of the graph.
        // A Set (seen) is used to keep track of visited nodes to prevent revisiting.

        val n = isConnected.size
        var ans = 0
        val graph = mutableMapOf<Int, MutableList<Int>>()

        // In this problem a BooleanArray can be used instead of a Set which is more efficient
        val seen = BooleanArray(n)

        // Build the graph from the adjacency matrix
        for (i in isConnected.indices) {
            // Initialize the adjacency list for the current node if not already initialized
            graph[i] = graph[i] ?: mutableListOf()

            // Populate the adjacency list for the current node
            for (j in i + 1..<n) {
                if (isConnected[i][j] == 1) {
                    graph[i]!!.add(j)

                    graph[j] = graph[j] ?: mutableListOf()
                    graph[j]!!.add(i)
                }
            }
        }

        // Helper function to perform DFS on the graph
        fun dfs(node: Int) {
            for (neighbor in graph[node]!!) {
                if (!seen[neighbor]) {
                    seen[neighbor] = true
                    dfs(neighbor)
                }
            }
        }

        // Iterate over all nodes
        for (i in isConnected.indices) {
            // If the node hasn't been seen, perform DFS and count it as a new component
            if (!seen[i]) {
                seen[i] = true
                dfs(i)
                ans++
            }
        }

        return ans
    }
}