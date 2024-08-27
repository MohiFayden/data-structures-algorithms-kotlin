package graph

import tree.TreeNode

/**
 * 863. All Nodes Distance K in Binary Tree
 *
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 * Example 2:
 *
 * Input: root = [1], target = 1, k = 3
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 500].
 * 0 <= Node.val <= 500
 * All the values Node.val are unique.
 * target is the value of one of the nodes in the tree.
 * 0 <= k <= 1000
 */

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class LC863AllNodesDistanceKInBinaryTree {
    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
        // Intuition:
        // To find all nodes at distance k from the target node, we can convert the tree into an undirected graph.
        // This allows us to easily traverse from any node to any of its connected nodes (left, right, or parent).
        // Using a BFS starting from the target node allows us to level-order traverse to exactly k levels deep.

        // Map to hold node values and their adjacent nodes
        val graph = mutableMapOf<Int, MutableList<Int>>()

        // Helper function to add adjacent nodes to the graph
        fun addNeighbor(node: Int, neighbor: Int) {
            graph.getOrPut(node) { mutableListOf() }.add(neighbor)
        }

        // Perform DFS to build the graph representation of the tree
        fun dfs(node: TreeNode?) {
            if (node == null) return

            node.left?.let { left ->
                addNeighbor(node.`val`, left.`val`)
                addNeighbor(left.`val`, node.`val`)
                dfs(left)
            }

            node.right?.let { right ->
                addNeighbor(node.`val`, right.`val`)
                addNeighbor(right.`val`, node.`val`)
                dfs(right)
            }
        }

        // Initialize the graph for the root node and start DFS
        root?.let {
            graph[it.`val`] = mutableListOf()
            dfs(it)
        }

        // BFS to find all nodes at distance k from the target node
        val seen = mutableSetOf<Int>() // Set to keep track of visited nodes
        val queue = ArrayDeque<Int>() // Queue for BFS

        target?.let { queue.add(it.`val`) } // Start BFS from the target node

        var level = 0
        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            if (level == k) return queue.toList() // If we reached the k-th level, return all nodes at this level

            repeat(levelSize) {
                val node = queue.removeFirst()
                seen.add(node)

                for (neighbor in graph[node]!!) {
                    if (seen.add(neighbor)) {
                        queue.addLast(neighbor)
                    }
                }
            }

            level++
        }

        return emptyList() // If no nodes are found at distance k, return an empty list
    }
}