package tree

import kotlin.math.abs

/**
 * 270. Closest Binary Search Tree Value
 *
 * Easy
 *
 * Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target. If there are multiple answers, print the smallest.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 * Output: 4
 * Example 2:
 *
 * Input: root = [1], target = 4.428571
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 109
 * -109 <= target <= 109
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
class LC270ClosestBinarySearchTreeValue {
    fun closestValue(root: TreeNode?, target: Double): Int {

        // Intuition:
        // Since we are dealing with a Binary Search Tree (BST), we can leverage its properties to find the closest value efficiently.
        // If the target is greater than the current node's value, the closest value must be the current node or in the right subtree.
        // Otherwise, it must be the current node or in the left subtree.
        // We will use Depth-First Search (DFS) to traverse the tree.

        // Perform the DFS
        fun dfs(node: TreeNode?, closest: Int): Int {
            if (node == null) return closest

            var currentClosest = closest

            // Update the closest value if the current node's value is closer to the target
            if (abs(node.`val` - target) < abs(closest - target)) {
                currentClosest = node.`val`
            } else if (abs(node.`val` - target) == abs(closest - target)) {
                // Set the minimum one if we have duplicate closest items (due to the negative numbers)
                currentClosest = minOf(closest, node.`val`)
            }

            // Continue searching in the subtree that is more likely to contain the closer value
            return if (target < node.`val`) {
                dfs(node.left, currentClosest)
            } else {
                dfs(node.right, currentClosest)
            }
        }

        // Initialize the closest value with the root node's value
        return dfs(root, root?.`val` ?: 0)
    }
}