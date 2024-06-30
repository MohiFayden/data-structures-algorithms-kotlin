package tree

import kotlin.math.max

/**
 * 1372. Longest ZigZag Path in a Binary Tree
 *
 * Medium
 *
 * You are given the root of a binary tree.
 *
 * A ZigZag path for a binary tree is defined as follow:
 *
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
 * Change the direction from right to left or from left to right.
 * Repeat the second and third steps until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 *
 * Return the longest ZigZag path contained in that tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
 * Output: 3
 * Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
 * Example 2:
 *
 *
 * Input: root = [1,1,1,null,1,null,null,1,1,null,1]
 * Output: 4
 * Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
 * Example 3:
 *
 * Input: root = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 5 * 104].
 * 1 <= Node.val <= 100
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
class LC1372LongestZigZagPathInABinaryTree {
    fun longestZigZag(root: TreeNode?): Int {

        // Intuition:
        // The goal is to find the longest ZigZag path in a binary tree.
        // A ZigZag path is defined as a path where the direction of traversal alternates at each step.
        // We'll use Depth-First Search (DFS) to explore each possible path in the tree.
        // We can pass the direction (goRight) and the current length of the ZigZag path (step) to our DFS function.
        // We'll track the longest path found using a variable 'longest'.

        var longest = 0

        fun dfs(node: TreeNode?, goRight: Boolean, step: Int) {
            // Base case: if the node is null, return
            if (node == null) return

            // Update the longest path found so far
            longest = max(longest, step)

            // If we are to go right, continue the path from the right child
            if (goRight) {
                // Going left breaks the current ZigZag, so restart the step count
                dfs(node.left, true, 1)
                // Going right continues the ZigZag, so increment the step count
                dfs(node.right, false, step + 1)
            } else {
                // If we are to go left, continue the path from the left child
                // Going left continues the ZigZag, so increment the step count
                dfs(node.left, true, step + 1)
                // Going right breaks the current ZigZag, so restart the step count
                dfs(node.right, false, 1)
            }
        }

        // Start DFS from the root, considering both possible initial directions
        dfs(root, true, 0)
        dfs(root, false, 0)

        // Return the longest ZigZag path found
        return longest
    }
}