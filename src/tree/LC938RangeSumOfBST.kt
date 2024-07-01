package tree

/**
 * 938. Range Sum of BST
 *
 * Easy
 *
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 * Example 2:
 *
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 2 * 104].
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * All Node.val are unique.
 *
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
class LC938RangeSumOfBST {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        return bst1(root, low, high)
        // return bst2(root, low, high)
    }

    //-------------------BST1--------------------
    private fun bst1(root: TreeNode?, low: Int, high: Int): Int {

        // Intuition and algorithm:
        // We can use DFS (Depth-First Search) to visit all the nodes in the tree.
        // By leveraging the properties of a BST, we can avoid visiting nodes that are outside the given range [low, high].
        // Specifically, we do not need to traverse the left subtree if the current node's value is less than or equal to `low`
        // and we do not need to traverse the right subtree if the current node's value is greater than or equal to `high`.

        // Base case: if the current node is null, return 0 as there are no values to add.
        if (root == null) return 0

        // Initialize the answer for the current subtree.
        var ans = 0

        // If the current node's value is within the range [low, high], add its value to the answer.
        if (root.`val` in low..high) ans += root.`val`

        // If the current node's value is greater than `low`, there might be valid nodes in the left subtree.
        // Recursively compute the sum for the left subtree and add it to the answer.
        if (root.`val` > low) ans += bst1(root.left, low, high)

        // If the current node's value is less than `high`, there might be valid nodes in the right subtree.
        // Recursively compute the sum for the right subtree and add it to the answer.
        if (root.`val` < high) ans += bst1(root.right, low, high)

        // Return the total sum of valid nodes in the current subtree.
        return ans
    }

    //-------------------BST2--------------------
    private fun bst2(root: TreeNode?, low: Int, high: Int): Int {
        // Initialize the answer to store the cumulative sum of valid nodes.
        var ans = 0

        // Helper function to perform DFS and compute the sum of valid nodes.
        fun bst(root: TreeNode?) {
            // Base case: if the current node is null, return as there are no values to add.
            if (root == null) return

            // If the current node's value is within the range [low, high], add its value to the answer.
            if (root.`val` in low..high) {
                ans += root.`val`
            }

            // If the current node's value is greater than `low`, there might be valid nodes in the left subtree.
            // Recursively call the helper function on the left subtree.
            if (root.`val` > low) bst(root.left)

            // If the current node's value is less than `high`, there might be valid nodes in the right subtree.
            // Recursively call the helper function on the right subtree.
            if (root.`val` < high) bst(root.right)
        }

        // Start the DFS from the root node.
        bst(root)

        // Return the total sum of valid nodes.
        return ans
    }
}