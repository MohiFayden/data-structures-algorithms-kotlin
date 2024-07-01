package tree

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 *
 * Medium
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
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
 * -100 <= Node.val <= 100
 */

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class LC103BinaryTreeZigzagLevelOrderTraversal {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {

        // Intuition and Algorithm:
        // Use BFS to traverse the tree level by level.
        // Maintain a flag to track the traversal direction (left to right or right to left).
        // If the current level is left to right, add nodes to the end of the list.
        // If right to left, add nodes to the beginning of the list.

        val ans = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode>()
        root?.let { queue.add(it) }

        var leftToRight = true

        // Perform BFS
        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            // Use a mutable list with a predefined size for performance
            val levelList = MutableList(levelSize) { 0 }

            // Process the current level
            for (i in 0..<levelSize) {
                val node = queue.removeFirst()

                // Determine the index to place the node value based on traversal direction
                val index = if (leftToRight) i else levelSize - i - 1
                levelList[index] = node.`val`

                // Add child nodes to the queue for the next level
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }

            // Add the current level list to the final result
            ans.add(levelList)

            // Toggle the traversal direction
            leftToRight = !leftToRight
        }

        return ans
    }
}