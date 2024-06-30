package tree

/**
 * 226. Invert Binary Tree
 *
 * Easy
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class LC226InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        // Intuition:
        // To invert a binary tree, we need to swap the left and right children of each node.
        // Using DFS, we can traverse the tree and perform the swap at each node.

        // Helper function to perform DFS and invert the tree
        fun invert(node: TreeNode?): TreeNode? {
            // Base case: if the node is null, return null
            if (node == null) return null

            // Swap the left and right children
            val temp = node.left
            node.left = node.right
            node.right = temp

            // Recursively invert the left and right subtrees
            invert(node.left)
            invert(node.right)

            // Return the current node after its children have been inverted
            return node
        }

        // Start the inversion process from the root
        return invert(root)
    }
}