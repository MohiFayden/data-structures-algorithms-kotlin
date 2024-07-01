package tree

/**
 * 98. Validate Binary Search Tree
 *
 * Medium
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left
 * subtree
 *  of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 *
 */

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class LC98ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {

        // Intuition and Algorithm:
        // The main property of a BST is that for any given node, all values in the left subtree
        // are smaller than the node's value, and all values in the right subtree are greater.
        // To validate this for each node in the tree, we can use the bst function that checks
        // if the current node's value lies within a valid range (low, high).
        // We start with the full range of possible values for a 32-bit integer.
        // For the left subtree, we narrow the high bound to the current node's value.
        // For the right subtree, we raise the low bound to the current node's value.

        fun bst(node: TreeNode?, low: Long, high: Long): Boolean {
            if (node == null) return true // Base case: An empty tree is a valid BST

            // Check if the current node's value is within the valid range
            if (node.`val` <= low || node.`val` >= high) return false

            // Recursively validate the left subtree:
            // All values in the left subtree must be less than the current node's value
            val left = bst(node.left, low, node.`val`.toLong())

            // Recursively validate the right subtree:
            // All values in the right subtree must be greater than the current node's value
            val right = bst(node.right, node.`val`.toLong(), high)

            // The current subtree is a valid BST if both left and right subtrees are valid
            return left && right
        }

        // Start the recursion with the full range of integer values
        return bst(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }
}