package graph

/**
 * 323. Number of Connected Components in an Undirected Graph
 *
 * Medium
 *
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
 *
 * Return the number of connected components in the graph.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 5, edges = [[0,1],[1,2],[3,4]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2000
 * 1 <= edges.length <= 5000
 * edges[i].length == 2
 * 0 <= ai <= bi < n
 * ai != bi
 * There are no repeated edges.
 */

class LC323NumberOfConnectedComponentsInAnUndirectedGraph {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {

        // Intuition:
        // We have a graph with nodes labeled from 0 to n-1.
        // We need to find the number of connected components in the graph.
        // To achieve this, we can pre-process the graph and build an adjacency list of the neighbors for each node.

        var ans = 0
        val adjList = mutableListOf<MutableList<Int>>()
        val seen = BooleanArray(n)

        // Initialize the adjacency list
        repeat(n) {
            adjList.add(mutableListOf())
        }

        // Add all the neighbors to the adjacency list
        for ((a, b) in edges) {
            adjList[a].add(b)
            adjList[b].add(a)
        }

        // Perform DFS to traverse the graph and mark visited nodes
        fun dfs(node: Int) {
            for (neighbor in adjList[node]) {
                if (!seen[neighbor]) {
                    seen[neighbor] = true
                    dfs(neighbor)
                }
            }
        }

        // Iterate over all the nodes to visit them
        for (node in 0..<n) {
            // For each unvisited node, increment the component count and perform DFS
            if (!seen[node]) {
                seen[node] = true
                ans++
                dfs(node)
            }
        }

        return ans
    }
}