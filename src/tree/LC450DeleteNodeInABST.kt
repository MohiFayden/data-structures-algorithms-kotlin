package tree

/**
 * 450. Delete Node in a BST
 *
 * Medium
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,7], key = 0
 * Output: [5,3,6,2,4,null,7]
 * Explanation: The tree does not contain a node with value = 0.
 * Example 3:
 *
 * Input: root = [], key = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -105 <= Node.val <= 105
 * Each node has a unique value.
 * root is a valid binary search tree.
 * -105 <= key <= 105
 *
 *
 * Follow up: Could you solve it with time complexity O(height of tree)?
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
class LC450DeleteNodeInABST {

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {

        // Intuition:
        // First, we need to find the node to be deleted, which we can accomplish using a DFS search in the BST

        if (root == null) return null

        // If we found the node to be deleted
        if (root.`val` == key) {

            // If one of the subtrees is null,
            // return the non-null subtree to remove the target node and maintain the BST structure
            if (root.left == null) return root.right
            if (root.right == null) return root.left

            // Otherwise, find the successor, which will replace the current node to keep the BST valid
            // The successor is the smallest node in the right subtree
            val successor = successor(root.right!!)

            // Update the current node's value with the successor's value, effectively removing the target node
            root.`val` = successor.`val`

            // Remove the successor node, which is now a duplicate
            root.right = deleteNode(root.right, successor.`val`)
            return root
        } else {
            // If the root is not the target node, recurse into the appropriate subtree based on BST properties
            if (key < root.`val`) root.left = deleteNode(root.left, key)
            else root.right = deleteNode(root.right, key)
        }

        return root
    }

    // This function finds the successor, which is the smallest node in the right subtree
    private fun successor(root: TreeNode): TreeNode {
        return if (root.left == null) root else successor(root.left!!)
    }
}