package tree

import kotlin.math.max

/**
 * 1448. Count Good Nodes in Binary Tree
 *
 * Medium
 *
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 * Example 2:
 *
 *
 *
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 * Example 3:
 *
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 *
 *
 * Constraints:
 *
 * The number of nodes in the binary tree is in the range [1, 10^5].
 * Each node's value is between [-10^4, 10^4].
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
class LC1448CountGoodNodesInBinaryTree {
    fun goodNodes(root: TreeNode?): Int {
        return dfs1(root, Int.MIN_VALUE)
        // return dfs2(root)
    }

    //---------------Recursion Approach1-------------------
    /**
     * Helper function to perform DFS traversal of the tree.
     * This function counts the "good" nodes where a node is "good"
     * if it is greater than or equal to the maximum value encountered so far on the path from the root.
     */
    private fun dfs1(root: TreeNode?, maxSoFar: Int): Int {
        if (root == null) return 0 // Base case: if the current node is null, return 0.

        val max = max(maxSoFar, root.`val`) // Update the maximum value seen so far.

        val left = dfs1(root.left, max) // Recursively process the left subtree.
        val right = dfs1(root.right, max) // Recursively process the right subtree.

        var ans = left + right // Sum the counts from the left and right subtrees.

        if (root.`val` >= maxSoFar) { // If the current node is a "good" node, increment the count.
            ans++
        }

        return ans // Return the total count of "good" nodes.
    }

    //---------------Recursion Approach2-------------------
    /**
     * Alternative helper function to perform DFS traversal of the tree.
     * This function uses an inner function to count the "good" nodes.
     */
    fun dfs2(root: TreeNode?): Int {

        var count = 0 // Initialize the count of "good" nodes.

        /**
         * Inner function to perform the DFS traversal.
         */
        fun dfs(root: TreeNode?, max: Int) {
            if (root == null) return // Base case: if the current node is null, return.

            if (root.`val` >= max) count++ // If the current node is a "good" node, increment the count.

            dfs(root.left, max(max, root.`val`)) // Recursively process the left subtree with the updated max value.
            dfs(root.right, max(max, root.`val`)) // Recursively process the right subtree with the updated max value.
        }

        dfs(root, Int.MIN_VALUE) // Start the DFS traversal from the root with initial max value as Int.MINVALUE.

        return count // Return the total count of "good" nodes.
    }
}