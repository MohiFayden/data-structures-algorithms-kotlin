package tree

/**
 * 101. Symmetric Tree
 *
 * Easy
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Could you solve it both recursively and iteratively?
 */

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Lc101SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {

        // Intuition:
        // To determine if a binary tree is symmetric, we need to check if the left subtree
        // is a mirror reflection of the right subtree. This means the left and right subtrees
        // should have the same structure and the same node values in a mirrored fashion.
        // We can achieve this by using Depth-First Search (DFS) to recursively compare
        // the left and right subtrees.
        // DFS is a strategy that goes as deep as possible along each branch before backtracking.
        // Here, DFS helps in comparing nodes level by level in a mirrored fashion.

        // Start the comparison with the root node's left and right children.
        return isMirror(root, root)
    }

    private fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
        // If both nodes are null, they are symmetric.
        if (left == null && right == null) return true
        // If only one of the nodes is null, they are not symmetric.
        if (left == null || right == null) return false

        // Check if the values of the nodes are equal and
        // recursively check the mirrored subtrees using DFS.
        return (left.`val` == right.`val`) &&
                isMirror(left.left, right.right) &&
                isMirror(left.right, right.left)
    }
}