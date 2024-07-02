package graph

/**
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 *
 * Medium
 *
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 *
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 *
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 *
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 *
 * It's guaranteed that each city can reach city 0 after reorder.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * Output: 3
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * Example 2:
 *
 *
 * Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * Output: 2
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * Example 3:
 *
 * Input: n = 3, connections = [[1,0],[2,0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 2 <= n <= 5 * 104
 * connections.length == n - 1
 * connections[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 */

class LC1466ReorderRoutesMakeAllPathsLeadCityZero {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {

        // Intuition:
        // We have a graph with n nodes and the edges are represented by connections.
        // We assume node 0 is the root of this graph, and eventually, all nodes should connect to 0.
        // Treat the graph as undirected to traverse from 0 to other nodes.
        // Use a set to keep track of original directed edges, so we know when an edge should be reversed.

        // Initialize the undirected graph
        val graph = mutableMapOf<Int, MutableList<Int>>()
        val roads = mutableSetOf<String>()
        val seen = BooleanArray(n)

        // Initialize the graph nodes
        repeat(n) { i ->
            graph[i] = mutableListOf()
        }

        // Build the undirected graph and record the original directed edges
        for ((x, y) in connections) {
            graph[x]!!.add(y)
            graph[y]!!.add(x)
            roads.add(toHash(x, y))
        }

        // Start DFS from node 0
        fun dfs(node: Int): Int {
            var count = 0
            for (neighbor in graph[node]!!) {
                if (!seen[neighbor]) {
                    seen[neighbor] = true
                    // Check if the edge needs to be reversed
                    if (roads.contains(toHash(node, neighbor))) {
                        count++
                    }
                    count += dfs(neighbor)
                }
            }
            return count
        }

        // Start DFS from the root node 0
        seen[0] = true
        return dfs(0)
    }

    // Helper function to create a key for an edge
    private fun toHash(x: Int, y: Int): String {
        return "$x,$y"
    }
}