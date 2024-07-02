package graph

/**
 * 2368. Reachable Nodes With Restrictions
 *
 * Medium
 *
 * There is an undirected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
 *
 * You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree. You are also given an integer array restricted which represents restricted nodes.
 *
 * Return the maximum number of nodes you can reach from node 0 without visiting a restricted node.
 *
 * Note that node 0 will not be a restricted node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
 * Output: 4
 * Explanation: The diagram above shows the tree.
 * We have that [0,1,2,3] are the only nodes that can be reached from node 0 without visiting a restricted node.
 * Example 2:
 *
 *
 * Input: n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
 * Output: 3
 * Explanation: The diagram above shows the tree.
 * We have that [0,5,6] are the only nodes that can be reached from node 0 without visiting a restricted node.
 *
 *
 * Constraints:
 *
 * 2 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges represents a valid tree.
 * 1 <= restricted.length < n
 * 1 <= restricted[i] < n
 * All the values of restricted are unique.
 */

class LC2368ReachableNodesWithRestrictions {
    fun reachableNodes(n: Int, edges: Array<IntArray>, restricted: IntArray): Int {

        // Intuition:
        // We have a graph with n nodes.
        // We can start the DFS from the root node 0.
        // At any node, we mark it as seen to avoid revisiting it.
        // We can mark restricted nodes as seen initially so that we don't visit them or any nodes accessible through them.
        // The number of visited nodes will be our answer.

        var ans = 0
        val graph = mutableMapOf<Int, MutableList<Int>>()
        val seen = BooleanArray(n)

        // Initialize the graph with empty lists
        repeat(n) { node ->
            graph[node] = mutableListOf()
        }

        // Add the edges to the graph
        for ((a, b) in edges) {
            graph[a]?.add(b)
            graph[b]?.add(a)
        }

        // Mark restricted nodes as seen to prevent DFS on those nodes
        restricted.forEach { node ->
            seen[node] = true
        }

        // Perform DFS on nodes that are not restricted
        fun dfs(node: Int) {
            seen[node] = true
            ans++

            for (neighbor in graph[node]!!) {
                if (!seen[neighbor]) {
                    dfs(neighbor)
                }
            }
        }

        // Start DFS from node 0
        dfs(0)

        return ans
    }
}