package tree

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * Medium
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class LC236LowestCommonAncestorOfABinaryTree {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

        // Intuition:
        // The algorithm works by recursively traversing the tree. If either p or q is found,
        // it returns that node. If both p and q are found in different subtrees of the same node,
        // that node is their lowest common ancestor. If they are found in the same subtree, the
        // result bubbles up from that subtree.

        // Case 1: The root node is p or q. The answer cannot be below the root node, because then it would be missing the root (which is either p or q) as a descendant.
        // Case 2: One of p or q is in the left subtree, and the other one is in the right subtree. The root must be the answer because it is the connection point between the two subtrees, and thus the lowest node to have both p and q as descendants.
        // Case 3: Both p and q are in one of the subtrees. In that case, the root is not the answer because we could look inside the subtree and find a "lower" node.

        // Base case: if the current node is null, return null
        if (root == null) return null

        // If the current node is either p or q, return the current node
        if (root == p || root == q) return root

        // Recur for the left and right subtrees
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        // If p and q are found in left and right subtrees respectively, return the current node
        if (left != null && right != null) return root

        // If p and q are found in the left subtree, return the result of the left subtree
        if (left != null) return left

        // If p and q are found in the right subtree, return the result of the right subtree
        return right
    }
}