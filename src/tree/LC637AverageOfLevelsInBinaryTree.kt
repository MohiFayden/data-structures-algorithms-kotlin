package tree

/**
 * 637. Average of Levels in Binary Tree
 *
 * Easy
 *
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * Example 2:
 *
 *
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
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
class LC637AverageOfLevelsInBinaryTree {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        // Intuition and Algorithm:
        // Use BFS to traverse each level of the binary tree.
        // Calculate the average value of nodes at each level and store it.

        val queue = ArrayDeque<TreeNode>()
        val ans = mutableListOf<Double>()

        // Start BFS with the root node, if it exists
        root?.let { queue.add(it) }

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            var levelSum = 0.0

            // Process all nodes at the current level
            repeat(levelSize) {
                val node = queue.removeFirst()

                // Add the node's value to the level sum
                levelSum += node.`val`

                // Add the node's children to the queue for the next level
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }

            // Calculate and add the average of the current level to the answer list
            ans.add(levelSum / levelSize)
        }

        // Convert the list of averages to a DoubleArray and return it
        return ans.toDoubleArray()
    }
}