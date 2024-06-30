package tree

import kotlin.math.min

/**
 * 111. Minimum Depth of Binary Tree
 *
 * Easy
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * Example 2:
 *
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
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
class LC111MinimumDepthOfBinaryTree {
    fun minDepth(root: TreeNode?): Int {
        // Uncomment the following line to use the first DFS method
        // return dfs1(root)
        // Using the second DFS method to find the minimum depth of the binary tree
        return dfs2(root)
    }


    //-----------------DFS 1-------------------
    /**
     * DFS method 1 to find the minimum depth of the binary tree
     * This method checks if either the left or right subtree is null and recursively finds the depth
     */
    private fun dfs1(root: TreeNode?): Int {
        // If the node is null, return depth as 0
        if (root == null) return 0

        // If left subtree is null, recursively find the depth of the right subtree
        if (root.left == null) {
            return 1 + dfs1(root.right)
        } else if (root.right == null) {  // If right subtree is null, recursively find the depth of the left subtree
            return 1 + dfs1(root.left)
        }

        // If neither subtree is null, find the minimum depth between the left and right subtrees
        return 1 + min(dfs1(root.left), dfs1(root.right))
    }


    //-----------------DFS 2-------------------
    /**
     * DFS method 2 to find the minimum depth of the binary tree
     * This method uses a helper function to track the current depth and update the minimum depth found
     */
    private fun dfs2(root: TreeNode?): Int {
        // If the node is null, return depth as 0
        if (root == null) return 0

        // Initialize minimum depth to the maximum possible integer value
        var min = Int.MAX_VALUE

        // Helper function to perform DFS traversal and update the minimum depth
        fun dfs(root: TreeNode?, depth: Int) {
            // If the node is null, return from the function
            if (root == null) return

            // If the node is a leaf node (both left and right are null), update the minimum depth
            if (root.left == null && root.right == null) {
                min = min(min, depth)
            }

            // Recursively traverse the left subtree with incremented depth
            dfs(root.left, depth + 1)
            // Recursively traverse the right subtree with incremented depth
            dfs(root.right, depth + 1)
        }

        // Start DFS traversal from the root node with initial depth of 1
        dfs(root, 1)

        // Return the minimum depth found
        return min
    }
}