package tree

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Medium
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [2,1], p = 2, q = 1
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the BST.
 */

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class LC235LowestCommonAncestorOfABinarySearchTree {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

        // Intuition:
        // In a BST, the values of the nodes in the left subtree are smaller than the root,
        // and the values of the nodes in the right subtree are larger than the root.
        // We can leverage this property to find the LCA:
        // - If the current node's value is equal to p or q's value, the current node is the LCA.
        // - If p and q are on opposite sides of the current node, then the current node is the LCA.
        // - If both p and q are smaller than the current node, explore the left subtree.
        // - If both p and q are larger than the current node, explore the right subtree.

        // Base case: If the tree is empty, return null.
        if (root == null) return null

        // If the current node is either p or q, return the current node.
        if (root.`val` == p?.`val` || root.`val` == q?.`val`) return root

        // If p and q are on opposite sides of the current node, return the current node.
        val pInLeftQInRight = p!!.`val` < root.`val` && q!!.`val` > root.`val`
        val qInLeftPInRight = q!!.`val` < root.`val` && p.`val` > root.`val`
        if (pInLeftQInRight || qInLeftPInRight) return root

        // Recursively search in the left or right subtree based on the values of p and q.
        // Since both p and q are either to the left or to the right, we only need to check one condition.
        return if (p.`val` < root.`val`) {
            lowestCommonAncestor(root.left, p, q)
        } else {
            lowestCommonAncestor(root.right, p, q)
        }
    }
}