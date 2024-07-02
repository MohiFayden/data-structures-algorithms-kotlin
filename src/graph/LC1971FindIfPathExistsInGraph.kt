package graph

/**
 * 1971. Find if Path Exists in Graph
 *
 * Easy
 *
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 *
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 *
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 * Example 2:
 *
 *
 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
 * Output: false
 * Explanation: There is no path from vertex 0 to vertex 5.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2 * 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= source, destination <= n - 1
 * There are no duplicate edges.
 * There are no self edges.
 */

class LC1971FindIfPathExistsInGraph {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {

        // Intuition
        // Since we have a bi-directional graph, we can pre-process the graph in a hash map.
        // Then, we can perform DFS starting from the source, and if we reach the destination, return true.

        // If there's only one node, the source and destination must be the same.
        if (n == 1) return true

        // Hash map to store the graph as adjacency lists.
        val graph = mutableMapOf<Int, MutableList<Int>>()
        val seen = BooleanArray(n)

        // Build the bi-directional graph.
        for ((x, y) in edges) {
            graph.computeIfAbsent(x) { mutableListOf() }.add(y)
            graph.computeIfAbsent(y) { mutableListOf() }.add(x)
        }

        // Perform DFS to visit all the neighbors.
        fun dfs(node: Int): Boolean {
            if (node == destination) return true
            for (neighbor in graph[node] ?: emptyList()) {
                if (!seen[neighbor]) {
                    seen[neighbor] = true
                    if (dfs(neighbor)) {
                        return true
                    }
                }
            }
            return false
        }

        // Mark the source as seen and start DFS from the source node.
        seen[source] = true
        return dfs(source)
    }
}