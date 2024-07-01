package tree

/**
 * 102. Binary Tree Level Order Traversal
 *
 * Medium
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 *
 */

/**
 *  Example:
 *  var ti = TreeNode(5)
 *  var v = ti.`val`
 *  Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class LC102BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        // Choose BFS for level order traversal
        return bfs(root)
        // Alternatively, we can use the recursive approach
        // return recursive(root, mutableListOf<MutableList<Int>>(), 0)
    }

    // BFS - Iterative approach
    // Intuition: Use a queue to traverse the tree level by level, adding child nodes to the queue as we go.
    private fun bfs(root: TreeNode?): List<List<Int>> {
        // Initialize the result list to store nodes at each level
        val ans = mutableListOf<MutableList<Int>>()
        // Queue to facilitate the BFS
        val queue = ArrayDeque<TreeNode>()

        // Add root to the queue if it's not null
        root?.let { queue.add(it) }

        // Process nodes level by level
        while (queue.isNotEmpty()) {
            // Create a new list for the current level
            val level = mutableListOf<Int>()
            val levelSize = queue.size

            // Process all nodes at the current level
            repeat(levelSize) {
                val node = queue.removeFirst()
                level.add(node.`val`)
                // Add left and right children to the queue if they exist
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            ans.add(level)
        }

        return ans
    }

    // Recursive approach for level order traversal
    // Intuition: Recursively traverse the tree, adding nodes' values to lists corresponding to their levels.
    private fun recursive(root: TreeNode?, ans: MutableList<MutableList<Int>>, level: Int): List<List<Int>> {
        // Base case: if the node is null, return the accumulated result
        if (root == null) return ans

        // Ensure the current level list exists in the result
        if (ans.size == level) {
            ans.add(mutableListOf())
        }

        // Add the current node's value to the current level list
        ans[level].add(root.`val`)

        // Recurse on the left and right children, increasing the level
        root.left?.let { recursive(it, ans, level + 1) }
        root.right?.let { recursive(it, ans, level + 1) }

        return ans
    }
}