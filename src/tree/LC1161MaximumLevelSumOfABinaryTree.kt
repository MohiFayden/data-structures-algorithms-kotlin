package tree

/**
 * 1161. Maximum Level Sum of a Binary Tree
 *
 * Medium
 *
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 * Example 2:
 *
 * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
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
class LC1161MaximumLevelSumOfABinaryTree {
    fun maxLevelSum(root: TreeNode?): Int {
        // Intuition:
        // We need to find the level of the binary tree that has the maximum sum of node values.
        // We can achieve this by performing a Breadth-First Search (BFS), which will allow us
        // to process the tree level by level. As we traverse each level, we calculate the sum
        // of the node values at that level and keep track of the maximum sum and its corresponding level.
        // If multiple levels have the same maximum sum, we return the smallest level number by not updating the answer.

        // Initialize the queue for BFS traversal
        val queue = ArrayDeque<TreeNode>()
        var level = 1 // Current level
        var maxSum = Int.MIN_VALUE // Initialize maxSum to the smallest possible value
        var ans = 1 // Variable to store the answer (the level with the maximum sum)

        // Add the root node to the queue to start the BFS
        root?.let { queue.add(it) }

        // Perform BFS
        while (queue.isNotEmpty()) {
            val levelSize = queue.size // Number of nodes at the current level
            var levelSum = 0 // Sum of values at the current level

            // Process all nodes at the current level
            repeat(levelSize) {
                val node = queue.removeFirst() // Dequeue the front node
                levelSum += node.`val` // Add the node's value to the level sum

                // Enqueue the children of the current node for the next level
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }

            // Update maxSum and ans if the current levelSum is greater than the previous maxSum
            if (levelSum > maxSum) {
                maxSum = levelSum
                ans = level // Update the answer to the current level
            }

            // Move to the next level
            level++
        }

        // Return the level with the maximum sum
        return ans
    }
}