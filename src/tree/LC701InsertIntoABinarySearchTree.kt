package tree

/**
 * 701. Insert into a Binary Search Tree
 *
 * Medium
 *
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3], val = 5
 * Output: [4,2,7,1,3,5]
 * Explanation: Another accepted tree is:
 *
 * Example 2:
 *
 * Input: root = [40,20,60,10,30,50,70], val = 25
 * Output: [40,20,60,10,30,50,70,null,null,25]
 * Example 3:
 *
 * Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 * Output: [4,2,7,1,3,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree will be in the range [0, 104].
 * -108 <= Node.val <= 108
 * All the values Node.val are unique.
 * -108 <= val <= 108
 * It's guaranteed that val does not exist in the original BST.
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
class LC701InsertIntoABinarySearchTree {
    fun insertIntoBST(root: TreeNode?, value: Int): TreeNode? {

        // Intuition:
        // To insert a value into a Binary Search Tree (BST), we can use Depth First Search (DFS)
        // to find the appropriate position for the new node. In a BST, for each node:
        // - Values in the left subtree are smaller than the node's value
        // - Values in the right subtree are larger than the node's value

        // Create the new node to be inserted
        val node = TreeNode(value)

        // If the tree is empty, the new node becomes the root
        if (root == null) return node

        // Otherwise, insert the node into the correct position in the BST
        insert(root, node)
        return root
    }

    private fun insert(root: TreeNode, node: TreeNode) {
        // If the new node's value is less than the current node's value,
        // it should be placed in the left subtree
        if (node.`val` < root.`val`) {
            // If the left child is null, the new node becomes the left child
            if (root.left == null) {
                root.left = node
            } else {
                // Otherwise, recursively insert the new node into the left subtree
                insert(root.left!!, node)
            }
        } else {
            // If the new node's value is greater than or equal to the current node's value,
            // it should be placed in the right subtree.
            // If the right child is null, the new node becomes the right child
            if (root.right == null) {
                root.right = node
            } else {
                // Otherwise, recursively insert the new node into the right subtree
                insert(root.right!!, node)
            }
        }
    }
}