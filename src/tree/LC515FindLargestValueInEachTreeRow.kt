package tree

import kotlin.math.max

/**
 * 515. Find Largest Value in Each Tree Row
 *
 * Medium
 *
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * Example 2:
 *
 * Input: root = [1,2,3]
 * Output: [1,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree will be in the range [0, 104].
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
class LC515FindLargestValueInEachTreeRow {
    fun largestValues(root: TreeNode?): List<Int> {
        // We know that BFS gives us the nodes in each level
        // We can check for the largest value during the BFS

        // Define the ans to collect the max values
        val ans = mutableListOf<Int>()

        // Perform the BFS
        val queue = ArrayDeque<TreeNode>()
        root?.let { queue.addLast(it) }

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            var currMax = queue.first().`val`

            // Iterate on the current level which has levelSize items
            repeat(levelSize) {
                val node = queue.removeFirst()

                currMax = max(currMax, node.`val`) // Find the max value of each level

                // Add the children to the queue to build the next level
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }

            ans.add(currMax) // Add the max value of the level to the answer
        }

        return ans
    }
}