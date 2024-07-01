package tree

/**
 * 1302. Deepest Leaves Sum
 *
 * Medium
 *
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 * Example 2:
 *
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 19
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 100
 *
 */

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class LC1302DeepestLeavesSum {
    fun deepestLeavesSum(root: TreeNode?): Int {

        // Intuition and Algorithm:
        // We will perform a BFS (Breadth-First Search) to traverse the tree level by level.
        // For each level, we will calculate the sum of the nodes' values.
        // By resetting the sum at the start of each level, the final sum will be the sum of the deepest leaves.

        var sum = 0

        // Initialize the queue for BFS with the root node
        val queue = ArrayDeque<TreeNode>()
        root?.let { queue.add(it) } // Add root to the queue if it's not null

        // Perform BFS
        while (queue.isNotEmpty()) {
            // Reset the sum as we start processing a new level
            sum = 0
            val levelSize = queue.size

            // Iterate through all nodes at the current level
            repeat(levelSize) {
                val node = queue.removeFirst()

                // Add the current node's value to the sum
                sum += node.`val`

                // Add child nodes to the queue for the next level
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }
        }

        // Return the sum of the deepest leaves
        return sum
    }
}