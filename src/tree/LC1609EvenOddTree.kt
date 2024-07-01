package tree

/**
 * 1609. Even Odd Tree
 *
 * Medium
 *
 * A binary tree is named Even-Odd if it meets the following conditions:
 *
 * The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
 * For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
 * For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
 * Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * Output: true
 * Explanation: The node values on each level are:
 * Level 0: [1]
 * Level 1: [10,4]
 * Level 2: [3,7,9]
 * Level 3: [12,8,6,2]
 * Since levels 0 and 2 are all odd and increasing and levels 1 and 3 are all even and decreasing, the tree is Even-Odd.
 * Example 2:
 *
 *
 * Input: root = [5,4,2,3,3,7]
 * Output: false
 * Explanation: The node values on each level are:
 * Level 0: [5]
 * Level 1: [4,2]
 * Level 2: [3,3,7]
 * Node values in level 2 must be in strictly increasing order, so the tree is not Even-Odd.
 * Example 3:
 *
 *
 * Input: root = [5,9,1,3,5,7]
 * Output: false
 * Explanation: Node values in the level 1 should be even integers.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 105].
 * 1 <= Node.val <= 106
 *
 */

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class LC1609EvenOddTree {
    fun isEvenOddTree(root: TreeNode?): Boolean {

        // Intuition and Algorithm:
        // Perform a Breadth-First Search (BFS) to traverse nodes level by level.
        // At each level, check if the nodes satisfy the conditions for an even-odd tree:
        // - For even-indexed levels, node values should be odd and strictly increasing.
        // - For odd-indexed levels, node values should be even and strictly decreasing.

        val queue = ArrayDeque<TreeNode>()
        var level = 0

        root?.let { queue.add(it) }

        // Perform the BFS
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val levelIsEven = level % 2 == 0
            var prevItem = if (levelIsEven) 0 else Int.MAX_VALUE

            // Process the current level
            repeat(levelSize) {
                val node = queue.removeFirst()
                val currVal = node.`val`

                val nodeIsEven = currVal % 2 == 0

                // For even-indexed levels, node values must be odd and strictly increasing
                if (levelIsEven && (nodeIsEven || currVal <= prevItem)) {
                    return false
                }

                // For odd-indexed levels, node values must be even and strictly decreasing
                if (!levelIsEven && (!nodeIsEven || currVal >= prevItem)) {
                    return false
                }

                prevItem = currVal

                // Add the children of the current node to the queue for the next level
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }

            // Move to the next level
            level++
        }

        // If all levels satisfy the conditions, return true
        return true
    }
}