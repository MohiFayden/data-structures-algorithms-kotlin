package tree

/**
 * 1325. Delete Leaves With a Given Value
 *
 * Medium
 *
 * Given a binary tree root and an integer target, delete all the leaf nodes with value target.
 *
 * Note that once you delete a leaf node with value target, if its parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you cannot).
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,2,null,2,4], target = 2
 * Output: [1,null,3,null,4]
 * Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left).
 * After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
 * Example 2:
 *
 *
 *
 * Input: root = [1,3,3,3,2], target = 3
 * Output: [1,3,null,null,2]
 * Example 3:
 *
 *
 *
 * Input: root = [1,2,null,2,null,2], target = 2
 * Output: [1]
 * Explanation: Leaf nodes in green with value (target = 2) are removed at each step.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 3000].
 * 1 <= Node.val, target <= 1000
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
class LC1325DeleteLeavesWithAGivenValue {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        // Intuition:
        // - Traverse the tree using DFS.
        // - Use post-order traversal to process children before the parent.
        // - If a node is a leaf and its value matches the target, remove it by returning null to the parent.
        // - Repeat the process to handle cases where parent nodes become leaves after their children are removed.

        fun dfs(node: TreeNode?): TreeNode? {
            if (node == null) return null

            // Traverse left and right subtrees first (post-order)
            node.left = dfs(node.left)
            node.right = dfs(node.right)

            // Check if the current node is a leaf and its value matches the target
            if (node.left == null && node.right == null && node.`val` == target) {
                return null // Remove the leaf node
            }

            return node // Return the (potentially modified) subtree
        }

        return dfs(root)
    }
}