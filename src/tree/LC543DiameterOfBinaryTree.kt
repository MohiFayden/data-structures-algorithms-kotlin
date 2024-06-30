package tree

/**
 * 543. Diameter of Binary Tree
 *
 * Easy
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * Example 2:
 *
 * Input: root = [1,2]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
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
class LC543DiameterOfBinaryTree {
    fun diameterOfBinaryTree(root: TreeNode?): Int {

        // Intuition:
        // The strategy is to use Depth First Search (DFS) to traverse the tree and calculate the depth of each subtree.
        // While doing this, we keep track of the maximum diameter found, which is the sum of the depths of the left and right subtrees for each node.

        var diameter = 0

        // Helper function to perform DFS and calculate the depth of the tree.
        // It returns the depth of the tree rooted at the given node.
        fun dfs(root: TreeNode?): Int {
            // If the current node is null, the depth is 0
            if (root == null) return 0

            // Recursively find the depth of the left and right subtrees
            val leftDepth = dfs(root.left)
            val rightDepth = dfs(root.right)

            // The diameter at the current node is the sum of the depths of left and right subtrees
            // Update the global diameter if this is the largest we've seen.
            diameter = maxOf(diameter, leftDepth + rightDepth)

            // Return the depth of the tree rooted at the current node.
            // This is the maximum depth of the left or right subtree plus one for the current node.
            return maxOf(leftDepth, rightDepth) + 1
        }

        // Start DFS from the root
        dfs(root)

        // Return the maximum diameter found
        return diameter
    }
}