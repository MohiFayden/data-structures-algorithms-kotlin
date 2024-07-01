package tree

/**
 * 700. Search in a Binary Search Tree
 *
 * Easy
 *
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 * Example 2:
 *
 *
 * Input: root = [4,2,7,1,3], val = 5
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 5000].
 * 1 <= Node.val <= 107
 * root is a binary search tree.
 * 1 <= val <= 107
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
class LC700SearchInABinarySearchTree {
    fun searchBST(root: TreeNode?, value: Int): TreeNode? {

        // Intuition and Algorithm:
        // Since this is a Binary Search Tree (BST), we can utilize its properties to efficiently find the target value.
        // For any given node, if the target value is less than the node's value, it will be in the left subtree.
        // Conversely, if the target value is greater than the node's value, it will be in the right subtree.
        // This allows us to eliminate half of the remaining nodes at each step, achieving O(log n) time complexity in the average case.

        return bst(root, value)
        // Alternatively, you can use the iterative version:
        // return bstIter(root, value)
    }

    //---------------------------------
    // Recursive approach
    private fun bst(root: TreeNode?, value: Int): TreeNode? {
        // If root is null, or we've found the node with the target value, return root
        if (root == null || root.`val` == value) return root

        // Continue the search in the left or right subtree based on the target value
        return if (value < root.`val`) {
            bst(root.left, value)
        } else {
            bst(root.right, value)
        }
    }

    //---------------------------------
    // Iterative approach
    private fun bstIter(root: TreeNode?, value: Int): TreeNode? {
        var curr = root
        // Traverse the tree until we find the target value or reach a null node
        while (curr != null && curr.`val` != value) {
            curr = if (value < curr.`val`) {
                curr.left
            } else {
                curr.right
            }
        }

        // Return the node containing the target value, or null if not found
        return curr
    }
}
