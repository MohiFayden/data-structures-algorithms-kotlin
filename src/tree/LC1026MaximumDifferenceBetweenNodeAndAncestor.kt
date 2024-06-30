package tree

/**
 * 1026. Maximum Difference Between Node and Ancestor
 *
 * Medium
 *
 * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 *
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 * Example 2:
 *
 *
 * Input: root = [1,null,2,null,0,3]
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 5000].
 * 0 <= Node.val <= 105
 */

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class LC1026MaximumDifferenceBetweenNodeAndAncestor {

    // Intuition:
    // The maximum difference between a node and its ancestor can be determined by
    // finding the difference between the maximum and minimum values in the subtree.
    // By passing the minimum and maximum values encountered so far to each subtree,
    // we ensure that we consider the ancestor condition properly.
    // Eventually, the difference between the max and min values in the entire tree will
    // give us the maximum difference between any node and its ancestor.

    // Function to calculate the maximum difference between a node and its ancestor.
    fun maxAncestorDiff(root: TreeNode?): Int {
        if (root == null) return 0
        // Start the DFS traversal with the root node's value as both min and max.
        return dfs(root, root.`val`, root.`val`)
    }

    // Helper function to perform DFS traversal.
    private fun dfs(node: TreeNode?, min: Int, max: Int): Int {
        // If we reach a null node, return the difference between max and min encountered so far.
        if (node == null) return max - min

        // Update the min and max values based on the current node's value.
        val currentMin = minOf(min, node.`val`)
        val currentMax = maxOf(max, node.`val`)

        // Recursively calculate the maximum difference for the left and right subtrees.
        val left = dfs(node.left, currentMin, currentMax)
        val right = dfs(node.right, currentMin, currentMax)

        // Return the maximum difference found in either subtree.
        return maxOf(left, right)
    }
}